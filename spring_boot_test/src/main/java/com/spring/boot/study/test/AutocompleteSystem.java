package com.spring.boot.study.test;

import java.util.*;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2020-04-21 15:42
 **/
public class AutocompleteSystem {

    TrieNode root, curNode;
    String stn;

    // 队列
    PriorityQueue<TrieNode> q = new PriorityQueue <>((t1, t2)-> t1.cut - t2.cut == 0? t2.str.compareTo (t1.str)  : t2.cut - t1.cut);

    public AutocompleteSystem(String[] sentence, int[] times) {
        root = new TrieNode ();
        for (int i = 0; i < sentence.length ; i++) {
            insert (sentence[i], times[i]);
        }
        curNode = root;
        stn = "";
    }

    List<String> input(char c) {
        if (c ==  '#') {
            insert (stn, 1);
            stn =  "";
            curNode =  root;
            return new ArrayList<> ();
        }

        stn += c;
        if (curNode != null && curNode.child.containsKey (c) ) {
            curNode  = curNode.child.get (c);
        } else {
            curNode = null;
            return new ArrayList<> ();
        }

        dfs(curNode);

        List<String> ret = new ArrayList<> ();
        int n = 3;
        while (n > 0 &&  !q.isEmpty ()) {
            TrieNode peek = q.peek ();
            ret.add (peek.str);
            q.poll ();
            n--;
        }

        while(!q.isEmpty()) {
            q.poll ();
        }

        return ret;
    }

    void dfs(TrieNode  n){
       if(n.str != ""){
            q.offer (n) ;
       }

       for(Map.Entry<Character, TrieNode> p : n.child.entrySet ()){
           dfs(p.getValue ());
        }
    }


    void insert(String s, int cnt){
          TrieNode cur = root;
          for(char c : s.toCharArray ()){
               if(!cur.child.containsKey (c)){
                   cur.child.put (c, new TrieNode());
               }
               cur = cur.child.get (c);
           }
           cur.str= s;
           cur.cut += cnt;
   }


    public static void main(String[] args) {
        AutocompleteSystem system = new AutocompleteSystem (new String[]{
                "i like",
                "i like i",
                "i aike i",
                "i kike i"
        }, new int[] {
                3,
                2,
                5,
                1
        });


        system.input ('i');
        system.input (' ');
        List<String> a = system.input ('a');
        System.out.println (a);
    }

}



class TrieNode {
    public String str = "";
    public int cut;
    public Map<Character, TrieNode> child;

    public TrieNode() {
        child = new HashMap<> ();
    }

}

