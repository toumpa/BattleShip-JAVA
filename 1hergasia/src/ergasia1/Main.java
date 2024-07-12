package ergasia1;

import java.util.Scanner; //‘œ’Ã–¡ √≈Ÿ—√…¡ 01793

public class Main {
	
public static void main(String[] args) {
		
		Scanner myObj = new Scanner(System.in);
		
		int[][] target = new int[10][2]; // array with guesses
		char[][] board = new char[9][9]; // array from the board
		int computer[][] = new int[9][2]; // array with the already placed ships
		boolean flag = false; // Variable for multiple games
		
		//----------------------------------------------------------------------------------------------------
		
		while(flag == false) {
			
			empty_array(board); // set table with B like its empty
			
			Patrol ship1 = new Patrol(board, computer); // place patrol ships 
			Cruiser ship2 = new Cruiser(board, computer); // place cruiser ships
			
			ship1.putPatrol();
			ship2.putCruiser();
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					
					if(board[i][j] == 't') { // if it's a necessary empty space for Patrol ships then
						
						board[i][j] = 'B'; // after you placed them all change it to just empty space with B
					}
				}
			}
			players_turn(target, myObj, board); // fill target with coordinates to hit the ships
			
			//------------------------------------------------------------------------------------------------
			
			Battleship action = new Battleship(target, computer); // get hits from another class
			
			for(int i = 0; i < action.getHits(); i++) { // how many times did you hit a ship
				
				board[Battleship.guesses[i][0] - 1][Battleship.guesses[i][1] - 1] = 'H'; //go to coordinates
			
			} // you hit a ship (- 1 to get from 0 to 9) and change it to H for hit
			
			//------------------------------------------------------------------------------------------------
			
			Print pr1 = new Print(target, computer, board); // print the 3 arrays from another class
			
			pr1.printTarget();
			pr1.printComputer();
			pr1.printBoard();
			
			//------------------------------------------------------------------------------------------------
			
			System.out.println("HITS: " + action.getHits());       // find and print hits
			System.out.println("SUNKS: " + action.getSunks());   // find and print sunks for Cruiser
			System.out.println("Your points are: " + action.getPoints());     // find and print the points he earned
			
			//------------------------------------------------------------------------------------------------
			
			System.out.println("Do you want to continue and start over a new game? Choose ~y~ for yes and ~n~ for no.");
			char an = myObj.next().charAt(0); // scan the answer to see if he wants to play again
			
			if(an == 'n' || an == 'N') {
				flag = true; // if he doesn't want then stop the loop
			}
		}
		
		//----------------------------------------------------------------------------------------------------
		
		myObj.close();
		System.out.println("END GAME!");

	}

static void empty_array(char[][] board) {
	
	for(int i = 0; i < 9; i++) {
		for(int j = 0; j < 9; j++) {
			board[i][j] = 'B'; // there is empty space in the table - no ships or missed guesses
		}
	}
}

static void players_turn(int[][] target, Scanner myObj, char[][] board) {
	
	int moves = 0; // get 10 coordinates
	while(moves < 10) {
		
		System.out.print("Give coordinates for your " + (moves + 1) + " ship (from 11 to 99 without using digit zero).\nRows goes first: ");
        int element = myObj.nextInt();
        
        if (element < 11 || element >= 100) { // coordinates out of limits
            System.out.println("\nWrong coordinates please try again! Choose between 11 to 99.");
	    } 
        else { // right coordinates
        	
        	int x = element / 10; // get first digit from quotient 
        	int y = element % 10; // get second digit from remainder
        	
        	if(y == 0) { // second digit is zero
        		System.out.println("Wrong coordinates! You include digit zero (0). Try again! ");
        	}
        	else {
        		target[moves][0] = x;
	        	target[moves][1] = y; 
	        	moves ++; 
	        	board[x-1][y-1] = 'M'; // place M for missed hit and if its a hit change it in main
        	}  // x-1 and y-1 cause the index of an array starts from 0 to 8
        }
	}
	System.out.println(" ");
}

}