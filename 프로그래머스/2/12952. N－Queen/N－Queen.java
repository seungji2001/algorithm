//1:39
import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int n) {
        int[] row = new int[n];
        int[] col = new int[n];
        int[][] box = new int[n][n];

        dfs(0, row, col, box);
        System.out.println(answer);
        return answer;
    }
    public void dfs(int rowindex, int[] r, int[] c, int[][] box){
        if(rowindex == box.length){
            answer ++;
            return;
        }
        for(int i = 0; i<box[0].length; i++) {
            if(c[i] == 1){
                continue;
            }
            if(check(rowindex, i, box)){
                c[i] = 1;
                box[rowindex][i] = 1;
                dfs(rowindex + 1, r, c, box);
                box[rowindex][i] = 0;
                c[i] = 0;
            }
        }
    }
    public boolean check(int orow, int ocol, int[][] box){
        int rindex = orow;
        int cindex = ocol;
        while(rindex >= 0 && cindex >= 0){
            if(box[rindex][cindex] == 1)
                return false;
            rindex --;
            cindex --;
        }
        rindex = orow;
        cindex = ocol;
        while(rindex >= 0 && cindex < box[0].length){
            if(box[rindex][cindex] == 1){
                return false;
            }
            rindex --;
            cindex ++;
        }
        return true;
    }
}