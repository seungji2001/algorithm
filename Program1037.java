package BaekJoon;

import java.util.Scanner;

public class Program1037 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int a = 1;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i<num; i++) {
			a = sc.nextInt();
			
			if(min>a)
				min = a;
			if(max<a)
				max = a;
		}
		
		System.out.println(min*max);
	}

}
