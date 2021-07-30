package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1284 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= T; i++) {
			sb.append("#").append(i).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if(w > r) {
				if(p * w > q + (w - r) * s)
					sb.append(q + (w - r) * s);
				else
					sb.append(p * w);
			} else {
				if(p > q)
					sb.append(q);
				else
					sb.append(p * w);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
