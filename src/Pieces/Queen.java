public class Queen extends Piece {
  public Queen (String c, int x, int y) {
    super(c, x, y);
  }
  public boolean isMoveValid (int newX, int newY, boolean pawnHasDiagonal) {
    //diagonal or straight, any length, no jumping
    return true;
  }
  public String toString () {
    return "Queen";
  }
}