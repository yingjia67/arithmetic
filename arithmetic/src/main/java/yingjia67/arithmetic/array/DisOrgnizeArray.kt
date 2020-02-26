package yingjia67.arithmetic.array

import java.util.*

class DisOrgnizeArray {
    class Solution(nums: IntArray) {

        val originArray = nums


        /** Resets the array to its original configuration and return it. */
        fun reset(): IntArray {
            return originArray
        }

        /** Returns a random shuffling of the array. */
        fun shuffle(): IntArray {
            val currentArray = originArray.copyOf()
            currentArray.indices.forEach {
                val random: Int = (Math.random()*currentArray.size).toInt()
                val tmp = currentArray[it]
                currentArray[it] = currentArray[random]
                currentArray[random] = tmp;
            }
            return currentArray
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * var obj = Solution(nums)
     * var param_1 = obj.reset()
     * var param_2 = obj.shuffle()
     */
}

fun main() {
    val array = intArrayOf(1,2,3)
    val solution = DisOrgnizeArray.Solution(array)
    solution.shuffle().forEach {
        print(it)
    }
}