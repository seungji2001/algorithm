import com.sun.source.tree.BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int nrow = 3;
    static int ncol = 3;
    static int[][] box = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int r = Integer.parseInt(strings[0]);
        int c = Integer.parseInt(strings[1]);
        int k = Integer.parseInt(strings[2]);

        for(int i = 1; i<=nrow; i++){
            strings = br.readLine().split(" ");
            for(int j = 1; j<=ncol; j++){
                box[i][j] =Integer.parseInt(strings[j - 1]);
            }
        }


        int answer = 0;
        while(box[r][c] != k){
            if(answer > 100){
                answer = -1;
                break;
            }
            if(ncol<=nrow){
                roperation();
            }else{
                coperation();
            }
           
            answer ++;
        }

        System.out.println(answer);
    }

    public static void coperation(){
        int mincolindex=Integer.MIN_VALUE;
        int[][] nbox = new int[box.length][box.length];
        for(int i = 1; i<=ncol; i++){
            Map<Integer, Integer> count = new HashMap<>();
            for(int j = 1; j<=nrow; j++){
                if(box[j][i] == 0){
                    continue;
                }
                //세로로 검사
               count.put(box[j][i], count.getOrDefault(box[j][i], 0) + 1);
            }
            Map<Integer, Integer> sortedMap = sortMap(count);
            //새로운 내용으로 박스 담아야한다
            mincolindex = Math.max(mincolindex, updateboxcol(nbox, i, sortedMap));
        }
        copybox(nbox);
        nrow = Math.min(mincolindex, 100);
    }

    public static void copybox(int[][] nbox){
        for(int i = 0; i<nbox.length; i++){
            System.arraycopy(nbox, 0, box, 0, nbox[i].length);
        }
    }

    public static Map<Integer, Integer> sortMap(Map<Integer, Integer> count){
        //정렬 수행
        List<Map.Entry<Integer, Integer>> maplist = new ArrayList<>(count.entrySet());
        Collections.sort(maplist, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                if(o1.getValue().compareTo(o2.getValue()) == 0){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> map : maplist){
            sortedMap.put(map.getKey(), map.getValue());
        }

        return sortedMap;
    }

    public static void roperation(){
        int[][] nbox = new int[box.length][box.length];
        int minrowindex=Integer.MIN_VALUE;
        for(int i = 1; i <= nrow; i++){
            Map<Integer, Integer> count = new HashMap<>();
            for(int j = 1; j <= ncol; j++){
                if(box[i][j] == 0){
                    continue;
                }
                count.put(box[i][j], count.getOrDefault(box[i][j], 0) + 1);
            }
            //행대로 sorted함
            Map<Integer, Integer> sortedMap = sortMap(count);
            //새로운 내용으로 박스 담아야한다
            minrowindex = Math.max(minrowindex, updatebox(nbox,i, sortedMap));
        }
        copybox(nbox);
        ncol = Math.min(minrowindex, 100);
    }

    public static int updateboxcol(int[][] box, int col, Map<Integer, Integer> map){
        //map의 value만큼 키 업데이트
        List<Map.Entry<Integer, Integer>> mapentry = new ArrayList<>(map.entrySet());
        int index = 1;
        for(Map.Entry<Integer, Integer> entry : mapentry){
            int key = entry.getKey();
            int value = entry.getValue();
            if(index >= 100){
                return index;
            }
            box[index++][col] = key;
            box[index++][col] = value;
        }
        return index - 1;
    }

    public static int updatebox(int[][] box, int row, Map<Integer, Integer> map){
        //map의 value만큼 키 업데이트
        List<Map.Entry<Integer, Integer>> mapentry = new ArrayList<>(map.entrySet());
        int index = 1;
        for(Map.Entry<Integer, Integer> entry : mapentry){
            int key = entry.getKey();
            int value = entry.getValue();
            if(index >= 100){
                return index;
            }
            box[row][index++] = key;
            box[row][index++] = value;
        }
        return index - 1;
    }
}