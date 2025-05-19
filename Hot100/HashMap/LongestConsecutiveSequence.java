package LeetCode.Hot100.HashMap;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 12:23 2025/5/19
 */
public class LongestConsecutiveSequence {

    public static int longestSequence(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,num);
        }
        int ans = 0;
        for(int num:nums){
            int right = map.get(num);
            if(!map.containsKey(num-1)){
                while(map.containsKey(right+1)){
                    right = map.get(right+1);
                }
            }
            map.put(num,right);
            ans = Math.max(ans,right-num+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(longestSequence(nums));
    }
}
