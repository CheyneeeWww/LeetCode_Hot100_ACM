package LeetCode.Hot100.BinarySearch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 21:12 2025/4/10
 */
public class MedianOfTwoSortedArrays {

    public static double MedianOfTwoSortedArrays(int[] nums1,int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1+len2;
        List<Integer> nums = new ArrayList<>();
        int flag1 = 0,flag2 = 0;
        double ans;
        while(flag1<len1 && flag2<len2){
            if(nums1[flag1]<nums2[flag2]){
                nums.add(nums1[flag1]);
                flag1++;
            }else if(nums1[flag1]>nums2[flag2]){
                nums.add(nums2[flag2]);
                flag2++;
            }else{
                nums.add(nums1[flag1]);
                nums.add(nums2[flag2]);
                flag1++;
                flag2++;
            }
            while(flag1 == len1 && flag2<len2){
                nums.add(nums2[flag2]);
                flag2++;
            }
            while(flag2 == len2 && flag1<len1){
                nums.add(nums1[flag1]);
                flag1++;
            }
        }
        if(len%2 == 0){
            ans = (double) (nums.get(len/2)+nums.get(len/2-1))/2;
        }else{
            ans = (double) nums.get(len/2);
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().replaceAll("[^\\d,-]","");
        String s2 = sc.nextLine().replaceAll("[^\\d,-]","");
        String[] split1 = s1.split(",");
        String[] split2 = s2.split(",");
        int[] nums1 = new int[split1.length];
        int[] nums2 = new int[split2.length];
        for(int i=0;i<nums1.length;i++){
            nums1[i] = Integer.parseInt(split1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            nums2[i] = Integer.parseInt(split2[i]);
        }

        double ans = MedianOfTwoSortedArrays(nums1,nums2);
        System.out.printf("%.5f",ans);
    }
}
