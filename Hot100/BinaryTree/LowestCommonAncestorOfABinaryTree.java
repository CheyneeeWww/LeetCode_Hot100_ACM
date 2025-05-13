package LeetCode.Hot100.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 19:33 2025/5/13
 */
public class LowestCommonAncestorOfABinaryTree {
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

    public static TreeNode findNode(TreeNode root,int value){
        if(root == null || root.val == value){
            return root;
        }
        TreeNode l = findNode(root.left,value);
        TreeNode r = findNode(root.right,value);
        return l==null?r:l;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root == null || p == root || q == root){
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        if(l != null && r != null){
            return root;
        }
        return l == null ?r:l;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        TreeNode root = buildTree(split);
        int pVal = sc.nextInt();
        TreeNode p = findNode(root,pVal);
        int qVal = sc.nextInt();
        TreeNode q = findNode(root,qVal);
        System.out.println(lowestCommonAncestor(root,p,q).val);
    }

}
