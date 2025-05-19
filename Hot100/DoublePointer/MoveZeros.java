package LeetCode.Hot100.DoublePointer;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 13:27 2025/5/19
 */
public class MoveZeros {

    public static void moveZeros(int[] nums){
        int left = 0;
        int right = 0;
        while(left<=right && right<=nums.length-1){
            if(nums[left]!=0){
                left++;
                right++;
            }else if(nums[right]==0 && nums[left]==0){
                right++;
            }else if(nums[left]==0 && nums[right]!=0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for(int i = 0;i<split.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        moveZeros(nums);
        for(int i = 0;i< nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
