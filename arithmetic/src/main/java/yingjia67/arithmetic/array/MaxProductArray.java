package yingjia67.arithmetic.array;

public class MaxProductArray {
    static class Solution {
        public int maxProduct(int[] nums) {
            if(nums.length == 1){
                return nums[0];
            }
            int dp = nums[0];
            int max = nums[0];
            int min = nums[0];
            for(int i = 1;i<nums.length;i++){
                int tmp = max;
                max = Math.max(max*nums[i],min*nums[i]);
                max = Math.max(max,nums[i]);
                min = Math.min(tmp*nums[i],min*nums[i]);
                min = Math.min(min,nums[i]);
                dp = Math.max(dp,max);
            }
            return dp;
        }
    }
}
