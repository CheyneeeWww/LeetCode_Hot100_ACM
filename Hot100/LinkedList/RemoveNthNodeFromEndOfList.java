package LeetCode.Hot100.LinkedList;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 23:24 2025/5/11
 */
public class RemoveNthNodeFromEndOfList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode RemoveNthNodeFromEndOfList(ListNode head,int n){
        //还是用快慢指针，先走n步，然后一起走
        //然后慢针到了n前一个，直接nextnext
        ListNode slow = new ListNode();
        ListNode fast = slow;
        ListNode cur = slow;
        slow.next = head;
        for(int i = 0;i<n+1;i++){
            fast = fast.next;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
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
        int n = sc.nextInt();
        ListNode cur = RemoveNthNodeFromEndOfList(head,n);
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
    }
}
