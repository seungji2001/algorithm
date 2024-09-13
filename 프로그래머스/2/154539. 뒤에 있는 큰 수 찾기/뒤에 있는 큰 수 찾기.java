import java.util.*;

public class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<Integer>();
        int end = numbers.length - 1;
        for(int i = end; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= numbers[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                answer[i] = -1;
            }else{
                answer[i] = stack.peek();
            }
            
            stack.push(numbers[i]);
        }
        return answer;
    }
}
