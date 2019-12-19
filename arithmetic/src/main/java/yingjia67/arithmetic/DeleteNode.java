package yingjia67.arithmetic;

public class DeleteNode {
    static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
