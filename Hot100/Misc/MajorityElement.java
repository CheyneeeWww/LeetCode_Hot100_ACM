package LeetCode.Hot100.Misc;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 18:26 2025/4/8
 */
public class MajorityElement {
    public static int MajorityElement(int[] nums){
        int x = 0;
        int votes = 0;
        for(int num:nums){
            if(votes == 0){
                x = num;
            }
            votes += num == x?1:-1;
        }
        return x;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(MajorityElement(nums));

    }
}
