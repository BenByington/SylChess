
import javax.swing.ImageIcon;

public class Knight extends Piece {
  public Knight (String c, int x, int y) {
    super(c, x, y);
    if(c == "white")
      setIcon(new ImageIcon(getClass().getResource("Pieces/Pics/WhiteKnight.gif")));
    else
      setIcon(new ImageIcon(getClass().getResource("Pieces/Pics/BlackKnight.gif")));
  }
  public boolean isMoveValid (int newX, int newY, boolean pawnHasDiagonal) {
    //L move, can jump
    return true;
  }
  public String toString () {
    return "Knight";
  }
}