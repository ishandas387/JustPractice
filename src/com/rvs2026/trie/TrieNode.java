package com.rvs2026.trie;

import java.util.Map;

public class TrieNode {

    Character c;
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    public TrieNode(Character c) {
        this.c = c;
        this.isEndOfWord = false;
        children = new java.util.HashMap<>();
    }

    //setters and getters

}
