package LeetCode.Hot100.LinkedList;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 19:33 2025/5/11
 */
public class LinkedListCycleII {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode LinkedListCycleII(ListNode head){
        ListNode slow = head,fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                ListNode temp = head;
                while(temp!=slow){
                    slow = slow.next;
                    temp = temp.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split =s.split(" ");
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode temp = head;
        for(int i = 1;i<split.length;i++){
            temp.next = new ListNode(Integer.parseInt(split[i]));
            temp = temp.next;
        }

        int pos = sc.nextInt();
        if(pos!=-1){
            ListNode lastNode = head;
            while(lastNode.next!=null){
                lastNode = lastNode.next;
            }
            ListNode cycleNode = head;
            for(int i=0;i<pos;i++){
                cycleNode = cycleNode.next;
            }
            lastNode.next = cycleNode;
        }
        System.out.println(LinkedListCycleII(head).val);
    }
}
