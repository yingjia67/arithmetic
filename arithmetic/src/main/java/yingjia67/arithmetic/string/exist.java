package yingjia67.arithmetic.string;

public class exist {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'a','b'}};
        String word = "ba";
        System.out.println(solution.exist(board,word));
    }
    static class Solution {
        public boolean exist(char[][] board, String word) {
            if(word == null || word.length() == 0){
                return true;
            }
            char words[] = word.toCharArray();
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
