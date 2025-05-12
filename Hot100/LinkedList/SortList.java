package LeetCode.Hot100.LinkedList;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 11:40 2025/5/12
 */
public class SortList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode SortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head,fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = SortList(head);
        ListNode right = SortList(temp);


        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(left!=null && right!=null){
            if(left.val<right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null? right:left;
        return dummy.next;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode cur = head;
        for(int i = 1;i< split.length;i++){
            cur.next = new ListNode(Integer.parseInt(split[i]));
            cur = cur.next;
        }

        ListNode temp = SortList(head);
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
