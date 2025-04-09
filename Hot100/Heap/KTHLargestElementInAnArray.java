package LeetCode.Hot100.Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 10:54 2025/4/9
 */
public class KTHLargestElementInAnArray {

    public static int KTHLargestElementInAnArray(int[] nums, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num:nums){
            heap.offer(num);
            if(heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceAll("[^\\d,-]","");
        int k = sc.nextInt();
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for(int i =0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(KTHLargestElementInAnArray(nums,k));



    }

}
