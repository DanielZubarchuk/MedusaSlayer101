package caveExplorer.MahinAndVeeraj;

import java.util.Scanner;

import caveExplorer.InventoryNockles;

public class MahinMemoryTilesUser {
	
	private static Scanner userIn;
	public static boolean flipped[][];
	
	private static int rowPick;
	private static int rowPick2;
	
	private static int colPick;
	private static int colPick2;
	
	public static int userScore;

	public static void main(String[] args) {	
	
	}
	
	public static void userPlay(){
		flipped = new boolean [4][4];
		
		userIn = new Scanner(System.in);
		
		while(true){
			chooseRowAndColumn();
			checkFlipped();
			chooseRowAndColumn2();
			checkFlipped2();
		
			if(EventMahinAndVeeraj.letters[rowPick - 1][colPick - 1] == EventMahinAndVeeraj.letters[rowPick2 - 1][colPick2 - 1]){
				userScore++;
				System.out.println("Player Score: " + userScore);
				flipped[rowPick - 1][colPick - 1] = true;//
				flipped[rowPick2 - 1][colPick2 - 1] = true;//
			}
			
			if(EventMahinAndVeeraj.letters[rowPick - 1][colPick - 1] != EventMahinAndVeeraj.letters[rowPick2 - 1][colPick2 - 1]){
				EventMahinAndVeeraj.display[rowPick][colPick] = "|_______";
				EventMahinAndVeeraj.display[rowPick2][colPick2] = "|_______";
				EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
				
				System.out.println("You lost your turn!");
				System.out.println("Player Score: " + userScore);
				
				VeerajMemoryTilesAI.computerPlay();
				break;
			}
		}
	}
	
	private static void chooseRowAndColumn(){
		rowPick = enterValidRow();
		colPick = enterValidColumn();
	}
	
	private static void checkFlipped(){
		while(flipped[rowPick-1][colPick-1] || VeerajMemoryTilesAI.filled[rowPick-1][colPick-1]){
			System.out.println("This is already flipped.");
			chooseRowAndColumn();
		}
		EventMahinAndVeeraj.display[rowPick][colPick] = "|___" + EventMahinAndVeeraj.letters[rowPick - 1][colPick - 1] + "___";
		EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
		flipped[rowPick-1][colPick-1] = true;
	}
	
	private static void chooseRowAndColumn2(){
		rowPick2 = enterValidRow2();
		colPick2 = enterValidColumn2();
	}
	
	private static void checkFlipped2(){
		while(flipped[rowPick2-1][colPick2-1] || VeerajMemoryTilesAI.filled[rowPick2-1][colPick2-1]){
			System.out.println("This is already flipped.");
			chooseRowAndColumn2();
		}
		EventMahinAndVeeraj.display[rowPick2][colPick2] = "|___" + EventMahinAndVeeraj.letters[rowPick2 - 1][colPick2 - 1] + "___";
		EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
		flipped[rowPick2-1][colPick2-1] = true;
	}
	
	private static boolean validInput(int userInput){
		boolean valid = false;
		if(userInput == 333){
			InventoryNockles.hasShield = true;
			EventMahinAndVeeraj.win = true;
			EventMahinAndVeeraj.cheatWinner();
		}
		else if(userInput == 1 || userInput == 2 || userInput == 3 || userInput == 4){
			valid = true;
		}
		return valid;
	}
	
	private static int ask(){
		int userInput = userIn.nextInt();
		return userInput;
	}
	
	private static int enterValidRow(){//
		boolean waitingForInput = true;
		System.out.println("Pick a row.");
		rowPick = ask();
		while(waitingForInput){
			if(!validInput(rowPick)){
				System.out.println("Enter a number from 1 to 4 only.");
				rowPick = ask();
			}else{
				waitingForInput = false;
			}
		}
		return rowPick;
	}
	
	private static int enterValidRow2(){
		boolean waitingForInput = true;
		System.out.println("Pick another row.");
		rowPick2 = ask();
		while(waitingForInput){
			if(!validInput(rowPick2)){
				System.out.println("Enter a number from 1 to 4 only.");
				rowPick2 = ask();
			}else{
				waitingForInput = false;
			}
		}
		return rowPick2;
	}
	
	private static int enterValidColumn(){
		boolean waitingForInput = true;
		System.out.println("Pick a column.");
		colPick = ask();
		while(waitingForInput){
			if(!validInput(colPick)){
				System.out.println("Enter a number from 1 to 4 only.");
				colPick = ask();
			}else{
				waitingForInput = false;
			}
		}
		return colPick;
	}
	
	private static int enterValidColumn2(){
		boolean waitingForInput = true;
		System.out.println("Pick another column.");
		colPick2 = ask();
		while(waitingForInput){
			if(!validInput(colPick2)){
				System.out.println("Enter a number from 1 to 4 only.");
				colPick2 = ask();
			}else{
				waitingForInput = false;
			}
		}
		return colPick2;
	}
}
