package programmers_lv2;

import java.util.*;

public class 배달 {
    static class Node{
        int idx;
        int cost;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }

    List<List<Node>> list;
    int[] dist;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int v = N;
        int e = road.length;
        int startIdx = 1;

        dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        list = new ArrayList<>();
        for(int i = 0; i < v + 1; i++){
            list.add(new ArrayList<Node>());
        }

        for(int i = 0; i < e; i++){
            list.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
        }
        // 무향그래프이므로 반대로도 추가
        for(int i = 0; i < e; i++){
            list.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }

        dist[startIdx] = 0;
        dijstra(startIdx);

        for(int i = 0; i < dist.length; i++){
            if(dist[i] <= K){
                answer++;
            }
        }

        return answer;
    }

    private void dijstra(int startIdx){
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        q.offer(new Node(startIdx, 0));

        while(!q.isEmpty()){
            Node currNode = q.poll();

            if(dist[currNode.idx] < currNode.cost){
                continue;
            }

            for(int i = 0; i < list.get(currNode.idx).size(); i++){
                Node nextNode = list.get(currNode.idx).get(i);

                if(dist[nextNode.idx] > currNode.cost + nextNode.cost){
                    dist[nextNode.idx] = currNode.cost + nextNode.cost;
                    q.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }
    }
}
