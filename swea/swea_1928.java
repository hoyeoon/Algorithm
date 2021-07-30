package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

public class swea_1928 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String base64data = br.readLine();
			byte[] binary = Base64.getDecoder().decode(base64data); // 디코딩
			sb.append("#").append(t).append(" ").append(new String(binary)).append("\n");
		}
		System.out.println(sb);
	}
}
