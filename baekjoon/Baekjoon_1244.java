package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1244 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		String[] arr = br.readLine().split(" ");
		int size = arr.length;
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				int n = size / idx;
				for(int i = 1; i <= n; i++) {
					if("1".equals(arr[idx * i - 1]))
						arr[idx * i - 1] = "0";
					else
						arr[idx * i - 1] = "1";
				}
			}
			else {
				int startToIdx = idx - 1;
				int endToIdx = size - idx;
				int n = Integer.min(startToIdx, endToIdx);
				if("1".equals(arr[idx - 1]))
					arr[idx - 1] = "0";
				else
					arr[idx - 1] = "1";
				
				for(int i = 1; i <= n; i++) {
					if(!arr[idx - 1 - i].equals(arr[idx - 1 + i]))
						break;
					
					if("1".equals(arr[idx - 1 - i]))
						arr[idx - 1 - i] = "0";
					else
						arr[idx - 1 - i] = "1";
					
					if("1".equals(arr[idx - 1 + i]))
						arr[idx - 1 + i] = "0";
					else
						arr[idx - 1 + i] = "1";
				}
			}
		}
		for(int i = 0; i < size; i++) {
			sb.append(arr[i]).append(" ");
			if((i + 1) % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}
