package LeetCode.Hot100.SlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @Author cnwang
 * @Date created in 16:20 2025/5/9
 */
public class FindAllAnagramsInAString {

    public static List<Integer> FindAllAnagramsInAString(String s,String p){
        List<Integer> ans = new ArrayList<>();
        //p比s短的话，那就一定是空的
        if(s.length()<p.length()){
            return ans;
        }
        //1. 将p的字符串存入
        //2. s的从左到右进行对比

        //step1:
        int[] nums = new int[26];
        for(int i=0;i<p.length();i++){
            nums[p.charAt(i)-'a']++;
        }

        //step2:
        int l = 0;
        for(int r = 0;r<s.length();r++){
            char c = s.charAt(r);
            nums[c-'a']--;
            while(nums[c-'a']<0){
                nums[s.charAt(l)-'a']++;
                l++;
            }
            if(r-l+1 == p.length()){
                ans.add(l);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        System.out.println(FindAllAnagramsInAString(s,p));
    }
}
