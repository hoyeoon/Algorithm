package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_1940 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String command;
		int speed;
		int totalMove;
		int inputSpeed;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			speed = 0;
			totalMove = 0;
			
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++) {
				String str = br.readLine();
				if(str.length() != 1) {
					st = new StringTokenizer(str, " ");
					command = st.nextToken();
					inputSpeed = Integer.parseInt(st.nextToken());
					
					if(command.equals("1"))
						speed += inputSpeed;
					else {
						if(speed < inputSpeed)
							speed = 0;
						else
							speed -= inputSpeed;
					}
				}
				totalMove += speed;
			}
			bw.write("#" + t + " " + totalMove);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
