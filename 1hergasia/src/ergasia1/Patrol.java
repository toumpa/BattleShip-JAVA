package ergasia1;

public class Patrol {  //‘œ’Ã–¡ √≈Ÿ—√…¡ 01793
	
	private char[][] board;
	private int[][] computer;
	
	Patrol(char[][] aBoard, int[][] aComputer) { // Constructor 
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
	
	
	public void putPatrol() {
		
		int c_moves = 0;
		while(c_moves < 3) { // place 3 Patrol ships
			
	        int i = (int)(1 + Math.random() * 10); // get random numbers from 1 to 9
	        int j = (int)(1 + Math.random() * 10);
	        int x = i-1; // the array computer gets from 0 to 9
	        int y = j-1;
	        
	        if((x >= 1 && x <= 7) && (y >= 1 && y <= 7) && board[x][y] == 'B') {        // if the random coordinates is between 1-7 and there is empty space
	        	
	        	if((board[x][y-1]=='B')&& (board[x][y+1]=='B')&& (board[x-1][y]=='B')&& (board[x+1][y]=='B')) { // if there is empty space on left, right, up and down from them
	        		
	        		board[x][y] = 'S';          // place S to the table in given coordinates
	                board[x][y-1] = board[x][y+1] = board[x-1][y] = board[x+1][y]='t';      // in the necessary empty space place t temporarily
	                c_moves = placeComputer(computer, c_moves, i, j);      // call the method and place the random elements in the computer array
	        	}
	        }
	        else if((x == 0) && (y >=1 && y <= 7) && (board[x][y] == 'B')) {     // if the coordinates are in first row and there is empty space
	        	
	        	if((board[x][y+1] == 'B') && (board[x][y-1] == 'B') && (board[x+1][y] == 'B')) {        // if the space is empty left, right and down from them
	        		
	        		board[x][y] = 'S';
	                board[x][y+1] = board[x][y-1] = board[x+1][y] = 't';       // fill this necessary space for now with t
	                c_moves = placeComputer(computer, c_moves, i, j);
	        	}
	        }
	        else if((x == 8) && (y >=1 && y <= 7) && (board[x][y] == 'B')) {         // if they are in last row and the space is empty
	        	
	        	if((board[x][y+1] == 'B') && (board[x][y-1] == 'B') && (board[x-1][y] == 'B')) {
	        		
	        		board[x][y] = 'S';
	                board[x][y+1] = board[x][y-1] = board[x-1][y] = 't'; // fill left, right and up with t
	                c_moves = placeComputer(computer, c_moves, i, j);
	        	}
	        }
	        else if((y == 0) && (x >=1 && x <= 7) && (board[x][y] == 'B')) { // if they are in first column and its empty
	        	
	        	if((board[x+1][y] == 'B') && (board[x][y+1] == 'B') && (board[x-1][y] == 'B')) {
	        		
	        		board[x][y] = 'S';
	                board[x+1][y] = board[x][y+1] = board[x-1][y] = 't'; // fill up, down and right with t
	                c_moves = placeComputer(computer, c_moves, i, j);
	        	}
	        }
	        else if((y == 8) && (x >=1 && x <= 7) && (board[x][y] == 'B')) { // if they are in last column and its empty
	        	
	        	if((board[x-1][y] == 'B') && (board[x][y-1] == 'B') && (board[x+1][y] == 'B')) {
	        		
	        		board[x][y] = 'S';
	                board[x-1][y] = board[x][y-1] = board[x+1][y] = 't'; // fill up, down and left with t
	                c_moves = placeComputer(computer, c_moves, i, j);
	        	}
	        }
	        else if(y == 0 && x == 0 && board[x][y] == 'B') { // if they are in left up corner
	        	
	        	if(board[1][0] == 'B' && board[0][1] == 'B') {
	        		
	        		board[0][0] = 'S';
	        		board[1][0] = board[0][1] = 't'; // fill right and down with t
	        		c_moves = placeComputer(computer, c_moves, i, j);
	        	}
	        }
	        else if(y == 8 && x == 0 && board[x][y] == 'B') { // if they are in right up corner
	        	
	        	if(board[1][8] == 'B' && board[0][7] == 'B') {
	        		
	        		board[0][8] = 'S';
	        		board[1][8] = board[0][7] = 't'; // fill left and down with t
	        		c_moves = placeComputer(computer, c_moves, i, j);
	        	}
	        }
	        else if(y == 0 && x == 8 && board[x][y] == 'B') { // if the are in left down corner
	        	
	        	if(board[7][0] == 'B' && board[8][1] == 'B') {
	        		
	        		board[8][0] = 'S';
	        		board[7][0] = board[8][1] = 't'; // fill up and right with t
	        		c_moves = placeComputer(computer, c_moves, i, j);
	        	}
	        }
	        else if(y == 8 && x == 8 && board[x][y] == 'B') { // if they are in right down corner
	        	
	        	if(board[7][8] == 'B' && board[8][7] == 'B') {
	        		
	        		board[8][8] = 'S';
	        		board[7][8] = board[8][7] = 't'; // fill up and left with t
	        		c_moves = placeComputer(computer, c_moves, i, j);
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
