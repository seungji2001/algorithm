import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum1 = 0, sum2 = 0;
        for (int num : queue1) sum1 += num;
        for (int num : queue2) sum2 += num;

        // 두 큐의 전체 합이 홀수이면 같은 값으로 나눌 수 없다.
        if ((sum1 + sum2) % 2 != 0) return -1;

        long target = (sum1 + sum2) / 2;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int num : queue1) q1.offer(num);
        for (int num : queue2) q2.offer(num);

        int operations = 0;
        while (sum1 != target) {
            if (operations > n * 3) return -1; // 무한 루프 방지

            if (sum1 > target) {
                int num = q1.poll();
                sum1 -= num;
                q2.offer(num);
                sum2 += num;
            } else {
                int num = q2.poll();
                sum2 -= num;
                q1.offer(num);
                sum1 += num;
            }
            operations++;
        }

        return operations;
    }
}
