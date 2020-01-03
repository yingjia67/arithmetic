package yingjia67.arithmetic.string;

import java.util.List;

public class findWords {
    static class Trie {
        boolean isWord = false;
        Trie[] tries = new Trie[26];

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
    static class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            Trie root = new Trie();
            for(String str:words){
                root.insert(str);
            }

            for(int i = 0;i<board.length;i++){
                for(int j = 0;j<board[0].length;j++){
                    if(dfs(board,words,i,j,0)){
                        return true;
                    }
                }
            }
            return false;
        }
        public boolean dfs(char[][] board,char[] words,int i,int j,int index){

            if(i<0||i==board.length||j<0||j==board[0].length||board[i][j]!=words[index]){
                return false;
            }
            if(index == words.length-1){
                return true;
            }
            char source = board[i][j];
            board[i][j] = '\0';
            boolean ret =  dfs(board,words,i,j+1,index+1)||
                    dfs(board,words,i,j-1,index+1)||
                    dfs(board,words,i+1,j,index+1)||
                    dfs(board,words,i-1,j,index+1);
            board[i][j] = source;
            return ret;
        }
    }
}
