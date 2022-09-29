package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		stack.push(0);
		for(int i = 1; i < n; i++) {
			if(arr[stack.peek()] > arr[i]) { 
				answer[i] = stack.peek() + 1;
			} else {
				while(!stack.isEmpty() && arr[stack.peek()] < arr[i])
					stack.pop();
				if(!stack.isEmpty())
					answer[i] = stack.peek() + 1;
			}
			stack.push(i);
		}
		for(int i = 0; i < n; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}
}