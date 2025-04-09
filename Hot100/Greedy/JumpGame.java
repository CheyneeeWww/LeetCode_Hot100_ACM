package LeetCode.Hot100.Greedy;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 0:15 2025/4/9
 */
public class JumpGame {

    public static boolean JumpGame(int[] nums){
        int mx = 0;
        for(int i = 0;i<nums.length;i++){
            if(mx<i){
                return false;
            }
            mx = Math.max(mx,i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceAll("[^\\d,-]","");
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for(int i = 0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(JumpGame(nums));
    }
}
