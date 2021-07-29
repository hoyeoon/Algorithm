package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class swea_1288 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int[] num = new int[10];
			int count = 0;
			sb.append("#").append(t).append(" ");
			
			String original_target = br.readLine();
			String target = "";
			while(IntStream.of(num).anyMatch(x -> x == 0)) {
				target = Integer.toString(Integer.parseInt(original_target) * ++count);
				char[] charArr = target.toCharArray();
				
				for(int i = 0; i < charArr.length; i++) {
					num[charArr[i] - '0'] += 1;
				}
			}
			sb.append(target).append("\n");
		}
		System.out.println(sb);
	}
}
