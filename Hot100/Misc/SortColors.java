package LeetCode.Hot100.Misc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 18:33 2025/4/8
 */
public class SortColors {
    public static void SortColors(int[] nums){
        int len = nums.length;
        int n0 = 0;
        int n1 = 0;
        for(int i = 0;i<len;i++){
            int num = nums[i];
            nums[i] = 2;
            if(num<2){
                nums[n1] = 1;
                n1++;
            }
            if(num<1){
                nums[n0] = 0;
                n0++;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        SortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
