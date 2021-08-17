package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_1828 {
	static class Temp implements Comparable<Temp>{
		int lowTemp, highTemp;
		
		public Temp(int lowTemp, int highTemp) {
			super();
			this.lowTemp = lowTemp;
			this.highTemp = highTemp;
		}

		@Override
		public int compareTo(Temp o) {
			return this.highTemp - o.highTemp;
		}
		
		@Override
		public String toString() {
			return "[" + lowTemp + ", " + highTemp + "]";
		}

	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer = 1;
		
		int N = Integer.parseInt(br.readLine());
		Temp[] temps = new Temp[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int lowTemp = Integer.parseInt(st.nextToken());
			int highTemp = Integer.parseInt(st.nextToken());
			
			temps[i] = new Temp(lowTemp, highTemp);
		}
		Arrays.sort(temps);
		
		int high = temps[0].highTemp;
		
		for(int i = 1; i < N; i++) {
			if(temps[i].lowTemp > high) {
				answer++;
				high = temps[i].highTemp;
			}
		}
		System.out.println(answer);
	}
}
