package com.spring.boot.study.biz.stream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.zip.ZipOutputStream;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-19 19:15
 **/
public class Compressor {


    private UnaryOperator<OutputStream> consumer;

    public Compressor(UnaryOperator<OutputStream> consumer) {
        this.consumer  =consumer;
    }

    public void compress(Path inFile, File outFile) {
        try (OutputStream outputStream = new FileOutputStream (outFile)){
            Files.copy (inFile, consumer.apply (outputStream));
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public static void main(String[] args) {
        new Compressor (ZipOutputStream::new);
    }
}
