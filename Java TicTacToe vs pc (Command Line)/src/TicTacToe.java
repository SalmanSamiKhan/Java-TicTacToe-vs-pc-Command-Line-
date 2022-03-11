import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	static Scanner sc = new Scanner(System.in);
	static Random random = new Random();
	static String[] ar = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };

	static int tie_count = 0;
	static boolean turn = true;
	static int player = 1;
	boolean result_flag = true;

	TicTacToe() {

		turn = firstTurn();
		print();
		int s = 999;
		while (result_flag) {

			// System.out.println("Player " + player + " turn -->");
			if (turn) {
				s = input();
			}

			else {
				s = pc_input();
			}
			System.out.println();
			check();
			print();
		}

	}

	public boolean firstTurn() {
		return random.nextBoolean();
	}

	public static int input() {
		boolean local_while_flag = true;
		int i = 999;
		while (local_while_flag) {

			System.out.print("\nYour turn: \n");
			i = sc.nextInt();
			if (i < 0 || i > 8) {
				System.out.println("Please enter from 0..8");
			}

			else {
				if (ar[i] == "U" || ar[i] == "P") {
					System.out.println("Already used! Input another number");
				} else {
					ar[i] = "U";
					System.out.println("You chose block "+i);
					local_while_flag = false;
					tie_count++;
				}
			}

		}
		turn = !turn;
		return i;
	}

	public static int pc_input() {
		boolean local_while_flag = true;
		int i = 999;
		while (local_while_flag) {

			i = random.nextInt(9);
			if (ar[i] == "U" || ar[i] == "P") {

			} else {
				ar[i] = "P";
				System.out.println("Pc chose block " + i);
				local_while_flag = false;
				tie_count++;
			}

		}
		turn = !turn;
		return i;
	}

	public void print() {

		for (int i = 0; i < ar.length; i++) {
			System.out.print("| " + ar[i] + " ");
			if (i == 2 || i == 5 || i == 8) {
				System.out.println("|");
			}
		}
		System.out.println();

	}

	public void check() {

		// X win condition
		if (ar[0] == "U" && ar[1] == "U" && ar[2] == "U") {
			xWins();

		}
		if (ar[3] == "U" && ar[4] == "U" && ar[5] == "U") {
			xWins();
		}
		if (ar[6] == "U" && ar[7] == "U" && ar[8] == "U") {
			xWins();
		}
		if (ar[0] == "U" && ar[3] == "U" && ar[6] == "U") {
			xWins();
		}
		if (ar[1] == "U" && ar[4] == "U" && ar[7] == "U") {
			xWins();
		}
		if (ar[2] == "U" && ar[5] == "U" && ar[8] == "U") {
			xWins();
		}
		if (ar[0] == "U" && ar[4] == "U" && ar[8] == "U") {
			xWins();
		}
		if (ar[2] == "U" && ar[4] == "U" && ar[6] == "U") {
			xWins();
		}

		// O win condition

		if (ar[0] == "P" && ar[1] == "P" && ar[2] == "P") {
			oWins();

		}
		if (ar[3] == "P" && ar[4] == "P" && ar[5] == "P") {
			oWins();
		}
		if (ar[6] == "P" && ar[7] == "P" && ar[8] == "P") {
			oWins();
		}
		if (ar[0] == "P" && ar[3] == "P" && ar[6] == "P") {
			oWins();
		}
		if (ar[1] == "P" && ar[4] == "P" && ar[7] == "P") {
			oWins();
		}
		if (ar[2] == "P" && ar[5] == "P" && ar[8] == "P") {
			oWins();
		}
		if (ar[0] == "P" && ar[4] == "P" && ar[8] == "P") {
			oWins();
		}
		if (ar[2] == "P" && ar[4] == "P" && ar[6] == "P") {
			oWins();
		}

		// Tie condition

		if (tie_count > 8) {
			System.out.println("Tied!\n");
			result_flag = false;
		}

	}

	public void xWins() {
		System.out.println("Yeee! You won!\n");
		result_flag = false;

	}

	public void oWins() {
		System.out.println("PC won!\n");
		result_flag = false;

	}

}
