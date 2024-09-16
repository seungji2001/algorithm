import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int row = Integer.parseInt(st[0]);
        int col = Integer.parseInt(st[1]);
        int tc = Integer.parseInt(st[2]);

        int[][] box = new int[row][col];
        for(int i = 0; i<row; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j<col; j++){
                box[i][j] = Integer.parseInt(str[j]);
            }
        }

            String[] strings = br.readLine().split(" ");
            for(int j = 0; j< strings.length; j++){
                if(strings[j].equals("1")){
                    box = updown(box);
                }else if(strings[j].equals("2")){
                    box = leftright(box);
                }else if(strings[j].equals("3")){
                    box = ninetoright(box);
                }else if(strings[j].equals("4")){
                    box = ninetoleft(box);
                }else if(strings[j].equals("5")){
                    box = clock(box);
                }else{
                    box = unclock(box);
                }
            }

        for(int i = 0; i<box.length; i++){
            for(int j = 0; j<box[i].length; j++){
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] unclock(int[][] box) {
        int rowHalf = box.length / 2;
        int colHalf = box[0].length / 2;

        int[][] result = new int[box.length][box[0].length];

        // 1번 구역 → 4번 구역
        for (int i = 0; i < rowHalf; i++) {
            for (int j = 0; j < colHalf; j++) {
                result[i + rowHalf][j] = box[i][j];  // 1번 구역에서 4번 구역으로 이동
            }
        }

        // 2번 구역 → 1번 구역
        for (int i = 0; i < rowHalf; i++) {
            for (int j = colHalf; j < box[0].length; j++) {
                result[i][j - colHalf] = box[i][j];  // 2번 구역에서 1번 구역으로 이동
            }
        }

        // 3번 구역 → 2번 구역
        for (int i = rowHalf; i < box.length; i++) {
            for (int j = colHalf; j < box[0].length; j++) {
                result[i - rowHalf][j] = box[i][j];  // 3번 구역에서 2번 구역으로 이동
            }
        }

        // 4번 구역 → 3번 구역
        for (int i = rowHalf; i < box.length; i++) {
            for (int j = 0; j < colHalf; j++) {
                result[i][j + colHalf] = box[i][j];  // 4번 구역에서 3번 구역으로 이동
            }
        }

        return copy(result);  // 최종적으로 결과를 box에 복사
    }



    public static int[][] clock(int[][] box){
        int[][] result = new int[box.length][box[0].length];
        //첫번째 구간 채우기
        for(int i = 0; i<box.length/2; i++){
            for(int j = 0; j<box[0].length/2; j++){
                result[i][j] = box[box.length/2 + i][j];
            }
        }
        //두번째 구간 채우기
        for(int i = 0; i<box.length/2; i++){
            for(int j = box[0].length/2; j<box[0].length; j++){
                result[i][j] = box[i][j-box[0].length/2];
            }
        }
        //세번째 구간 구하기
        for(int i = box.length/2; i<box.length; i++){
            for(int j = box[0].length/2; j<box[0].length; j++){
                result[i][j] = box[i - box.length/2][j];
            }
        }
        //네번째 구간 구하기
        for(int i = box.length/2; i<box.length; i++){
            for(int j = 0; j<box[0].length/2; j++){
                result[i][j] = box[i][j + box[0].length/2];
            }
        }

        return copy(result);
    }
    public static int[][] ninetoleft(int[][] box) {
        int[][] result = new int[box[0].length][box.length];
        for (int i = 0; i < box[0].length; i++) {
            for (int j = 0; j < box.length; j++) {
                result[i][j] = box[j][box[0].length - 1 - i];  // 인덱스 수정
            }
        }
        return copy(result);  // 결과를 원본 box에 복사
    }


    public static int[][] ninetoright(int[][] box) {
        int[][] result = new int[box[0].length][box.length];  // 회전 후 행과 열이 반대
        for (int i = 0; i < box[0].length; i++) {  // 결과 배열의 행을 탐색
            for (int j = 0; j < box.length; j++) {  // 결과 배열의 열을 탐색
                result[i][j] = box[box.length - 1 - j][i];  // 시계 방향 회전
            }
        }
        return copy(result);  // 결과를 원본 배열에 복사
    }

    public static int[][] leftright(int[][] box){
        int[][] result = new int[box.length][box[0].length];
        for(int i = 0; i<box.length; i++){
            for(int j = 0; j<box[i].length; j++){
                result[i][j] = box[i][box[i].length - 1 - j];
            }
        }

        return copy(result);
    }

    public static int[][] updown(int[][] box){
        int[][] result = new int[box.length][box[0].length];
        for(int i = 0; i<box.length; i++){
            result[i] = box[box.length - 1 - i];
        }
        return copy(result);
    }

    public static int[][] copy(int[][] result) {
        int[][] box = new int[result.length][result[0].length];
        // 행과 열을 하나씩 복사
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                box[i][j] = result[i][j];
            }
        }
        return box;
    }
}
