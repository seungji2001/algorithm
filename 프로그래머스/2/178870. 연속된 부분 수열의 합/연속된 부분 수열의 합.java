import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int total = sequence.length; 
        
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        while(right < total){
            sum = sum + sequence[right];
            while(sum > k){
                sum = sum - sequence[left];
                left ++;
            } 
            
            if(sum == k){
                int diff = right - left;
                if(diff < minLength){
                    minLength = diff;
                    start = left;
                    end = right;
                }
            }
            right ++;
        }
        
        answer[0] = start;
        answer[1] = end;
        
        return answer;
    }
}