package LeetCode.Hot100.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 9:53 2025/5/13
 */
public class DiameterOfBinaryTree {
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
        while(!queue.isEmpty() && index<nodes.length){
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

    static int ans = 0;
    public static int dismeterOfBinaryTree(TreeNode root){
        dfs(root);
        return ans;
    }

    public static int dfs(TreeNode root){
        if(root == null){
            return -1;
        }
        int left = dfs(root.left)+1;
        int right = dfs(root.right)+1;
        ans = Math.max(ans,left+right);
        return Math.max(left,right);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        TreeNode root = buildTree(split);
        System.out.println(dismeterOfBinaryTree(root));

    }
}
