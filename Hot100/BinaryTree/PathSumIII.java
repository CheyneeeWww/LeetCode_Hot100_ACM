package LeetCode.Hot100.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 17:16 2025/5/13
 */
public class PathSumIII {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int x){
            val = x;
        }
    }

    public static TreeNode buildTree(String[] nodes){
        if(nodes == null || nodes.length == 0 || nodes[0].equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while(!queue.isEmpty() && index< nodes.length){
            TreeNode cur = queue.poll();
            if(index< nodes.length && !nodes[index].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(cur.left);
            }
            index++;
            if(index< nodes.length && !nodes[index].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(cur.right);
            }
            index++;
        }
        return root;
    }

    static int target = 0;
    //前面是和，后面的value
    static HashMap<Long,Integer> map = new HashMap<>();
    public static int pathSum(TreeNode root,int targetSum){
        target = targetSum;
        map.put(0L,1);
        return dfs(root,0L);
    }

    public static int dfs(TreeNode root,long curSum){
        if(root == null){
            return 0;
        }
        curSum += root.val;
        int ans = 0;
        ans += map.getOrDefault(curSum-target,0);
        map.put(curSum,map.getOrDefault(curSum,0)+1);
        int l = dfs(root.left,curSum);
        int r = dfs(root.right,curSum);
        ans += l+r;
        map.put(curSum,map.get(curSum)-1);
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int targetSum = sc.nextInt();
        String[] split = s.split(" ");
        TreeNode root = buildTree(split);
        int ans = pathSum(root,targetSum);
        System.out.println(ans);
    }
}
