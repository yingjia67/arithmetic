package yingjia67.arithmetic.string;

public class isPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));

    }
    static class Solution {
        public boolean isPalindrome(String s) {
            String s1 = s.toLowerCase();
            int i = 0;
            int j  = s.length()-1;
            while (i<j){
                while (!isNumOrLetter(s1.charAt(i))&&i<j){
                    i++;
                }
                while (!isNumOrLetter(s1.charAt(j))&&i<j){
                    j--;
                }
                if(s1.charAt(i)!=s1.charAt(j)){
                    return false;
                }
                i++;j--;
            }
            return true;
        }
        public boolean isNumOrLetter(char c){
            if((c>='a'&&c<='z')||(c>='0'&&c<='9')){
                return true;
            }else {
                return false;
            }
        }
    }
}
