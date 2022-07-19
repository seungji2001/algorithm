package BaekJoon;

import java.util.Scanner;

public class Program10757 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		int max_length = Math.max(a.length(), b.length());
		
		int[] A = new int[max_length+1];
		int[] B = new int[max_length+1];
		
		for(int i = a.length()-1,idx = 0; i>=0; i--,idx++) {
			A[idx] = a.charAt(i)-'0';
		}
		
		for(int i = b.length()-1, idx = 0; i>=0; i--,idx++) {
			B[idx] = b.charAt(i) - '0';
		}
		
		for(int i = 0; i<max_length; i++) {
			int value = A[i] + B[i];
			A[i] = value % 10;
			A[i+1] += (value/10);
		}
		
		StringBuilder sb = new StringBuilder();
		if(A[max_length] != 0) {
			sb.append(A[max_length]);
		}
		
		for(int i = max_length -1; i>=0; i--) {
			sb.append(A[i]);
		}
		System.out.println(sb);
	}

}
