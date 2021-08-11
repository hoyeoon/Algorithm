package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<Integer> line1 = new Stack<>();
		Stack<Integer> line2 = new Stack<>();
		Stack<Integer> line3 = new Stack<>();
		Stack<Integer> line4 = new Stack<>();
		Stack<Integer> line5 = new Stack<>();
		Stack<Integer> line6 = new Stack<>();
		int n = Integer.parseInt(st.nextToken());
		st.nextToken();
		int line, flat;
		int answer = 0;
		
		while(n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			line = Integer.parseInt(st.nextToken());
			flat = Integer.parseInt(st.nextToken());
			
			switch(line) {
			case 1:
				answer = function(line1, flat, answer);
				break;
			case 2:
				answer = function(line2, flat, answer);
				break;
			case 3:
				answer = function(line3, flat, answer);
				break;
			case 4:
				answer = function(line4, flat, answer);
				break;
			case 5:
				answer = function(line5, flat, answer);
				break;
			case 6:
				answer = function(line6, flat, answer);
				break;
			}
		}
		System.out.println(answer);
	}

	private static int function(Stack<Integer> line, int flat, int answer) {
		if(line.isEmpty())	{
			line.add(flat);
			answer++;
		} else {
			if(line.peek() < flat) {
				line.add(flat);
				answer++;
			}else if(line.peek() > flat) {
				while(!line.isEmpty() && (line.peek() > flat)) {
					line.pop();
					answer++;
				}
				if(line.isEmpty() || line.peek() != flat) {
					line.add(flat);
					answer++;
				}
			}
		}
		return answer;
	}
}
