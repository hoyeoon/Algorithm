package source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
sample input(첫 번째 숫자는 노드의 개수, 두 번째 숫자는 간선의 개수 이다).
5
8
0 1 5
0 4 1
0 2 7
0 3 2
1 2 3
1 3 6
2 3 10
3 4 4
 */
public class 플로이드_워셜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int[][] dist = new int[v][v];

        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                if(i == j){
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        System.out.println(Arrays.deepToString(dist));

        st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[start][end] = Math.min(dist[start][end], cost);
            dist[end][start] = Math.min(dist[end][start], cost);
        }
        System.out.println(Arrays.deepToString(dist));

        // 플로이드_워셜 알고리즘
        for(int k = 0; k < v; k++){
            for(int i = 0; i < v; i++){
                for(int j = 0; j < v; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dist));
    }
}
