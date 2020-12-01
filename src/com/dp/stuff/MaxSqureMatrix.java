package com.dp.stuff;

public class MaxSqureMatrix {

  //  static char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
  static char[][] matrix = { { '1'}};

    public static void main(String[] args) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = Character.getNumericValue(matrix[i][j]);
                } else if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result);

    }
}
