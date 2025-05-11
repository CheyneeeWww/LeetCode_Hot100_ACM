package LeetCode.Hot100.LinkedList;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 21:44 2025/5/10
 */
public class PalindromeLinkedList {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static boolean PalindromeLinkedList(ListNode head){
        if(head == null || head.next == null){
            return true;
        }

        //找到一个中点
        ListNode slow = head,fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseHalf = reverseList(slow);

        ListNode p1 = head,p2 = reverseHalf;
        boolean result = true;
        while(p2!=null){
            if(p1.val != p2.val){
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        reverseList(reverseHalf);
        return result;
    }

    public static ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre = null, temp = null;
        while(cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode temp = head;
        for(int i = 1;i< split.length;i++){
            temp.next = new ListNode(Integer.parseInt(split[i]));
            temp = temp.next;
        }
        System.out.println(PalindromeLinkedList(head));
    }
}
