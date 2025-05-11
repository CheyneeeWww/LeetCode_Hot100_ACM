package LeetCode.Hot100.LinkedList;

/**
 * @Author cnwang
 * @Date created in 23:05 2025/5/9
 */
public class IntersectionOfTwoLinkedLists {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode IntersectionOfTwoLinkedLists(ListNode headA,ListNode headB){
        ListNode A = headA, B = headB;
        while(A!=B){
            A = A == null? headB : A.next;
            B = B == null? headA : B.next;
        }
        return A;
    }
    //只会写死输入的方式
    public static void main(String[] args){
        //构建链表A
        //这里用sample1中的：4->1->8->4->5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        //构建链表B：
        //这里用sample1中的5->6->1->8->4->5
        //相交节点是8
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        System.out.println(IntersectionOfTwoLinkedLists(headA,headB).val);


    }
}
