package yingjia67.arithmetic.list;

import yingjia67.arithmetic.PublicClass.ListNode;
public class SortList {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode3;

        listNode3.next = listNode2;
        listNode2.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        listNode1.printListNode();
        System.out.println();
        System.out.println();
        solution.sortList(listNode1).printListNode();

    }
    static class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null){
                return null;
            }
            if(head.next == null){
                return head;
            }

            return sortListRecursion(head);
        }

        ListNode sortListRecursion(ListNode head){

            ListNode middleLastNode = getMiddleLastNode(head);
            if(null == middleLastNode){
                return head;
            }
            ListNode middleNode = middleLastNode.next;
            middleLastNode.next = null;
            return mergeList(sortListRecursion(head),sortListRecursion(middleNode));
        }

        ListNode mergeList(ListNode node1,ListNode node2){
            ListNode tmpNode1 = node1;
            ListNode tmpNode2 = node2;
            ListNode combineNode = null;
            ListNode headNode;
            if(node1.val<node2.val){
                headNode = node1;
            }else {
                headNode = node2;
            }
            while (tmpNode1!=null && tmpNode2!=null){
                if(tmpNode1.val<tmpNode2.val){
                    if(combineNode == null){
                        combineNode = tmpNode1;
                        tmpNode1 = tmpNode1.next;
                        combineNode.next = null;
                    }
                    else {
                        combineNode.next = tmpNode1;
                        tmpNode1 = tmpNode1.next;
                        combineNode = combineNode.next;
                        combineNode.next =null;
                    }
                }else {
                    if(combineNode == null){
                        combineNode = tmpNode2;
                        tmpNode2 = tmpNode2.next;
                        combineNode.next = null;
                    }
                    else {
                        combineNode.next = tmpNode2;
                        tmpNode2 = tmpNode2.next;
                        combineNode = combineNode.next;
                        combineNode.next =null;
                    }

                }
            }
            if(tmpNode1!=null){
                combineNode.next = tmpNode1;
            }
            if(tmpNode2!=null){
                combineNode.next = tmpNode2;
            }
            return headNode;
        }

        ListNode getMiddleLastNode(ListNode node){
            if(node.next == null){
                return null;
            }
            if(node.next.next == null){
                return node;
            }
            ListNode slow = node;
            ListNode fast = node;
            ListNode tmpNode = null;
            while (fast.next!=null&&fast.next. next!=null){
                fast = fast.next.next;
                tmpNode = slow;
                slow = slow.next;
            }
            return tmpNode;
        }
    }


}
