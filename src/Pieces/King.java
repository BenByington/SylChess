
import javax.swing.ImageIcon;

public class King extends Piece {
  public King (String c, int x, int y) {
    super(c, x, y);
    if(c == "white")
      setIcon(new ImageIcon(getClass().getResource("Pieces/Pics/WhiteKing.gif")));
    else
      setIcon(new ImageIcon(getClass().getResource("Pieces/Pics/BlackKing.gif")));
  }
  public boolean isMoveValid (int newX, int newY, boolean pawnHasDiagonal) {
    //diagonal or straight, 1 away
    return(Math.abs(newX-xPos) < 2 && Math.abs(newY-yPos) < 2);
  }
  public String toString () {
    return "King";
  }
}