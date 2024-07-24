import java.util.*;
class Node{
    int node;
    int depth;
    public Node(int node, int depth){
        this.node = node;
        this.depth = depth;
    }
    public String toString(){
        return node + " " + depth;
    }
}
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<List<Integer>> list = new LinkedList<>();
        for(int i = 0; i<=n; i++){
            list.add(new LinkedList<>());
        }
        
        Set<Integer> visited = new HashSet<>();
        
        for(int i = 0; i<edge.length; i++){
            int v1 = edge[i][0];
            int v2 = edge[i][1];
            
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
    
        
        int max = 0;
        while(!q.isEmpty()){
            Node cnode = q.poll();
            
            
            if(visited.contains(cnode.node)){
                continue;
            }
            visited.add(cnode.node);
             if(cnode.depth > max){
                max = cnode.depth;
                answer = 1;
            }else if(cnode.depth == max){
                answer ++;
            }
            for(int neighbornode : list.get(cnode.node)){
                if(!visited.contains(neighbornode)){
                    q.add(new Node(neighbornode, cnode.depth + 1));
                }
            }
        }
        
        
        return answer;
    }
  
}