package hun;

import java.util.Scanner;

public class Main1463 {
	
	public static int min = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m[] = new int[n+1];
		for(int i = 0; i<m.length; i++) {
			m[i] = 10000000;
		}
		int rslt = f(n,m);
		
		System.out.println(rslt);
		
	}
	
	public static int f(int n, int[] m) {   
		int num;
		
		if(m[n]!=10000000) {
			return m[n];
		}
		if(n == 1) {
			return 0;
		}
		if(n%3 == 0) {
			num = 1 + f(n/3,m);
			if(m[n]>num) {
				m[n] = num;
			}
		}
		else if(n%2 == 0) {
			num = 1 + f(n/2,m);
			if(m[n]>num) {
				m[n] = num;
			}
		}
		num =  1 + f(n-1,m);
		if(num<m[n]) {
			m[n] = num;
		}
		
		return m[n];
	}
	
}
