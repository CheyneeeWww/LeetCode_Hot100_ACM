package LeetCode.Hot100.Matrix;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 18:14 2025/5/9
 */
public class SetMatrixZeroes {
    public static void SetMatrixZeroes(int[][] matrix){
        int m = matrix.length;//行数
        int n = matrix[0].length;//列数

        boolean row = false;
        boolean col = false;

        for(int i = 0;i<n;i++){
            if(matrix[0][i]==0){
                col = true;
            }
        }

        for(int j = 0;j<m;j++){
            if(matrix[j][0] == 0){
                row = true;
            }
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1;i<m;i++){
            if(matrix[i][0]==0){
                for(int j = 1;j<n;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 1;i<n;i++){
            if(matrix[0][i]==0){
                for(int j = 1;j<m;j++){
                    matrix[j][i] = 0;
                }
            }
        }

        if(row){
            for(int i = 0;i<n;i++){
                matrix[0][i] = 0;
            }
        }

        if(col){
            for(int j = 0;j<m;j++){
                matrix[j][0] = 0;
            }
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();//行
        int col = sc.nextInt();//列
        int[][] nums = new int[row][col];
        for(int i = 0;i<row;i++){
            for(int j =0;j<col;j++){
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(nums));
        SetMatrixZeroes(nums);
        System.out.println(Arrays.deepToString(nums));
    }
}
