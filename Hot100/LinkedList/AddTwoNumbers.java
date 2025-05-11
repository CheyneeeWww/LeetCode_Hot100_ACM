package LeetCode.Hot100.LinkedList;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 21:54 2025/5/11
 */
public class AddTwoNumbers {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode AddTwoNumbers(ListNode l1,ListNode l2){
        ListNode head = new ListNode();
        ListNode temp = head;
        int x = 0;
        while(l1!=null || l2 !=null){
            int val1 = l1 == null? 0:l1.val;
            int val2 = l2 == null? 0:l2.val;
            temp.next = new ListNode((val1+val2+x)%10);
            x = (val1+val2+x)/10;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(x == 1){
            temp.next = new ListNode(x);
        }
        return head.next;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] split1 = s1.split(" ");
        ListNode head1 = new ListNode(Integer.parseInt(split1[0]));
        ListNode temp1 = head1;
        for(int i = 1;i< split1.length;i++){
            temp1.next = new ListNode(Integer.parseInt(split1[i]));
            temp1 = temp1.next;
        }

        String s2 = sc.nextLine();
        String[] split2 = s2.split(" ");
        ListNode head2 = new ListNode(Integer.parseInt(split2[0]));
        ListNode temp2 = head2;
        for(int i = 1;i< split2.length;i++){
            temp2.next = new ListNode(Integer.parseInt(split2[i]));
            temp2 = temp2.next;
        }
        ListNode temp = AddTwoNumbers(head1,head2);
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
