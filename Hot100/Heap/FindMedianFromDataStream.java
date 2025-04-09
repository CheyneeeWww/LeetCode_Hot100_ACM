package LeetCode.Hot100.Heap;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.Object;

/**
 * @Author cnwang
 * @Date created in 12:38 2025/4/9
 */
public class FindMedianFromDataStream {
    //堆295的题目：数据流的中位数
    //这个输入输出比较复杂，就直接求中位数好了

    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a); // 最大堆
    PriorityQueue<Integer> right = new PriorityQueue<>(); // 最小堆

    public void addNum(int num) {
        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        }
        return (left.peek() + right.peek()) / 2.0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String input = sc.nextLine();

        s = s.replace("[","").replace("]","").replace("\"","");
        String[] operations = s.split(",\\s*");

        input = input.replace("[","").replace("]","");
        String[] data = input.split(",\\s*");
        int[] nums = new int[data.length];
        for (int i = 0; i < nums.length; i++) {
            if (data[i].isEmpty()) {
                nums[i] = 0; // 或者使用其他默认值
            } else {
                nums[i] = Integer.parseInt(data[i]);
            }
        }
        //operations 和 nums
        int len = operations.length;

        FindMedianFromDataStream findMedianFromDataStream = new FindMedianFromDataStream();
        Object[] output  = new Object[len];
        for(int i = 0;i< len;i++){
            switch(operations[i]){
                case "MedianFinder":
                    output[i] = null;
                    break;
                case "addNum":
                    findMedianFromDataStream.addNum(nums[i]);
                    output[i] = null;
                    break;
                case "findMedian":
                    output[i] = findMedianFromDataStream.findMedian();
                    break;
            }
        }

        System.out.print("[");
        for(int i = 0;i< output.length;i++){
            System.out.print(output[i]);
            if(i< output.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
}
