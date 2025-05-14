package LeetCode.Hot100.Graph;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 11:30 2025/5/14
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid){
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void dfs(int i,int j,char[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[rows][cols];
        for(int i = 0;i<rows;i++){
            String s = sc.nextLine();
            String[] split = s.split(" ");
            for(int j = 0;j<cols;j++){
                grid[i][j] = split[j].charAt(0);
            }
        }
        System.out.println(numIslands(grid));
    }
}
