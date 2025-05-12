package LeetCode.Hot100.LinkedList;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 1:00 2025/5/12
 */
public class SwapNodesInPairs {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode SwapNodesInPairs(ListNode head){
        ListNode cur = new ListNode();
        ListNode temp = cur;
        cur.next = head;
        while(head != null && head.next != null){
            //这边是在交换
            temp.next = head.next;
            head.next = head.next.next;
            temp.next.next = head;
            //下面是为了下一个循环做准备
            temp = head;
            head = head.next;
        }
        return cur.next;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode temp = head;
        for(int i = 1;i< split.length;i++){
            temp.next = new ListNode(Integer.parseInt(split[i]));
            temp = temp.next;
        }
        ListNode cur = SwapNodesInPairs(head);
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }
}
