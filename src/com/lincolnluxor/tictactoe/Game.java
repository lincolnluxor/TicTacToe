package com.lincolnluxor.tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	Scanner input = new Scanner(System.in);
	String inputString;
	int inputInteger;
	boolean goodInput = false;
	int winningPlayer = 0;
	int activePlayer = 1;
	String[] markers = {"X", "Y"};
	String[][] board = {
			{"1","2","3"},
			{"4","5","6"},
			{"7","8","9"}
			};
	ArrayList<Integer> remainingNumbers = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		new Game();
	}

	public Game() {
		remainingNumbers.add(1);
		remainingNumbers.add(2);
		remainingNumbers.add(3);
		remainingNumbers.add(4);
		remainingNumbers.add(5);
		remainingNumbers.add(6);
		remainingNumbers.add(7);
		remainingNumbers.add(8);
		remainingNumbers.add(9);
		System.out.println("Tic Tac Toe!");
		while (winningPlayer == 0) {
			printBoard();
			getInput();
			transformSelection();
			checkWinner();
			if (activePlayer == 1) {
				activePlayer += 1;
			}
			else {
				activePlayer -= 1;
			}
		}
		closeGame();
	}
	
	public void printBoard() {
		//remove the comment from the next line if you want separators between the rows
		//System.out.println("-------");
		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + "|");
				
			}
			System.out.println();
			//remove the comment from the next line if you want separators between the rows
			//System.out.println("-------");
		}
	}
	
	public void transformSelection() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (inputInteger == ((i*3)+j+1)) {
					if (activePlayer == 1) {
						board[i][j] = markers[activePlayer-1];
					}
					else {
						board[i][j] = markers[activePlayer-1];
					}
				}
			}
		}
	}
	
	public Integer getInput() {
		System.out.println("Player " + activePlayer + "!  Pick a place on the board from 1-9:");
		while (goodInput == false) {
			inputString = input.nextLine();
			try {
				inputInteger = Integer.parseInt(inputString);
				if (inputInteger >= 1 && inputInteger <= 9) {
					for (int i = 0; i < remainingNumbers.size(); i++) {
						if (remainingNumbers.get(i) == inputInteger) {
							remainingNumbers.remove(i);
							goodInput = true;
						}
					}
				}
			}
			catch (Exception e) {
				printBoard();
				System.out.println("Please enter a digit from 1-9 that has not been chosen already:"); 
			}
		}
		goodInput = false;
		return inputInteger;
	}
	
	public int checkWinner() {
		for (int i = 0; i < markers.length; i++) {
			if (board[0][0] == markers[i] && board[0][1] == markers[i] && board[0][2] == markers[i]) { //top row
				winningPlayer = activePlayer;
			}
			else if (board[1][0] == markers[i] && board[1][1] == markers[i] && board[1][2] == markers[i]) { //middle row
				winningPlayer = activePlayer;
			}
			else if (board[2][0] == markers[i] && board[2][1] == markers[i] && board[2][2] == markers[i]) { //bottom row
				winningPlayer = activePlayer;
			}
			else if (board[0][0] == markers[i] && board[1][0] == markers[i] && board[2][0] == markers[i]) { //left column
				winningPlayer = activePlayer;
			}
			else if (board[0][1] == markers[i] && board[1][1] == markers[i] && board[2][1] == markers[i]) { //middle column
				winningPlayer = activePlayer;
			}
			else if (board[0][2] == markers[i] && board[1][2] == markers[i] && board[2][2] == markers[i]) { //right column
				winningPlayer = activePlayer;
			}
			else if (board[0][0] == markers[i] && board[1][1] == markers[i] && board[2][2] == markers[i]) { //diagonal 1
				winningPlayer = activePlayer;
			}
			else if (board[0][2] == markers[i] && board[1][1] == markers[i] && board[2][0] == markers[i]) { //diagonal 2
				winningPlayer = activePlayer;
			}
			else if (remainingNumbers.size() == 0) {
				winningPlayer = 3;
			}
		}
		return winningPlayer;
	}
	
	public void closeGame() {
		if (winningPlayer < 3) {
			System.out.println("Congratulations Player " + winningPlayer + "!");
		}
		else {
			System.out.println("Stalemate");
		}
		printBoard();
	}
}
