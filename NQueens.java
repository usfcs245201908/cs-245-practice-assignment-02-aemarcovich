import java.io.*; 
public class NQueens
{
	int n;
	int [][] board;
	NQueens(int n)
	{
		this.n=n;
		this.board= new int[n][n];
	} 
	public boolean checkrow(int row)
	{
		for (int y=0;y<n;y++)
		{
			if (board[row][y]==1)
			{
				return false;
			}
		}
		return true;
	}

	public boolean checkDiag(int col, int row) {
		for (int x = row, y = col; x < n && y < n; x++, y++) {
			if (board[x][y] == 1) {
				return false;
			}
		}
		for (int x = row, y = col; x >= 0 && y >= 0;  x--, y--) {
			if (board[x][y] == 1) {
				return false;
			}
		}
		for (int x = row, y = col; x >= 0 && y < n; x--, y++) {
			if (board[x][y] == 1) {
				return false;
			}
		}
		for (int x = row, y = col; x < n && y >= 0;  x++, y--) {
			if (board[x][y] == 1) {
				return false;
			}
		}
		return true;
	}

	public boolean checkcol(int col)
	{
		for (int x=0;x<n;x++)
		{
			if (board[x][col]==1)
			{
				return false;
			}
		}
		return true;
	}
	public void printToConsole()
	{
		for (int x=0;x<n;x++)
		{
			System.out.print("|");
			for(int y=0;y<n;y++)
			{
				if (board[x][y]==0)
				{
					System.out.print("_");
				}
				else 
				{
					System.out.print("Q");
				}
				;
			}
			System.out.println("|");
		}
	} 
	boolean canPlaceAQueen(int row,int col)
	{
		return checkcol(col) && checkrow(row) && checkDiag(col, row);
	}
	public boolean placeNQueens() throws Exception
	{
		// printToConsole();
		return placeNQueens(0);
	}
	public boolean placeNQueens(int row) throws Exception
	{
		if (n<1)
		{
			throw new Exception();
		}
		if(row==n)
			return true;
		for (int col=0;col<n;col++)
		{
			if (canPlaceAQueen(row,col)){
				board[row][col]=1;
				if (placeNQueens(row+1))
					return true;
				else
					board[row][col]=0;
			}
		}
		return false;
	}
}

