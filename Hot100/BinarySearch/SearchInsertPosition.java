package LeetCode.Hot100.BinarySearch;

import javax.naming.directory.SearchControls;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 20:08 2025/4/9
 */
public class SearchInsertPosition {

    public static int SearchInsertPosition(int[] nums,int target){
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return left;
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
        System.out.println(SearchInsertPosition(nums,target));
    }

}
