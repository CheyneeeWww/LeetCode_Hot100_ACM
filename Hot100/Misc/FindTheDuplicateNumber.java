package LeetCode.Hot100.Misc;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 19:13 2025/4/8
 */
public class FindTheDuplicateNumber {
    public static int FindTheDuplicateNumber(int[] nums){
        int res = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int count = map.getOrDefault(nums[i],0)+1;
            map.put(nums[i],count);
            if(count>1){
                res = nums[i];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for(int i = 0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(FindTheDuplicateNumber(nums));
    }
}
