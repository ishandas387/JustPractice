package com.leetfree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Given a grid ,
 * 0 is empty space
 * 1 is building 
 * 2 is obstacle.
 * Find the spot where it is shortest distance to all the buildings.
 */
public class ShortestDistanceToAllTheBuildings{

    static int[][] gridOfCity = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};

        //BFS solution O(mn) traversed atleast once
        private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1});

    public static void main(String[] args) {
        //try to calculate from each building 
        // the reach and distance of each point.
        System.out.println("Distance shortest "+getTheDist());
       
    }

    private static int getTheDist() {
        
        if(gridOfCity.length==0){
            return -1;
        }
        
        int row = gridOfCity.length;
        int col = gridOfCity[0].length;

        
        
        int[][] distance = new int[row][col];
        int[][] reach = new int[row][col];
        int buildings =0;
        //Get the min dis here
        int dist = Integer.MAX_VALUE;
        for(int i =0; i<row;i++){
            for(int j =0 ; j<col ;j++){
                if(gridOfCity[i][j] ==1){
                    bfs(i,j,reach,distance);
                    buildings++;
                }
            }
        }

        for(int i =0; i<row;i++){
            for(int j =0 ; j<col ;j++){
                if(reach[i][j] == buildings && gridOfCity[i][j] == 0){
                    dist = Math.min(distance[i][j],dist);
                }
            }
        }

        return dist == Integer.MAX_VALUE ? -1 : dist;
    }

    private static void bfs(int i, int j, int[][] reach, int[][] distance) {

        int row = gridOfCity.length;
        int col = gridOfCity[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        queue.offer(new int[] { i, j });
        visited[i][j] = true;

        int d = 0;
        if (!queue.isEmpty()) {
            int size = queue.size();
            d++;
            for (int k = 0; k < size; k++) {
                int[] current = queue.poll();

                for (int[] direct : DIRECTIONS) {
                    int rr = current[0] + direct[0];
                    int cc = current[1] + direct[1];

                    if (isValid(rr, cc, visited)) {
                        queue.offer(new int[] { rr, cc });
                        visited[rr][cc] = true;
                        reach[rr][cc]++;
                        distance[rr][cc] += d;
                    }
                }
            }
        }
        
    }

    private static boolean isValid(int rr, int cc, boolean[][] visited) {
        if(rr < 0 || cc<0 || rr>gridOfCity.length-1 || cc> gridOfCity[0].length-1 || gridOfCity[rr][cc] !=0 ){
            return false;
        }
        if(visited[rr][cc] == true){
            return false;   
        }
        return true;
    }

}