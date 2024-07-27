import java.util.*;

class Solution {
    class Ticket {
        public int index;
        public String depart;
        public Ticket(int index, String depart) {
            this.index = index;
            this.depart = depart;
        }
        public String toString() {
            return index + " " + depart;
        }
    }
    
    int total = 0;
    
    public List<String> solution(String[][] tickets) {
        total = tickets.length;

        Map<String, List<Ticket>> map = new HashMap<>();

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            String depart = ticket[0];
            String arrive = ticket[1];
            map.computeIfAbsent(depart, k -> new LinkedList<>()).add(new Ticket(i, arrive));
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key), Comparator.comparing(t -> t.depart));
        }

        boolean[] visited = new boolean[total];
        List<String> result = dfs(map, "ICN", new ArrayList<>(Arrays.asList("ICN")), visited);

        
        return result;
    }

    public List<String> dfs(Map<String, List<Ticket>> map, String start, List<String> path, boolean[] visited) {
        if (path.size() == total + 1) {
            List<String> result = new ArrayList<>(path);
            return result;
        }

        if (!map.containsKey(start)) {
            return null;
        }

        for (Ticket ticket : map.get(start)) {
            if (!visited[ticket.index]) {
                visited[ticket.index] = true;
                path.add(ticket.depart);
                List<String> result = dfs(map, ticket.depart, path, visited);
                if(result != null){
                    return result;
                }
                path.remove(path.size() - 1);
                visited[ticket.index] = false;
            }
        }
        return null;
    }
}
