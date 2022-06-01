package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		int cnt = 1;
		
		for(int i = 0; i < n; i++){
			queue.offer(i + 1);
		}
		sb.append("<");
		
		while(!queue.isEmpty()) {
			if(cnt == k) {
				sb.append(queue.poll()).append(", ");
				cnt = 1;
				continue;
			}
			cnt++;
			queue.offer(queue.poll());
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
		sc.close();
	}
}
