package yingjia67.arithmetic;

// Definition for a Node.

public class PublicClass{
    public static class Node {
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
        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
    };

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
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

    public static class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }
  }

}




