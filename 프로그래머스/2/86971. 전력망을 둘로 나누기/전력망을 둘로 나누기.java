import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        List<List<Integer>> list = new LinkedList<>();
        for(int i = 0; i<=n; i++){
            list.add(new LinkedList<>());
        }
        
        for(int i = 0; i<wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        
        for(int i = 0; i<wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            Set<Integer> set = new HashSet<>();
            int depthv1 = dfs(list, v1, v2, 0, set);
            
            set = new HashSet<>();
            int depthv2 = dfs(list, v2, v1, 0, set);
            
            answer = Math.min(answer, Math.abs(depthv1 - depthv2));
        }
        
        return answer;
    }
    
    public int dfs(List<List<Integer>> list, int node, int onode, int depth, Set<Integer> visited){
        int count = 1;
        visited.add(node);
        for(int neighbor : list.get(node)){
            if(neighbor == onode){
                continue;
            }
            if(visited.contains(neighbor)){
                continue;
            }
            count += dfs(list, neighbor, onode, depth + 1, visited);
        }
        
        return count;
    }
    
}