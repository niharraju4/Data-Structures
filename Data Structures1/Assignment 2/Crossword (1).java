package algs11;
import stdlib.StdOut;


public class Crossword {
	private Square[][] puzzle;
    
	public Crossword(boolean[][] blackSquares) {
		puzzle = new Square[blackSquares.length][blackSquares[0].length];
	    // FINISH
		int label = 1;
        for(int r = 0; r < puzzle.length; r++)
        {
                for(int c = 0; c < puzzle[r].length; c++)
                {
                        if(blackSquares[r][c])
                                puzzle[r][c] = new Square(true, 0);
                        else if(tobeLabeled(r, c, blackSquares))
                        {
                                puzzle[r][c] = new Square(false, label);
                                label++;
                        }
                        else if(!tobeLabeled(r, c, blackSquares))
                        {
                                puzzle[r][c] = new Square(false, 0);
                        }
                }
        }
	}

	private boolean tobeLabeled(int r, int c, boolean[][] blackSquares) {
		// TODO 
        if(blackSquares[r][c] == true)
            return false;
    if(r != 0 && blackSquares[r-1][c])
    {
            return true;
    }
    if(c != 0 && blackSquares[r][c-1])
    {
            return true;
    }
    return false;
	}
	
	public void print() {
		for (int i=0; i<puzzle.length; i++) {
			for (int j=0; j<puzzle[0].length; j++)
					StdOut.print(puzzle[i][j].getLabel());
			StdOut.println();
		}
				
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] test = new boolean[7][9];
		test[0][0] = true; test[0][3] = true;test[0][4] = true;test[0][5] = true;
        test[1][4]= true;
        for (int j=6; j<9; j++) test[2][j] = true;
        test[3][2]=true;  test[3][6]=true;
        for (int j=0; j<3; j++) test[4][j] = true;
        test[5][4]=true;
        test[6][3] = true;test[6][4] = true;test[6][5] = true; test[6][8] = true;
        
        Crossword c = new Crossword(test);
        c.print();
        
	}

}
