package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];

        st = new StringTokenizer(br.readLine(), " ");

        for(int j = 0; j < W; j++) {
            int n = Integer.parseInt(st.nextToken());

            for(int i = 0; i < n; i++) {
                map[i][j] = 1;
            }
        }

        System.out.println(Arrays.deepToString(map));

        int zeroCount = 0;

        for(int i = 0; i < H; i++) {
            int startIdx = Integer.MAX_VALUE;
            int endIdx = Integer.MIN_VALUE;

            for(int j = 0; j < W; j++) {
                if(map[i][j] == 1) {
                    startIdx = Math.min(startIdx, j);
                    endIdx = Math.max(endIdx, j);
                }
            }

            for(int j = 0; j < W; j++) {
                if(map[i][j] == 0) {
                    if(j > startIdx && j < endIdx) {
                        zeroCount++;
                    }
                }
            }
        }

        System.out.println(zeroCount);
    }
}
