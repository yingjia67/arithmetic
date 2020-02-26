package yingjia67.arithmetic.array
class intersect{
    class Solution {
        fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
            val hashMap:MutableMap<Int,Int> = HashMap()
            val retList = ArrayList<Int>()
            nums1.forEach {
                if(hashMap.keys.contains(it)){
                    val value = hashMap[it]!!.plus(1)
                    hashMap[it] = value
                }else{
                    hashMap[it] = 1
                }
            }
            nums2.forEach {
                if(hashMap.keys.contains(it)){
                    retList.add(it)
                    hashMap[it] = hashMap[it]!!-1
                    if(hashMap[it]!!<=0){
                        hashMap.remove(it)
                    }
                }
            }

            return retList.toTypedArray().toIntArray()
        }
    }
}

fun main() {
    val solution = intersect.Solution()
    val array1 = intArrayOf(1,2,2,1)
    val array2 = intArrayOf(2,2)
    val ret = solution.intersect(array1,array2)
    ret.forEach {
        print(it)
    }
}