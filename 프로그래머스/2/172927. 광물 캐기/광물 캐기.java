//3:00
import java.util.*;
class Power{
    int index;
    int sum;
    List<String> list = new ArrayList<>();
    public Power(int index, int sum, List<String> list){
        this.index = index;
        this.sum = sum;
        this.list = list;
    }
    
    public String toString(){
        return sum + " " + list.toString();
    }
}

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int toolTotal = picks[0] + picks[1] + picks[2];
        int mineralTotal = minerals.length;
        if (mineralTotal > toolTotal * 5) {
            minerals = Arrays.copyOfRange(minerals, 0, toolTotal * 5);
            mineralTotal = minerals.length;
        }
        int index = (int)Math.ceil(minerals.length/5);
        PriorityQueue<Power> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Power p1, Power p2){
            
                return p2.sum - p1.sum;
            }
        });
        
        
        int sum = 0;
        int idx = 0;
        List<String> list = new ArrayList<>();
        for(int i = 0; i<minerals.length; i++){
            if(minerals[i].equals("diamond")){
                list.add("diamond");
                sum += 25;
            }else if(minerals[i].equals("iron")){
                list.add("iron");
                sum += 5;
            }else{
                list.add("stone");
                sum += 1;
            }
            if((i + 1)%5== 0){
                pq.add(new Power(idx, sum, list));
                idx ++;
                list = new ArrayList<>();
                sum = 0;
            }
        }
        pq.add(new Power(idx, sum, list));
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<picks.length; i++){
            if(i == 0){
                map.put("diamond", picks[i]);
            }else if(i == 1){
                map.put("iron", picks[i]);
            }else{
                map.put("stone", picks[i]);
            }
        }
        
        while(!pq.isEmpty()){
            Power p = pq.poll();
            List<String> array = p.list;
            if(map.isEmpty()){
                break;
            }
            if(map.containsKey("diamond")&&map.get("diamond") >= 1){
                for(String s : array){
                    answer += 1;
                }
                if(map.get("diamond") == 1){
                    map.remove("diamond");
                }else{
                    map.put("diamond", map.get("diamond")-1);
                }
                continue;
            }
             if(map.containsKey("iron") && map.get("iron")>=1){
                for(String s : array){
                    if(s.equals("diamond")){
                        answer += 5;
                    }else{
                        answer += 1;
                    }
                }
                if(map.get("iron") == 1){
                    map.remove("iron");
                }else{
                    map.put("iron", map.get("iron")-1);
                }
                continue;
            }
            if(map.containsKey("stone") && map.get("stone")>=1){
                for(String s : array){
                    if(s.equals("diamond")){
                        answer += 25;
                    }else if(s.equals("iron")){
                        answer += 5;
                    }else{
                        answer += 1;
                    }
                }
                if(map.get("stone") == 1){
                    map.remove("stone");
                }else{
                    map.put("stone", map.get("stone")-1);
                }
                continue;
            }
        }
        
        return answer;
    }
}