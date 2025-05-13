package LeetCode.Hot100.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 13:42 2025/5/13
 */
public class KTHSmallestElementInABST {
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

    private static int k;
    private static int ans;

    public static int kthSmallest(TreeNode root,int kth){
        //中序遍历就是从小到大的
        //第k小的就是中序遍历的第k个
        k = kth;
        dfs(root);
        return ans;
    }

    public static void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        if(--k==0){
            ans = root.val;
            return;
        }
        dfs(root.right);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        TreeNode root = buildTree(split);
        int k = sc.nextInt();
        int ans = kthSmallest(root,k);
        System.out.println(ans);
    }

}
