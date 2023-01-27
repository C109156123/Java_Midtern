/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze_main;

/**
 *
 * @author User
 */
import java.util.LinkedList;

public class Maze {
    private int[][] maze;
    private boolean[][] visited;
    private int startX, startY;
    private int endX, endY;

    public Maze(int[][] maze, int startX, int startY, int endX, int endY) {
        this.maze = maze;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.visited = new boolean[maze.length][maze[0].length];
    }

    public boolean solve() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (current.x == endX && current.y == endY) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                if (isValidMove(newX, newY)) {
                    queue.add(new Node(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }

    private boolean isValidMove(int x, int y) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) {
            return false;
        }
        if (maze[x][y] == 1 || visited[x][y]) {
            return false;
        }
        return true;
    }

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
