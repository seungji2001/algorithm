package BaekJoon;

import java.util.Scanner;

public class Program10250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
	
		int tc = sc.nextInt();
		
		int h,w,n;
		int y,x;
		for(int i = 0; i<tc; i++) {
			
			h = sc.nextInt();
			w = sc.nextInt();
			n = sc.nextInt();
			
            if(n%h == 0 ){
                System.out.println(h*100 + n/h);
            }
            else{
                System.out.println((n%h*100) + n/h + 1);
            }
		}
	}
}
