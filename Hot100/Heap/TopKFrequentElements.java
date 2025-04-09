package LeetCode.Hot100.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 11:56 2025/4/9
 */
public class TopKFrequentElements {

    public static List<Integer> TopKFrequentElements(int[] nums,int k){
        //构造HashMap，记录nums中各个数字出现的频率
        HashMap<Integer,Integer> store = new HashMap<>();
        for(int i:nums){
            if(store.containsKey(i)){
                store.put(i,store.get(i)+1);
            }else{
                store.put(i,1);
            }
        }
        //构造小根堆，使用PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return store.get(o1)-store.get(o2);
                        //如果返回负值，表示o1的优先级更高
                        //如果返回正值，表示o2的优先级更高
                        //表示越小的优先级越高
                    }
                }
        );

        //
        for(Integer key: store.keySet()){
            if(minHeap.size()<k){
                minHeap.offer(key);
            }else if(store.get(key)>store.get(minHeap.peek())){
                minHeap.poll();
                minHeap.add(key);
            }
        }



        List<Integer> res = new ArrayList<>();
        int i = 0;

        while(!minHeap.isEmpty()){
            res.add(minHeap.poll());
            i++;
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceAll("[^\\d,-]","");
        int k = sc.nextInt();
        String[] split  = s.split(",");
        int[] nums = new int[split.length];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(TopKFrequentElements(nums,k));
    }

}
