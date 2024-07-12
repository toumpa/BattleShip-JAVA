package ergasia1;

public class Cruiser {  //‘œ’Ã–¡ √≈Ÿ—√…¡ 01793
	
	private char[][] board;
	private int[][] computer;
	
	Cruiser(char[][] aBoard, int[][] aComputer) { // Constructor 
		setBoard(aBoard);
		setComputer(aComputer);
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] aBoard) {
		board = aBoard;
	}

	public int[][] getComputer() {
		return computer;
	}

	public void setComputer(int[][] aComputer) {
		computer = aComputer;
	}
	
	
	public void putCruiser() {
		
		int c_moves = 3;
		while(c_moves < 9) { // Cruiser equals with 2 empty spaces so i need 3 other moves to complete the 9 place for the computer array
			
			int i = (int)(Math.random() * 10); // like in Patrol
	        int j = (int)(Math.random() * 10);
	        int x = i-1;
	        int y = j-1;
	        
	        if((x >= 1 && x <= 7) && (y >= 1 && y <= 7) && board[x][y] == 'B') { // between 1-7 columns and rows
	        	
	        	if(board[x][y-1]=='B'){ // if there is empty space left from the random coordinates
	        		board[x][y] = 'S'; // place S in both of them
	                board[x][y-1] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);  // place the random element in computer
	                c_moves = placeComputer(computer, c_moves, i, j-1);  // place the element next to random in computer
	        	}
	        	else if(board[x][y+1]=='B') { // empty space right
	        		board[x][y] = 'S';
	                board[x][y+1] = 'S'; // place S in both of them
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i, j+1);
	        	}
	        	else if(board[x-1][y]=='B') { // empty up
	        		board[x][y] = 'S';
	                board[x-1][y] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i-1, j);
	        	}
	        	else if(board[x+1][y]=='B') { // empty down
	        		
	        		board[x][y] = 'S';
	                board[x+1][y] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i+1, j);
	        	}
	        }
	        else if((x == 0) && (y >=1 && y <= 7) && (board[x][y] == 'B')) { // if they are in first row and there is empty space
	        	if(board[x][y+1] == 'B') { // empty right
	        		board[x][y] = 'S';
	                board[x][y+1] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i, j+1);
	        	}
	        	else if(board[x][y-1] == 'B') { // empty left
	        		board[x][y] = 'S';
	                board[x][y-1] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i, j-1);
	        	}
	        	else if(board[x+1][y] == 'B') { // empty down
	        		board[x][y] = 'S';
	                board[x+1][y] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i+1, j);
	        	}
	        }
	        else if((x == 8) && (y >=1 && y <= 7) && (board[x][y] == 'B')) { // if they are in last row
	        	if(board[x][y+1] == 'B') { // empty right
	        		board[x][y] = 'S';
	                board[x][y+1] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i, j+1);
	        	}
	        	else if(board[x][y-1] == 'B') { // empty left
	        		board[x][y] = 'S';
	                board[x][y-1] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i, j-1);
	        	}
	        	else if(board[x-1][y] == 'B') { // empty up
	        		board[x][y] = 'S';
	                board[x-1][y] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i-1, j);
	        	}
	        }
	        else if((y == 0) && (x >=1 && x <= 7) && (board[x][y] == 'B')) { // if they are in first column
	        	if(board[x+1][y] == 'B') { // empty down
	        		board[x][y] = 'S';
	                board[x+1][y] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i+1, j);
	        	}
	        	else if(board[x][y+1] == 'B') { // empty right
	        		board[x][y] = 'S';
	                board[x][y+1] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i, j+1);
	        	}
	        	else if(board[x-1][y] == 'B') { // empty up
	        		board[x][y] = 'S';
	                board[x-1][y] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i-1, j);
	        	}
	        }
	        else if((y == 8) && (x >=1 && x <= 7) && (board[x][y] == 'B')) { // if they are in last row
	        	if(board[x-1][y] == 'B'){ // empty up
	        		board[x][y] = 'S';
	                board[x-1][y] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i-1, j);
	        	}
	        	else if(board[x][y-1] == 'B') { // empty left
	        		board[x][y] = 'S';
	                board[x][y-1] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i, j-1);
	        	}
	        	else if(board[x+1][y] == 'B') { // empty down
	        		board[x][y] = 'S';
	                board[x+1][y] = 'S';
	                c_moves = placeComputer(computer, c_moves, i, j);
	                c_moves = placeComputer(computer, c_moves, i+1, j);
	        	}
	        }
	        else if(y == 0 && x == 0 && (board[x][y] == 'B')) { // if they are in up left corner
	        	if(board[1][0] == 'B') { // empty down
	        		board[0][0] = 'S';
	                board[1][0] = 'S';
	                c_moves = placeComputer(computer, c_moves, 1, 1);
	                c_moves = placeComputer(computer, c_moves, 2, 1);
	        	}
	        	else if(board[0][1] == 'B') { // empty right
	        		board[0][0] = 'S';
	                board[0][1] = 'S';
	                c_moves = placeComputer(computer, c_moves, 1, 1);
	                c_moves = placeComputer(computer, c_moves, 1, 2);
	        	}
	        }
	        else if(y == 8 && x == 0 && (board[x][y] == 'B')) { // if they are in up right corner
	        	if(board[1][8] == 'B') { // empty down
	        		board[0][8] = 'S';
	                board[1][8] = 'S';
	                c_moves = placeComputer(computer, c_moves, 1, 9);
	                c_moves = placeComputer(computer, c_moves, 2, 9);
	        	}
	        	else if(board[0][7] == 'B') { // empty left
	        		board[0][8] = 'S';
	                board[0][7] = 'S';
	                c_moves = placeComputer(computer, c_moves, 1, 9);
	                c_moves = placeComputer(computer, c_moves, 1, 8);
	        	}
	        }
	        else if(y == 0 && x == 8 && (board[x][y] == 'B')) { // if they are in down left corner
	        	if(board[7][0] == 'B') { // empty up
	        		board[8][0] = 'S';
	                board[7][0] = 'S';
	                c_moves = placeComputer(computer, c_moves, 9, 1);
	                c_moves = placeComputer(computer, c_moves, 8, 1);
	        	}
	        	else if(board[8][1] == 'B') { // empty right
	        		board[8][0] = 'S';
	                board[8][1] = 'S';
	                c_moves = placeComputer(computer, c_moves, 9, 1);
	                c_moves = placeComputer(computer, c_moves, 9, 2);
	        	}
	        }
	        else if(y == 8 && x == 8 && (board[x][y] == 'B')) { // if they are in down right corner
	        	if(board[7][8] == 'B') { // empty up
	        		board[8][8] = 'S';
	                board[7][8] = 'S';
	                c_moves = placeComputer(computer, c_moves, 9, 9);
	                c_moves = placeComputer(computer, c_moves, 8, 9);
	        	}
	        	else if(board[8][7] == 'B') { // empty left
	        		board[8][8] = 'S';
	                board[8][7] = 'S';
	                c_moves = placeComputer(computer, c_moves, 9, 9);
	                c_moves = placeComputer(computer, c_moves, 9, 8);
	        	}
	        }
		}
	}
	
	public int placeComputer(int[][] computer, int moves, int i, int j) {
		
		computer[moves][0] = i;
		computer[moves][1] = j;
		moves++;
		
		return moves;
	}

}
