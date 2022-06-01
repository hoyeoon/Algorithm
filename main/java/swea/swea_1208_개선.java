package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1208_개선 {
	static int N, min = 0, max = 99, data[] = new int[100];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println("#" + t + " " + solve());
		}
	}
	private static int solve() {
		Arrays.sort(data);
		for (int i = 0; i < N; i++) {
			int v = diff();
			if (v < 2) {
				return v;
			}
			data[min]++;
			data[max]--;
			
			changeMin();
			changeMax();
		}
		return diff();
	}
	
	private static void changeMin() {
		if (data[min] <= data[min + 1]) min = 0;
		else min++;
	}
	private static void changeMax() {
		if (data[max] >= data[max - 1]) max = 99;
		else max--;
	}
	
	private static int diff() {
		return data[max] - data[min];
	}
}