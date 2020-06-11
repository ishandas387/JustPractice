package com.random;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode root;

    Trie (){
        this.root = new TrieNode();
    }

    public void addWord(String word){
        Map<Character, TrieNode>  child = root.getChildrens();
        TrieNode node = null;
        for(int i=0; i<word.length();i++){
            char c = word.charAt(i);
            if(child.containsKey(c)){
                node = child.get(c);
            } else {
                node = new TrieNode();
                node.setC(c);
                child.put(c, node);
            }
            child= node.getChildrens();
            if(i == word.length()-1){
                node.setLeaf(true);
            }
        }
    }

    public boolean findWord(String word){
        Map<Character, TrieNode>  child = root.getChildrens();
        TrieNode node = null;
        for(int i=0; i<word.length();i++){
            char c = word.charAt(i);
            if(child.containsKey(c)){
            
                node = child.get(c);
                child = node.getChildrens();
            }
            else{
                node = null;
                break;
            }
        }

        if(node != null && node.isLeaf){
            return true;
        } else{
            return false;
        }


    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.addWord("egg");
        System.out.println(t.findWord("eg"));
        System.out.println(t.findWord("egg"));
        t.addWord("xmax");
        System.out.println(t.findWord("x"));
        System.out.println(t.findWord("xmax"));
    }

}

class TrieNode{
    Character c ;
    Map<Character, TrieNode> childrens = new HashMap<>();
    boolean isLeaf;

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c = c;
    }

    public Map<Character, TrieNode> getChildrens() {
        return childrens;
    }

    public void setChildrens(Map<Character, TrieNode> childrens) {
        this.childrens = childrens;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    
}