package BaekJoon;

import java.util.Scanner;

public class Program1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m,n;
		m = sc.nextInt();
		n = sc.nextInt();
		
		int f = 0;
		for(int i = m; i<=n; i++) {
			if(i == 1)
				continue;
			f = 0;
			for(int j = 2; j<=Math.sqrt(i); j++) {
				if(i%j == 0) {
					f = 1;
					break;
				}
			}
			if(f == 0) {
				System.out.println(i);
			}
		}
	}
}
