package BaekJoon;

import java.util.Scanner;

public class Program1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		int input;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int t = 0;
		int f = 1;
		for(int i = 0; i< n; i++) {
			input = sc.nextInt();
			f = 1;
			if(input >= 2) {
				for(int j = 2; j<input; j++) {
					if(input % j == 0) {
						f=0;
						break;
					}
				}
				if(f ==1) {
					t++;
				}
			}
		}
		System.out.println(t);
	}

}
