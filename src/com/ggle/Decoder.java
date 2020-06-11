package com.ggle;

import java.util.Stack;

public class Decoder {
    public static void main(String[] args) {
        System.out.println(decodeString("3[ac]2[b]"));
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder decoded = new StringBuilder();
        final char BLANK=' ';

        for (int i = 0; i < s.length(); i++) {
            char prev = BLANK;
            char c = s.charAt(i);
            if(isAlphabet(c) && prev == BLANK){
                decoded.append(c);
            
               
            } else {
                if (notBrackets(c)) {
                    stack.push(c);
                } else if (c == ']') {
                    StringBuilder inter = new StringBuilder();
                    int repeat = 0;
                    while (!stack.isEmpty()) {
                        Character ch = new Character(stack.pop());
                        if (Character.isDigit(ch)) {
                            repeat = Integer.parseInt(ch + "");
                            inter.reverse();
                            break;
                        } else {
                            inter.append(ch);
                        }
                    }
                    for (int j = 0; j < repeat; j++) {
                        decoded.append(inter);
                    }
                } else if(c == '['){
                    prev = c;
                }

            }
        }

        return decoded.toString();
    }

    private static boolean notBrackets(char c) {
        return (c != ']' && c != '[');
    }

    public static boolean isAlphabet(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
}