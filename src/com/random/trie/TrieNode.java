package com.random.trie;

public class TrieNode {
    
    TrieNode[] nodes = new TrieNode[26];
    boolean isEnd;

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        this.isEnd = Boolean.TRUE;
    }
    
    //contains key
    public boolean containsKey(char ch){
        return nodes[ch-'a'] != null;
    }

    //get key
    public TrieNode get(char ch){
        return nodes[ch -'a'];
    }
    //put key
    public void put(char ch, TrieNode node){
        nodes[ch -'a'] = node;
    }
}
