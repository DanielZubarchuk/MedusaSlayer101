package caveExplorer.MahinAndVeeraj;

import java.util.Arrays;
import java.util.Scanner;

public class EventMahinAndVeeraj {

	static String[][] letters;
	static String[] objects = {"!", "@", "#", "$", "%", "^", "&", "*"};
	static int[] counters = new int[8];
	static String[][] blank;
	static String[][] display;
	static Scanner input;
	
	public EventMahinAndVeeraj() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		input = new Scanner(System.in);
		display = new String[5][5];
		letters = new String[4][4];
		blank = new String[4][4];
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
		
		System.out.println("Enter a row");
		int rowIn = input.nextInt();
		
		System.out.println("Enter a column");
		int colIn = input.nextInt();
		
		
		
		display[rowIn][colIn] = "|_" + "X" + "_";
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
	}
	
	public static void printPic(String[][] pic){
		for(String[] row: pic){
			for(String col: row){
				System.out.print(col);
			}
			System.out.println();
		}
	}

}
