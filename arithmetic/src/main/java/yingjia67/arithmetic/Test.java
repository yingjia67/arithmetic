package yingjia67.arithmetic;

public class Test {

   public int maxvalue(int n){
       if(n == 0 || n ==1)
           return n;
       return maxvalue(n-1)+maxvalue(n-2);
   }

   public int maxvalue2(int n){

       if(n == 0 || n ==1)
           return n;
       int st1,st2;
       st1 = 0;
       st2 =1;
       for(int i = 0;i<n-1;i++){
            int tmp = st2;
            st2 = st1+st2;
            st1 = tmp;
       }
       return st2;
   }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.maxvalue(18));
        System.out.println(test.maxvalue2(18));
    }
}
