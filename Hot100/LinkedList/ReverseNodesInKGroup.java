package LeetCode.Hot100.LinkedList;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 10:07 2025/5/12
 */
public class ReverseNodesInKGroup {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode ReverseNodesInKGroup(ListNode head,int k){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        int count = 0;
        while(cur.next!=null){
            count++;
            cur = cur.next;
        }
        //链表长度
        cur = head;
        ListNode pre = null;
        ListNode temp = null;
        ListNode node = dummy;
        while(count>=k){
            for(int i = 0;i<k;i++){
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            ListNode tail = node.next;
            node.next = pre;
            tail.next = cur;
            node = tail;

            count -= k;
        }
        return dummy.next;
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
        int k = sc.nextInt();
        ListNode cur = ReverseNodesInKGroup(head,k);
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }
}
