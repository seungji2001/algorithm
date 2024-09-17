import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int[][] dp = new int[land.length][land[0].length];
        for(int i = 0; i<land[0].length; i++){
            dp[0][i] = land[0][i];
        }
        
        for(int i = 1; i<land.length; i++){
            for(int j = 0; j<land[i].length; j++){
                int prev = j;
                int sum = 0;
                for(int k = 0; k<land[i].length; k ++){
                    if(prev != k){
                        sum = Math.max(sum, land[i][prev] + dp[i - 1][k]);
                    }
                }
                dp[i][j] = sum;
            }
        }
        
        for(int i = 0; i<land[0].length; i++){
            answer = Math.max(answer, dp[land.length - 1][i]);
        }
        
        return answer;
    }
}