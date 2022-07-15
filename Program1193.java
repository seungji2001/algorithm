package BaekJoon;

import java.io.IOException;
import java.util.Scanner;

public class Program1193 {

	public static void main(String[] args) throws IOException{
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int num = 0;
		int i;
		for(i = 1; ; i++) {
			num += i;
			if(num>=n)
				break;
		}
		System.out.println(num);
		
		int functionSum = i+1;
		int lineNum = i;
		int lineSum = num;
		
		int f1,f2;
		f1 = 0;
		f2=0;
		while(lineSum >= n) {
			f1++;
			f2 = functionSum - f1;
			lineSum--;
		}
		System.out.println(i);
		if(i%2 == 1) {
			System.out.println(f1 + "/" + f2);
		}
		else {
			System.out.println(f2 + "/" + f1);
		}
	}
}
