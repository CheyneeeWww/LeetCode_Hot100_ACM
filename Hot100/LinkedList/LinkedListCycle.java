package LeetCode.Hot100.LinkedList;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 18:59 2025/5/11
 */
public class LinkedListCycle {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static boolean LinkedListCycle(ListNode head){
        ListNode slow = head,fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        //1.构建链表
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode temp = head;
        for(int i = 1;i<split.length;i++){
            temp.next = new ListNode(Integer.parseInt(split[i]));
            temp = temp.next;
        }
        //2.获取环的位置并构建环
        int pos = sc.nextInt();
        if(pos!=-1){
            ListNode lastNode = head;
            while(lastNode.next!=null){
                lastNode = lastNode.next;
            }
            ListNode cycleNode = head;
            for(int i = 0;i<pos;i++){
                cycleNode = cycleNode.next;
            }
            lastNode.next = cycleNode;
        }
        System.out.println(LinkedListCycle(head));
    }
}
