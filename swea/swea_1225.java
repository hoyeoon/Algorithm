package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1225 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src\\swea\\input_swea_1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int t = 1; t <= 10; t++) {
			int[] numbers = new int[8];
			br.readLine();
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 8; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			int minValue = Integer.MAX_VALUE;
			for(int i = 0; i < 8; i++)
				minValue = Integer.min(numbers[i], minValue);
			
			int n = minValue / 15 * 15 - 15;
			
			for(int i = 0; i < 8; i++)
				q.offer(numbers[i] - n);
			
			int i = 0;
			while(true) {
				if(q.peek() - (i + 1) % 5 <= 0) {
					q.poll();
					q.offer(0);
					break;
				}
				
				q.offer(q.poll() - (++i) % 5);
			}
		
			while(!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
			q.clear();
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
