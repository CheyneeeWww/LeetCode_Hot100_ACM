package LeetCode.Hot100.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 16:24 2025/5/13
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int x){
            val = x;
        }
        TreeNode(int x,TreeNode l,TreeNode r){
            val = x;
            left = l;
            right = r;
        }
    }

    public static TreeNode buildTree(int[] preorder,int[] inorder){
        int len = preorder.length;
        if(len == 0) return null;
        int leftSize = indexOf(inorder,preorder[0]);
        int[] pre1 = Arrays.copyOfRange(preorder,1,leftSize+1);
        int[] pre2 = Arrays.copyOfRange(preorder,leftSize+1,len);
        int[] in1 = Arrays.copyOfRange(inorder,0,leftSize);
        int[] in2 = Arrays.copyOfRange(inorder,leftSize+1,len);
        TreeNode left = buildTree(pre1,in1);
        TreeNode right = buildTree(pre2,in2);
        return new TreeNode(preorder[0],left,right);
    }

    public static int indexOf(int[] a ,int x){
        for(int i = 0;;i++){
            if(a[i] == x){
                return i;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] split1 = s1.split(" ");
        int[] preorder = new int[split1.length];
        for(int i = 0;i<split1.length;i++){
            preorder[i] = Integer.parseInt(split1[i]);
        }
        String s2 = sc.nextLine();
        String[] split2 = s2.split(" ");
        int[] inorder = new int[split2.length];
        for(int i = 0;i<split2.length;i++){
            inorder[i] = Integer.parseInt(split2[i]);
        }
        TreeNode root = buildTree(preorder,inorder);
        List<Integer> list = levelOrder(root);
        System.out.println(list);
    }

    public static List<Integer> levelOrder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode temp = queue.poll();
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
                ans.add(temp.val);
            }
        }
        return ans;
    }
}
