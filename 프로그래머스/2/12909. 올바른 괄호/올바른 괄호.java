import java.util.*;

class Solution {
    boolean solution(String strings) {
        boolean answer = true;
        
        Stack<Character> s = new Stack<>();
        for(char c : strings.toCharArray()){
            if(c=='('){
                s.push('(');
                continue;
            }
            //) 인 경우
            if(!s.isEmpty()){
                char check = s.pop();
                if(check != '('){
                    return false;
                }
            }else{
                return false;
            }
        }
        
        if(!s.isEmpty()){
            return false;
        }
        return true;
    }
}