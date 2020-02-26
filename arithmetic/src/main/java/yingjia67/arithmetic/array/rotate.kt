package yingjia67.arithmetic.array

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        var bakValue = 0;
        var len:Int = nums.size
        var  totalTimes = 0;
        var loopStart = 0;

        while (totalTimes<len){
            var currentIndex = loopStart;
            bakValue = nums[currentIndex]
            while (true){
                totalTimes++;
                var nextIndex = (currentIndex-k)%len
                if(nextIndex<0){
                    nextIndex+=len
                }
                if(nextIndex == loopStart){
                    nums[currentIndex] = bakValue
                    break
                }
                nums[currentIndex] = nums[nextIndex]
                currentIndex = nextIndex
            }
            loopStart++;
        }
    }
}

fun main() {
    var nums:IntArray = intArrayOf(1,2,3,4,5,6)
    val solution = Solution()
    solution.rotate(nums,2)
    nums.forEach { print(it) }

}