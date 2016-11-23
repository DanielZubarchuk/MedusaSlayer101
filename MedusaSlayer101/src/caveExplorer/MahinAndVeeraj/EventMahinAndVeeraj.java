package caveExplorer.MahinAndVeeraj;

import java.util.Arrays;
import java.util.Scanner;

import caveExplorer.InventoryNockles;
import caveExplorer.Playable;
import caveExplorer.caveExplorer;

public class EventMahinAndVeeraj implements Playable{

	private static final String[] SEQUENCE_1 = {"As you enter the room, the ceiling recedes and Medusa's sister appears.","<The shield that the gods spoke of is attached to the wall behind her. >","Her raspy voice reverberates through"
			+ " your skull.","Do you have a good memory? "};
	private static final String[] SEQUENCE_2 = {"You'll have to"
			+ " beat Medusa's sister at this memory game!"};
	private static final String[] SEQUENCE_3 = {"Are you ready?", "GO!"};
	public static final String[] SEQUENCE_4 = {"You defeated Medusa's sister!","She accepts her defeat begrudgingly.",
			"You take the shield off the wall and proceed with your journey."};
	public static final String[] CHEAT = {"You cheating cheater!", 
			"The gods have learned that you have cheated your way to victory.", 
			"You must now restart, but you will still have your shield and any other items you may have acquired."};
	
	static String[][] letters;
	static String[] objects = {"H", "I", "M", "E", "D", "U", "S", "A"};
	static int[] counters = new int[8];
	static String[][] display;
	static Scanner input;
	public static boolean win;
	static boolean cheat;

	public static Scanner in = new Scanner(System.in);
	
	public static void readSequence(String[] seq){
		for(String s : seq){
			caveExplorer.print(s);
			caveExplorer.print("- - - press enter - - -");
			in.nextLine();
		}
	}
	
	public void play() {
		input = new Scanner(System.in);
		display = new String[5][5];
		letters = new String[4][4];
		InventoryNockles.hasShield = false; 
		readSequence(SEQUENCE_1);
		readSequence(SEQUENCE_2);
		readSequence(SEQUENCE_3);
		
		for(int row = 0; row < display.length; row++){
			for(int col = 0; col < display[row].length; col++){
				display[row][col] = "|_______";
				if(col == 3){
					display[row][col] = "|_______";
				}
				if(row == 0){
					display[row][col] = "      " + Integer.toString(col);
				}
				if(col == 0){
					display[row][col] = Integer.toString(row);
				}
				display[0][0] = "";
			}
		}
		printPic(display);
		
		for(int row = 0; row < letters.length; row++){
			for(int col = 0; col < letters[row].length; col++){
				int index = (int)(Math.random()*8);
				while(counters[index] == 2){
					index = (int)(Math.random()*8);
				}
				counters[index] ++;
				letters[row][col] = objects[index];
			}
		}
		VeerajMemoryTilesAI.computerPlay();
		//
		win = true;
		for(int row = 0; row < display.length; row++){
			for(int col = 0; col < display[row].length; col++){
				if(display[row][col] == "|_______"){
					win = false;
				}
			}
		}
		if(win){
			if(VeerajMemoryTilesAI.computerScore > MahinMemoryTilesUser.userScore){
				readSequence(SEQUENCE_4);
				InventoryNockles.hasShield = true;
			}
			if(VeerajMemoryTilesAI.computerScore < MahinMemoryTilesUser.userScore){
				System.out.println("Medusa's sidekick has killed you!");
			}
			if(VeerajMemoryTilesAI.computerScore == MahinMemoryTilesUser.userScore){
				System.out.println("You are equally matched. Try again when you're stronger");
			}
		}
	}
	
	public static void printPic(String[][] pic){
		for(String[] row: pic){
			for(String col: row){
				System.out.print(col);
			}
			System.out.println();
		}
	}
	
	public static void cheatWinner(){
		win = true;
		readSequence(SEQUENCE_4);
		cheat = true;
		readSequence(CHEAT);
		caveExplorer.currentRoom = caveExplorer.caves[1][2];
		caveExplorer.startExploring();
	}
	
	public EventMahinAndVeeraj() {
	}
}
