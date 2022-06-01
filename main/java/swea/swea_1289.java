package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			char[] arr = br.readLine().toCharArray();
			char[] init = new char[arr.length];
			for(int i = 0; i < arr.length; i++)
				init[i] = '0';
			
			sb.append("#").append(t).append(" ");
			char target;
			int answer = 0;
			while(Arrays.equals(arr, init) == false) {	// arr와 init이 같지 않을때까지 반복.
				int idx = 0;
				for(int i = 0; i < arr.length; i++){
					if(init[i] != arr[i]){
						idx = i; // idx는 init과 arr의 값이 다른 시작 idx
						break;
					}
				}
				if(arr[idx] == '1')
					target = '1';
				else
					target = '0';
				
				// idx부터 마지막 idx까지 값을 target으로 변경
				for(int i = idx; i < arr.length; i++){
					init[i] = target;
				}
				answer++;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);	
	}
}
