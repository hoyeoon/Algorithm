package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8958 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		char[] arr;
		int cnt;
		int flag;
		
		for(int t = 0; t < T; t++) {
			cnt = 0;
			flag = 0;
			arr = br.readLine().toCharArray();
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == 'O') {
					flag++;
				}else {
					flag = 0;
				}
				cnt += flag;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
