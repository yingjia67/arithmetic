package yingjia67.arithmetic.list;

import yingjia67.arithmetic.list.struct.TreeNode;

public class 树的深度优先 {

    private void depthTraversal(TreeNode tn)
    {
        if (tn!=null)
        {
            System.out.print(tn.val+"  ");
            depthTraversal(tn.left);
            depthTraversal(tn.right);
        }
    }
}
