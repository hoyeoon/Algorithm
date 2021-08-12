package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_6808 {
	static int[] shuffle1 = new int[9];
	static int[] shuffle2 = new int[9];
	static int[] numbers = new int[9];
	static boolean[] isSelected = new boolean[9];
	static StringBuilder sb;
	static int win1;
	static int win2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 9; i++) {
				shuffle1[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] check = new int[18]; 
			for(int i = 0; i < 9; i++) {
				check[shuffle1[i] - 1] = 1;
			}			
			int idx = 0;
			for(int i = 0; i < 18; i++) {
				if(check[i] == 0) {
					shuffle2[idx] = i + 1;
					idx++;
				}
			}
			
			win1 = 0; win2 = 0;
			permutation(0, 0);
			sb.append(win1).append(" ").append(win2).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void permutation(int cnt, int flag) {
		if(cnt == 9) {
			int score1 = 0;
			int score2 = 0;
			for(int i = 0; i < 9; i++) {
				if(numbers[i] < shuffle1[i])
					score1 += numbers[i] + shuffle1[i];
				else
					score2 += numbers[i] + shuffle1[i];				
			}
			if(score1 > score2)
				win1++;
			else
				win2++;
			return;
		} else {
			for(int i = 0; i < 9; i++) {
				if((flag & 1 << i) != 0) continue;
				
				numbers[cnt] = shuffle2[i];
				permutation(cnt + 1, flag | 1 << i);

			}			
		}
	}
}
