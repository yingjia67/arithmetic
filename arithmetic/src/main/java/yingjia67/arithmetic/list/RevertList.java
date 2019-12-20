package yingjia67.arithmetic.list;

public class RevertList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        listNode5.next = null;
        ListNode a = solution.reverseList(listNode1);
        a.printListNode();
    }
    static class Solution {
        public ListNode reverseList(ListNode head) {

            if(head ==null){
                return null;
            }
            if(head.next == null){
                return head;
            }

            ListNode bakNode = head;
            ListNode movedNode = null;
            while (bakNode.next!=null){
                ListNode tmpNode = bakNode.next;
               bakNode.next = movedNode;
               movedNode = bakNode;
               bakNode = tmpNode;
            }
            bakNode.next = movedNode;
            return bakNode;
        }
    }
}
