package LeetCode.Hot100.Greedy;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 10:30 2025/4/9
 */
public class JumpGameII {

    public static int JumpGameII(int[] nums){
        int len = nums.length;
        int curRight = 0;
        int nextRight = 0;
        int count = 0;
        for(int i = 0;i<len-1;i++){
            nextRight = Math.max(nextRight,i+nums[i]);
            if(i==curRight){
                curRight = nextRight;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceAll("[^\\d,-]","");
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(JumpGameII(nums));
    }

}
