package com.amz;

import java.util.Iterator;
import java.util.Stack;

public class CandyCrush1D {

    class Pair {
        Character key;
        int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Character getKey() {
            return key;
        }

        public void setKey(Character key) {
            this.key = key;
        }

        public Pair(Character key, int count) {
            this.key = key;
            this.count = count;
        }

    }

    public static void main(String[] args) {
        String s = "baaabbbabbccccd";

        Stack<Pair> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (checkStack(stack, c)) {
                    Pair popped = stack.pop();
                    popped.setCount(popped.getCount()+1);
                    stack.push(popped);
                    
                } else {
                    if(stack.peek().getCount() >=3 ){
                        stack.pop();
                    }
                    CandyCrush1D cd = new CandyCrush1D();
                    stack.push(cd.new Pair(c, 1));
                }
            } else {
                CandyCrush1D cd = new CandyCrush1D();
                stack.push(cd.new Pair(c, 1));
            }
        }

        Iterator i = stack.iterator();

        StringBuilder sb = new StringBuilder();
        while(i.hasNext()){
            Pair p = (Pair)i.next();
            System.out.println(p.getKey());
            sb.append(p.getKey());
        }
        System.out.println(s);
        System.out.println(sb.toString());
        

    }

    private static boolean checkStack(Stack<Pair> stack, Character c) {
        return stack.peek().getKey().equals(c);
    }
}
