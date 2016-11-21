package caveExplorer.MahinAndVeeraj;

import java.util.Arrays;
import java.util.Scanner;

import caveExplorer.Playable;
import caveExplorer.caveExplorer;

public class EventMahinAndVeeraj implements Playable{

	private static final String[] SEQUENCE_1 = {"Do you have a good memory?"};
	private static final String[] SEQUENCE_2 = {"Either way, you're going to have to play this game to get past this room","You'll have to"
			+ " beat Medusa's sidekick at this memory game!"};
	private static final String[] SEQUENCE_3 = {"Are you ready?", "GO!"};
	private static final String[] SEQUENCE_4 = {"You defeated Medusa's sidekick!",
			"Here, take this shield and proceed with your journey!"};
	
	public static Scanner in = new Scanner(System.in);
	
	public static void readSequence(String[] seq){
		for(String s : seq){
			caveExplorer.print(s);
			caveExplorer.print("- - - press enter - - -");
			in.nextLine();
		}
	}
	
	public void play() {
	}

	static String[][] letters;
	static String[] objects = {"!", "@", "#", "$", "%", "^", "&", "*"};
	static int[] counters = new int[8];
	static String[][] blank;
	static String[][] display;
	static Scanner input;
	public static boolean userTurn;
	//
	public EventMahinAndVeeraj() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		input = new Scanner(System.in);
		display = new String[5][5];
		letters = new String[4][4];
		blank = new String[4][4];
		readSequence(SEQUENCE_1);
		readSequence(SEQUENCE_2);
		readSequence(SEQUENCE_3);
		
		for(int row = 0; row < display.length; row++){
			for(int col = 0; col < display[row].length; col++){
				display[row][col] = "|___";
				if(col == 3){
					display[row][col] = "|___";
				}
				if(row == 0){
					display[row][col] = "   " + Integer.toString(col);
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
		MahinMemoryTilesUser.userPlay();
		
		boolean win = true;
		for(int row = 0; row < display.length; row++){
			for(int col = 0; col < display[row].length; col++){
				if(display[row][col] == "|___"){
					win = false;
				}
			}
		}
		if(win){
			readSequence(SEQUENCE_4);
		}
	}
	//
	//
	public static void printPic(String[][] pic){
		for(String[] row: pic){
			for(String col: row){
				System.out.print(col);
			}
			System.out.println();
		}
	}



}
