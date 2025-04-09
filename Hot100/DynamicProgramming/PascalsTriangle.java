package LeetCode.Hot100.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 23:29 2025/4/8
 */
public class PascalsTriangle {

    public static List<List<Integer>> PascalsTriangle(int numRows){
        Integer[][] dp = new Integer[numRows][];

        for(int i = 0;i<numRows;i++){
            dp[i] = new Integer[i+1];
            dp[i][0] = dp[i][i] = 1;
            for(int j = 1;j<i;j++){
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(Integer[] row:dp){
            res.add(Arrays.asList(row));
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numRows = sc.nextInt();
        System.out.println(PascalsTriangle(numRows));
    }
}
