package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1 0 0 0 1 0 1 0 0 1
1 0 0 0 1 0 1 1 1 1
1 0 0 0 1 0 1 0 0 1
1 0 0 0 1 1 1 0 0 1
1 0 0 0 1 0 1 0 0 1
1 1 1 1 1 0 1 1 1 1
1 0 0 0 1 0 1 0 0 1
1 1 1 1 1 0 1 0 0 1
1 0 0 0 1 1 1 0 0 1
1 0 0 0 1 0 1 0 0 2
*/
public class swea_1210 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src\\swea\\input_swea_1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 11; t++) {
			br.readLine();
			sb.append("#").append(t).append(" ");
			char[] temp = br.readLine().replace(" ", "").toCharArray();
			int size = temp.length;
			char[][] map = new char[size][size];
			map[0] = temp;
			int row = size - 2;
			int col = 0;
			
			for(int i = 1; i < size; i++) {
				map[i] = br.readLine().replace(" ", "").toCharArray();
			}
			for(int i = 0; i < size; i++) {
				if(map[size - 1][i] == '2') {
					col = i;
					break;
				}
			}
			
			int flag = 0; // flag 0 : 위로 이동 중, flag 1 : 좌 이동 중, flag 2 : 우 이동 중
			while(row != 0) {
				if(flag == 0) {
					if(col - 1 >= 0 && col - 1 < size && map[row][col - 1] == '1') {
							col--;
							flag = 1;
							continue;
					}
					if(col + 1 >= 0 && col + 1 < size && map[row][col + 1] == '1') {
							col++;
							flag = 2;
							continue;
					}
					row--;
				}
				else if(flag == 1) {
					if(map[row - 1][col] == '1') {
						row--;
						flag = 0;
					}else {
						col--;
					}
				}
				else if(flag == 2){
					if( map[row - 1][col] == '1') {
						row--;
						flag = 0;
					}else {
						col++;
					}
				}
			}
			sb.append(col).append("\n");
		}
		System.out.println(sb);
	}
}
