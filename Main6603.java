package hun;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main6603 {

	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		while(n != 0) {
			int nums[] = new int[n];
			int bucket[] = new int[6];
			for(int i = 0; i<n; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			
			pick(bucket, nums, n, 6, 6);
			System.out.println("");
			n = sc.nextInt();
		}
		
		
	}
	
	public static void pick(int[] bucket, int[] nums, int bucketSize,int p, int r) {
		if(r == 0) {
			for(int i = 0; i<p; i++) {
				System.out.print(nums[bucket[i]] + " ");
			}
			System.out.println("");
			return;
		}
		int smallest;
		int lastIndex = p - r - 1;
		if(p == r) {
			smallest = 0;
		}
		else {
			smallest = bucket[lastIndex] + 1;
		}
		for(int item = smallest; item < bucketSize; item++) {
			bucket[lastIndex+1] = item;
			pick(bucket,nums,bucketSize, p, r-1);
		}
	}

}
