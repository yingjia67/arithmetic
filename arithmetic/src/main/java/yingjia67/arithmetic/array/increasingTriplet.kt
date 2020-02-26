package yingjia67.arithmetic.array

class increasingTriplet{
    class Solution {
        fun increasingTriplet(nums: IntArray): Boolean {
            val len = nums.size
            if(len<3){
                return false
            }
            var a = nums[0]
            var b:Int? = null



           for(i in 1 until len){
                if(b == null){
                    if(nums[i]>a){
                        b = nums[i]
                    }
                    if(nums[i]<a){
                        a = nums[i]
                    }
                }else{
                    if(nums[i]<a){
                        //b = a
                        a = nums[i]
                    }
                    if(nums[i]<b && nums[i]>a){
                        b = nums[i]
                    }
                    if(nums[i]>b){
                        return true
                    }
                }
           }
            return false
        }
    }
}

fun main() {
    val solution = increasingTriplet.Solution()
    val array = intArrayOf(2,1,5,0,3)
    solution.increasingTriplet(array)
}