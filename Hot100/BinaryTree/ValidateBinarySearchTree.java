package LeetCode.Hot100.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Integer.MIN_VALUE;

/**
 * @Author cnwang
 * @Date created in 13:10 2025/5/13
 */
public class ValidateBinarySearchTree {
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
        while(!queue.isEmpty() && index< nodes.length ){
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

    static long root_val = Long.MIN_VALUE;
    //中序遍历
    public static boolean isValidBST(TreeNode root){
        if(root==null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val<=root_val){
            return false;
        }
        root_val = root.val;
        //在这里是左边的
        if(!isValidBST(root.right)){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        TreeNode root = buildTree(split);
        System.out.println(isValidBST(root));
    }
}
