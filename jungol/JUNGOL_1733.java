package jungol;

import java.util.Scanner;

public class JUNGOL_1733 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[21][21];
		
 		int[] dx = {0, 1, 1, -1};
		int[] dy = {1, 0, 1,  1};
		
		for (int i = 1; i < 20; i++)
			for (int j = 1; j < 20; j++)
				map[i][j] = sc.nextInt();
		sc.close();
		
		for(int i = 1; i < 20; i++) {
			for(int j = 1; j < 20; j++) {
				int currVal = map[i][j];
				if(currVal == 0) continue;

				// currVal = 1, 2
				for(int d = 0; d < 4; d++) {
					if(currVal == map[i + dx[d] * -1][j + dy[d] * -1]) continue;
					
					int count = 1;
					while(currVal == map[i + dx[d] * count][j + dy[d] * count]) {
						count++;
					}
					
					if(count == 5) {
						System.out.println(currVal);
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
}