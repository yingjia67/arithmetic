package yingjia67.arithmetic.array

class searchMatrix{
    class Solution {
        fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
            if(matrix.isEmpty()||matrix[0].isEmpty()){
                return false
            }
            var j = matrix[0].size-1
            var i = 0
            return dfs(matrix,i,j,target)
        }

        fun dfs(matrix: Array<IntArray>,i:Int,j:Int,target: Int):Boolean{
            if(i>matrix.size-1 || j<0){
                return false
            }
            if(matrix[i][j] == target){
                return true
            }else if(matrix[i][j]<target){
                var tmp = i+1
                return dfs(matrix,tmp,j,target)
            }else{
                var tmp = j-1
                return dfs(matrix,i,tmp,target)
            }
        }
    }
}