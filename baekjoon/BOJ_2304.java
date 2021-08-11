package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2304 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> stack1 = new Stack<>();
		Stack<int[]> stack2 = new Stack<>();
		int n = Integer.parseInt(st.nextToken());
		int[][] info = new int[n][2];
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; 
		}
		Arrays.sort(info, Comparator.comparingInt(a -> a[0]));
//		System.out.println(Arrays.deepToString(info));
		
		int maxHeight = info[0][1];
		int maxLoc = 0;
		int maxIdx = 0;
		for(int i = 1; i < info.length; i++) {
			if(maxHeight < info[i][1]) {
				maxHeight = info[i][1];
				maxLoc = info[i][0];
				maxIdx = i;
			}
		}
//		System.out.println("maxHeight : " + maxHeight);
//		System.out.println("maxLoc : " + maxLoc);
//		System.out.println("maxIdx : " + maxIdx);
		
		stack1.push(info[0]);
		for(int i = 1; i <= maxIdx; i++) {
			if(stack1.peek()[1] <= info[i][1]) {
				stack1.push(info[i]);
			}
		}
		stack2.push(info[n - 1]);
		for(int i = info.length - 2; i >= maxIdx; i--) {
			if(stack2.peek()[1] <= info[i][1]) {
				stack2.push(info[i]);
			}
		}
		
		for(int i = 0; i < stack1.size(); i++)
			System.out.println(Arrays.toString(stack1.get(i)));
		System.out.println("-----------------------------");
		for(int i = 0; i < stack2.size(); i++)
			System.out.println(Arrays.toString(stack2.get(i)));
		
		for(int i = 0; i < stack1.size() - 1; i++) {
			answer += (stack1.get(i + 1)[0] - stack1.get(i)[0]) * stack1.get(i)[1];
		}
		for(int i = stack2.size() - 1; i > 0; i--) {
			answer += (stack2.get(i - 1)[0] - stack2.get(i)[0]) * stack2.get(i - 1)[1];
		}
		answer += maxHeight;
		System.out.println(answer);
	}
}
