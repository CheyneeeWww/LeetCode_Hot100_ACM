package LeetCode.Hot100.BinarySearch;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 20:21 2025/4/10
 */
public class SearchInRotatedSortedArray {

    public static int SearchInRotatedSortedArray(int[] nums,int target){
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else{
                if(nums[mid]<=nums[right]){//
                    if(nums[mid]<target && target<=nums[right]){
                        left = mid+1;
                    }else{
                        right = mid-1;
                    }
                }else{
                    if(nums[mid]>target && target>=nums[left]){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int target = sc.nextInt();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for(int i = 0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(SearchInRotatedSortedArray(nums,target));
    }

}
