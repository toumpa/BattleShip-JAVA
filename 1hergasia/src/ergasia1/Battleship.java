package ergasia1;

public class Battleship { //ÔÏÕÌĞÁ ÃÅÙÑÃÉÁ 01793
	
	private int[][] target;
	private int[][] computer;
	
	static int hits, sunks;
	static int[][] guesses = new int[9][2];
	
 	Battleship(int[][] aTarget, int[][] aComputer) { // Constructor 
		target = aTarget;
		computer = aComputer;
	}

	public int[][] getTarget() { // getter and setter for array target
		return target;
	}

	public void setTarget(int[][] aTarget) {
		target = aTarget;
	}

	public int[][] getComputer() {
		return computer;
	}

	public void setComputer(int[][] aComputer) { // getter and setter for computer
		computer = aComputer;
	}
	
	public int getHits() {
		
		hits = 0;
		for(int i = 0; i < 10; i++) { // for each index of array target
			for(int j = 0; j < 9; j++) { // for each index of array computer
				
				if(target[i][0] == computer[j][0]) { // if the rows are equal 
					if(target[i][1] == computer[j][1]) { // and the columns are equal then the coordinates are the same
						
						guesses[hits][0] = target[i][0]; // keep the coordinates in a new array
						guesses[hits][1] = target[i][1];
						hits ++; // there is one hit
					
					}
				}
			}
		}
		return hits;
	}
	
	public int getSunks() {
		
		// the first Cruiser is in rows 3 and 4 and columns 0 and 1 in the array computer
		// the second is in rows 5 and 6 and columns 0 and 1
		// the third is in 7 and 8 rows and in 0 and 1 columns
		
		sunks = 0;
		int temp1 = 0 , temp2 = 0, temp3 = 0; // max sunks = 3 
		for(int i = 0; i < 10; i++) { // for each index of target
			
			if(target[i][0] == computer[3][0] && target[i][1] == computer[3][1]) { // if some of it equals with the half of the ship
				temp1 ++; // increase 1
			}
			else if(target[i][0] == computer[4][0] &&target[i][1] == computer[4][1]) { // if some of it equals with the other half
				temp1 ++; // increase again 
			}
			else if(target[i][0] == computer[5][0] && target[i][1] == computer[5][1]) { // check with the same way the second ship
				temp2 ++;
			}
			else if(target[i][0] == computer[6][0] && target[i][1] == computer[6][1]) {
				temp2 ++;
			}
			else if(target[i][0] == computer[7][0] && target[i][1] == computer[7][1]) { // check with the same way the third ship
				temp3 ++;
			}
			else if(target[i][0] == computer[8][0] && target[i][1] == computer[8][1]) {
				temp3 ++;
			}
		}

		if(temp1 == 2) { // the two half of the first ship has been hit
			sunks ++; // we have one sunk
		}
		if(temp2 == 2) {
			sunks ++;
		}
		if(temp3 == 2) {
			sunks ++;
		}
		return sunks;
	}
	
	public int getPoints() {
		int points = 0;
		
		points = hits + 2 * sunks; // 1 point for each hit and 2 points for each sunk
		
		return points;
	}

}