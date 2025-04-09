package LeetCode.Hot100.DynamicProgramming;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 23:22 2025/4/8
 */
public class ClimbingStairs {

    public static int ClimbingStairs(int n){
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2;i<n+1;i++){
            nums[i] = nums[i-1]+nums[i-2];
        }
        return nums[n];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(ClimbingStairs(n));
    }
}
