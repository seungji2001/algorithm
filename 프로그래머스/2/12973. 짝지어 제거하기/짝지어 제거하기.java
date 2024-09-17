import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty()){
                if(c == stack.peek()){
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        
        if(stack.isEmpty()){
            return 1;
        }
        return 0;
    }
}
