package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Baekjoon_17299 {
	private static int ngf[];	// 오등큰수
	private static int arr[]; 	// 수열
	private static int count[] = new int[1000001];	// count[i]가 수열 A에서 등장한 횟수
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());	// 수열의 크기
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		ngf = new int[size];
		
		for(int i = 0; i < size; i++) {
			count[arr[i]]++;
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int i = 1; i < size; i++) {
			if(stack.isEmpty()) { 
				stack.push(i);
			}
			while(!stack.isEmpty() && count[arr[i]] > count[arr[stack.peek()]]) {
				ngf[stack.pop()] = arr[i];
				System.out.println(i);
			}
			stack.push(i);
		}
		
		System.out.println(Arrays.toString(ngf));
			
		while (!stack.isEmpty()) {
            ngf[stack.pop()] = -1;
        }
		
		System.out.println(Arrays.toString(ngf));
	}
}