//1:21
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        for(int i = 0; i<n-1; i++){
            int c = prices[i];
            int duration = 0;
            boolean flag = true;
            for(int j = i+1; j<n; j++){
                duration ++;
                if(c>prices[j]){
                    flag = false;
                    answer[i] = duration;
                    break;
                }
            }
            if(flag){
                answer[i] = duration;
            }
        }
        
        return answer;
    }
}