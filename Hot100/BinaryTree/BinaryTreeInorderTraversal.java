package LeetCode.Hot100.BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 20:38 2025/5/12
 */
public class BinaryTreeInorderTraversal {
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
        while(!queue.isEmpty() && index < nodes.length){
            TreeNode cur = queue.poll();

            if(index<nodes.length && !nodes[index].equals("null")){
                cur.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(cur.left);
            }
            index++;

            if(index<nodes.length && !nodes[index].equals("null")){
                cur.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.offer(cur.right);
            }
            index++;
        }
        return root;
    }

    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        dfs(res,root);
        return res;
    }

    public static void dfs(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        dfs(res,root.left);
        res.add(root.val);
        dfs(res,root.right);
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        TreeNode root = buildTree(split);
        List<Integer> list = inorderTraversal(root);
        System.out.println(list);
    }
    
}
