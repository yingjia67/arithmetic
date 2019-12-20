package yingjia67.arithmetic.list;

public class OddEventNode {
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
        listNode4.next = listNode5;
        listNode5.next = null;
        solution.oddEvenList(listNode1).printListNode();
    }
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head == null || head.next == null||head.next.next == null){
                return head;
            }
            ListNode oddNode = head;
            ListNode eventNode = head.next;
            ListNode oddMovedNode = oddNode;
            ListNode eventMovedNode = eventNode;
            while (eventMovedNode.next!=null&&eventMovedNode.next.next != null){
                oddMovedNode.next = oddMovedNode.next.next;
                oddMovedNode = oddMovedNode.next;
                eventMovedNode.next = eventMovedNode.next.next;
                eventMovedNode = eventMovedNode.next;
            }
            if(oddMovedNode.next!=null&&oddMovedNode.next.next!=null){
                oddMovedNode.next = oddMovedNode.next.next;
                oddMovedNode = oddMovedNode.next;
                eventMovedNode.next = null;
                oddMovedNode.next = eventNode;
            }else {
                eventMovedNode.next = null;
                oddMovedNode.next = eventNode;
            }
            return oddNode;
        }
    }
}
