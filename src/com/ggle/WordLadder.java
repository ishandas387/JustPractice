package com.ggle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class WordLadder {
    
    class Node{
        String word;
        int level;

        public Node(String word, int level){
            this.word = word;
            this.level = level;
        }
    }
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>(Arrays.asList("hit", "hot","dot","cog","dog","log","lot"));
        String startWord = "hit";
        String endWord = "cog";

        System.out.println(numberOfTransformation(wordList, startWord, endWord));
    }

    private static int numberOfTransformation(List<String> wordList, String startWord, String endWord) {
        
        int L = startWord.length();
        Map<String, List<String>> dictionary = new HashMap<>();
        //transform and store a word dict
        /**
         * Create a transformation map to look it up later.
         * The map will be having a key of words formed by replacing a single char
         * Example DOG -> *OG, D*G, DO*
         * 
         * The value will be a list of words that can form that key
         * 
         * Example D*G -> [DOG, DIG, DAG]
         */
        createTheTransformationMap(wordList, L, dictionary);

        WordLadder wl = new WordLadder();
        /**
         * Try to BFS from the startword with level as 1
         * same theory of using QUEUE and tracking the VISITED
         * for each of the transformation check the map if key exists
         * IF exists then get the list and for each of the word in the list
         * CHECK if end word is found
         * IF found return level+1 
         * ELSE add the word to the visited and queue.
         */
        // bfs
        Queue<Node> queue = new LinkedList<>();
        queue.add(wl.new Node(startWord, 1));
        Set<String> visited = new HashSet<>();
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            int level = poll.level;
            String word = poll.word;

            for(int i=0; i<L; i++){
                String relatedWord = word.substring(0,i) +"*"+ word.substring(i+1, L);
                if(dictionary.containsKey(relatedWord)){
                    List<String> trns = dictionary.get(relatedWord);
                    for(String t : trns){
                        if(t.equals(endWord)){
                            return level+1;
                        } else {
                            if(!visited.contains(t)){
                                visited.add(t);
                                queue.add(wl.new Node(t, level+1));
                            }
                        }
                    }
                } 
            }
        }

        return 0;

    }

    private static void createTheTransformationMap(List<String> wordList, int L, Map<String, List<String>> dictionary) {
        wordList.forEach(word -> {
            for(int i =0; i<L; i++){
                String newWord = word.substring(0,i) +"*"+ word.substring(i+1, L);
                List<String> transformations = dictionary.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                dictionary.put(newWord, transformations);
            }
        });
    }
}
