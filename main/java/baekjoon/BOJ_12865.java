package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12865 {
    static class Backpack {
        int w;
        int v;

        Backpack(int w, int v){
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Backpack> backpacks = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            backpacks.add(new Backpack(w, v));
        }

        backpacks.sort(Comparator.comparingInt(o -> o.w));

        for (Backpack backpack : backpacks) {
            System.out.println(backpack.w + ", " + backpack.v);
        }

        int[] dp = new int[k + 1];

        for(int i = 0; i < n; i++){
            for(int j = backpacks.get(i).w; j < k + 1; j++){
                dp[j] = Math.max(dp[j], backpacks.get(i).v);
            }
            System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
        }

    }
}
