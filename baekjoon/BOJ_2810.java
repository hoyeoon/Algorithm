package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2810 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		char[] arr = br.readLine().toCharArray();
		int answer = 0;
		char before = arr[0];
		int Lcnt = 0;
		
		if(arr[0] == 'L') 
			Lcnt++;
		else 
			answer++;
		
		if(arr.length == 1) {
			System.out.println(answer);
			return;
		}
		
		for(int i = 1; i < arr.length; i++) {
			if(before == 'S') {
				if(arr[i] == 'L') {
					Lcnt++;
				}
				answer++;
			}else {
				if(arr[i] == 'S') {
					answer += Lcnt / 2 + 1;
					Lcnt = 0;
				}else {
					Lcnt++;
				}
			}
			before = arr[i];
		}
		System.out.println(answer);
	}
}
