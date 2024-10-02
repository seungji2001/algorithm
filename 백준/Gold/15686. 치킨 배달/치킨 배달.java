import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
5 2
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2

5 1
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
 */
public class Main {

    public static class Location{
        int row;
        int col;
        public Location(int row, int col){
            this.row = row;
            this.col = col;
        }
        public String toString(){
            return row + " " + col;
        }
    }

    static int[][] box;
    static List<Location> homelocations;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);

        List<Location> locations = new LinkedList<>();
        homelocations = new LinkedList<>();

        box = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            strings = br.readLine().split(" ");
            for(int j = 1; j<=n; j++){
                box[i][j] = Integer.parseInt(strings[j-1]);
                if(box[i][j] == 2){
                    locations.add(new Location(i, j));
                }else if(box[i][j] == 1){
                    homelocations.add(new Location(i, j));
                }
            }
        }

        //location안에서의 조합 구하기
        combination(locations, m, new LinkedList<Location>(), 0);

        System.out.println(answer);
    }

    public static void getmindistance(List<Location> bucket){
        //1의 모든 위치에서 가장 가까운 2와의 거리를 봐야한다
        int minsum = 0;
        for(Location home : homelocations){
            int mindistance = Integer.MAX_VALUE;
            int hrow = home.row;
            int hcol = home.col;
            for(Location chicken : bucket){
                int chickenrow = chicken.row;
                int chickencol = chicken.col;

                int result = Math.abs(hrow - chickenrow) + Math.abs(hcol - chickencol);
                mindistance = Math.min(result, mindistance);
            }
            minsum += mindistance;
        }
        answer = Math.min(minsum, answer);
    }

    public static void combination(List<Location> locations, int m, List<Location> bucket, int index){
        if(bucket.size() == m){
            //해당 조합으로 최소거리 구하기
            getmindistance(bucket);
            return;
        }
        for(int i = index; i<locations.size(); i++){
            Location loc = locations.get(i);
            if(bucket.contains(loc)){
                continue;
            }
            bucket.add(loc);
            combination(locations, m, bucket, i + 1);
            bucket.remove(bucket.size() - 1);
        }
    }
}