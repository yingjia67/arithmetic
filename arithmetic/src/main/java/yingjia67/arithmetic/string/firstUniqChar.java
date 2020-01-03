package yingjia67.arithmetic.string;

public class firstUniqChar {
    static class Solution {
        public int firstUniqChar(String s) {
            char tmp;
            for(int i = 0;i<s.length();i++){
                if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                    return i;
                }
            }
            return -1;
        }
    }
}
