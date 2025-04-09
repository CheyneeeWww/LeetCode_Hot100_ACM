package LeetCode.Hot100.Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 10:45 2025/4/9
 */
public class PartitionLabels {

    public static List<Integer> PartitionLabels(String s){
        //先遍历这个s，找出最末尾的位置last
        char[] ss = s.toCharArray();
        int len = s.length();
        int[] last = new int[26];
        for(int i = 0;i<len;i++){
            last[ss[i]-'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 0;i<len;i++){
            end = Math.max(end,last[ss[i]-'a']);
            if(end == i){
                ans.add(end-start+1);
                start = i+1;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(PartitionLabels(s));

    }
}
