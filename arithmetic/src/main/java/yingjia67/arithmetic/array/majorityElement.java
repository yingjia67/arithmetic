package yingjia67.arithmetic.array;

public class majorityElement {
    static class Solution {
        public int majorityElement(int[] nums) {
            int len = nums.length;
            int cnt = 0;
            int num = 0;
            for(int i = 0;i<nums.length;i++){
                if(cnt == 0){
                    num = nums[i];
                    cnt = 1;
                    continue;
                }
                if(nums[i]!=num){
                    cnt--;
                }else {
                   cnt++;
                }
            }
            return num;
        }
    }
}
