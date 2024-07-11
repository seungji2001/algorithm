import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * A → B
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	56701	23329	18494	39.664%
문제
정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

2를 곱한다.
1을 수의 가장 오른쪽에 추가한다. 
A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

입력
첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.

출력
A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.

예제 입력 1 
2 162
예제 출력 1 
5
2 → 4 → 8 → 81 → 162

예제 입력 2 
4 42
예제 출력 2 
-1
예제 입력 3 
100 40021
예제 출력 3 
5
100 → 200 → 2001 → 4002 → 40021

문제
정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

2를 곱한다.
1을 수의 가장 오른쪽에 추가한다. 
A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

2 162
2 → 4 → 8 → 81 → 162

4 42

100 40021
while(시작수가 100보다 클때 ){
if(40021 % 2 == 0){
	n/=2;
}else if(뒤의 수가 1로 끝날때){
	40021 -> 4002
}
}
만약 결과가 시작수와 다르면 -1
같으면 answer
40021 -> 4002 -> 2001 -> 200 -> 100  
 */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int answer = 1;
		while(start < end) {
			if(end % 2 == 0) {
				end /= 2;
				answer ++;
			}else if(String.valueOf(end).endsWith("1")) {
				String endStr = String.valueOf(end).substring(0, String.valueOf(end).length()-1);
				end = Integer.parseInt(endStr);
				answer ++;
			}else {
				break;
			}
		}
		
		if(start == end) {
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}
	}

}
