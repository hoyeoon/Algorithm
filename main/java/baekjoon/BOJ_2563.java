package baekjoon;

import java.util.Scanner;

public class BOJ_2563 {
	public static void main(String[] args) {
		int[][] map = new int[101][101];
		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int answer = 0;
		
		while(n-- > 0) {
			String[] temp = sc.nextLine().split(" ");
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					if(map[x + i][y + j] == 0)
						map[x + i][y + j] = 1;
				}
			}
		}
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				if(map[i][j] == 1)
					answer++;
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
