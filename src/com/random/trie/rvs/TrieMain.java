package com.random.trie.rvs;

public class TrieMain {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.add("word");
        System.out.println(t.search("word"));
        System.out.println(t.search("d"));
        System.out.println(t.searchWithDot(".or."));
        System.out.println(t.searchWithDot(".az."));
    }
}
