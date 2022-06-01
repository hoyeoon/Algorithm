package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class swea_1948 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= T; i++) {
			sb.append("#").append(i).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			LocalDate startDate = LocalDate.of(2021, startMonth, startDay);
			LocalDate endDate = LocalDate.of(2021, endMonth, endDay);
			
			long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
			sb.append(days).append("\n");
		}
		System.out.println(sb);
	}
}
