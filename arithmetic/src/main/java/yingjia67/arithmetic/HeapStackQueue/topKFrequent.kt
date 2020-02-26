package yingjia67.arithmetic.HeapStackQueue

import java.util.*
import kotlin.collections.HashMap

class topKFrequent{
    class Solution {
        fun topKFrequent(nums: IntArray, k: Int): List<Int> {
            val ret = ArrayList<Int>()
            val map:MutableMap<Int,Int> = HashMap()
            val minHeap = PriorityQueue<Map.Entry<Int,Int>>
            { o1:Map.Entry<Int,Int>,o2:Map.Entry<Int,Int>->
                    o1.value-o2.value

            }

            nums.forEach {
                map[it]=map.getOrDefault(it,0)+1
            }

            map.entries.forEach{
                if(minHeap.size<k){
                    minHeap.add(it)
                }else{
                    if(it.value>minHeap.peek().value){
                        minHeap.remove()
                        minHeap.add(it)
                    }
                }
            }
            minHeap.forEach{
                ret.add(it.key)
            }
            return ret
        }
    }
}

fun main() {
    val array = intArrayOf(4,1,-1,2,-1,2,3)
    val k = 2
    val solution = topKFrequent.Solution()
    solution.topKFrequent(array,2).forEach{
        println(it)
    }
}