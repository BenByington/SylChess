
import javax.swing.ImageIcon;

public class Pawn extends Piece {
  public Pawn (String c, int x, int y) {
    super(c, x, y);
    if(c == "white")
      setIcon(new ImageIcon(getClass().getResource("Pieces/Pics/WhitePawn.gif")));
    else
      setIcon(new ImageIcon(getClass().getResource("Pieces/Pics/BlackPawn.gif")));
  }
  public boolean isMoveValid (int newX, int newY, boolean pawnHasDiagonal) {
    //one forwards unless in inital place
    //diagonal to kill
    if (pawnHasDiagonal && (color == "black" && (newY == yPos+1 && (newX == xPos+1 || newX == xPos-1)) || (color == "white" && (newY == yPos-1 && (newX == xPos+1 || newX == xPos-1))))) {
      return true;
    } else {
      if (newX != xPos) {
        return false;
      } else {
        if ((yPos == 1 && color == "black") || (yPos == 6 && color == "white")) { //inital
          return ((newY-yPos < 3 && 0 < newY-yPos && color == "black") || (newY - yPos > -3 && 0 > newY - yPos &&  color == "white"));
        } else { //not inital
          return ((newY-yPos < 2 && 0 < newY-yPos && color == "black") || (newY - yPos > -2 && 0 > newY - yPos && color == "white"));
        }
      }
    }
  }
  public String toString () {
    return "Pawn";
  }
}