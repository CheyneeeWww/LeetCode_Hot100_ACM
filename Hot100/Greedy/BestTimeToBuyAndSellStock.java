package LeetCode.Hot100.Greedy;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 0:03 2025/4/9
 */
public class BestTimeToBuyAndSellStock {

    public static int BestTimeToBuyAndSellStock(int[] nums){
        int min_c = nums[0];
        int max_p = 0;
        for(int i=1;i<nums.length;i++){
            max_p = Math.max(max_p,(nums[i]-min_c)>0?nums[i]-min_c:0);
            min_c = Math.min(min_c,nums[i]);
        }
        return max_p;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceAll("[^\\d,-]","");
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for(int i = 0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(BestTimeToBuyAndSellStock(nums));
    }
}
