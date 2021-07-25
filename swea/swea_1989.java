package swea;

import java.io.*;

public class swea_1989 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			String str = br.readLine();
			StringBuilder temp_sb = new StringBuilder(str);
			String reversedStr = temp_sb.reverse().toString();
			
			if(str.equals(reversedStr)) {
				sb.append(1);
			}else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
