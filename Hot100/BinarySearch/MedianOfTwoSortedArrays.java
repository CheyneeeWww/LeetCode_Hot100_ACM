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
        if(nums1.length>nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        //一定是nums1<=nums2
        int m = nums1.length;
        int n = nums2.length;
        //m<n
        int left = 0;
        int right = m;

        while(left<=right){
            int i = (left+right)/2;
            int j = (m+n+1)/2-i;

            int nums1_left_MAX = (i == 0?Integer.MIN_VALUE:nums1[i-1]);
            int nums1_right_MIN = (i == m?Integer.MAX_VALUE:nums1[i]);
            int nums2_left_MAX = (j == 0?Integer.MIN_VALUE:nums2[j-1]);
            int nums2_right_MIN = (j==n?Integer.MAX_VALUE:nums2[j]);

            if(nums1_left_MAX<=nums2_right_MIN && nums2_left_MAX<=nums1_right_MIN){
                if((m+n)%2==1){
                    return Math.max(nums1_left_MAX,nums2_left_MAX);
                }else{
                    return (Math.max(nums1_left_MAX,nums2_left_MAX)+Math.min(nums1_right_MIN,nums2_right_MIN))/2.0;
                }
            }else if(nums1_left_MAX>nums2_right_MIN){
                right = i-1;
            }else{
                left = i+1;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] split1 = s1.split(" ");
        String[] split2 = s2.split(" ");
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
