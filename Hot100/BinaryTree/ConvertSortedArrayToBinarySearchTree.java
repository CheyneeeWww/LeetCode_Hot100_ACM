package LeetCode.Hot100.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 12:24 2025/5/13
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int x){
            val = x;
        }
    }

    public static TreeNode buildBST(int[] nodes,int left,int right){
        if(left>right){
            return null;
        }
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(nodes[mid]);
        root.left = buildBST(nodes,left,mid-1);
        root.right = buildBST(nodes,mid+1,right);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums){
        return buildBST(nums,0,nums.length-1);
    }

    public static List<Integer> levelOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            res.add(temp.val);

            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for(int i = 0;i< split.length;i++){
            nums[i] = Integer.parseInt(split[i]);
        }
        TreeNode root = sortedArrayToBST(nums);
        List<Integer> list = levelOrder(root);
        System.out.println(list);
    }
}
