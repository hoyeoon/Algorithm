package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17298 {
	static int n;
	static int[] arr;
	static int[] nge;
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		nge = new int[n];
		String[] str = br.readLine().split(" ");
		for(int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		for(int i = 0; i < n; i++) {
			while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				nge[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			nge[stack.pop()] = -1;
		}
		for(int i = 0; i < n; i++)
			sb.append(nge[i]).append(" ");
		System.out.println(sb);
	}
}