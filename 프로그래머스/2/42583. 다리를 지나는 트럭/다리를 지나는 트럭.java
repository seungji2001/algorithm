import java.util.*;
class Truck{
    int weight;
    int bridge;
    public Truck(int w, int b){
        this.weight = w;
        this.bridge = b;
    }
    public String toString(){
        return weight + " " + bridge;
    }
}
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Truck> q = new LinkedList<>();
        int sum = 0;
        int index = 0;
        
        while (index < truck_weights.length || !q.isEmpty()) {
            answer++;
            
            // 다리에서 나갈 트럭이 있는지 확인
            if (!q.isEmpty() && q.peek().bridge == answer) {
                Truck ctruck = q.poll();
                sum -= ctruck.weight;
            }
            
            // 다음 트럭이 다리에 진입할 수 있는지 확인
            if (index < truck_weights.length && sum + truck_weights[index] <= weight) {
                q.add(new Truck(truck_weights[index], answer + bridge_length));
                sum += truck_weights[index];
                index++;
            }
        }
        
        return answer;
    }
}