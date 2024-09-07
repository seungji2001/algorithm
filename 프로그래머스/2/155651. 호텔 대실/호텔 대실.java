import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        // 종료 시간을 기준으로 정렬
        PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>(){
            public int compare(String[] s1, String[] s2){
                String[] time1 = s1[0].split(":");
                String[] time2 = s2[0].split(":");
                
                if (time1[0].equals(time2[0])) {
                    return time1[1].compareTo(time2[1]);
                }
                return time1[0].compareTo(time2[0]);
            } 
        });
        
        // 우선순위 큐에 예약 시간 추가
        for (int i = 0; i < book_time.length; i++) {
            pq.add(book_time[i]);
        }
        
        // 방마다 종료 시간을 저장하는 우선순위 큐
        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();
        
        while (!pq.isEmpty()) {
            String[] current = pq.poll();
            String startTime = current[0];
            String endTime = current[1];
            
            // 현재 예약의 시작 시간을 분 단위로 변환
            int startMinutes = timeToMinutes(startTime);
            // 현재 예약의 종료 시간을 분 단위로 변환
            int endMinutes = timeToMinutes(endTime) + 10; // 청소 시간 10분 추가
            
            // 기존 객실 중에서 가장 빨리 끝나는 객실의 종료 시간 확인
            if (!roomEndTimes.isEmpty() && roomEndTimes.peek() <= startMinutes) {
                roomEndTimes.poll(); // 방이 겹치지 않으면 기존 방을 사용할 수 있으므로 제거
            }
            
            // 새로운 종료 시간을 방 종료 큐에 추가
            roomEndTimes.add(endMinutes);
        }
        
        // 사용한 방의 수는 종료 시간이 저장된 큐의 크기
        return roomEndTimes.size();
    }
    
    // 시간을 분 단위로 변환하는 함수
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }
}
