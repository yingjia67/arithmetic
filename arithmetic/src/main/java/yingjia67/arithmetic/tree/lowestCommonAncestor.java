package yingjia67.arithmetic.tree;

import java.util.LinkedList;
import yingjia67.arithmetic.PublicClass.TreeNode;

public class lowestCommonAncestor {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            LinkedList<TreeNode> path1 = new LinkedList();
            LinkedList<TreeNode> path2 = new LinkedList();
            findPath(root,p,path1);
            findPath(root,q,path2);
            TreeNode tmp = root;
            while(true){
                TreeNode a = path1.poll();
                TreeNode b = path2.poll();
                if(a == null){
                    return tmp;
                }
                if(b == null){
                    return tmp;
                }
                if(a.val!=b.val){
                    break;
                }
                tmp =a;
            }
            return tmp;


        }

        public boolean findPath(TreeNode node, TreeNode target,LinkedList<TreeNode> list){
            if(node == null){
                return false;
            }
            list.addLast(node);
            if(node.val == target.val){
                return true;
            }
            if(findPath(node.left,target,list)){
                return true;
            }
            if(findPath(node.right,target,list)){
                return true;
            }
            list.removeLast();
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
        Solution solution = new Solution();
        solution.lowestCommonAncestor(node3,node5,node4);


    }
}
