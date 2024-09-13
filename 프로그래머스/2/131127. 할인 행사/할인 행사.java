import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // Create a map to store the required items and their counts
        Map<String, Integer> requiredItems = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            requiredItems.put(want[i], number[i]);
        }

        // Iterate over each possible starting day of the 10-day period
        for (int day = 0; day <= discount.length - 10; day++) {
            Map<String, Integer> currentItems = new HashMap<>(requiredItems);
            for (int i = 0; i < 10; i++) {
                String sale = discount[day + i];
                if (currentItems.containsKey(sale)) {
                    currentItems.put(sale, currentItems.get(sale) - 1);
                    if (currentItems.get(sale) == 0) {
                        currentItems.remove(sale);
                    }
                }
            }

            // If all items are matched, increment the answer
            if (currentItems.isEmpty()) {
                answer ++;
            }
        }

        return answer;
    }
}
