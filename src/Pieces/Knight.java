public class Knight extends Piece {
  public Knight (String c, int x, int y) {
    super(c, x, y);
  }
  public boolean isMoveValid (int newX, int newY, boolean pawnHasDiagonal) {
    //L move, can jump
    return true;
  }
  public String toString () {
    return "Knight";
  }
}