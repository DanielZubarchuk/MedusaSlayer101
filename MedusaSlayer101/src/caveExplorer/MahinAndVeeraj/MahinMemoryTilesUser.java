package caveExplorer.MahinAndVeeraj;

import java.util.Scanner;

//import java.util.Scanner;

public class MahinMemoryTilesUser {
	
	public MahinMemoryTilesUser() {
		//boolean turnFinished = false;
		Scanner userChoice = new Scanner(System.in);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userPlay();
	}
	
	public static void userPlay(){
		//boolean turnFinished = false;
		int turns = 0;
		//System.out.println("test");
		//if i already pick for example (1,1), ai has to choose different row and column
		while(EventMahinAndVeeraj.userTurn == true){
			System.out.println("Pick a row.");
			//int rowPick = EventMahinAndVeeraj.input.nextInt();
			int rowPick = userChoice.nextInt();
			
			System.out.println("Pick a column.");
			//int colPick = EventMahinAndVeeraj.input.nextInt();
			int colPick = userChoice.nextInt();
			
			//display the choice the user made
			EventMahinAndVeeraj.display[rowPick][colPick] = "|_" + EventMahinAndVeeraj.letters[rowPick][colPick] + "_";
			//printpic of display array
			EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
			
			turns++;
		}
		EventMahinAndVeeraj.userTurn = false;
		//if the second selection is same as the first selection, continue
		if(turns == 2){
			EventMahinAndVeeraj.userTurn = false;//
			turns = 0;
		}
	}
	
	//public static void userTurnStatus(){
		//if(turnCount == 2){
			//turnFinished = true;
		//}
	//}
}
