import java.util.*;
class Node{
    int num;
    int depth;
    public Node(int n, int d){
        this.num = n; 
        this.depth = d;
    }
}
class Solution {

    public int solution(int x, int y, int n) {
        int answer = 0;
        //x에 n 더하기
        //x에 2 곱하기
        //x에 3 곱하기
        /*
        x를 y로 변환하기 위해 필요한 최소 연산 횟수
        
        */
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Node n1, Node n2){
                return n1.depth - n2.depth;
            }
        });
        
        pq.add(new Node(y, 0));
        boolean flag = false;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int c = node.num;
            int d = node.depth;
        
            if(c < 0){
              
                continue;
            }
            //만약 c가 0이라면 횟수가 답이다
            if(c == x){
                answer = d;
                flag = true;
                break;
            }
            // c - n
            //조건 : c - n 이 음수가 되는 경우 넣지 않는다
            int first = c - n;
            if(first >= 0){
                pq.add(new Node(first, d + 1));   
            }
            
            //조건 : second가 2로 나눠지지 않는다면 무시한다
            if(c % 2 == 0){
                pq.add(new Node(c / 2, d + 1));   
            }
            
            if(c % 3 == 0){
                pq.add(new Node(c/3, d + 1));   
            }
        }
        
        return flag == true? answer : -1;
    }
}