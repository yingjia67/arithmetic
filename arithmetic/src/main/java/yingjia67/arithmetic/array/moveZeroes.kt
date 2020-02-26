package yingjia67.arithmetic.array

class moveZeroes{
    class Solution {
        fun moveZeroes(nums: IntArray): Unit {
            var totalNum = 0;
            nums.forEachIndexed { index, i ->
                if(i == 0){
                    totalNum++
                }
                if(i!=0 && totalNum!=0){
                    nums[index-totalNum] = nums[index]
                }
            }
            for(i in 0 until totalNum) {
                nums[nums.size - 1 - i] = 0
            }
        }
    }
}

fun main() {
    var arr = intArrayOf(0,1,2,0,12)
    var solution = moveZeroes.Solution()
    solution.moveZeroes(arr)
    arr.forEach {
        println(it)
    }
}