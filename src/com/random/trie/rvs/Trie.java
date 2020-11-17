package com.random.trie.rvs;

import java.util.Map;
import java.util.Map.Entry;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void add(String word) {
        Map<Character, TrieNode> children = root.getChildren();
        TrieNode node = null;
        for (int i = 0; i < word.length(); i++) {
            char charAt = word.charAt(i);
            if (children.containsKey(charAt)) {
                node = children.get(charAt);
            } else {
                node = new TrieNode();
                node.setC(charAt);
                children.put(charAt, node);
            }

            children = node.getChildren();
            if (i == word.length() - 1) {
                node.setEnd(Boolean.TRUE);
            }
        }
    }

    public boolean search(String word) {
        Map<Character, TrieNode> children = root.getChildren();
        TrieNode node = null;
        for (int i = 0; i < word.length(); i++) {
            char charAt = word.charAt(i);
            if (children.containsKey(charAt)) {
                node = children.get(charAt);
                children = node.getChildren();
            } else {
                node = null;
                break;
            }
        }
        return node != null && node.isEnd;
    }

    public boolean searchWithDot(String word) {
        TrieNode node = root;
        return isWordPresentRecursive(word, node);
    }

    private boolean isWordPresentRecursive(String word, TrieNode node) {
        Map<Character, TrieNode> children = node.getChildren();
        for (int i = 0; i < word.length(); i++) {
            char charAt = word.charAt(i);
            if (children.containsKey(charAt)) {
                node = children.get(charAt);
                children = node.getChildren();
            } else {
                if (charAt == '.') {
                    for (Entry<Character, TrieNode> entry : children.entrySet()) {
                        node = children.get(entry.getKey());
                        if (isWordPresentRecursive(word.substring(i + 1), node)) {
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }

        }
        return node != null && node.isEnd();
    }

}
