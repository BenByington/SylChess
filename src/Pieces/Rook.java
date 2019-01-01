
import javax.swing.ImageIcon;

public class Rook extends Piece {
  public Rook (String c, int x, int y) {
    super(c, x, y);
    if(c == "white")
      setIcon(new ImageIcon(getClass().getResource("Pieces/Pics/WhiteRook.gif")));
    else
      setIcon(new ImageIcon(getClass().getResource("Pieces/Pics/BlackRook.gif")));
  }
  public boolean isMoveValid (int newX, int newY, boolean pawnHasDiagonal) {
    //straight, any length, no jumping
    return true;
  }
  public String toString () {
    return "Rook";
  }
}