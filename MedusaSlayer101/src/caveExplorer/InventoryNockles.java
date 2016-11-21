package caveExplorer;

public class InventoryNockles {

	public boolean hasMap;
	public static boolean hasHelmet; // helmet item
	public static boolean hasShield;
	public static boolean hasSword;
	private String map;
	
	public InventoryNockles() {
		hasMap = false;
//		hasHelmet = true;
//		hasShield = true;
//		hasSword = true;
		updateMap();
	}

	public void setHasMap(boolean hasMap) {
		this.hasMap = hasMap;
	}

	public void updateMap() {
		pd8CaveRoom[][] caves =  caveExplorer.caves;
		//create the top
		map = " ";
		//horizontal line across top row,
		//width 4
		for(int i = 0; i < caves[0].length -1; i++){
			map += "____";
		}
		map+= "___\n";
		//each room
		for(pd8CaveRoom[] row: caves){
			//there are 3 rows of text 
			for(int textRow = 0; textRow < 3; textRow ++){
				for(pd8CaveRoom cr : row){
					String str = "|   ";
					String contents = cr.getContents();
					if (textRow == 1){
						if (cr.getDoor(pd8CaveRoom.WEST)!= null && cr.getDoor(pd8CaveRoom.WEST).isOpen()){
							str = "  " + contents + " ";
						}else{
							str = "| "+ contents + " ";
						}
					}
					else if (textRow == 2){
						if(cr.getDoor(pd8CaveRoom.SOUTH)!= null && cr.getDoor(pd8CaveRoom.SOUTH).isOpen()){
							str = "|_ _";
						}else{
							str = "|___";
						}
					}
					map += str;
				}//end of row of cave rooms
				map += "|\n";
			}
		}
	}

	public String getDescription() {
		if (hasMap) return map;
		else return "You have no map";
	}
	
	public String getGodItems(){
		String output = "";
		if(hasHelmet){
			output += "You have the Helmet of Invisibility. "; 
		}
		if(hasShield){
			output += "You have the shield.";
		}
		if(hasSword){
			output += "You have the sword.";
		}
		return output;
		
	}

}
