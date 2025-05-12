package LeetCode.Hot100.LinkedList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author cnwang
 * @Date created in 10:42 2025/5/12
 */
public class CopyListWithRandomPointer {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode random;
        ListNode(){};
        ListNode(int x){
            val = x;
            next = null;
            random = null;
        }
    }

    public static ListNode CopyListWithRandomPointer(ListNode head){

        ListNode cur = head;
        HashMap<ListNode,ListNode> map = new HashMap<>();
        while(cur!=null){
            map.put(cur,new ListNode(cur.val));
            cur = cur.next;
        }

        cur = head;
        while(cur!=null){
            ListNode node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
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

        ListNode cur = CopyListWithRandomPointer(head);
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

    }
}
