package LeetCode.Hot100.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 19:34 2025/5/13
 */
public class BinaryTreeMaximumPathSum {
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

    static int ans = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root){
        dfs(root);
        return ans;
    }

    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int t = root.val;
        if(left>=0){
            t+=left;
        }
        if(right>=0){
            t+=right;
        }
        ans = Math.max(ans,t);
        return Math.max(root.val,Math.max(right,left)+root.val);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        TreeNode root = buildTree(split);
        System.out.println(maxPathSum(root));
    }
}
