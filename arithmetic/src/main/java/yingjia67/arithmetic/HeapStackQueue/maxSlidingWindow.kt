package yingjia67.arithmetic.HeapStackQueue

import java.util.*
import kotlin.collections.ArrayList

class maxSlidingWindow{
    class Solution {
        fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
            val retList = ArrayList<Int>()
            val tmpList = LinkedList<Int>()
            nums.forEachIndexed { index, i ->
                if(!tmpList.isEmpty()&&tmpList.peek()<index-k+1){
                    tmpList.poll()
                }
                while (!tmpList.isEmpty()&&i>nums[tmpList.last()]){
                    tmpList.removeLast()
                }
                tmpList.add(index)
                if(index>=k-1){
                    retList.add(nums[tmpList.peek()])
                }
            }
            return retList.toTypedArray().toIntArray()
        }
    }
}

fun main() {
    val solution = maxSlidingWindow.Solution()
    val array = intArrayOf(1,3,-1,-3,5,3,6,7)
    val k = 3
    solution.maxSlidingWindow(array,k).forEach {
        println(it)
    }
}