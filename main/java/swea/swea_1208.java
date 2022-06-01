package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_1208 {
	private static int getMinIdx(int[] arr) {
		int min_value = arr[0];
		int min_idx = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < min_value) {
				min_value = arr[i];
				min_idx = i; 
			}
		}
		return min_idx;
	}
	private static int getMaxIdx(int[] arr) {
		int max_value = arr[0];
		int max_idx = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max_value) {
				max_value = arr[i];
				max_idx = i; 
			}
		}
		return max_idx;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			while(n-- > 0) {
				int minIdx = getMinIdx(arr);
				int maxIdx = getMaxIdx(arr);
				
				arr[minIdx]++;
				arr[maxIdx]--;
			}
			
			sb.append(arr[getMaxIdx(arr)] - arr[getMinIdx(arr)]).append("\n");
		}
		System.out.println(sb);
	}
}