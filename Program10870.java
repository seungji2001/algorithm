package BaekJoon;

import java.util.Scanner;

public class Program10870 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int rslt = fibo(n);
		System.out.println(rslt);
	}
	
	public static int fibo(int n) {
		if(n == 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		else {
			return fibo(n-1)+fibo(n-2);
		}
	}

}
