package yingjia67.arithmetic.array

class productExceptSelf{
    class Solution {
        fun productExceptSelf(nums: IntArray): IntArray {
            val len = nums.size
            val array1 = IntArray(len-1)
            val array2 = IntArray(len-1)
            var ret = IntArray(len)
            var total1 = 1
            var total2 = 1
            for(i in 0..len-2){
                total1*=nums[i]
                array1[i] = total1
                total2*=nums[len-i-1]
                array2[i] = total2
            }
            for(i in 0 until len){
                var value1:Int
                var value2:Int
                if(i-1<0){
                    value1 =1
                }else{
                    value1 = array1[i-1]
                }
                if(len-i-2<0){
                    value2 = 1
                }else{
                    value2 = array2[len-i-2]
                }
                ret[i] = value1*value2
            }
            return ret
        }
    }
}

fun main() {
    val solution = productExceptSelf.Solution()
    var array = intArrayOf(1,2,3,4)
    solution.productExceptSelf(array)
}