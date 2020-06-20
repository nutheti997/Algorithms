package com.noc.algs;


//finding possible ways to keep N queens in NxN chessboard
public class QueensChessProblem {
	
	private static int N = 4;
	
	public static void main(String[] args) {
		
		int[][] ary = {
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}
		};
		
		solveNQ(ary, 0);
	}

	private static void solveNQ(int[][] ary, int row) {
		if(row >= N) {
			System.out.println("\n============================");
			printArray(ary);
			return;
		}
		
		for(int col = 0 ; col < N; col++) {
			if(isSafe(ary, row, col)) {
				ary[row][col] = 1;
				solveNQ(ary, row + 1);
				ary[row][col] = 0; //back tracking
			}
		}
	}
	
	private static boolean isSafe(int[][] ary, int row, int col) {
		//checking if any Queen in same row
		for(int i =0; i < N; i++) {
			if(ary[row][i] == 1) {
				return false;
			}
		}
		
		//check if any Queen in same column
		for(int i= 0; i <row; i++) {
			if(ary[i][col] == 1) {
				return false;
			}
		}
		
		//diagonal to left top
		for(int r = row, c= col; r>=0 && c >=0; r--,c--) {
			if(ary[r][c] == 1) {
				return false;
			}
		}
		//diagonal to right top
		for(int r = row, c= col; r>=0 && c < N; r--,c++) {
			if(ary[r][c] == 1) {
				return false;
			}
		}
		return true;
	}
	private static void printArray(int[][] ary) {
		for (int i = 0; i < ary.length; i++) {
			System.out.println();
			for (int j = 0; j < ary[0].length; j++) {
				System.out.printf("%d ", ary[i][j]);
			}
		}
	}
}
