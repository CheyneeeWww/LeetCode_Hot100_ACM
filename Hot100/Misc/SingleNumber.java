package LeetCode.Hot100.Misc;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 18:08 2025/4/8
 */
public class SingleNumber {
    public static int SingleNumber(int[] nums){
        int res = 0;
        for(int i =0;i<nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for(int i = 0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(SingleNumber(nums));
    }
}
