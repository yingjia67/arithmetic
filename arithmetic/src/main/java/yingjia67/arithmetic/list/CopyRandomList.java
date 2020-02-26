package yingjia67.arithmetic.list;

import java.util.HashMap;
import yingjia67.arithmetic.PublicClass.Node;

public class CopyRandomList {

    static class Solution {
        public Node copyRandomList(Node head) {


            if(head == null){
                return null;
            }
            HashMap<Node,Node> map = new HashMap<>();
            Node currentNode = head;
            Node currentNodeNew = copyNode(head);
            Node headNew = currentNodeNew;
            map.put(currentNode,currentNodeNew);
            while (currentNode.next!=null){
                currentNode = currentNode.next;
                Node tmpNode = copyNode(currentNode);
                currentNodeNew.next = tmpNode;
                currentNodeNew = tmpNode;
                map.put(currentNode,currentNodeNew);
            }
            currentNode = head;
            currentNodeNew = headNew;
            while (currentNode.next!=null){
                currentNodeNew.random = map.get(currentNode.random);
                currentNode = currentNode.next;
                currentNodeNew = currentNodeNew.next;
            }
            currentNodeNew.random = map.get(currentNode.random);
            return headNew;
        }
        Node copyNode(Node node){
            return new Node(node.val,node.next,node.random);
        }
        void printNode(Node node){
            Node tmpNode = node;
            if(tmpNode!=null){
                System.out.println(tmpNode);
                System.out.println(tmpNode.val);
                System.out.println(tmpNode.random);
                System.out.println(tmpNode.random.val);
            }
            while (tmpNode.next != null){
                System.out.println(tmpNode.next);
                System.out.println(tmpNode.next.val);
                System.out.println(tmpNode.next.random);
                System.out.println(tmpNode.next.random.val);
                tmpNode = tmpNode.next;
            }
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        node1.next = node2;
        node1.val = 1;
        node1.random = node3;
        node2.next = node3;
        node2.val = 2;
        node2.random = node4;
        node3.next = node4;
        node3.val = 3;
        node3.random = node1;
        node4.next = null;
        node4.val = 4;
        node4.random = node2;
        Solution solution = new Solution();
        solution.printNode(node1);
        System.out.println();
        solution.printNode(solution.copyRandomList(node1));

    }
}



