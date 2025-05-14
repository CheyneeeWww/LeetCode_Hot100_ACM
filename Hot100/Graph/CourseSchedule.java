package LeetCode.Hot100.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 11:30 2025/5/14
 */
public class CourseSchedule {

    public static boolean canFinish(int numCourses,int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {       //(a,b)要想学习a得先学习b，因此构建b——>a的有向边
            graph.get(pre[1]).add(pre[0]);
        }

        int[] visited = new int[numCourses];

        for(int i = 0;i<numCourses;i++){
            if(hasCycle(graph,visited,i)){
                return false;
            }
        }
        return true;
    }

    public static boolean hasCycle(List<List<Integer>> graph,int[] visited,int course){
        if(visited[course] == 1){
            return true;
        }
        if(visited[course] == 2){
            return false;
        }

        visited[course] = 1;//正在访问
        for(int nextCourse : graph.get(course)){
            if(hasCycle(graph, visited, nextCourse)){
                return true;
            }
        }
        visited[course] = 2;
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numCourses = sc.nextInt();
        int preLength = sc.nextInt();
        sc.nextLine();
        int[][] pre = new int[preLength][2];
        for(int i = 0;i<preLength;i++){
            String s = sc.nextLine();
            String[] split = s.split(" ");
            pre[i][0] = Integer.parseInt(split[0]);
            pre[i][1] = Integer.parseInt(split[1]);
        }
        System.out.println(canFinish(numCourses,pre));
    }

}
