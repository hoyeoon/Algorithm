package source;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
sample input
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
*/
public class 다익스트라 {
    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }

    static int[] dist;
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dist = new int[v + 1];

        st = new StringTokenizer(br.readLine());
        int startIdx = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= v; i++){
            list.add(new ArrayList<Node>());
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, cost));
        }

        dist[startIdx] = 0;
        dijstra(startIdx);

        System.out.println(Arrays.toString(dist));
    }

    private static void dijstra(int startIdx) {

        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        q.offer(new Node(startIdx , 0));

        while(!q.isEmpty()){
            Node currNode = q.poll();

            if(currNode.cost > dist[currNode.idx]){
                continue;
            }

            for(int i = 0; i < list.get(currNode.idx).size(); i++){

                Node nextNode = list.get(currNode.idx).get(i);

                if(dist[nextNode.idx] > nextNode.cost + currNode.cost){
                    dist[nextNode.idx] = nextNode.cost + currNode.cost;
                    q.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }
    }
}
