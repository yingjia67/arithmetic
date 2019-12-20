package yingjia67.arithmetic.list;

public class CrossList {
    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null){
                return null;
            }
            ListNode tmpA = headA;
            ListNode tmpB = headB;
            ListNode node = null;
            while (tmpA!=null&&tmpB!=null){
                tmpA = tmpA.next;
                tmpB = tmpB.next;
            }
            if(tmpA==null){
                node = headB;
                while (tmpB!=null){
                   tmpB = tmpB.next;
                   node = node. next;

                }
                tmpA = headA;
                while (node!=null){
                    if(node == tmpA){
                        return node;
                    }
                    node = node.next;
                    tmpA = tmpA.next;
                }
            }
            if(tmpB==null){
                node = headA;
                while (tmpA!=null){
                    tmpA = tmpA.next;
                    node = node. next;

                }
                tmpB = headB;
                while (node!=null){
                    if(node == tmpB){
                        return node;
                    }
                    node = node.next;
                    tmpB = tmpB.next;
                }
            }

            return null;
        }
    }
}
