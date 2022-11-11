package hun;

import java.util.Scanner;

public class Main14889 {
	static int[][] s;
	static int[] sum;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		s= new int[n][n];
		sum = new int[(n*n-n)/2];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				int num = sc.nextInt();
				s[i][j] = num;
			}
		}
		
		f(0,1,0,n);
	}
	
	public static void f(int c, int r, int cnt,int n) {
		if(r >= n) {
			return;
		}
		sum[cnt] = s[c][r] + s[r][c];
		for(int i = 0; i<n; i++) {
			f(i,i+1+r,cnt+1,n);
		}
	}

}
