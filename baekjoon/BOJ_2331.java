package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2331 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		List<Integer> list = new ArrayList<>();
		int answer = 0;
		
		int[] A = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
		int P = Integer.parseInt(st.nextToken());
		
		while(true) {
			int N = (int) Math.pow(A[0], 2) + (int) Math.pow(A[1], 2);
			if(list.contains(N)) {
				answer = list.size();
				break;
			}
			
			
		}
		System.out.println(answer);
	}
}
