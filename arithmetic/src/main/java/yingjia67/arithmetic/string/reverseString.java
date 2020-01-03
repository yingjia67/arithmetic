package yingjia67.arithmetic.string;

public class reverseString {
    static class Solution {
        public void reverseString(char[] s) {
            if(s.length == 1 ||s.length == 0){
                return;
            }
            for(int i = 0;i<Math.floor(s.length/2);i++){
                char a;
                a = s[i];
                s[i] = s[s.length-1-i];
                s[s.length-1-i] = a;
            }
        }
    }
}
