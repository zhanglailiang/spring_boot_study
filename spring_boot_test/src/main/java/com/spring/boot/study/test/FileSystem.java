package com.spring.boot.study.test;

import java.util.*;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-04-26 15:59
 **/
public class FileSystem {

    private HashMap<String, DataNode> dateTree;

    class DataNode {
        public Set<String> child;
        public String data;

        public DataNode() {
            child = new HashSet ();
        }
    }

    public FileSystem() {
        dateTree = new HashMap<String, DataNode>();
        dateTree.put("/", new DataNode());
    }

    public List<String> ls(String path) {
        if (!dateTree.containsKey(path)) {
            return new ArrayList ();
        }

        DataNode dataNode = dateTree.get(path);
        Set<String> sets = dataNode.child;
        return new ArrayList(sets);
    }

    public void mkdir(String path) {
        if (path == null || "/".equals(path) || "".equals(path) || dateTree.containsKey(path))return;
        int lastindex = path.lastIndexOf("/");
        String parentPath = path.substring(0, lastindex);
        parentPath = parentPath.equals ("")?"/":parentPath;
        mkdir(parentPath);

        dateTree.put(path, new DataNode());
        dateTree.get(parentPath).child.add(path.substring (lastindex+1));
    }

    public void addContentToFile(String filePath, String content) {
        mkdir(filePath);
        if (dateTree.get(filePath).data == null ) {
            dateTree.get(filePath).data = content;
        } else {
            dateTree.get(filePath).data += content;
        }
    }

    public String readContentFromFile(String filePath) {
        if (!dateTree.containsKey(filePath)) {
            return null;
        }
        return dateTree.get(filePath).data;

    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem ();
        List<String> ls = fileSystem.ls ("/");
        System.out.println (ls);
        fileSystem.mkdir ("/a/b/c");
        fileSystem.addContentToFile ("/a/b/c/d", "hello");
         ls = fileSystem.ls ("/a");
        System.out.println (ls);
        String s = fileSystem.readContentFromFile ("/a/b/c/d");
        System.out.println (s);

    }
}
