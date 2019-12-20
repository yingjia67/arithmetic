package yingjia67.arithmetic.list;

public class ReList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = null;
        solution.isPalindrome(listNode1);

    }
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null||head.next == null){
                return true;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next!=null&&fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode tmpNode = slow.next;
            slow.next = null;
            tmpNode = reverseList(tmpNode);
            slow = head;
            while (tmpNode!=null&&slow!=null){
                if(tmpNode.val!=slow.val){
                    return false;
                }
                tmpNode = tmpNode.next;
                slow = slow.next;
            }
            return true;
        }
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
