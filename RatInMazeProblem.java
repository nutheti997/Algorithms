package com.noc.algs;

public class RatInMazeProblem {
	
	static boolean isSolved = false;

	static int[][] maze = { 
			{ 1, 0, 1, 1 }, 
			{ 1, 1, 1, 1 }, 
			{ 0, 1, 1, 1 }, 
			{ 0, 1, 0, 1 } 
		};

	public static void main(String[] args) {
		int x = 0;
		int y = 0;

		if (maze.length == 0)
			return;
		int[][] partSolution = new int[maze.length][maze[0].length];
		partSolution[0][0] = 1;

		int[] xPath = { 1, 0,-1, 0 };
		int[] yPath = { 0, 1,0, -1 };

		if(findPath(partSolution, x, y, xPath, yPath, 2)) {
			
		} else {
			System.out.println("No Solution!!");
		}
	}

	private static boolean findPath(int[][] solution, int x, int y, int[] xPath, int[] yPath, int itr) {

		int i, newX, newY;
		newX = x;
		newY = y;

		if (x == maze.length -1 && y == maze[0].length -1) {
			System.out.println("find the Solution");
			printArray(solution);
			isSolved =  true;
		}

		for (i = 0; i < xPath.length; i++) {
			newX = x + xPath[i];
			newY = y + yPath[i];
			if (isSafe(newX, newY, solution)) {
				solution[newX][newY] = itr;
				if (findPath(solution, newX, newY, xPath, yPath, itr + 1))
					isSolved =  true;
				else
					solution[newX][newY] = 0;// backtracking
			}
		}

		return isSolved;

	}

	static boolean isSafe(int x, int y, int sol[][]) {
		return (x >= 0 && x < sol.length && y >= 0 && y < sol[0].length && sol[x][y] == 0 && maze[x][y] == 1);
	}

	private static void printArray(int[][] ary) {
		for (int i = 0; i < ary.length; i++) {
			System.out.println();
			for (int j = 0; j < ary[0].length; j++) {
				System.out.printf("%3d ", ary[i][j]);
			}
		}
	}

}
