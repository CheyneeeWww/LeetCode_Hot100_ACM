package LeetCode.Hot100.Misc;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 19:13 2025/4/8
 */
public class FindTheDuplicateNumber {
    public static int FindTheDuplicateNumber(int[] nums){
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre0 = 0;
        int pre1 = slow;
        while(pre0!=pre1){
            pre0 = nums[pre0];
            pre1 = nums[nums[pre1]];
        }
        return nums[pre0];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceAll("[^\\d,-]","");
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for(int i = 0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(FindTheDuplicateNumber(nums));
    }
}
