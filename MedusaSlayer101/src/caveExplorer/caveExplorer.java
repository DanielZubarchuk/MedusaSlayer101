package caveExplorer;
import java.util.Scanner;

import caveExplorer.VictorAndGabriel.EventVictorAndGabriel;
import caveExplorer.DanielAndJoyce.EventDanielAndJoyce;
import caveExplorer.MahinAndVeeraj.EventMahinAndVeeraj;

public class caveExplorer {

	public static pd8CaveRoom[][] caves;
	public static Scanner in;
	public static pd8CaveRoom currentRoom;
	public static InventoryNockles inventory;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		caves = new pd8CaveRoom[5][5];
		for(int row = 0; row < caves.length; row++){
			for (int col = 0; col < caves[row].length; col++){
				caves[row][col] = new pd8CaveRoom("This room has coordinates " + row + ", " + col);
			}
		}
	currentRoom = caves[1][2];
	caves[3][2] = new EventRoom("Time to play Battleship!", new EventDanielAndJoyce()); 
	caves[1][1] = new EventRoom("This is the Minesweeper Room.", new EventVictorAndGabriel());
	caves[2][2] = new EventRoom("Get ready to test your memory!", new EventMahinAndVeeraj());
	caves[1][3] = new EventRoom("This is where you found the map.", new GameStartEvent());
	currentRoom.enter();
	caves[1][2].setConnection(pd8CaveRoom.WEST, caves[1][1], new Door());
	caves[1][2].setConnection(pd8CaveRoom.SOUTH, caves[2][2], new Door());
	caves[1][2].setConnection(pd8CaveRoom.EAST, caves[1][3], new Door());
	caves[2][1].setConnection(pd8CaveRoom.NORTH, caves [1][1], new Door());
	caves[2][1].setConnection(pd8CaveRoom.SOUTH, caves [3][1], new Door());
	caves[2][1].setConnection(pd8CaveRoom.NORTH, caves [1][1], new Door());
	caves[2][2].setConnection(pd8CaveRoom.WEST, caves [2][1], new Door());
	caves[2][2].setConnection(pd8CaveRoom.EAST, caves [2][3], new Door());
	caves[3][2].setConnection(pd8CaveRoom.NORTH, caves [2][2], new Door());

	inventory = new InventoryNockles();
	startExploring();
}

	
	private static void startExploring() {
		while(true){
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("What would you like to do?");
			String input = in.nextLine();
			act(input);
		}
	}
	private static void act(String input) {
		currentRoom.interpretAction(input);
	}


	public static void print(String s){
		System.out.println(s);
	}
}
