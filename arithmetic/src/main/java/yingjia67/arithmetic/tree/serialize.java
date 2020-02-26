package yingjia67.arithmetic.tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import yingjia67.arithmetic.PublicClass.TreeNode;


public class serialize {
    static public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            serialize(root,builder);
            return builder.toString().trim();
        }

        public void serialize(TreeNode node,StringBuilder builder){
            if(node == null){
                builder.append(' ');
                builder.append("$");
                return;
            }else {
                builder.append(' ');
                builder.append(node.val);
            }
            serialize(node.left,builder);
            serialize(node.right,builder);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strings = data.split(" ");
            Queue<String> queue = new LinkedList<>();
            for(int i = 0;i<strings.length;i++){
                queue.add(strings[i]);
            }
            return deserialize(queue);

        }
        public TreeNode deserialize(Queue<String> queue) {
            if(queue.isEmpty()){
                return null;
            }
            String value = queue.poll();
            if(value.equals("$")){
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(value));
            node.left = deserialize(queue);
            node.right = deserialize(queue);
            return node;

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
        Codec codec = new Codec();
        String se = codec.serialize(node3);
        System.out.println(se);
        TreeNode node = codec.deserialize(se);
        System.out.println(codec.serialize(node));
    }
}
