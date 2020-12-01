package com.ggle.wordsearch2;

public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(!node.contains(c)){
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setWord(word);
    }

	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
        this.root = root;
        
	}

}
