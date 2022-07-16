package BaekJoon;

import java.util.Scanner;

public class Program2869 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" A B V :");
		int up,down,length;
		up = sc.nextInt();
		down = sc.nextInt();
		length = sc.nextInt();
		
		
		int day = (length-down)/(up-down);
		
		if((length-down)%(up-down)!=0)
			day++;
		System.out.println(day);
	}
}
