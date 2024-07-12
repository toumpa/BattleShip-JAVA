package ergasia1;

public class Print extends Battleship{ //‘œ’Ã–¡ √≈Ÿ—√…¡ 01793
	
	private char[][] board;
	
	Print(int[][] target, int[][] computer, char[][] aBoard){ // Constructor
		super(target, computer); // target and computer arrays are the same as the Battleship class
		setBoard(aBoard);
	}

	public char[][] getBoard() { // getter and setter for board array
		return board;
	}

	public void setBoard(char[][] aBoard) {
		board = aBoard;
	}
	
    public void printComputer() {
		
		System.out.println("\n");
		System.out.println("The computer placed his ships in positions: ");
		System.out.print("[");
		
		for(int i = 0; i < 8; i++) { // one index before last cause print needs to stop without a < , >
			
        	System.out.print(super.getComputer()[i][0]);
        	System.out.print(super.getComputer()[i][1] + ", ");
        }
		
		System.out.print(super.getComputer()[8][0]); // print last index
		System.out.print(super.getComputer()[8][1]);
		System.out.print("]");
		System.out.println("\n");
	}
	
	public void printTarget() {
		
		System.out.println("The positions you placed your guesses is: ");
		System.out.print("[");
		
		for(int i = 0; i < 9; i++) { // same as printComputer()
			
        	System.out.print(super.getTarget()[i][0]);
        	System.out.print(super.getTarget()[i][1] + ", ");
        }
		
		System.out.print(super.getTarget()[9][0]);
		System.out.print(super.getTarget()[9][1]);
		System.out.print("]");
	}
	
	public void printBoard() {
		
		System.out.println("BOARD:");
		
		for(int i = 0; i < 9; i++) { // print all the element in each index
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println();
	}

}
