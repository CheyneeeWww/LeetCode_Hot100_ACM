package LeetCode.Hot100.Matrix;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 22:45 2025/5/9
 */
public class SearchA2dMatrixII {

    public static boolean SearchA2dMatrixII(int[][] matrix,int target){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][n-1]<target){
                    break;
                }
                if(matrix[i][j]>target){
                    break;
                }
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

    }
}
