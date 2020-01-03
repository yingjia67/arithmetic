package yingjia67.arithmetic.string;

import java.util.ArrayList;
import java.util.List;

public class partition {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        List<List<String>> ret = solution.partition(s);
        for(List<String> list: ret){
            for(String str: list){
                System.out.println(str);
            }
            System.out.println();
        }
    }
    static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> ret = new ArrayList<>();
            List<String> list = new ArrayList<>();
            dfs(s,list,ret,0);
            return ret;
        }
        public void dfs(String s,List<String> list,List<List<String>> ret,int start){
            if(start == s.length()){
                ret.add(list);
                return;
            }
            int len = s.length();
            for(int i = start;i<len;i++){
                if(isPalindrome(s,start,i)){
                    List<String> tmpList = new ArrayList<>(list);
                    list.add(s.substring(start,i+1));
                    dfs(s,list,ret,i+1);
                    list = tmpList;
                }
            }
        }
        public boolean isPalindrome(String s,int start,int end){
            while (end>start){
                if(s.charAt(end)!=s.charAt(start)){
                    return false;
                }
                end--;
                start++;
            }
            return true;
        }
    }
}
