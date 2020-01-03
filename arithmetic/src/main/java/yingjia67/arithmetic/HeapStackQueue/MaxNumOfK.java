package yingjia67.arithmetic.HeapStackQueue;

public class MaxNumOfK {

    public static void main(String args[]) {
        int nums[] = {3,2,3,1,2,4,5,5,6};
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums,0,nums.length-1,4));
     }

    static class Solution {
        static class Data {
            int num;
            int value;

            public Data(int num, int value) {
                this.num = num;
                this.value = value;
            }
        }

        public int findKthLargest(int[] nums, int k) {
            return findKthLargest(nums,0,nums.length-1,k);
        }
        public int findKthLargest(int[] nums, int left,int right,int k) {
            int num = k;
            Data data1 = quickSort(nums,left,right);
            while (true){
                int currentNum = right-left+1-(data1.num-left);
                if(currentNum == num){
                    return data1.value;
                }else if(currentNum> num){
                    num = num;
                    left = data1.num+1;
                    return findKthLargest(nums,left,right,num);
                }else {
                    num = k-currentNum;
                    right = data1.num-1;
                    return findKthLargest(nums,left,right,num);
                }
            }
        }
        public Data quickSort(int[] nums,int left,int right){
            int base = nums[left];
            while (left!=right){
                while (left!=right&&nums[right]>=base){
                    right--;
                }
                if(left!=right){
                    int tmp = nums[right];
                    nums[left] = tmp;
                }
                while (left!=right&&nums[left]<=base){
                    left++;
                }
                if(left!=right){
                    int tmp = nums[left];
                    nums[right] = tmp;
                }
            }
            nums[left] = base;
            return new Data(left,nums[left]);
        }
    }
}
