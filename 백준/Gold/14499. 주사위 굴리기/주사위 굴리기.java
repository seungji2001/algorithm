import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] oside = new int[6];
    static int[] drow = new int[]{0, 0, -1, 1};
    static int[] dcol = new int[]{1, -1, 0, 0};
    static int row = 0;
    static int col = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int trow = Integer.parseInt(strings[0]);
        int tcol = Integer.parseInt(strings[1]);
        row = Integer.parseInt(strings[2]);
        col = Integer.parseInt(strings[3]);
        int tc = Integer.parseInt(strings[4]);

        int[][] box = new int[trow][tcol];
        for(int i = 0; i<trow; i++){
            strings = br.readLine().split(" ");
            for(int j = 0; j<tcol; j++){
                box[i][j] = Integer.parseInt(strings[j]);
            }
        }

        strings = br.readLine().split(" ");
        //현위치 저장

        for(int i = 0; i<tc; i++){
            int direction = Integer.parseInt(strings[i]) - 1;

            //현 위치에서 주사위 이동
            moveDice(direction, box);
        }
    }

    static void moveDice(int direction, int[][] box){
        //새로운 지도 위치
        int nrow = row + drow[direction];
        int ncol = col + dcol[direction];
        if(nrow >= 0 && nrow < box.length && ncol >= 0 && ncol < box[0].length){
            row = nrow;
            col = ncol;
        }else{
            return;
        }



        //지도 지점의 값
        int value = box[row][col];

        moveDirection(direction);

        //지도위 수가 0이며, 주사위 바닥이 0이 아닌 경우 주사위 바닥수를 지도위에 복사
        if(value == 0){
            box[row][col] = oside[5];
        }
        //지도위 수가 0이 아닌 경우 복사 후 0으로 만들기
        else if(value != 0){
            box[row][col] = 0;
            oside[5] = value;
        }

        //지도 지점의 값을 주사위에 복사

        System.out.println(oside[0]);
    }

    static void moveDirection(int direction) {
        int temp;
        switch (direction) {
            case 0: // 동쪽 이동
                temp = oside[0];
                oside[0] = oside[3];
                oside[3] = oside[5];
                oside[5] = oside[2];
                oside[2] = temp;
                break;
            case 1: // 서쪽 이동
                temp = oside[0];
                oside[0] = oside[2];
                oside[2] = oside[5];
                oside[5] = oside[3];
                oside[3] = temp;
                break;
            case 2: // 북쪽 이동
                temp = oside[0];
                oside[0] = oside[1];
                oside[1] = oside[5];
                oside[5] = oside[4];
                oside[4] = temp;
                break;
            case 3: // 남쪽 이동
                temp = oside[0];
                oside[0] = oside[4];
                oside[4] = oside[5];
                oside[5] = oside[1];
                oside[1] = temp;
                break;
        }

    }


}
