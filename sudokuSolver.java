
public class Main
{
    int[][] board = {
    {7,8,0,4,0,0,1,2,0},
    {6,0,0,0,7,5,0,0,9},
    {0,0,0,6,0,1,0,7,8},
    {0,0,7,0,4,0,2,6,0},
    {0,0,1,0,5,0,9,3,0},
    {9,0,4,0,6,0,0,0,5},
    {0,7,0,3,0,0,0,1,2},
    {1,2,0,0,0,7,4,0,0},
    {0,4,9,2,0,6,0,0,7}
};

	public static void main(String[] args) {
	    Main m = new Main();
	    m.solve();
	}
	
	public void display(int[][] board) {
	    for(int i = 0;i<board.length;i++) {
	        if(i%3==0 && i!=0) {
	            System.out.println(" - - - - - - - - - - - - ");
	        }
	        for(int j = 0;j<board.length;j++) {
	            if(j%3==0 && j!=0) {
	                System.out.print(" | ");
	            }
	            System.out.print(board[i][j] + " ");
	        }
	        System.out.println();
	    }
	    System.out.println();
	    System.out.println(" - - - - - - - - - - - - ");
	    System.out.println();
	}
	
	public int[] findNull(int[][] board){
	    int[] ary = new int[2];
	    int[] a = new int[2];
	    a[0]=99;
	    
	    for(int i = 0;i<board.length;i++) {
	        for(int j = 0;j<board.length;j++) {
	            if(board[i][j]==0) {
	                ary[0] = i;
	                ary[1] = j;
	                return ary;
	            }
	        }
	    }
	    return a;
	    
	}
	
	public boolean valid(int[][] board, int num, int[] position) {
	    for(int i = 0;i<board[0].length;i++) {
	        if(board[position[0]][i] == num && position[1] != i) {
	            return false;
	        }
	    }
	    
	    for(int j = 0;j<board.length;j++) {
	        if(board[j][position[1]] == num && position[0] != j) {
	            return false;
	        }
	    }
	    
	    int boardCol = position[1]/3;
	    int boardRow = position[0]/3;
	    
	    for(int i = boardRow*3;i<(boardRow*3 + 3);i++) {
	        for(int j = boardCol*3;j<(boardCol*3 + 3);j++) {
	            if(board[i][j]==num && position[0]!=i && position[1]!=j) {
	                return false;
	            }
	        }
	    }
	    
	    return true;
	}
	
	public boolean solve() {
	    
	    int col = 0, row = 0;
	    int[] con = new int[2];
	    con = findNull(board);
	    if(con[0]==99) {
	        display(board);
	        return true;
	    } else {
	        row = con[0];
	        col = con[1];
	    }
	    
	    for(int i = 1;i<10;i++) {
	        if(valid(board, i, con)) {
	            board[row][col] = i;
	            
	            display(board);
	        
    	        if(solve()) {
    	           //display(board);
    	           return true; 
    	        }
    	        board[row][col] = 0;
	        }
	    }
	    return false;
	    
	}
}










