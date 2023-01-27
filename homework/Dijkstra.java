/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra_main;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
static int n = 5;
static int[][] graph = {{0, 2, 5, 1, Integer.MAX_VALUE},
{2, 0, 3, 2, Integer.MAX_VALUE},
{5, 3, 0, 3, 1},
{1, 2, 3, 0, 4},
{Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 4, 0}};
static boolean[] visited = new boolean[n];
static int[] dist = new int[n];


public static void main(String[] args) {
    for (int i = 0; i < n; i++) {
        dist[i] = Integer.MAX_VALUE;
    }

    dijkstra(0);

    for (int i = 0; i < n; i++) {
        System.out.println("0 到 " + i + " 的最短距离是 " + dist[i]);
    }
}

public static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    dist[start] = 0;
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
        Node curr = pq.poll();
        int currIndex = curr.index;
        if (visited[currIndex]) continue;
        visited[currIndex] = true;

        for (int i = 0; i < n; i++) {
            if (graph[currIndex][i] != Integer.MAX_VALUE && !visited[i]) {
                if (dist[i] > dist[currIndex] + graph[currIndex][i]) {
                    dist[i] = dist[currIndex] + graph[currIndex][i];
                    pq.offer(new Node(i, dist[i]));
                }
            }
        }
    }
}
}

class Node implements Comparable<Node> {
int index;
int distance;


Node(int index, int distance) {
    this.index = index;
    this.distance = distance;
}

@Override
public int compareTo(Node o) {
    return this.distance - o.distance;
}
}


