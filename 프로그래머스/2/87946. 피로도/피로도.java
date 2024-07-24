import java.util.*;


class Solution {
    int row = 0;
    int col = 0;
    int answer = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        row = dungeons.length;
        col = dungeons[0].length;
        
        dfs(k, dungeons, new HashSet<>(), 0, 0);
        
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, Set<Integer> visited, int depth, int nextround){
        if(depth == row){
            answer = Math.max(answer, nextround);
            return;
        }
       
        for(int i = 0; i<row; i++){
            if(visited.contains(i)){
                continue;
            }
            visited.add(i);
            
            int need = dungeons[i][0];
            int use = dungeons[i][1];
          
            if(need <= k){
                k -= use;
                dfs(k, dungeons, visited, depth + 1, nextround + 1);
                k += use;
            }else{
                dfs(k, dungeons, visited, depth + 1, nextround);
            }
            visited.remove(i);
        }
    }
}
