public class Rook extends Piece {
  public Rook (String c, int x, int y) {
    super(c, x, y);
  }
  public boolean isMoveValid (int newX, int newY, boolean pawnHasDiagonal) {
    //straight, any length, no jumping
    return true;
  }
  public String toString () {
    return "Rook";
  }
}