package LeetCode.Hot100.BinarySearch;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 20:54 2025/4/10
 */
public class FindMinimumInRotatedSortedArray {

    public static int FindMinimumInRotatedSortedArray(int[] nums){
        int len = nums.length;
        int left = 0;
        int right = len-1;
        int min_data = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left+(right-left)/2;
            min_data = Math.min(min_data,nums[mid]);
            if(nums[mid]>nums[right]){//左边有序
                if(nums[mid]>min_data && min_data>=nums[left]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[mid]<min_data && min_data<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return min_data;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceAll("[^\\d,-]","");
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for(int i = 0;i< nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
     System.out.println(FindMinimumInRotatedSortedArray(nums));
    }
}
