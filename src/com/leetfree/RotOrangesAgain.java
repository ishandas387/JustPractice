package com.leetfree;

import java.util.ArrayDeque;
import java.util.Queue;

public class RotOrangesAgain {

    class Pair{
        int r;
        int c;
        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        int[][] oranges = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        // given matrix of oranges, prepare the count of good oranges and the queue of rotten

        Queue<Pair> rottenQueue = new ArrayDeque<>();
        int row = oranges.length;
        int col = oranges[0].length;
        int goodOranges =0;
        RotOrangesAgain reference = new RotOrangesAgain();
        for(int i=0; i<row ; i++){
            for(int j=0; j<col; j++){
                if(oranges[i][j] == 1){
                    goodOranges++;
                } else if(oranges[i][j] ==2){
                    rottenQueue.offer(reference.new Pair(i, j));
                }
            }
        }
        rottenQueue.offer(reference.new Pair(-1, -1));
        int timeElapsed = 0;
        int[][] navigation = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!rottenQueue.isEmpty()){
            Pair poll = rottenQueue.poll();
            int r = poll.r;
            int c = poll.c;
            if(r == -1){
                timeElapsed++;
                if(!rottenQueue.isEmpty())
                    rottenQueue.offer(reference.new Pair(-1, -1));
            } else {
                //rotten
                for(int[] nav : navigation){
                    int neighbourRow = r+nav[0];
                    int neighbourCol = c+nav[1];
                    //check boundary
                    if(neighbourRow < row && neighbourCol < col && neighbourRow >= 0 && neighbourCol >=0){
                        if(oranges[neighbourRow][neighbourCol] == 1){
                            goodOranges--;
                            oranges[neighbourRow][neighbourCol] = 2;
                            rottenQueue.offer(reference.new Pair(neighbourRow, neighbourCol));
                        }
                    }

                }

            }
        }

        System.out.println(goodOranges == 0 ? timeElapsed : -1);
    }
}
