package BaekJoon;

import java.util.Scanner;

public class Program25314 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		while(input!=0) {
			if(input%4 == 0) {
				input-=4;
				System.out.print("long" + " ");
			}
		}
		System.out.println("int");
	}

}
