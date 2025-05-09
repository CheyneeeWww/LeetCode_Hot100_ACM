package LeetCode.Hot100.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 19:32 2025/5/9
 */
public class SpiralMatrix {

    public static List<Integer> SpiralMatrix(int[][] matrix){
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int loop = Math.min(row,col)/2;

        for(int i = 0;i<loop;i++){
            for(int j = i;j<col-1-i;j++){
                ans.add(matrix[i][j]);
            }
            for(int j = i;j<row-1-i;j++){
                ans.add(matrix[j][col-1-i]);
            }
            for(int j = i;j<col-1-i;j++){
                ans.add(matrix[row-1-i][col-1-j]);
            }
            for(int j = i;j<row-1-i;j++){
                ans.add(matrix[row-1-j][i]);
            }
        }

        if(Math.min(row,col)%2==1){
            if(col==row){
                ans.add(matrix[row/2][row/2]);
            }
            if(col<row){
                for(int i = loop;i<row-loop;i++){
                    ans.add(matrix[i][loop]);
                }
            }
            if(col>row){
                for(int i = loop;i<col-loop;i++){
                    ans.add(matrix[loop][i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        for(int i = 0;i<row;i++){
            for(int j =0;j<col;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(SpiralMatrix(matrix));
    }
}
