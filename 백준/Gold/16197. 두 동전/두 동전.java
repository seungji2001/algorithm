import java.io.*;
import java.util.*;

public class Main {

    public static class Coin {
        int x;
        int y;
        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Status {
        Coin coin1;
        Coin coin2;
        int depth;
        public Status(Coin c1, Coin c2, int depth) {
            this.coin1 = c1;
            this.coin2 = c2;
            this.depth = depth;
        }
    }
    static int[] drow = {1, -1, 0, 0};
    static int[] dcol = {0, 0, -1, 1};
    static char[][] map;
    static Set<String> visited = new HashSet<>();
    static int row;
    static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        row = Integer.parseInt(s[0]);
        col = Integer.parseInt(s[1]);

        map = new char[row][col];

        Coin[] coins = new Coin[2];
        int index = 0;
        for(int i = 0; i < row; i++) {
            String string = br.readLine();
            for(int j = 0; j < col; j++) {
                if(string.charAt(j) == 'o') {
                    coins[index++] = new Coin(i, j);
                }
                map[i][j] = string.charAt(j);
            }
        }

        Status status = new Status(coins[0], coins[1], 0);
        Queue<Status> q = new LinkedList<>();
        q.add(status);
        int answer = -1;
        
        while(!q.isEmpty()) {
            Status status1 = q.poll();
            Coin c1 = status1.coin1;
            Coin c2 = status1.coin2;

            if (status1.depth >= 10) {
                continue;
            }

            String state = c1.x + "," + c1.y + "," + c2.x + "," + c2.y;
            if(visited.contains(state)) {
                continue;
            }
            visited.add(state);

            for(int i = 0; i < 4; i++) {
                int nrow1 = c1.x + drow[i];
                int ncol1 = c1.y + dcol[i];
                int nrow2 = c2.x + drow[i];
                int ncol2 = c2.y + dcol[i];

                boolean check1 = valid(nrow1, ncol1);
                boolean check2 = valid(nrow2, ncol2);

                if(!check1 && !check2) continue;
                if((!check1 && check2) || (check1 && !check2)) {
                    answer = status1.depth + 1;
                    System.out.println(answer);
                    return;
                }

                if(map[nrow1][ncol1] == '#') {
                    nrow1 = c1.x;
                    ncol1 = c1.y;
                }
                if(map[nrow2][ncol2] == '#') {
                    nrow2 = c2.x;
                    ncol2 = c2.y;
                }

                if(!visited.contains(nrow1 + "," + ncol1 + "," + nrow2 + "," + ncol2)) {
                    q.add(new Status(new Coin(nrow1, ncol1), new Coin(nrow2, ncol2), status1.depth + 1));
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean valid(int nrow, int ncol) {
        return nrow >= 0 && nrow < row && ncol >= 0 && ncol < col;
    }
}