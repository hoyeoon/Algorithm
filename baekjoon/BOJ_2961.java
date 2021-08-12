package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {
	static int min;
	static int N;
	static int[] sour;
	static int[] bitter;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		isSelected = new boolean[N];
		sour = new int[N];
		bitter = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		generateSubset(0);
		System.out.println(min);
	}
	
	private static void generateSubset(int cnt) {	// cnt : 부분집합을 처리하기 위해 고려된 원소 수
		if(cnt == N) {
			// 부분집합 완성
			int flag = 0;
			int multipleSour = 1;
			int sumBitter = 0;
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					multipleSour *= sour[i];
					sumBitter += bitter[i];
					flag = 1;
				}
			}
			if(flag == 1)
				min = Math.min(min, Math.abs(multipleSour - sumBitter));
			return;
		}
		
		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset(cnt + 1);
		
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}
}
