package hun;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Permutation {

	public static int next = 0;
	public static int end = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> rslt = new ArrayList<Integer>();
		ArrayList<Integer> bucket = new ArrayList<Integer>();
		
	
		for(int i = 0; i <n; i++) {
			rslt.add(sc.nextInt() - 1);
		}
		
		pick(bucket,n,n,rslt);
		if(end == 0) {
			System.out.println("-1");
		}
	}
	
	public static void pick(ArrayList<Integer> bucket, int depth, int bucketSize, ArrayList<Integer> rslt) {
		
		if(depth == 0)
		{
			if(next == 1) {
				for(int i = 0; i<bucketSize; i++) {
					System.out.print(bucket.get(i)+1 + " ");
				}
				end = 1;
			}
			int flag = 1;
			for(int i = 0; i<bucketSize; i++) {
				if(rslt.get(i) != bucket.get(i))
					flag = 0;
			}
			if(flag == 1) {
				next = 1;
				return;
			}
			
			
			return;
		}
		
		int lastIndex = bucketSize - depth - 1;
		int smallest = 0;
		
		for(int item = smallest; item< bucketSize; item++) {
			if(end == 1)
				return;
			boolean chosen = false;
			for(int j = 0; j <= lastIndex; j++) {
				if(bucket.get(j) == item) {
					chosen = true;
					break;
				}
			}
			if(chosen)
				continue;
			
			bucket.add(lastIndex + 1, item);
			pick(bucket,depth-1,bucketSize,rslt);
		}
		
	}
}