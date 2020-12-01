package com.ggle.wordsearch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch {

    
    static char[][] board = {
        
        { 'q', 'w', 'e', 'r', 't', 'y' },
        { 'a', 's', 'd', 'f', 'g', 'h' },
        { 'z', 'x', 'c', 'v', 'b', 'n' },
        { 'y', 'u', 'a', 'd', 'p', 'r' },
        { 'g', 'f', 't', 'b', 'a', 'g' },
        { 'o', 'o', 'f', 't', 's', 'g' } };

        
    public static void main(String[] args) {
        //given a char[][] board search word from wordlist
        // return a list of word that is found.
        List<String> words = Arrays.asList("cat","dogs","foo");
        //build a trie from the wordlist
        Trie myTrie = new Trie();
        buildTrie(words, myTrie);
        List<String> results = new ArrayList<>();
        for(int r=0; r<board.length; r++){
            for(int c =0; c<board[0].length; c++){
                dfs(r,c,myTrie.getRoot(), results);
            }
        }

        System.out.println("***************");
        results.forEach(System.out::println);
    }

    private static void dfs(int r, int c, TrieNode node, List<String> results) {
        char cellValue = board[r][c];
        if(cellValue == '*' || !node.contains(cellValue)){
            return;
        }

        node = node.get(cellValue);
        if(node.getWord() != null){
            results.add(node.getWord());
            node.setWord(null);
        }

        board[r][c] ='*';
        if(r>0)
            dfs(r-1,c, node, results);
        if(r<board.length-1)
            dfs(r+1, c, node, results);
        if(c>0)
            dfs(r,c-1, node, results);
        if(c<board[0].length-1)
            dfs(r, c+1, node, results);
        
        board[r][c] = cellValue;
    }

    private static void buildTrie(List<String> words, Trie myTrie) {
        words.forEach(word -> myTrie.insert(word));
    }
}
