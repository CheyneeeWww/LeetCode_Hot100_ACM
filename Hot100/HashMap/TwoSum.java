package LeetCode.Hot100.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 10:49 2025/5/19
 */
public class TwoSum {

    public static int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for(int i = 0;i< nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        int target = sc.nextInt();
        sc.nextLine();
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}
