	import java.util.Scanner;
	
	public class BacktrackingQueen {
	
		public static void main(String[] args) {
	
			Scanner key = new Scanner(System.in);
			System.out.println("Please Enter the grid size:");
			int size = key.nextInt();
		
	
			boolean[][] board = new boolean[size][size];
			
		
			if (Solve(board, 0)==false) {
				System.out.println("solution not found");
				System.exit(0);
			}
			else
			System.out.println("The exact solution");
			print(board);
		
		}
		
	
		
		//The key method, this method firstly control if the current board is goal, secondly searching for appropriate place 
		// consideringly the previous moves and it continues to make next moves with same procedure 
		
		public static boolean Solve(boolean board[][], int column) {
			if (column >= board[0].length)
				return true;
			for (int i = 0; i < board[0].length; i++) {
				if (appropriate(board, i, column)) {
					board[i][column] = true;
		//Print at each iteration
					print(board);
		// Recursive method usage			
					if (Solve(board, column + 1))
						return true;
		//Backtracking, we can also use remove method to backtrack instead of this usage
					board[i][column] = false;
				}
			}
		//if the current board is not goal and there is no alternative move then the method should respond false return
		// In the main method this case is expressed like "not found"	 
			return false;
		}
	
        // For each new move, this method controls whether the move can be applied or not
		public static boolean appropriate(boolean board[][], int row, int column) {
			
			//To check column
			for (int i = 0; i < column; i++) {
				if (board[row][i] == true)
					return false;
			}
			
			//To check row
			for (int i = row, j1 = column; i >= 0 && j1 >= 0; i--, j1--) {
				if (board[i][j1] == true)
					return false;
			}
			//To check diagonal
			for (int i = row, k1 = column; k1 >= 0 && i < board[0].length; k1--, i++) {
				if (board[i][k1] == true)
					return false;
			}
			return true;
		}
	
		//printing the stages
		
		public static void print(boolean board[][]) {
			
			for (int i = 0; i < board[0].length; i++) {
				for (int j = 0; j < board[0].length; j++)
					//X for Queens 
					if (board[i][j] == true) {
						System.out.print("X");
					} 
				    //O for empty areas
					else {
						System.out.print("O");
					}
				System.out.println();
			}
			System.out.println();
		}
		
	
	}
