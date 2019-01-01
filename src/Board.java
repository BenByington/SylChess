import java.util.Arrays;
import java.awt.Image;

public class Board {
  Piece[][] board;

  public Board () {
    board = new Piece[8][8];
    newBoard();
  }

  public void setBoard (Piece[][] b) {
    board = b;
  }
  public void setPiece (int x, int y, Piece p) {
    board[y][x] = p;
  }
  public Piece[][] getBoard () {
    return board;
  }
  public Piece getPiece (int x, int y) {
    return board[y][x];
  }

  public void newBoard () {
    Piece p1 = new King("black",0,0);
    board[0][0] = new Rook("black",0,0);
    board[0][1] = new Knight("black",1,0);
    board[0][2] = new Bishop("black",2,0);
    board[0][3] = new Queen("black",3,0);
    board[0][4] = new King("black",4,0);    
    board[0][5] = new Bishop("black",5,0);
    board[0][6] = new Knight("black",6,0);
    board[0][7] = new Rook("black",7,0);
    for (int i = 0; i < 8; i++) {
      board[1][i] = new Pawn("black",i,1);
    }
    board[7][0] = new Rook("white",0,7);
    board[7][1] = new Knight("white",1,7);
    board[7][2] = new Bishop("white",2,7);
    board[7][3] = new Queen("white",3,7);
    board[7][4] = new King("white",4,7);    
    board[7][5] = new Bishop("white",5,7);
    board[7][6] = new Knight("white",6,7);
    board[7][7] = new Rook("white",7,7);
    for (int i = 0; i < 8; i++) {
      board[6][i] = new Pawn("white",i,6);
    }
  }

  public boolean isMoveValid (int x, int y, int newX, int newY) {
    if (board[newY][newX] != null) {
      if (board[newY][newX].getColor() == board[y][x].getColor()) {
        System.out.println("trying to kill own piece");
        return false;
      }
    }
    boolean pawnHasDiagonal;
    if (x == 0) {
      pawnHasDiagonal = ((board[y][x].getColor() == "black" && (board[y+1][x+1] != null)) || (board[y][x].getColor() == "white" && (board[y-1][x+1] != null)));
    } else if (x == 7) {
      pawnHasDiagonal = ((board[y][x].getColor() == "black" && (board[y+1][x-1] != null)) || (board[y][x].getColor() == "white" && (board[y-1][x-1] != null)));
    } else {
      pawnHasDiagonal = ((board[y][x].getColor() == "black" && ((board[y+1][x+1] != null) || (board[y+1][x-1] != null))) || (board[y][x].getColor() == "white" && ((board[y-1][x+1] != null || board[y-1][x-1] != null))));
    }
    return board[y][x].isMoveValid(newX, newY, pawnHasDiagonal);
  }
  public boolean movePiece (int x, int y, int newX, int newY) {
    if (!isMoveValid(x, y, newX, newY)) return false;
    board[newY][newX] = board[y][x]; 
    board[newY][newX].setXPos(newX);
    board[newY][newX].setYPos(newY);
    board[y][x] = null;
    return true;
  }
  public String toString () {
    return Arrays.deepToString(board);
  }
  
  public Image getImage(int x, int y)
  {
    if(board[x][y] == null)
      return null;
    return board[x][y].getImage();
  }
}