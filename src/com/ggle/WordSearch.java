package com.ggle;

public class WordSearch {

    static char[][] board = {
        
    { 'q', 'w', 'e', 'r', 't', 'y' },
    { 'a', 's', 'd', 'f', 'g', 'h' },
    { 'z', 'x', 'c', 'v', 'b', 'n' },
    { 'y', 'u', 'a', 'd', 'p', 'r' },
    { 'g', 'f', 't', 'b', 'a', 'g' },
    { 'o', 'o', 'f', 't', 's', 'g' } };

    public static void main(String[] args) {
        String word = "cad";

        int rows = board.length;
        int cols = board[0].length;
        // boolean result = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // dfs here
                if (dfs(word, i, j, 0)) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }

    private static boolean dfs(String word, int i, int j, int offset) {
        int rows = board.length;
        int cols = board[0].length;
        // corner checks
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }

        System.out.println(board[i][j]+" at "+i+"-"+j+ " for offset "+offset);
        if(board[i][j] != word.charAt(offset)){
            return false;
        } else {
            char temp = board[i][j]; 
            board[i][j] = '*';
            // check if this was the last char.
            if (offset == word.length() - 1) {
                // that means word has ended and word is found
                System.out.println("word found");
                return true;
            } else {
                System.out.println("dfs");
                if (dfs(word, i + 1, j, offset + 1) || dfs(word, i-1, j , offset + 1)
                        || dfs(word, i , j+1, offset + 1) || dfs(word, i, j - 1, offset + 1)) {
                    // dfs through with an increased offset
                    System.out.println("found in recurssion");
                    return true;
                }
            }

            board[i][j] = temp;

        }
        // as the char not found
        return false;

    }

   /*
     * 0 2 5 0 {'q','w','e','r','t','y'}, {'a','s','d','f','g','h'}, 2
     * {'z','x','c','v','b','n'}, {'y','u','a','d','p','r'},
     * {'g','f','t','b','a','g'}, 5 {'o','o','f','t','s','g'}
     */



}
