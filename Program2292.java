package BaekJoon;

import java.util.Scanner;

public class Program2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int rslt;
		if(n == 1) {
			rslt = 1;
		}
		else {
			rslt = 2;
		}
		int num = 1;
		for(int i = 1; i<n; i++) {
			num += i*6;
			if(n>num) {
				System.out.println(num);
				rslt++;
			}
			else
				break;
		}
		System.out.println(rslt);
	}

}
