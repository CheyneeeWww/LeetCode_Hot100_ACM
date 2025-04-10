package LeetCode.Hot100.BinarySearch;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 20:39 2025/4/9
 */
public class SearchA2dMatrix {

    public static boolean SearchA2dMatrix(int[][] array,int target){
        int m = array.length;
        int n = array[0].length;

        int row_top = 0;
        int row_down = m-1;
        while(row_top<=row_down){
            int row_mid = row_top+(row_down-row_top)/2;
            if(array[row_mid][0]>target){
                row_down = row_mid-1;
            }else if(array[row_mid][n-1]<target){
                row_top = row_mid+1;
            }else{
                row_top = row_mid;
                break;
            }
        }
        if(row_top>=m || row_top<0 ||array[row_top][0]>target ||array[row_top][n-1]<target){
            return false;
        }

        int row = row_top;

        int column_left = 0;
        int column_right = n-1;
        while(column_left<=column_right){
            int column_mid = column_left+(column_right-column_left)/2;
            if(array[row][column_mid]<target){
                column_left = column_mid+1;
            }
            else if(array[row][column_mid]>target){
                column_right = column_mid-1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int target = sc.nextInt();
        s = s.substring(2,s.length()-2);
        String[] split = s.split("\\],\\[");
        int[][] array = new int [split.length][];

        for(int i=0;i< split.length;i++){
            String[] nums = split[i].split(",");
            array[i] =new int[nums.length];
            for(int j=0;j<nums.length;j++){
                array[i][j] = Integer.parseInt(nums[j]);
            }
        }
        //array这个就是二维数组
        System.out.println(SearchA2dMatrix(array,target));
    }
}
