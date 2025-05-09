package LeetCode.Hot100.SlidingWindow;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 15:08 2025/5/9
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int LongestSubstringWithoutRepeatingCharacters(String s){
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        int l = 0;
        for(int r = 0;r<s.length();r++){
            char c = s.charAt(r);
            while(l<r && set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(LongestSubstringWithoutRepeatingCharacters(s));

    }
}
