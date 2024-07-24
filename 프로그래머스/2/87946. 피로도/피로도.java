import java.util.*;
class Solution {
    int answer = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        dfs(k, dungeons, new HashSet<>(), 0);
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, Set<Integer> visited, int count){
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited.contains(i) && dungeons[i][0] <= k) {
                visited.add(i);
                dfs(k - dungeons[i][1], dungeons, visited, count + 1);
                visited.remove(i);
            }
        }
    }
}