import java.util.*;
class Solution {
    
    int[] drow = {-1, -1, -1, 0, 1, 1, 1, 0};
    int[] dcol = {-1, 0, 1, 1, 1, 0, -1, -1};
    
    int answer = 0;
    
    public int solution(int[][] board) {
        /*
        위치와 인접한 공간 방문 했음을 나타낸다
        */
        int n = board.length;
        int[][] visited = new int[n][n];
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == 1){
                    check(board, visited, i, j);
                }
            }
        }
        
        
        answer = countnum(visited);
        
        return answer;
    }
    
    public int countnum(int[][] visited){
        int result = 0;
        for(int i = 0; i<visited.length; i++){
            for(int j = 0; j<visited.length; j++){
                if(visited[i][j] == 0){
                    result++;
                }
            }
        }
        return result;
    }
    
    public void check(int[][] board, int[][] visited, int row, int col){
        visited[row][col] = 1;
        for(int i = 0; i<8; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board.length){
                if(visited[nrow][ncol]!=1){
                    visited[nrow][ncol] = 1;
                }
            }
        }
    }
}