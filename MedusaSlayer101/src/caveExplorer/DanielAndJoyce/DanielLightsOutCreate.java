package caveExplorer.DanielAndJoyce;

import java.util.Random;

import caveExplorer.Playable;
import caveExplorer.caveExplorer;

public class DanielLightsOutCreate implements Playable{

    private boolean[][] grid; 
    private int ROWS;
    private int COLS;
    private static final String ON = " # ";
    private static final String OFF = " - ";

    public void LightsOut(int r, int c){
        grid = new boolean[r][c];
        ROWS = r;
        COLS = c;

        final int N = 2 * r * c;
  
        Random rand = new Random();
        for (int i = 0; i < N; i++){
            move(rand.nextInt(r), rand.nextInt(c));
        }
    }
        
//    public void LightsOut(int n){
//        this(n, n);
//    }

    public final void move(int r, int c){
        if (!inBounds(r, c)){
            return;
        }

        toggle(r, c);
        toggle(r - 1, c);
        toggle(r + 1, c);
        toggle(r, c - 1);
        toggle(r, c + 1);
    }

    public boolean over() {
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLS; j++){
                if (grid[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "    ";  

       
        for (int i = 0; i < COLS; i++) {
            s += i + "  ";   
        }
        s += "\n";

        for (int i = 0; i < ROWS; i++) {
            s += " " + i + " ";   
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j]) {
                    s += ON;
                } else {
                    s += OFF;
                }
            }
            s += "\n";
        }

        return s;
    }

    private void toggle(int r, int c) {
        if (!inBounds(r, c)) {
            return;
        }
        grid[r][c] = !grid[r][c];
    }

    private boolean inBounds(int r, int c) {
        return r >= 0 && r < ROWS && c >= 0 && c < COLS;
    }

	
	private static final String[] SEQUENCE_1 = {"<A little yellow mouse with brown "
			+ "stripes and a lightening shaped tail runs up to you.>" + "Hi, I can see "
					+ "you are not from around here.", "Do you like puzzles?"};
	private static final String[] SEQUENCE_2 = {"You are going to have so much fun playing my 2-D games"
			+ ". Take this map."};

	public void play() {
		readSequence(SEQUENCE_1);
		System.out.println("Come on. Tell me you like puzzles.");
		while(caveExplorer.in.nextLine().toLowerCase().indexOf("yes") < 0){
			caveExplorer.print("Come on! You know you like puzzles. Say yes!");
		}
		readSequence(SEQUENCE_2);
		caveExplorer.inventory.setHasMap(true);
	}

	public static void readSequence(String[] seq){
		for(String s : seq){
			caveExplorer.print(s);
			caveExplorer.print("- - - press enter - - -");
			caveExplorer.in.nextLine();
		}
	}
}
