package LeetCode.Hot100.Graph;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 11:31 2025/5/14
 */
public class ImplementTriePrefixTree {

    public static class Node{
        Node[] son = new Node[26];
        boolean end = false;
    }

    private static final Node root = new Node();

    //public static void Trie(){};

    public static void insert(String word){
        Node cur = root;
        for(char c:word.toCharArray()){
            c -= 'a';
            if(cur.son[c] == null){
                cur.son[c] = new Node();
            }
            cur = cur.son[c];
        }
        cur.end = true;
    }

    public static boolean search(String word){
        Node cur = root;
        for(char c:word.toCharArray()){
            c -= 'a';
            if(cur.son[c] == null){
                return false;
            }
            cur = cur.son[c];
        }
        return cur.end == true;
    }

    public static boolean startWith(String word){
        Node cur = root;
        for(char c:word.toCharArray()){
            c -= 'a';
            if(cur.son[c] == null){
                return false;
            }
            cur = cur.son[c];
        }
        return true;
    }

    public static void main(String[] args){
        ImplementTriePrefixTree sample = new ImplementTriePrefixTree();
        sample.insert("apple");
        System.out.println(sample.search("apple"));
        System.out.println(sample.search("app"));
        System.out.println(sample.startWith("app"));
        sample.insert("app");
        System.out.println(sample.search("app"));
    }
}
