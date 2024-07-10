import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// 1 5 2 1 4 3 4 5 2 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
//		int n = 10;
		String[] s = br.readLine().split(" ");
//		String[] s = new String[] {"1", "5", "2", "1", "4", "3", "4", "5", "2", "1"};
		
		int[] arr = new int[n];
		int[] small = new int[n];
		int[] large = new int[n];
		
		for(int i = 0; i< s.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		for(int i = 0; i<arr.length; i++) {
			small[i] = 1;
			for(int j = 0; j<i; j++) {
				//2 j = 0
				if(arr[i]>arr[j]) { //1 
					small[i] = Math.max(small[j]+1, small[i]);
				}
			}
		}
		
		for(int i = arr.length-1; i>=0; i--) {
			large[i] = 1;
			for(int j = arr.length - 1; j>i; j--) {
				//2 j = 0
				if(arr[i]>arr[j]) { //1 
					large[i] = Math.max(large[j]+1, large[i]);
				}
			}
		}
	
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i<n; i++) {
			max = Math.max(max, small[i] + large[i] - 1);
		}
		
		System.out.println(max);
	}
}

