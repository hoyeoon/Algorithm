package swea;

import java.io.*;

public class swea_2056 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		outer : for(int i = 1; i <= t; i++) {
			sb.append("#").append(i).append(" ");
			
			String input = br.readLine();
			String year = input.substring(0, 4);
			int month = Integer.parseInt(input.substring(4, 6));
			int day = Integer.parseInt(input.substring(6, 8));
			
			if(month < 1 || month > 12) {
				sb.append(-1).append("\n");
				continue;
			}
			
			switch(month){
				case 1: case 3:	case 5:	case 7:	case 8:	case 10: case 12:
					if(day < 1 || day > 31) {
						sb.append(-1).append("\n");
						continue outer;
					}
				case 4: case 6: case 9: case 11:
					if(day < 1 || day > 30) {
						sb.append(-1).append("\n");
						continue outer;
					}
				case 2:
					if(day < 1 || day > 28) {
						sb.append(-1).append("\n");
						continue outer;
					}
			}
			sb.append(year).append("/").append(String.format("%02d", month)).
			append("/").append(String.format("%02d", day)).append("\n");
		}
		System.out.println(sb);
	}
}
