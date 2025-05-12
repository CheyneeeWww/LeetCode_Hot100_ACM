package LeetCode.Hot100.Misc;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 19:13 2025/4/8
 */
public class FindTheDuplicateNumber {
    public static int FindTheDuplicateNumber1(int[] nums){
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

    public static int FindTheDuplicateNumber2(int[] nums){
        //可以作为环形链表
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while(pre1!=pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for(int i = 0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(FindTheDuplicateNumber1(nums));
        System.out.println(FindTheDuplicateNumber2(nums));
    }
}
