package com.random;

public class EggDrop {
    public static void main(String[] args) {
        //given number of floors and egg find the min number of drops needed to find where the egg breaks

        int eggs = 2;
        int floors = 6;

        System.out.println("---"+drop(eggs, floors));
    }

    private static int drop(int eggs, int floors) {
        
        // matrix one extra from egg and floors because no point in taking 0 eggs 0 floors
        int[][] matrix = new int[eggs+1][floors+1];

        // the base cases

        // when number of floor is 1 then, it will be 1 min drop no matter the number of eggs

        for(int i =0; i<matrix.length;i++){
            matrix[i][1] = 1;
            matrix[i][0] = 0;
        }
        //similarly if number of eggs is 1 then the number of floors are the worst case for each floor.

        for(int j=0; j<= floors; j++){
            matrix[1][j] = j;
        }

        int result = Integer.MAX_VALUE;

        for(int i=2; i<= eggs; i++){
            for(int j = 2 ; j<=floors; j++){
                matrix[i][j] = Integer.MAX_VALUE;
                for(int x=1; x<=j ; x++){
                    //two cases either it breaks or it doesnt
                    result = Integer.max(matrix[i-1][x-1], matrix[i][j-x]);
                    // plus one to stimulate the fall from where ever it is happening
                    result += 1;
                    if(result < matrix[i][j]){
                        matrix[i][j] = result;
                    }
                }
            }
        }

        return matrix[eggs][floors];

    }
}