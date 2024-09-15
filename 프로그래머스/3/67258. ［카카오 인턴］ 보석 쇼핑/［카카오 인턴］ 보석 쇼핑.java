import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int totalTypes = set.size();
        
        int end = 0; int start = 0;
        int min = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        while(end < gems.length){
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            end ++;
            
            while(map.size() == totalTypes){
                if(end - start < min){
                    min = end - start;
                    answer[0] = start + 1;
                    answer[1] = end;
                }
                map.put(gems[start], map.get(gems[start]) - 1);
                if(map.get(gems[start]) == 0){
                    map.remove(gems[start]);
                }
                start ++;
            }
        }
        
        
        return answer;
    }
}