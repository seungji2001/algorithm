import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] drow = {-1, 1, 0, 0};
    public static int[] dcol = {0, 0, -1, 1};

    public static int[][][] mode = {
            {{0}},
            {{0}, {1}, {2}, {3}},
            {{2, 3}, {0, 1}},
            {{0, 3}, {1, 3}, {1, 2}, {0, 2}},
            {{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
            {{0, 1, 2, 3}}
    };
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;
    static int min = 0;

    public static class Node{
        public int row;
        public int col;
        public int value;
        public Node(int r, int c, int v){
            this.row = r;
            this.col = c;
            this.value = v;
        }
    }

    public static class NodeCase{
        int nodeValue;
        int r;
        int c;
        int[] nodecase;
        public NodeCase(int nodeValue, int r, int c, int[] nodecase){
            this.nodeValue = nodeValue;
            this.r = r;
            this.c = c;
            this.nodecase = nodecase;
        }
        public String toString(){
            return nodeValue + Arrays.toString(nodecase);
        }
    }

    static List<Node> cctv = new LinkedList<>();
    static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); //row
        m = Integer.parseInt(st.nextToken()); //col
        cctv = new ArrayList<>();
        int zero_cnt = 0;
        map = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5){
                    cctv.add(new Node(i, j, map[i][j]));
                } else if(map[i][j] == 0) zero_cnt++;
            }
        }

        List<NodeCase> bucket = new ArrayList<>();
        combination(0, bucket, cctv.size());

        System.out.println(answer);

    }

    /*

4 5
0 0 2 0 3
0 6 0 0 0
0 0 6 6 0
0 0 0 0 0
     */
    public static void combination(int nodedepth, List<NodeCase> bucket, int cctvsize){
        if(nodedepth == cctvsize){
            int[][] copybox = new int[map.length][];
            for(int i = 0; i<n; i++){
                copybox[i] = map[i].clone();
            }
            fillBox(copybox, bucket);
            return;
        }
        Node node = cctv.get(nodedepth);
        //확인 가능한 경우의 수
        int c = mode[node.value].length;
        //1번일때
        //다음 노드로 확인
        for(int i = 0; i<c; i++){
            bucket.add(new NodeCase(node.value,node.row, node.col, mode[node.value][i]));
            combination(nodedepth + 1, bucket, cctvsize);
            bucket.remove(bucket.size() - 1);
        }

    }

    public static void fillBox(int[][] copy, List<NodeCase> nodeCaseList){
        //bucket의 주어진 조건에 맞게 copy박스 채우기
        for(NodeCase nc : nodeCaseList){
            int nodenum = nc.nodeValue;
            int row = nc.r;
            int col = nc.c;
            int[] nodecases = nc.nodecase;
            //copy의 row와 col을 기점으로 nodecasses의 방향으로 box채우기
            for(int ndirection : nodecases){
                fillrecursive(row, col, copy, ndirection);
            }

        }
//
//        for(int i = 0; i<n; i++){
//            System.out.println(Arrays.toString(copy[i]));
//        }
//        System.out.println();
        boolean[][] visited = new boolean[n][m];
        min = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(!visited[i][j] && copy[i][j] == 0){
                    min ++;
                    dfs(copy, i, j, visited);
                }
            }
        }
        answer = Math.min(answer, min);
    }

    public static void dfs(int[][] copy, int row, int col, boolean[][] visited){
        if(visited[row][col]){
            return;
        }
        visited[row][col] = true;
        for(int i = 0; i<4; i++){
            int nrow = drow[i] + row;
            int ncol = dcol[i] + col;
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
                if(copy[nrow][ncol] == 0 && !visited[nrow][ncol]){
                    min ++;
                    dfs(copy, nrow, ncol, visited);
                }
            }
        }
    }

    public static void fillrecursive(int row, int col, int[][] copy, int ndirection){
        int nrow = drow[ndirection] + row;
        int ncol = dcol[ndirection] + col;
        if(nrow >= 0 && nrow <n && ncol >=0 && ncol < m && copy[nrow][ncol]!=6){
            copy[nrow][ncol] = 7;
            fillrecursive(nrow, ncol, copy, ndirection);
        }
    }
}