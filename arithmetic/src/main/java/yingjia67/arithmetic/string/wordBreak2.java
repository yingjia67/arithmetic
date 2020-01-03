package yingjia67.arithmetic.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordBreak2 {
    public static void main(String[] args) {
        String s = "pineapplepenapple";
        String wordDictArray[] = {"apple","pen","applepen","pine","pineapple"};
        List<String> wordDict = Arrays.asList(wordDictArray);
        Solution solution = new Solution();
        List<String> ret = solution.wordBreak(s,wordDict);
        for(String str : ret){
            System.out.println(str);
        }
    }
    static class Solution {

        public int getMaxLength(List<String > wordDict){
            int maxLen = 0;
            for(String word:wordDict){
                maxLen = word.length()>maxLen?word.length():maxLen;
            }
            return maxLen;
        }
        public boolean wordBreak1(String s, List<String> wordDict) {
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


        public List<String> wordBreak(String s, List<String> wordDict) {
            List res = new ArrayList();
            if(!wordBreak1(s,wordDict)){
                return res;
            }
            StringBuilder builder = new StringBuilder();
            dfs(s,wordDict,res,builder,0);
            return res;
        }
        public void dfs(String s,List<String> wordDict,List<String> res,StringBuilder builder,int start){
            int len = s.length();
            if(start == s.length()){
                res.add(builder.toString().trim());
                return;
            }
            for(int i = start;i<len;i++){
                int len1 = builder.length();
                if(wordDict.contains(s.substring(start,i+1))){
                    builder.append(s.substring(start,i+1));
                    builder.append(" ");
                    dfs(s,wordDict,res,builder,i+1);
                    builder.setLength(len1);
                }
            }
        }
    }
}
