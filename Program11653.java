package BaekJoon;

import java.util.Scanner;

public class Program11653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

				Scanner in = new Scanner(System.in);
		        
				int N = in.nextInt();
		 
				for (int i = 2; i <= Math.sqrt(N); i++) {	// 또는 i * i <= N
					while (N % i == 0) {
						System.out.println(i);
						N /= i;
					}
				}
				if (N != 1) {
					System.out.println(N);
				}
		
//		int n;
//		
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		
//		if(n == 1)
//			System.out.println(n);
//		int i = 2;
//		while(n!=1) {
//			if(n % i == 0) {
//				n /= i;
//				System.out.println(i);
//			}
//			else
//				i +=1;
//		}
//		int i;
//		int flag=0;
//		if(n == 1)
//			System.out.println(1);
//		while(n!=1) {
//			if(n%2 == 0) {
//				n/=2;
//				System.out.println(2);
//				continue;
//			}
//			for(i =2; i<=n; i++) {
//				for(int j = 2; j<i; j++) {
//					flag = 1;
//					if(i%j == 0) {
//						flag = 0;
//						break;
//					}
//				}
//				if(flag == 1) {
//					if(n%i == 0) {
//						n/=i;
//						System.out.println(i);
//					}
//				}
//			}
//		}
	}
}