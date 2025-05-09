package LeetCode.Hot100.Matrix;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 22:01 2025/5/9
 */
public class RotateImage {
    public static void RotateImage(int[][] matrix){
        int n = matrix.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<i;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int[] row:matrix){
            for(int i = 0;i<n/2;i++){
                int tmp = row[i];
                row[i] = row[n-1-i];
                row[n-1-i] = tmp;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        RotateImage(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
