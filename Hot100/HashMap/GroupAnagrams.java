package LeetCode.Hot100.HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 12:04 2025/5/19
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs){
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] sortedS = s.toCharArray();
            Arrays.sort(sortedS);
            String key = new String(sortedS);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(s);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        System.out.println(groupAnagrams(split));
    }
}
