package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class swea_3499 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str;
		Queue<String> queue1 = new LinkedList<>();
		Queue<String> queue2 = new LinkedList<>();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			br.readLine();
			str = br.readLine().split(" ");
			int n = str.length;
			for(int i = 0; i < n / 2 + n % 2; i++) {
				queue1.offer(str[i]);
			}
			for(int i = n / 2 + n % 2; i < n; i++) {
				queue2.offer(str[i]);
			}
			for(int i = 0; i < n / 2; i++) {
				sb.append(queue1.poll()).append(" ").append(queue2.poll()).append(" ");
			}
			for(int i = 0; i < n % 2; i++) {
				sb.append(queue1.poll());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
