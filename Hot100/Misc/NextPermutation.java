package LeetCode.Hot100.Misc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 18:51 2025/4/8
 */
public class NextPermutation {
    public static void NextPermutation(int[] nums){
        int len = nums.length;
        int i = len-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = len-1;
            //[5,3,7,6,4,1,2]
            //   i
            //下面这个<=很重要
            while(nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1,len-1);
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceAll("[^\\d,-]","");
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for(int i =0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        NextPermutation(nums);
        System.out.println(Arrays.toString(nums).replace(" ",""));
    }
}
