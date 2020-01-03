package yingjia67.arithmetic.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class wordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List wordDict = new ArrayList();
        wordDict.add("lee");
        wordDict.add("tcode");
        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s,wordDict));
    }
    static class Solution {
        public int getMaxLength(List<String > wordDict){
            int maxLen = 0;
            for(String word:wordDict){
                maxLen = word.length()>maxLen?word.length():maxLen;
            }
            return maxLen;
        }
        public boolean wordBreak(String s, List<String> wordDict) {
            if(s == null || s.length() == 0){
                return true;
            }
            Boolean[] flags = new Boolean[s.length()+1];
            flags[0] = true;
            int maxlen = getMaxLength(wordDict);
            for(int i = 1;i<=s.length();i++){
                flags[i] = false;
                for(int j = 1;j<=maxlen&&j<=i;j++){
                    if(!flags[i-j]){
                        continue;
                    }
                    String sub = s.substring(i-j,i);
                    if(wordDict.contains(sub)){
                        flags[i] = true;
                        break;
                    }
                }
            }
            return flags[s.length()];
        }
    }
}
