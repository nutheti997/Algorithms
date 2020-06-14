package com.noc.algs;

/**
 * 
 * If Knight starts at [0,0] position in 8x8 chess borad, possible ways to cover
 * all the places
 * 
 * 
 */
public class ChessKnightsProblem {

	static int SIZE = 8; // chessboard size

	public static void main(String[] args) {
		int sol[][] = initializeArray();

		/*
		 * xMove[] and yMove[] define next move of Knight. xMove[] is for next value of
		 * x coordinate yMove[] is for next value of y coordinate
		 */
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		// Since the Knight is initially at the first block
		sol[0][0] = 0;

		if (makeNextMove(0, 0, sol, xMove, yMove, 1)) {
			printArray(sol);
		} else {
			System.out.println("No Solution!");

		}
	}

	private static int[][] initializeArray() {
		int[][] chessBoard = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {

			for (int j = 0; j < SIZE; j++) {
				chessBoard[i][j] = -1;
			}
		}
		return chessBoard;
	}

	private static boolean makeNextMove(int x, int y, int[][] chessboard, int xMove[], int yMove[], int moveNum) {
		int nextX;
		int nextY;
		int i;
		if (moveNum == SIZE * SIZE) {

			return true;
		}
		for (i = 0; i < 8; i++) {

			nextX = x + xMove[i];
			nextY = y + yMove[i];

			if (isValidMove(nextX, nextY, chessboard)) {
				chessboard[nextX][nextY] = moveNum;
				if (makeNextMove(nextX, nextY, chessboard, xMove, yMove, moveNum + 1)) {
					return true;
				} else {
					chessboard[nextX][nextY] = -1;
				}
			}

		}
		return false;
	}

	static boolean isValidMove(int x, int y, int chess[][]) {
		return (x >= 0 && x < SIZE && y >= 0 && y < SIZE && chess[x][y] == -1);
	}

	private static void printArray(int[][] ary) {
		for (int i = 0; i < SIZE; i++) {
			System.out.println();
			for (int j = 0; j < SIZE; j++) {
				System.out.printf("%3d ", ary[i][j]);
			}
		}
	}

}
