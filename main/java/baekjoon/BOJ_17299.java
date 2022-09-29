package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_17299 {
	private static int[] ngf;	// 오등큰수
	private static int[] arr; 	// 수열
	private static int[] count = new int[1000001];	// count[i]가 수열 A에서 등장한 횟수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());	// 수열의 크기
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		ngf = new int[size];
		
		for(int i = 0; i < size; i++) {
			count[arr[i]]++;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < size; i++) {
			while(!stack.isEmpty() && count[arr[i]] > count[arr[stack.peek()]]) {
				ngf[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
            ngf[stack.pop()] = -1;
        }
		
		for(int i = 0; i < size; i++) {
			sb.append(ngf[i]).append(" ");
		}
		System.out.println(sb);
	}
}