package LeetCode.Hot100.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 15:51 2025/5/13
 */
public class FlattenBinaryTreeToLinkedList {
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

    public static void flatten(TreeNode root){
        while(root!=null){
            TreeNode left = root.left;
            TreeNode temp = left;
            if(temp!=null){
                while(temp.right!=null){
                    temp = temp.right;
                }
                temp.right = root.right;
                root.left = null;
                root.right = left;
            }
            root = root.right;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        TreeNode root = buildTree(split);
        flatten(root);
        while(root!=null){
            System.out.print(root.val+" ");
            root = root.right;
        }
    }

}
