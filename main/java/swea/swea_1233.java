package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_1233 {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src\\swea\\input_swea_1233.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] arr;
		
		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");
			int n = Integer.parseInt(br.readLine());
			arr = new char[n + 1];
			int startLeaf = 0;
			
			for(int i = 1; i <= n; i++) {
				String[] str = br.readLine().split(" ");
				arr[i] = str[1].charAt(0);
				
				if(str.length == 4)
					startLeaf = i;
			}
//			System.out.println(Arrays.toString(arr));
			
			int flag = 1; // 계산이 가능 1, 불가능 0
			for(int i = 1; i <= startLeaf; i++) {
				if(arr[i] != '+' && arr[i] != '-' && arr[i] != '*' && arr[i] != '/') { // 숫자인 경우
					if(arr[i * 2] == '+' || arr[i * 2] == '-' || arr[i * 2] == '*' || arr[i * 2] == '/' ||
					arr[i * 2 + 1] == '+' || arr[i * 2 + 1] == '-' || arr[i * 2 + 1] == '*' || arr[i * 2 + 1] == '/') {
						flag = 0;
						break;
					}
				}	
			}
			sb.append(flag).append("\n");
		}
		System.out.println(sb);
	}
}
