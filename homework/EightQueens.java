/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueen;

/**
 *
 * @author User
 */
public class EightQueens {
    private int[] queens;
    private int solutions;

    public EightQueens() {
        queens = new int[8];
    }

    public void solve() {
        placeQueen(0);
        System.out.println("Total solutions: " + solutions);
    }

    private void placeQueen(int row) {
        if (row == 8) {
            printSolution();
            solutions++;
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (canPlaceQueen(row, col)) {
                queens[row] = col;
                placeQueen(row + 1);
            }
        }
    }

    private boolean canPlaceQueen(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private void printSolution() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (queens[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        EightQueens queens = new EightQueens();
        queens.solve();
    }
}
