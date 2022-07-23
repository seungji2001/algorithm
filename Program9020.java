package BaekJoon;

import java.util.Scanner;

public class Program9020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int n;
		int m;
		int flag = 0;

		int min = 999999999;
		int min_j = 999999999;
		int min_m = 999999999;
		for(int i = 0; i<tc; i++) {
			n = sc.nextInt();
			min = 999999999;
			min_j = 999999999;
			min_m = 999999999;
			for(int j = 2; j<n; j++) {
				flag = 0;
				for(int k = 2; k<=Math.sqrt(j); k++) {
					if(j%k == 0) {
						//소수가 아닌경우
						flag = 1;
						break;
					}
				}
				if(flag == 0) {
					//j가 소수인경우
					flag = 1;
					//m은 전체 입력 수(n)에서 소수인 경우를 뺌
					m = n - j;
					if(m == 1) {
						//m이 1이면 n은 소수로만 이뤄진 수가 아님
						continue;
					}
					for(int k = 2; k<=Math.sqrt(m); k++) {
						//m이 소수인지 확인하는 문장
						//이 경우 m이 2의경우, 3의경우가 무시됨 이 두수는 어차피 소수이다
						if(m % k == 0) {
							flag = 0;
							//소수가 아님
							break;
						}
					}
					if(flag == 0) {
						//소수가 아닌경우 아래 문장 생략함
						continue;
					}
					//소수의 경우 두 수를 빼서 s에 저장
					int s = j-m;
					if(s<0) {
						s*=-1;
					}
					if(min>s) {
						min = s;
						min_j = j;
						min_m = m;
					}
					//이 경우의 경우 하나의 
					
				}

			}
			System.out.println(min_j + " " + min_m);
		}
	}

}
