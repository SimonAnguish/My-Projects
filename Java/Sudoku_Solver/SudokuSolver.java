class SudokuSolver {
	public static void main(String[] args) {
		System.out.printf("The solution to the puzzle is: \n\n");
		int grid[][] = {
			{0,1,8,0,0,0,0,2,6}, // Row 1
			{0,0,0,0,0,0,3,0,0}, // Row 2
			{0,0,3,1,5,0,0,0,0}, // Row 3
			{0,0,0,9,0,0,4,0,3}, // Row 4
			{0,5,0,0,4,0,8,0,7}, // Row 5
			{0,0,0,0,0,0,0,0,0}, // Row 6
			{8,0,0,0,3,0,0,0,0}, // Row 7
			{0,9,5,0,0,7,0,0,0}, // Row 8
			{4,0,0,6,0,2,7,9,0}  // Row 9
		};
		
		int solution[][] = SolvePuzzle(grid);
		for (int i=0;i<9;i++) {
			for (int j=0;j<9;j++) {
				System.out.printf("|%d",grid[i][j]);
			}
			System.out.printf("|\n");
		}
	}
	
	public static int[][] SolvePuzzle(int grid[][]) {
		// Possible Solutions in a 9x9 grid
		int ps[][][] = new int[9][9][9];
		
		for (int i=0;i<ps.length;i++) {
			for (int j=0;j<ps[0].length;j++) {
				if (grid[i][j] == 0) {
//					for (int k=1;k<=9;k++) {
//						if (k )
//					}
					grid[i][j] = 9;
				}
			}
		}
		
		return grid;
	}
}