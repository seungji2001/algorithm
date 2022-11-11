package hun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2309 {

	public static int end = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int n;
		for(int i = 0; i<9; i++) {
			n = sc.nextInt();
			list.add(i, n);
		}
		
		Collections.sort(list);
		
		int[] output = new int[7];
		boolean[] visited = new boolean[9];
		pick(list,output,visited,0,7);
		sc.close();
	}
	
	public static void pick(ArrayList<Integer> arr, int[] output, boolean[] visited, int depth, int r) {
		if(depth == r) {
			int sum = 0;
			for(int i = 0; i<r; i++) {
				sum += output[i];
				if(sum > 100)
					return;
			}
			if(sum == 100) {
				end = 1;
				for(int i = 0; i<r; i++) {
					System.out.println(output[i]);
					
				}
				return;
			}
			return;
			
		}
		
		for(int i = 0; i<arr.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr.get(i);
				pick(arr,output,visited,depth+1, r);
				if(end == 1) {
					return;
				}
				visited[i] = false;
			}
		}
	}

}
