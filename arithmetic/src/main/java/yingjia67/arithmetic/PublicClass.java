package yingjia67.arithmetic;

// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
    public void printNode(){
        Node tmpNode = this;
        while (tmpNode!=null){
            System.out.println(tmpNode.val);
            tmpNode = tmpNode.next;
        }
    }
};
/**
 * Definition for singly-linked list.
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    public void printListNode(){
        ListNode tmpNode = this;
        while (tmpNode!=null){
            System.out.println(tmpNode.val);
            tmpNode = tmpNode.next;
        }
    }
}
