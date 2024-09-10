import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String ns = s;
        for(int i = 0; i<s.length(); i++){
            //문자열 조작하기
            if(check(ns)){
                answer++;
            }
            ns = make(ns);
        }
        
        return answer;
    }
    
    public String make(String s){
         char firstletter = s.charAt(0);
        s += firstletter;
        s = s.substring(1);
        return s;
    }
    
    public boolean check(String s){
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char p = stack.peek();
                if(p == '[' && c == ']'){
                    stack.pop();
                }else if(p == '{' && c == '}'){
                    stack.pop();
                }else if(p == '(' && c == ')'){
                    stack.pop();
                }
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}