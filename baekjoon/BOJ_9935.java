package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_9935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split("");
		String bombStr = br.readLine();
		String[] bomb = bombStr.split("");
		System.out.println(Arrays.toString(bomb));
		int size = bomb.length;
		Stack<String> stack = new Stack<>();
		
		for(int i = 0; i < input.length; i++) {
			System.out.println(i + " " + stack);
			
			if(!stack.isEmpty() && stack.peek().equals(bomb[size - 1])){
				int flag = 1;
				int stackSize = stack.size();
				for(int j = 0; j < size; j++) {
					if(!stack.get(stackSize - 1 - j).equals(bomb[size - 1 - j])) {
						flag = 0;
						break;
					}
				}
				if(flag == 1) {
					
					for(int j = 0; j < size; j++) {
						stack.pop();
					}
				}
			}
			if(bombStr.contains(input[i])) {
				stack.push(input[i]);
			}
			if(!bombStr.contains(input[i])) {
				sb.append(input[i]);
			}
		}
		
		if(!stack.isEmpty() && stack.peek().equals(bomb[size - 1])){
			int flag = 1;
			int stackSize = stack.size();
			for(int j = 0; j < size; j++) {
				if(!stack.get(stackSize - 1 - j).equals(bomb[size - 1 - j])) {
					flag = 0;
					break;
				}
			}
			if(flag == 1) {
				
				for(int j = 0; j < size; j++) {
					stack.pop();
				}
			}
		}
		
		System.out.println(stack);
		System.out.println(sb);
	}
	
}
