package com.netty.study.demo.nio;

import io.netty.util.internal.StringUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class TimeClientHandle implements Runnable {



    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;

    public TimeClientHandle(int port) {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();

            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stop() {
        this.stop = false;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> lt = selectionKeys.iterator();

                while(lt.hasNext()) {
                    SelectionKey key = lt.next();
                    lt.remove();

                    try {

                        handleInput(key);
                    } catch (Exception e) {
                        key.cancel();
                        if (key.channel() != null) {
                            key.channel().close();
                        }
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            SocketChannel sc  = (SocketChannel) key.channel();
            if (key.isConnectable()) {
                if (sc.finishConnect()) {
                    sc.register(selector, SelectionKey.OP_READ);

                    String currentTime =(new Date(System.currentTimeMillis()).toString());
                    doWrite(sc, currentTime);
                } else {
                    System.exit(1);
                }

            } else if (key.isReadable()) {
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[]  bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);

                    this.stop();
                } else if (readBytes < 0) {
                    key.cancel();
                    sc.close();
                }
            }
        }
    }


    private void doWrite(SocketChannel channel, String response) throws IOException {
        if (!StringUtil.isNullOrEmpty(response)) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);

            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }
}
