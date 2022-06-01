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
		
		int A = Integer.parseInt(st.nextToken());
		list.add(A);
		int[] arr = Arrays.stream(Integer.toString(A).split("")).mapToInt(Integer::parseInt).toArray();
		int P = Integer.parseInt(st.nextToken());
		
		while(true) {
			A = 0;
			for(int i = 0; i < arr.length; i++) {
				A += (int) Math.pow(arr[i], P);
			}
			if(list.contains(A)) {
				answer = list.indexOf(A);
				break;
			}
			list.add(A);
			arr = Arrays.stream(Integer.toString(A).split("")).mapToInt(Integer::parseInt).toArray();
		}
		System.out.println(answer);
	}
}
