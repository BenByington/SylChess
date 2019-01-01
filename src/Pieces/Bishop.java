public class Bishop extends Piece {
  public Bishop (String c, int x, int y) {
    super(c, x, y);
  }
  public boolean isMoveValid (int newX, int newY, boolean pawnHasDiagonal) {
    //diagonal, any length
    return true;
  }
  public String toString () {
    return "Bishop";
  }
}