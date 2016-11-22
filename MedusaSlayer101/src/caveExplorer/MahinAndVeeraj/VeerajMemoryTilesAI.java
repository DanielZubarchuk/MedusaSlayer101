package caveExplorer.MahinAndVeeraj;

public class VeerajMemoryTilesAI {
	
	public static int computerScore;
	public VeerajMemoryTilesAI() {
	}

	public static void main(String[] args) {
	}

	public static void computerPlay(){
		computerScore = 0;
		while(true){
			int row = (int)(Math.random() * 4);
			int col = (int)(Math.random() * 4);
		
			int row2 = (int)(Math.random() * 4);
			int col2 = (int)(Math.random() * 4);
			while(row2 == row && col == col2){
				row2 = (int)(Math.random() * 4);
				col2 = (int)(Math.random() * 4);
			}
		EventMahinAndVeeraj.display[row+1][col+1] = "|___" + EventMahinAndVeeraj.letters[row][col] + "___";
		EventMahinAndVeeraj.display[row2+1][col2+1] = "|___" + EventMahinAndVeeraj.letters[row2][col2] + "___";
		EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
		//
		if(EventMahinAndVeeraj.letters[row][col] == EventMahinAndVeeraj.letters[row2][col2]){
			System.out.println("These are equal");
			computerScore ++;
		}
		//
		//
		if(EventMahinAndVeeraj.letters[row][col] != EventMahinAndVeeraj.letters[row2][col2]){
			System.out.println("These are not equal");
			EventMahinAndVeeraj.display[row+1][col+1] = "|_______";
			EventMahinAndVeeraj.display[row2+1][col2+1] = "|_______";
			EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
			System.out.println("Computer Score: " + computerScore);
			MahinMemoryTilesUser.userPlay();
			break;
		}
		}
	}
}
