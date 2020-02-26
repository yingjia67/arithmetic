package yingjia67.arithmetic.list;

import yingjia67.arithmetic.PublicClass.ListNode;

public class DeleteNode {
    static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
