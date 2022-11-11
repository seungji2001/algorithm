package hun;

import java.util.Scanner;

public class Main1748 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String num;
		num = sc.next();
		int cnt = num.length();
		long sum = 0;
		
		for(int i = 1; i<cnt; i++) {
			sum = sum + (long) (i * (9*Math.pow(10, (i-1))));
		}
		
		if(cnt>1)
			sum = (long) (sum + (cnt * ((Integer.parseInt(num) - (getNum(cnt-1))))));
		
		
		if(cnt == 1) {
			System.out.print(num);
		}
		else
			System.out.println(sum);

	}
	
	public static long getNum(int cnt) {
		long c = 0;
		for(int i = 0; i<cnt; i++) {
			c = (long) (c + 9*Math.pow(10, i));
		}
		return c;
	}

}
