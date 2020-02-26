package yingjia67.arithmetic.tree;
import yingjia67.arithmetic.PublicClass.TreeNode;

public class RebuildTree {
    static class Solution{
        public TreeNode rebuildTree(int[] first,int[] middle){
            TreeNode node = rebuildTree(first,0,first.length-1,middle,0,middle.length-1);
            return node;
        }
        public TreeNode rebuildTree(int[] first,int firstLeft,int firstRight,int[] middle,int middleLeft,int middleRight){
            System.out.println(firstLeft+" "+firstRight+" "+middleLeft+" "+middleRight);
            if(middleRight<middleLeft||firstRight<firstLeft){
                return null;
            }
            TreeNode node = new TreeNode(first[firstLeft]);
            int value = first[firstLeft];
            int i;
            for(i = 0;i<middleRight-middleLeft+1;i++){
                if(middle[middleLeft+i] == value){
                    break;
                }
            }
            int middleLeft1 = middleLeft;
            int middleRight1 = middleLeft+i-1;
            int middleLeft2 = middleLeft+i+1;
            int middleRight2 = middleRight;

            int firstLeft1 = firstLeft+1;
            int firstRight1 = firstLeft1+i-1;
            int firstLeft2 = firstRight1+1;
            int firstRight2 = firstRight;

            node.left = rebuildTree(first,firstLeft1,firstRight1,middle,middleLeft1,middleRight1);
            node.right = rebuildTree(first,firstLeft2,firstRight2,middle,middleLeft2,middleRight2);
            return node;
        }
    }

    public static void main(String[] args) {
        int[] first = {1,2,4,7,3,5,6,8};
        int[] middle = {4,7,2,1,5,3,8,6};
        Solution solution = new Solution();
        solution.rebuildTree(first,middle);
    }
}
