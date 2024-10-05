import java.util.*;
import java.io.*;

public class Main {
    // 파이어볼 정보 클래스
    static class Meteor {
        int r, c, m, s, d;
        public Meteor(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; // 방향 r값 변경값
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1}; // 방향 c값 변경값
    static ArrayList<Meteor>[][] map; // 파이어볼 이동 후 정보
    static ArrayList<Meteor> meteors = new ArrayList<>(); // 모든 파이어볼 정보

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        // 입력되는 파이어볼 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            meteors.add(new Meteor(r, c, m, s, d));
        }
        // K번 이동명령 진행
        for (int i = 0; i < K; i++) {
            meteorMove(N);
            meteorFire(N);
        }
        bw.write(meteorCal() + "\n"); // 메테오 질량의 합 BufferedWriter 저장
        bw.flush();
        bw.close();
        br.close();
    }

    // 파이어볼 이동시키는 함수
    static void meteorMove(int N) {
        for (Meteor cur : meteors) {
            int tempR = (cur.r + N + dr[cur.d] * (cur.s % N)) % N;
            int tempC = (cur.c + N + dc[cur.d] * (cur.s % N)) % N;
            cur.r = tempR;
            cur.c = tempC;
            map[cur.r][cur.c].add(cur);
        }
    }

    // 파이어볼 분열 진행
    static void meteorFire(int N) {
        ArrayList<Meteor> newMeteors = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c].size() < 2) {
                    if (map[r][c].size() == 1) {
                        newMeteors.add(map[r][c].get(0));
                    }
                    map[r][c].clear();
                    continue;
                }
                int mSum = 0, sSum = 0, oddCount = 0, evenCount = 0;
                int size = map[r][c].size();
                for (Meteor cur : map[r][c]) {
                    mSum += cur.m;
                    sSum += cur.s;
                    if (cur.d % 2 == 1) {
                        oddCount++;
                    } else {
                        evenCount++;
                    }
                }
                map[r][c].clear();
                mSum /= 5;
                if (mSum == 0) {
                    continue;
                }
                sSum /= size;
                if (oddCount == size || evenCount == size) {
                    for (int i = 0; i < 8; i += 2) {
                        newMeteors.add(new Meteor(r, c, mSum, sSum, i));
                    }
                } else {
                    for (int i = 1; i < 8; i += 2) {
                        newMeteors.add(new Meteor(r, c, mSum, sSum, i));
                    }
                }
            }
        }
        meteors = newMeteors;
    }

    // 파이어볼 질량의 합 구하는 함수
    static int meteorCal() {
        int result = 0;
        for (Meteor cur : meteors) {
            result += cur.m;
        }
        return result;
    }
}