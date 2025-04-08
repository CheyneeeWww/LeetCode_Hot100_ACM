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
        int flag0 = 0;
        int flag1 = 0;
        for(int i =0;i<len;i++){
            int num = nums[i];
            nums[i] =2;
            if(num < 2){
                nums[flag1] = 1;
                flag1++;
            }
            if(num<1){
                nums[flag0] = 0;
                flag0++;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceAll("[^\\d,-]","");
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        SortColors(nums);
        System.out.println(Arrays.toString(nums).replace(" ",""));
    }
}
