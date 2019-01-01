
import javax.swing.ImageIcon;

public class Bishop extends Piece {
  public Bishop (String c, int x, int y) {
    super(c, x, y);
    if(c == "white")
      setIcon(new ImageIcon(getClass().getResource("Pieces/Pics/WhiteBishop.gif")));
    else
      setIcon(new ImageIcon(getClass().getResource("Pieces/Pics/BlackBishop.gif")));
  }
  public boolean isMoveValid (int newX, int newY, boolean pawnHasDiagonal) {
    //diagonal, any length
    return true;
  }
  public String toString () {
    return "Bishop";
  }
}