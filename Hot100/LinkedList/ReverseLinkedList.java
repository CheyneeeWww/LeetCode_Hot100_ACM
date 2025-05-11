package LeetCode.Hot100.LinkedList;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 0:23 2025/5/10
 */
public class ReverseLinkedList {
    public static class ListNode{
        //节点存储的值
        int val;
        //指向下一个节点的引用（指针）
        ListNode next;
        //无参构造ListNode(){}
        ListNode(){};
        //有参构造ListNode
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode temp = null,pre = null;
        while(cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode temp = head;
        for(int i = 1;i<split.length;i++){
            temp.next = new ListNode(Integer.parseInt(split[i]));
            temp = temp.next;
        }
        ListNode reverseHead = reverseList(head);
        while(reverseHead != null){
            System.out.println(reverseHead.val);
            reverseHead = reverseHead.next;
        }

    }
}
