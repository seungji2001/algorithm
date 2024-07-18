import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 끝점을 기준으로 오름차순 정렬
        Arrays.sort(targets, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        int lastEnd = -1;  // 마지막 요격 지점을 추적
        
        for (int i = 0; i < targets.length; i++) {
            int start = targets[i][0];
            int end = targets[i][1];
           
            if(start >= lastEnd){
                lastEnd = end;
                answer ++;
            }
        }
        
        return answer;
    }
}
