package caveExplorer.MahinAndVeeraj;

public class VeerajMemoryTilesAI {

	public VeerajMemoryTilesAI() {
	}

	public static void main(String[] args) {
	}

	public static void computerPlay(){
		int computerScore = 0;
		while(true){
			int row = (int)(Math.random() * 4);
			int col = (int)(Math.random() * 4);
		
			int row2 = (int)(Math.random() * 4);
			int col2 = (int)(Math.random() * 4);
			while(row2 == row && col == col2){
				row2 = (int)(Math.random() * 4);
				col2 = (int)(Math.random() * 4);
			}
		EventMahinAndVeeraj.display[row+1][col+1] = "|_" + EventMahinAndVeeraj.letters[row][col] + "_";
		EventMahinAndVeeraj.display[row2+1][col2+1] = "|_" + EventMahinAndVeeraj.letters[row2][col2] + "_";
		EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
		//
		if(EventMahinAndVeeraj.letters[row][col] == EventMahinAndVeeraj.letters[row2][col2]){
			System.out.println("These are equal");
			computerScore ++;
		}
		//
		if(EventMahinAndVeeraj.letters[row][col] != EventMahinAndVeeraj.letters[row2][col2]){
			System.out.println("These are not equal");
			EventMahinAndVeeraj.display[row+1][col+1] = "|___";
			EventMahinAndVeeraj.display[row2+1][col2+1] = "|___";
			EventMahinAndVeeraj.printPic(EventMahinAndVeeraj.display);
			System.out.println("Computer Score: " + computerScore);
			MahinMemoryTilesUser.userPlay();
			break;
		}
		}
	}
}
