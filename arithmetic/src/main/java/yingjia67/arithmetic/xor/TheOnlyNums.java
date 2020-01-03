package yingjia67.arithmetic.xor;

public class TheOnlyNums {
    static class Solution {
        public int singleNumber(int[] nums) {
            int tmp = nums[0];
            for(int i = 1;i<nums.length;i++){
                tmp = tmp^nums[i];
            }
            return tmp;
        }
    }
}
