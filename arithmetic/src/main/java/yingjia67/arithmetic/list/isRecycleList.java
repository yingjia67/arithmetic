package yingjia67.arithmetic.list;


//判断是否回文链表
class isRecycleList{
    public static void main(String args[]) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = null;
        //solution.isPalindrome(listNode1);
        ListNode list = solution.getMidNode(listNode1);
        printList(list);
    }

    public static void  printList(ListNode node){
        ListNode movedNode = node;
        while (movedNode!=null){
            System.out.println(movedNode.val);
            movedNode = movedNode.next;
        }
    }

    public static  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null||head.next == null){
                return true;
            }
            ListNode bakNode = getMidNode(head);
            ListNode list2 = bakNode.next;
            bakNode.next = null;
            list2 = reverList(list2);
            ListNode list1 = head;
            while (list2!=null){
                if(list1.val!=list2.val){
                    return false;
                }
                list2 = list2.next;
                list1 = list1.next;
            }
            return true;
        }
        public ListNode getMidNode(ListNode head){
            if(head == null||head.next == null){
                return head;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next!=null && fast.next.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        public ListNode reverList(ListNode head){
            if(head == null||head.next == null){
                return head;
            }
            ListNode  pre = null;
            ListNode  latter = head;
            while (latter!=null){
                ListNode bakPre = pre;
                ListNode bakLatter = latter;
                pre = latter;
                latter = latter.next;
                bakLatter.next = bakPre;
            }
            return pre;
        }
    }
}

