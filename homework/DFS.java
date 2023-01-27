/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfs_main;

/**
 *
 * @author User
 */
import java.util.LinkedList;

class DFS {

    void DFS(int s, LinkedList<Integer>[] adj) {
        boolean[] visited = new boolean[adj.length];
        DFSUtil(s, visited, adj);
    }

    void DFSUtil(int v, boolean[] visited, LinkedList<Integer>[] adj) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i : adj[v]) {
            if (!visited[i]) {
                DFSUtil(i, visited, adj);
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        LinkedList<Integer>[] adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        adj[0].add(1);
        adj[0].add(2);
        adj[1].add(2);
        adj[2].add(0);
        adj[2].add(3);
        adj[3].add(3);
        new DFS().DFS(2, adj);
    }
}

