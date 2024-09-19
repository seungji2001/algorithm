import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int trow = 0;
    static int tcol = 0;
    static int[][] box;
    static int[] drow = {0, 1, -1, 0};
    static int[] dcol = {1, 0, 0, -1};
    static boolean[][] visit;
    static int answer = 0;
    static int min = Integer.MAX_VALUE;
    static int totalw = 0;
    static int totalv = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        trow = Integer.parseInt(st.nextToken());
        tcol = Integer.parseInt(st.nextToken());
        box = new int[trow][tcol];
        visit = new boolean[trow][tcol];

        // 입력
        for(int i = 0; i < trow; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < tcol; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 2){
                    totalv ++;
                }
                if(box[i][j] == 1){
                    totalw ++;
                }
            }
        }

        int total = trow * tcol;
        List<Integer> list = new LinkedList<>();
        combination(total, list, 3, 0);


        int a = totalv + totalw + 3 + min;
        System.out.println(trow * tcol - a);
    }

    public static void combination(int total, List<Integer> list, int depth, int index){
        if(list.size() == depth){
            count(list);
            return;
        }
        for(int i = index; i<total; i++){
            if(list.contains(i)){
                continue;
            }
            //만약 이미 벽이 있거나, 2의 경우는 건너 뛰어도 됨
            if(box[i/tcol][i%tcol] != 0){
                continue;
            }
            list.add(i);
            combination(total, list, depth, i);
            list.remove(list.size() - 1);
        }
    }

    public static void dfs(int row, int col, int[][] b){
        if(visit[row][col]){
            return;
        }
        visit[row][col] = true;
        for(int i = 0; i<4; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow >= 0 && nrow<trow && ncol >= 0 && ncol < tcol){
                if(b[nrow][ncol] == 0 && !visit[nrow][ncol]){
                    answer ++;
                    dfs(nrow, ncol, b);
                }
            }
        }
    }
    public static void count(List<Integer> lists){
        int[][] b = new int[trow][tcol];
        for(int i = 0; i<trow; i++){
            b[i] = Arrays.copyOf(box[i], box[i].length);
        }
        for(int num : lists){
            b[num/tcol][num%tcol] = 1;
        }
        visit = new boolean[trow][tcol];
        answer = 0;
        for(int i = 0; i<trow; i++){
            for(int j = 0; j<tcol; j++){
                if(b[i][j] == 2){
                    dfs(i, j, b);
                }
            }
        }
        min = Math.min(min, answer);

    }
}