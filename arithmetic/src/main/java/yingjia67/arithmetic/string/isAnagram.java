package yingjia67.arithmetic.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class isAnagram {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isAnagram("anagram","nagaram");
    }
    static class Solution {
        public boolean isAnagram(String s, String t) {
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i = 0;i<s.length();i++){
                if(map.get(s.charAt(i)) == null){
                    map.put(s.charAt(i),1);
                }else {
                    int tmp = map.get(s.charAt(i));

                    map.put(s.charAt(i),tmp+1);

                }
            }
            for(int i = 0;i<t.length();i++){
                if(map.get(t.charAt(i)) == null){
                    return false;
                }else {
                    int tmp = map.get(t.charAt(i));
                    map.put(t.charAt(i),tmp-1);
                }
            }
            for(int value : map.values()){
                if(value!=0){
                    return false;
                }
            }
            return true;
        }
    }
}
