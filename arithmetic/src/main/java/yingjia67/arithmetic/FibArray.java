package yingjia67.arithmetic;

public class FibArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getFNP(6));
    }
    static class Solution{
        public int getFN(int n){
            if(n<=1){
                return n;
            }else {
                 return getFN(n-1)+getFN(n-2);
            }
        }
        public int getFNP(int n){

            if(n<=1){
                return n;
            }
            int a = 0;int b =1;

            for(int i = 2;i<n;i++){
                int temp = a+b;
                a = b;
                b = temp;
            }
            return a+b;
        }
    }
}
