import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long small = 1;  // 최소 시간을 1로 시작
        long large = (long)times[times.length - 1] * n;  // 가능한 최대 시간
        long answer = large;

        while (small <= large) {
            long sum = 0;
            long mid = (small + large) / 2;

            // 각 심사관이 mid 시간 동안 몇 명을 처리할 수 있는지 계산
            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {  // 처리할 수 있는 사람 수가 충분하거나 많다면
                answer = mid;  // 답 후보 갱신
                large = mid - 1;  // 시간을 줄여서 더 좋은 답을 찾음
            } else {  // 처리할 수 있는 사람 수가 부족하면
                small = mid + 1;  // 시간을 늘림
            }
        }

        return answer;
    }
}
