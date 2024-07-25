import java.util.*;
class Solution {
    int n = 0;
    char[] words;
    int answer = -1;
    public int solution(String word) {
        n = word.length();
        words = new char[]{'A', 'E', 'I', 'O', 'U'};
        
        answer = combination(0, new LinkedList<>(), 0, word);
        return answer;
    }
    public int combination(int depth, List<Integer> bucket, int choose, String word){
        
        String makedword = makeWord(bucket);
        if(makedword.equals(word)){
            return answer;
        }
        
        if(depth == words.length){
            return - 1;
        }
        
        for(int i = 0; i<5; i++){
            bucket.add(i);
            int result = combination(depth + 1, bucket, i, word);
            if(result != -1){
                return result;
            }
            bucket.remove(bucket.size()-1);
        }
        return -1;
    }
    
    public String makeWord(List<Integer> bucket){
        answer ++;
        StringBuilder sb = new StringBuilder();
        for(int index : bucket){
            sb.append(words[index]);
        }
        return sb.toString();
    }
}