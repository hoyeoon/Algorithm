package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1228 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		List<String> code;
		List<String> command;
		
		for (int t = 1; t <= 10; t++) {
			code = new LinkedList<>();
			command = new ArrayList<>();
			br.readLine();
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens())
				code.add(st.nextToken());
			br.readLine();
			st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens())
				command.add(st.nextToken());
//			System.out.println(code);
//			System.out.println(command);
			
			int x = -1, y = -1, cnt = 0;

			for(int i = 0; i < command.size(); i++) {
				if("I".equals(command.get(i))) {
					x = Integer.parseInt(command.get(i + 1));
					y = Integer.parseInt(command.get(i + 2));
					i += 2;
					continue;
				}
//				System.out.print(command.get(i) + "-");
				
				code.add(x + cnt, command.get(i));
				cnt++;
				
				if(cnt == y) {
					cnt = 0;
				}
			}
//			System.out.println();
//			System.out.println("2"+ code);
			
			for(int i = 0; i < 10; i++)
				sb.append(code.get(i)).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
