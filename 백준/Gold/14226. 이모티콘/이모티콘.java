import java.io.*;
import java.util.*;

public class Main {

    public static class Status{
        int clipboard;
        int wind;
        int depth;

        public Status(int cb, int w, int d){
            this.clipboard = cb;
            this.wind = w;
            this.depth = d;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int n = sc.nextInt();

        Queue<Status> q = new LinkedList<>();
        q.add(new Status(0, 1, 0));

        Set<String> visited = new HashSet<>();

        while(!q.isEmpty()){
            Status status = q.poll();
            if(visited.contains(status.clipboard+","+status.wind)){
                continue;
            }
            visited.add(status.clipboard+","+status.wind);

            if(status.wind == n){
                answer = status.depth;
                break;
            }

            //3번의 방법이 있다
            //1) 화면에 있는거 클립보드에 복사하는 경우
                //클립보드는 비어있거나 화면에 있는 수랑 다를 경우만 새로운 경우로 취급
            if(status.clipboard != status.wind){
                q.add(new Status(status.wind, status.wind, status.depth + 1));
            }
            //2) 클립보드에 있는거 화면에 복사하는 경우
                //클립보드가 비어 있으면 안된다
            if(status.clipboard != 0){
                q.add(new Status(status.clipboard, status.wind + status.clipboard, status.depth + 1));
            }
            //3) 화면에 있는걸 하나 지운다
                //화면에 있는게 0이하로 떨어지면 안된다
            if(status.wind > 0){
                q.add(new Status(status.clipboard, status.wind - 1, status.depth + 1));
            }

        }

        System.out.println(answer);
    }

}