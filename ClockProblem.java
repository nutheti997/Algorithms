package com.noc.algs;

import java.util.ArrayList;

public class ClockProblem {

	private static ArrayList<String> visitedList = new ArrayList<String>();
	
	static int loops = 0;

	public static void main(String[] args) {
		printOrder(4, 4, 4, new Character[12], 0, "");
	System.out.println(loops);
	}

	private static void printOrder(int p, int n, int d, Character[] clock, int index, String order) {
		loops++;
		if (order.length() == 12) {
			System.out.println("******==>" + order);
			return;
		}

		if (!isNextMoveAllowed(p, n, d, clock, index)) {
			return;
		}

		checkD(p, n, d, clock, index, order);
		checkN(p, n, d, clock, index, order);
		checkP(p, n, d, clock, index, order);

	}

	private static void checkP(int p, int n, int d, Character[] clock, int index, String order) {
		if (p > 0) {
			int idx = index + 1;
			if (idx == 12)
				idx = 0;
			if (clock[idx] == null && !visitedList.contains(order + 'p')) {
				clock[idx] = 'p';
				visitedList.add(order + 'p');
				printOrder(p - 1, n, d, clock, idx, order + 'p');

				clock[idx] = null;

				printOrder(p, n, d, clock, index, order);
			}

		}
	}

	private static void checkN(int p, int n, int d, Character[] clock, int index, String order) {
		if (n > 0) {

			int idx = index + 5;
			if (idx >= 12)
				idx = idx - 12;
			if (clock[idx] == null && !visitedList.contains(order + 'n')) {
				clock[idx] = 'n';
				visitedList.add(order + 'n');

				printOrder(p, n - 1, d, clock, idx, order + 'n');
				clock[idx] = null;

				printOrder(p, n, d, clock, index, order);
			}

		}
	}

	private static void checkD(int p, int n, int d, Character[] clock, int index, String order) {
		if (d > 0) {

			int idx = index + 10;
			if (idx >= 12)
				idx = idx - 12;
			if (clock[idx] == null && !visitedList.contains(order + 'd')) {
				clock[idx] = 'd';
				visitedList.add(order + 'd');
				printOrder(p, n, d - 1, clock, idx, order + 'd');
				clock[idx] = null;

				printOrder(p, n, d, clock, index, order);
			}

		}
	}

	private static boolean isNextMoveAllowed(int p, int n, int d, Character[] clock, int index) {
		int indx;
		indx = index + 1;
		if (((indx) == 12)) {
			indx = 0;
		}
		if (clock[indx] == null) {
			return true;
		}
		indx = index + 5;
		if ((indx >= 12)) {
			indx = indx - 12;
		}
		if (clock[indx] == null) {
			return true;
		}
		indx = index + 10;
		if ((indx >= 12)) {
			indx = indx - 12;
		}
		if (clock[indx] == null) {
			return true;
		}

		return false;
	}

}
