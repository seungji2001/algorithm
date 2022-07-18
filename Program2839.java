package BaekJoon;

import java.util.Scanner;

public class Program2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		int x=0,y=0;
		n = sc.nextInt();
		
	
		
			for(x=(n/5); x>=0; x--) {
				y = n - (x*5);
				if(y%3 == 0)
					break;
			}
			
			if((x+y/3) == 0 || y%3 != 0)
				System.out.println("-1");
			else
				System.out.println(x + y/3);
		
	}

}
