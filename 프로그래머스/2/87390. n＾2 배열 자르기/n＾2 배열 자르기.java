import java.util.*;
class Solution {
    public List<Long> solution(int n, long left, long right) {
        List<Long> answer = new ArrayList<>();
        
        long startLine = left / n + 1;
        long startNum = left % n;
        
        long endLine = right / n + 1;
        long endNum = right % n;
        int end = n - (int) endNum - 1;
        
        for(long i = startLine; i<=endLine; i++){
            long j = 0;
            for(j = 1; j<=i; j++){
                answer.add(i);
            }
            for(long k = j; k<=n; k++){
                answer.add(k);
            }
        }
        
        int ent = (int)startNum;
        return answer.subList(ent, answer.size() - end);
    }
    
   
}