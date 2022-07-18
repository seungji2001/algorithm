package BaekJoon;

import java.util.Scanner;

public class Program2775 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("test case:");
		int tc = sc.nextInt();
		int k,n;
		for(int i = 0; i<tc; i++) {
			System.out.print("k, n");
			k = sc.nextInt();
			n = sc.nextInt();
			
			int[][] arr = new int[k+1][n+1];
			
			for(int j=0; j<=k; j++) {
				arr[j][0] = 0;
				for(int l=1; l<=n; l++) {
					if(j == 0) {
						arr[j][l]=l; 
					}
					else {
						arr[j][l] = arr[j-1][l] + arr[j][l-1];
					}
				}
			}
			
			System.out.println(arr[k][n]);
			
		}
	}

}
