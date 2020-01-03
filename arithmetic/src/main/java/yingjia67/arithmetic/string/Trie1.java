package yingjia67.arithmetic.string;

public class Trie1 {
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
