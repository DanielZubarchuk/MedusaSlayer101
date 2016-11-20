package caveExplorer.MahinAndVeeraj;

import java.util.Scanner;

public class MahinMemoryTilesUser {
	
	private static Scanner userChoiceRow;
	private static Scanner userChoiceRow2;
	private static int rowPick;
	private static int rowPick2;
	private static Scanner userChoiceCol;
	private static Scanner userChoiceCol2;
	private static int colPick;
	private static int colPick2;
	
	static boolean valid = true;

	public MahinMemoryTilesUser() {
		
	}

	public static void main(String[] args) {
//		System.out.println("test");
//		formFields();
//		userPlay();
		//System.out.println("test");
	}
	
	public static void userPlay(){
		//boolean turnFinished = false;
		int userScore = 0;
		//System.out.println("test");
		//if i already pick for example (1,1), ai has to choose different row and column
		while(EventMahinAndVeeraj.userTurn){
			System.out.println("Pick a row.");
			//int rowPick = EventMahinAndVeeraj.input.nextInt();
			rowPick = userChoiceRow.nextInt();
			
			System.out.println("Pick a column.");
			//int colPick = EventMahinAndVeeraj.input.nextInt();
			colPick = userChoiceCol.nextInt();
			
			System.out.println("Pick another row.");
			rowPick2 = userChoiceRow2.nextInt();
			
			System.out.println("Pick another column.");
			colPick2 = userChoiceCol2.nextInt();
		
			
		//display the choice the user made
		//make isValid for user input
		//if(EventMahinAndVeeraj.userTurn == true){
			EventMahinAndVeeraj.display[rowPick][colPick] = "|_" + EventMahinAndVeeraj.letters[rowPick - 1][colPick - 1] + "_";
			EventMahinAndVeeraj.display[rowPick2][colPick2] = "|_" + EventMahinAndVeeraj.letters[rowPick2 - 1][colPick2 - 1] + "_";
			//printpic of display array
			EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
			
			if(EventMahinAndVeeraj.letters[rowPick - 1][colPick - 1] == EventMahinAndVeeraj.letters[rowPick2 - 1][colPick2 - 1]){
				userScore++;
			}
			
			if(EventMahinAndVeeraj.letters[rowPick - 1][colPick - 1] != EventMahinAndVeeraj.letters[rowPick2 - 1][colPick2 - 1]){
				EventMahinAndVeeraj.display[rowPick][colPick] = "|___";
				EventMahinAndVeeraj.display[rowPick2][colPick2] = "|___";
				EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
				
				EventMahinAndVeeraj.userTurn = false;
			}
		//}
		}	

		//EventMahinAndVeeraj.userTurn = false;
		//if the second selection is same as the first selection, continue
		//if(turns == 2){
			//EventMahinAndVeeraj.userTurn = false;//
			//
			//turns = 0;
		//}
		System.out.println("hi");
	}
	
	private static void formFields(){
		userChoiceRow = new Scanner(System.in);
		userChoiceRow2 = new Scanner(System.in);
		userChoiceCol = new Scanner(System.in);
		userChoiceCol2 = new Scanner(System.in);
	}
	
	private static void validInput(int userInput){
		if(userInput <=0 || userInput >=5){
			valid = false;
			System.out.println("Enter a number from 1 to 4 only.");
		}
	}
	
	//public static void userTurnStatus(){
		//if(turnCount == 2){
			//turnFinished = true;
		//}
	//}
}
