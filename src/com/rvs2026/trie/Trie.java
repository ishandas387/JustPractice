package com.rvs2026.trie;

import java.util.Map;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode(null);
    }

    public void insert(String word) {

        Map<Character, TrieNode> child = root.children;
        TrieNode node = null;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(child.containsKey(c)) {
                node = child.get(c);
            } else {
                node = new TrieNode(c);
                child.put(c, node);
            }
            child = node.children;
            if(i == word.length() - 1) {
                node.isEndOfWord = true;
            }
        }
    }

    public boolean search(String word) {
        Map<Character, TrieNode> child = root.children;
        TrieNode node = null;
        for(int i =0 ; i< word.length(); i++){
            char c= word.charAt(i);
            if(child.containsKey(c)) {
                node = child.get(c);
                child = node.children;
            } else {
                node = null;
                break;
            }
        }

        return node != null && node.isEndOfWord;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("world"));
        System.out.println(trie.search("hi"));
    }
}
