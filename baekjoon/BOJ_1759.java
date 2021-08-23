package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	static int L, C;
	static char[] alpha;
	static char[] output;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		output = new char[L];
		alpha = new char[C];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);
		comb(0, 0, 0, 0);
	}
	
	private static void comb(int cnt, int start, int vowelCnt, int consonant) {
		if(cnt == L) {
			if(vowelCnt < 1 || consonant < 2) return;
			
			int flag = 0;
			for(int i = 0; i < L - 1; i++) {
				if(output[i] > output[i + 1]) {
					flag = 1;
					break;
				}
			}
			if(flag == 0) {
				System.out.println(new String(output));
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
			output[cnt] = alpha[i];
			
			switch(output[cnt]) {
			case 'a': case 'e': case 'i': case 'o': case 'u':
				comb(cnt + 1, i + 1, vowelCnt + 1, consonant);
				break;
			default:
				comb(cnt + 1, i + 1, vowelCnt, consonant + 1);
				break;
			}
		}
	}
}
