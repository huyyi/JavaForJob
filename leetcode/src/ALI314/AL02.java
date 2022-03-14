package ALI314;

import java.util.Scanner;

public class AL02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int score = 0;
        for(int i=0;i<4;i++){
            matrix = rotateMatrix(matrix);
            score += getScore(matrix);
        }
        System.out.println(score);
    }
    public static int getScore(int[][] matrix){
        int len = matrix[0].length;
        int[] dp = new int[len];
        int score = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0&&dp[j]==1){
                    score++;
                }else if(matrix[i][j]==1&&dp[j]==0){
                    dp[j] = 1;
                }
            }
        }
        return score;
    }
    public static int[][] rotateMatrix(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[j][matrix.length-i-1] = matrix[i][j];
            }
        }
        return res;
    }
}
//2 4
//0 1 0 0
//1 0 1 0