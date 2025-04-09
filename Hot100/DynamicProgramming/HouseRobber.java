package LeetCode.Hot100.DynamicProgramming;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 23:40 2025/4/8
 */
public class HouseRobber {

    public static int HouseRobber(int[] nums){
        int len = nums.length;
        int[] dp = new int[len+2];
        for(int i = 0;i<len;i++){
            dp[i+2] = Math.max(dp[i+1],dp[i]+nums[i]);
        }
        return dp[len+1];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceAll("[^\\d,-]","");
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for(int i = 0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(HouseRobber(nums));
    }
}
