package LeetCode.Hot100.LinkedList;

import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 20:32 2025/5/11
 */
public class MergeTwoSortedLists {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode MergeTwoSortedLists(ListNode list1,ListNode list2){
        ListNode head = new ListNode();
        ListNode cur = head;
        while(list1 != null && list2 != null){
            if(list1.val>list2.val){
                cur.next = list2;
                list2 = list2.next;
            }else{
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2:list1;
        return head.next;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] split1 = s1.split(" ");
        ListNode head1 = new ListNode(Integer.parseInt(split1[0]));
        ListNode temp1 = head1;
        for(int i = 1;i<split1.length;i++){
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

        ListNode temp = MergeTwoSortedLists(head1,head2);
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }

    }
}
