import java.util.*;
public class Sudoku {
    public static boolean isSafe(char[][] board,int row,int col,int num) {
        //row and col
        for(int i=0;i<board.length;i++) {
            //ROW CONDITION
            if(board[i][col]==(char)(num+'0')) {
                return false;
            }//coloumn condition
            if(board[row][i]==(char)(num+'0')) {
                return false;
            }
        }//grid
        int sr= (row/3)*3;
        int sc = (col/3)*3;
        for(int i=sr;i<sr+3;i++) {
            for(int j=sc;j<sc+3;j++) {
                if(board[i][j]==(char)(num+'0')) {
                    return false;
                }
            }
        }return true;
    }
    
    public static boolean helper(char[][] board,int row,int col) {
        if(row == board.length) {
            return true;
        }
        
        int nrow=0;
        int ncol=0;
        if(col!=board.length-1) {
            nrow=row;
            ncol = col+1;
        }else {
            ncol=0;
            nrow = row+1;
        }
        if(board[row][col]!='.') {
            if(helper(board, nrow, ncol)) {
                return true;
            } return false;
        }    
        for(int i=1;i<=9;i++) {
            if(isSafe(board,row,col,i)) {
                board[row][col]=(char)(i+'0');
                if(helper(board, nrow, ncol)) {
                    return true;
                }else {
                    board[row][col]='.';
                }
            }
        }
            
        return false;
    }

    public static void SudokuSolver(char[][] board) {
        helper(board,0,0);
    }
    public static void PrintBoard(char[][] board) {
        System.out.println("+-------+-------+-------+");
        for(int r = 0; r<9;r++) {
            System.out.print("| ");
            for(int c =0;c<9;c++) {
                System.out.print(board[r][c]+" ");
                if(c==2 || c==5) {
                    System.out.print("| ");
                }
            }System.out.println("|");
            if(r==2 || r==5) {
                System.out.println("+-------+-------+-------+");
            }
        }System.out.println("+-------+-------+-------+");
    }
    

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        System.out.println("SUDOKU PUZZLE");
        System.out.println("enter digit 1-9 for the known cells and '.' for empty space");
        System.out.println();

        for(int r=0;r<9;r++) {
            System.out.print("row "+(r+1)+" : ");
            String line = sc.next();
            while(line.length()!=9) {
                System.out.print("enter excatly 9 characters : ");
                line = sc.next();
            
            }board[r] = line.toCharArray();
        }
        System.out.println("\nYour Puzzle :");
        PrintBoard(board);
        
        boolean solved = helper(board,0,0);
        if(solved) {
            System.out.println("\nsolving...\n");
            System.out.println("sudoku solved : ");
            PrintBoard(board);
        }else {
            System.out.println("no solution exits for this combination : ");
        }
        sc.close();


    }
}
