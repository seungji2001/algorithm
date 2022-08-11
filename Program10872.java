package BaekJoon;

import java.util.Scanner;

public class Program10872 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int rslt = factorial(num);
		System.out.println(rslt);
	}
	
	public static int factorial(int n) {
		if(n == 0) {
			return 1;
		}
		else {
			return n*factorial(n-1);
		}
	}

}
