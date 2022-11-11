package hun;

import java.util.Scanner;

public class Main10974 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int bucket[] = new int[n+1];
		pick(bucket, n, n);
	}
	
	public static void pick(int[] bucket, int bucketSize, int k) {
		
		if(k == 0) {
			for(int i = 0; i<bucketSize; i++) {
				System.out.print((bucket[i]+1) + " ");
			}
			System.out.println("");
			
		}
		
		int lastIndex = bucketSize - k - 1;
		int smallest = 0;
		int flag = 0;
		

		for(int item = smallest; item< bucketSize; item++) {
		
			flag = 0;
			for(int j = 0; j <= lastIndex; j++) {
				if(bucket[j] == item) {
					flag = 1;
					break;
				}
			}
			if(flag == 1)
				continue;
			
			bucket[lastIndex+1] = item;
			pick(bucket,bucketSize,k-1);
		
		}
	}
}
