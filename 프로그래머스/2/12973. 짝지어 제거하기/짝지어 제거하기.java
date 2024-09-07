import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        // 문자열을 순차적으로 처리
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            // 스택이 비어있지 않고, 현재 문자가 스택의 최상단 문자와 같으면
            if (!stack.isEmpty() && stack.peek() == current) {
                stack.pop(); // 쌍을 이루는 문자를 제거
            } else {
                stack.push(current); // 그렇지 않으면 스택에 추가
            }
        }
        
        // 스택이 비어있으면 모든 문자가 쌍을 이루어 제거된 상태
        return stack.isEmpty() ? 1 : 0;
    }
}
