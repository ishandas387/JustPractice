package com.random.trie;

public class Trie {
    
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }
    //insert
    public void insert(String word){
        TrieNode node = root;
        for(int i=0; i< word.length(); i++){
            char current = word.charAt(i);
            if(!node.containsKey(current)){
                node.put(current, new TrieNode());
            }
            node = node.get(current);
        }

        node.setEnd();
    }

    public TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i=0; i<word.length();i++){
            char current = word.charAt(i);
            if(node.containsKey(current)){
                node = node.get(current);

            } else {
                return null;
            }
        }
        return node;
    }
    //search word
    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

}
