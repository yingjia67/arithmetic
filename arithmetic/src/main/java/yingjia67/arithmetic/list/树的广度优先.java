package yingjia67.arithmetic.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import yingjia67.arithmetic.list.struct.TreeNode;

public class 树的广度优先 {
    public static class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> lists=new ArrayList<Integer>();
            if(root==null)
                return lists;
            Queue<TreeNode> queue=new LinkedList<TreeNode>();
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode tree=queue.poll();
                if(tree.left!=null)
                    queue.offer(tree.left);
                if(tree.right!=null)
                    queue.offer(tree.right);
                lists.add(tree.val);
            }
            return lists;
        }
    }
}
