package hun;

import java.util.Scanner;

public class Main17427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//fx -> x까지의 소수를 합한것
		//gx -> fx!
		
		long sum = 0;
		for(int i = 1; i<=n; i++) {
			sum += getSum(i);
		}
		
		System.out.println(sum);
	}
	
	public static int getSum(int i) {
		int flag = 1;
		int sum = 0;
		for(int j = 1; j<=i; j++) {
			if(i%j == 0) {
				sum += j;
			}
		}
		return sum;
	}

}
