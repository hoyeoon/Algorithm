package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2941 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int answer = 1;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == '=') {
				if(i > 1 && arr[i - 1] == 'z' && arr[i - 2] == 'd') {
					answer -= 2;
				}else if(arr[i - 1] == 'c' || arr[i - 1] == 's' || arr[i - 1] == 'z') {
					answer -= 1;
				}
			}else if(arr[i] == '-') {
				if(arr[i - 1] == 'c' || arr[i - 1] == 'd') {
					answer -= 1;
				}
			}else if(arr[i] == 'j') {
				if(arr[i - 1] == 'l' || arr[i - 1] == 'n') {
					answer -= 1;
				}
			}
			answer++;
		}
		System.out.println(answer);
	}
}
