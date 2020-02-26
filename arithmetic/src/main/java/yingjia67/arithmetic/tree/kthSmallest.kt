package yingjia67.arithmetic.tree

import yingjia67.arithmetic.TreeNode


class kthSmallest{
    class Solution {
        fun kthSmallest(root: TreeNode?, k: Int): Int {
            if(root==null){
                return 0
            }
            val leftCount = getNodeCount(root.left)
            if(leftCount == k-1){
                return root.`val`
            }else if (leftCount>k-1){
                return kthSmallest(root.left,k)
            }else{
                return kthSmallest(root.right,k-1-leftCount)
            }
        }

        fun getNodeCount(node: TreeNode?):Int{
            var totalNum = 0;
            if(node == null){
                return totalNum
            }
            totalNum+=1
            totalNum+=getNodeCount(node.left)
            totalNum+=getNodeCount(node.right)
            return totalNum
        }
    }
}