package LeetCode.Hot100.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 20:51 2025/4/9
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] FindFirstAndLastPositionOfElementInSortedArray(int[] nums,int target){

        int l = BinarySearch(nums,target);
        if(l==nums.length || nums[l]!=target) {
            return new int[]{-1, -1};
        }else{
            int r = BinarySearch(nums,target+1);
            return new int[]{l,r-1};
        }
    }

    public static int BinarySearch(int[] nums,int target){
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceAll("[^\\d,-]","");
        int target = sc.nextInt();
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for(int i=0;i< nums.length;i++){
            if(split[i].isEmpty()){
                nums[i] = Integer.MIN_VALUE;
            }else {
                nums[i] = Integer.parseInt(split[i]);
            }
        }
        int[] res = FindFirstAndLastPositionOfElementInSortedArray(nums,target);
        System.out.println(Arrays.toString(res));
    }

}
