package LeetCode.Hot100.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 11:30 2025/5/14
 */
public class RottingOranges {

    public static int orangesRotting(int[][] grid){
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        int time = 0;
        int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            //queue中存的是腐烂的橘子，每一轮
            boolean flag = false;
            //用于标记当前遍历是否感染了新鲜橘子
            for(int i = 0;i<size;i++){
                int[] cur = queue.poll();
                for(int[] dir:direction){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y] == 1 ){
                        grid[x][y] = 2;
                        queue.offer(new int[]{x,y});
                        fresh--;
                        flag = true;
                    }
                }
            }
            if(flag){
                time++;
            }
        }
        return fresh == 0? time:-1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();
        int[][] nums = new int[rows][cols];
        for(int i = 0;i<rows;i++){
            String s = sc.nextLine();
            String[] split = s.split(" ");
            for(int j = 0;j<cols;j++){
                nums[i][j] = Integer.parseInt(split[j]);
            }
        }
        System.out.println(orangesRotting(nums));
    }
}
