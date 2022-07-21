package BaekJoon;

import java.util.Scanner;

public class Program4948 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n;
		int tc;
		int m = 0;
	
		n = sc.nextInt();
		int flag;
		while(n!=0) {
		
			flag = 0;
			m = 0;
			for(int i = (n+1); i<=2*n; i++) {
				flag = 0;
				if(i == 1) {
					continue;
				}
				if(i == 2) {
					m++;
				}
				for(int j = 2; j<=Math.sqrt(i*2); j++) {
					if(i%j == 0) {
						flag = 1;
						break;
					}
				}
				if(flag == 0) {
					m++;
				}
			}
			System.out.println(m);
		n = sc.nextInt();
		}
	}

}
