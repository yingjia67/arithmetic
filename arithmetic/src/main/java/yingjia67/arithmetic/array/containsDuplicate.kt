package yingjia67.arithmetic.array

class containsDuplicate {
    class Solution {
        fun containsDuplicate(nums: IntArray): Boolean {
            var set = HashSet<Int>()
            return nums.any {it ->
                if (set.contains(it))
                    return@any true
                else{
                    set.add(it)
                    return@any false
                }
            }

        }
    }
}

fun main() {
    var intArray = intArrayOf(1,2,3,1)
    var solution = containsDuplicate.Solution()
    solution.containsDuplicate(intArray)
}

