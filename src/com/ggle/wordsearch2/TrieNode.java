package com.ggle.wordsearch2;

public class TrieNode {
    
    TrieNode[] nodes = new TrieNode[26];
    String word;

    public boolean contains(char c){
        return nodes[c-'a'] != null;
    }

    public void put(char c, TrieNode node){
        nodes[c-'a'] = node;
    }

    public TrieNode get(char c){
        return nodes[c-'a'];
    }

    public String getWord(){
        return this.word;
    }

    public void setWord(String word){
        this.word = word;
    }
}
