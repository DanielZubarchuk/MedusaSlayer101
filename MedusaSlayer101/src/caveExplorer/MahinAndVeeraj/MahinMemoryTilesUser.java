package caveExplorer.MahinAndVeeraj;

import java.util.Scanner;

import caveExplorer.InventoryNockles;

public class MahinMemoryTilesUser {
	
	private static Scanner userIn;
	
	private static Scanner userChoiceRow;
	private static Scanner userChoiceRow2;
	private static int rowPick;
	private static int rowPick2;
	private static Scanner userChoiceCol;
	private static Scanner userChoiceCol2;
	private static int colPick;
	private static int colPick2;
	public static int userScore;


	public MahinMemoryTilesUser() {
		
	}

	public static void main(String[] args) {	
	
	}
	
	public static void userPlay(){
		userScore = 0;
		
		userIn = new Scanner(System.in);//
		userChoiceRow = new Scanner(System.in);
		userChoiceRow2 = new Scanner(System.in);
		userChoiceCol = new Scanner(System.in);
		userChoiceCol2 = new Scanner(System.in);
	
		//if i already pick for example (1,1), ai has to choose different row and column
		while(true){
			//System.out.println("Pick a row.");
			//rowPick = userChoiceRow.nextInt();
			/*while(rowPick <= 0 || rowPick >= 5){
				System.out.println("Pick a valid row.");
				rowPick = userChoiceRow.nextInt();
			}*/
			rowPick = enterValidRow();
		
			//System.out.println("Pick a column");//
			//colPick = userChoiceCol.nextInt();
			/*while(colPick <= 0 || rowPick >= 5){
				System.out.println("Pick a valid column.");
				colPick = userChoiceCol.nextInt();
			}*/
			colPick = enterValidColumn();
		
			EventMahinAndVeeraj.display[rowPick][colPick] = "|___" + EventMahinAndVeeraj.letters[rowPick - 1][colPick - 1] + "___";
			EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
		
			//System.out.println("Pick another row.");
			//rowPick2 = userChoiceRow2.nextInt();
			/*while(rowPick2 <= 0 || rowPick2 >= 5){
				System.out.println("Pick another valid row.");
				rowPick2 = userChoiceRow2.nextInt();
			}*/
			rowPick2 = enterValidRow2();
		
			//System.out.println("Pick another column.");
			//colPick2 = userChoiceCol2.nextInt(); //
			/*while(colPick2 <= 0 || rowPick2 >= 5){
				System.out.println("Pick another valid column.");
				colPick2 = userChoiceCol2.nextInt();
			}*/
			colPick2 = enterValidColumn2();
		
			EventMahinAndVeeraj.display[rowPick2][colPick2] = "|___" + EventMahinAndVeeraj.letters[rowPick2 - 1][colPick2 - 1] + "___";
			EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
		
			if(EventMahinAndVeeraj.letters[rowPick - 1][colPick - 1] == EventMahinAndVeeraj.letters[rowPick2 - 1][colPick2 - 1]){
				userScore++;
				System.out.println("Player Score: " + userScore);
			}
		
			//
			if(EventMahinAndVeeraj.letters[rowPick - 1][colPick - 1] != EventMahinAndVeeraj.letters[rowPick2 - 1][colPick2 - 1]){
				EventMahinAndVeeraj.display[rowPick][colPick] = "|_______";
				EventMahinAndVeeraj.display[rowPick2][colPick2] = "|_______";
				EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
				
				System.out.println("You lost your turn!");
				System.out.println("Player Score: " + userScore);
				/*rowPick = 0;
				rowPick2 = 0;
				colPick = 0;
				colPick2 = 0;*/
				VeerajMemoryTilesAI.computerPlay();
				break;
			}
		}
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
	
	//public static void userTurnStatus(){
		//if(turnCount == 2){
			//turnFinished = true;
		//}
	//}
}
