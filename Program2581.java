package BaekJoon;

import java.util.Scanner;

public class Program2581 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m, n;
		
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		int flag=1;
		int sum = 0;
		int min = 100000;
		for(int i = m; i<=n; i++) {
			if(i>=2) {
			for(int j = 2; j<i; j++) {
				flag = 1;
				if(i%j == 0) {
					flag =0;
					break;
				}
					
			}
			if(flag == 1) {
				sum += i;
				if(min>i) {
					min = i;
				}
			}
			}
		}
		 if(sum == 0)
	            System.out.println("-1");
        else{
            System.out.println(sum);
		    System.out.println(min);   
        }
	}

}
