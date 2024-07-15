import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 곱셈
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
0.5 초 (추가 시간 없음)	128 MB	130504	36936	26844	27.282%
문제
자연수 A를 B번 곱한 수를 알고 싶다. 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.

출력
첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.

예제 입력 1 
10 11 12
예제 출력 1 
4
 */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// 10을 11번 콥한 수를 알고 싶다
		//단 수가 매우 커질 수 있으므로 이를 12 로 나눈 나머지를 구하려 한다
		
		//분할정복을 사용한 거듭제곱
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		Long answer = 1L;
		Long flag = a;
		//b = 5
		while(b > 0) {
			if(b % 2 == 1) {
				//answer = 10
				//answer = 10 * 100 = 1000
				answer = (answer * flag) % c;
			}
			//flag = 100
			flag = (flag * flag) % c;
			//b = 2
			b/=2;
		}
		
		System.out.println(answer);
	}

}
