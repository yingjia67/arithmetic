package yingjia67.arithmetic.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findWords {

    static class Solution {
        public static void main(String[] args) {
            char[][] board = {
                    {'o', 'a', 'a', 'n'},
                    {'e', 't', 'a', 'e'},
                    {'i', 'h', 'k', 'r'},
                    {'i', 'f', 'l', 'v'}
            };
            List<String> ret;
            String[] words = {"eat","oath"};
            Solution solution = new Solution();
            ret = solution.findWords(board,words);
            for(String str:ret){
                System.out.println(str);
            }

        }
        static class Trie {
            boolean isWord = false;
            Trie[] tries = new Trie[26];
            String word;

            /** Initialize your data structure here. */
            public Trie() {

            }

            /** Inserts a word into the trie. */
            public void insert(String word) {
                char[] wordArray = word.toCharArray();
                Trie current = this;
                for(char c: wordArray){
                    if(current.tries[c-'a']==null){
                        current.tries[c-'a'] = new Trie();
                    }
                    current = current.tries[c-'a'];
                }
                current.isWord = true;
                current.word = word;
            }

            /** Returns if the word is in the trie. */
            public boolean search(String word) {
                char[] wordArray = word.toCharArray();
                Trie current = this;
                for(char c: wordArray){
                    if(current.tries[c-'a']==null){
                        return false;
                    }
                    current = current.tries[c-'a'];
                }
                return current.isWord;
            }

            /** Returns if there is any word in the trie that starts with the given prefix. */
            public boolean startsWith(String prefix) {
                char[] wordArray = prefix.toCharArray();
                Trie current = this;
                for(char c: wordArray){
                    if(current.tries[c-'a']==null){
                        return false;
                    }
                    current = current.tries[c-'a'];
                }
                return true;
            }
        }
        public List<String> findWords(char[][] board, String[] words) {
            HashSet<String> tmpRet = new HashSet<>();
            Trie root = new Trie();
            for(String str:words){
                root.insert(str);
            }

            for(int i = 0;i<board.length;i++){
                for(int j = 0;j<board[0].length;j++){
                    if(root.tries[board[i][j]-'a']!=null){
                        dfs(board,i,j,root,tmpRet);
                    }
                }
            }
            return new ArrayList<>(tmpRet);
        }
        public void dfs(char[][] board,int i,int j,Trie trie,HashSet<String> ret){
            if(i<0||i==board.length||j<0||j==board[0].length||board[i][j] == '\0'){
                return ;
            }
            Trie compareTrie = trie.tries[board[i][j]-'a'];
            if(compareTrie == null){
                return;
            }
            if(compareTrie.word!=null){
                ret.add(compareTrie.word);
            }
            char source = board[i][j];
            board[i][j] = '\0';
            dfs(board,i,j+1,compareTrie,ret);
            dfs(board,i,j-1,compareTrie,ret);
            dfs(board,i+1,j,compareTrie,ret);
            dfs(board,i-1,j,compareTrie,ret);
            board[i][j] = source;
        }
    }
}
