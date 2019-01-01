
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Piece {
  String color; //white or black
  int xPos; // where the piece is
  int yPos;
  private ImageIcon pic;

  public Piece () {
    color = "";
    xPos = 0;
    yPos = 0;
  }
  public Piece (String c, int x, int y) {
    color = c;
    xPos = x;
    yPos = y;
  }

  public void setColor (String c) {
    color = c;
  }
  public void setXPos (int x) {
    xPos = x;
  }
  public void setYPos (int y) {
    yPos = y;
  }

  public String getColor () {
    return color;
  }
  public int getXPos () {
    return xPos;
  }
  public int getYPos () {
    return yPos;
  }
  public Image getImage()
  {
    return pic.getImage();
  }
  public void setIcon(ImageIcon i)
  {
    pic = i;
  }

  public abstract boolean isMoveValid (int newX, int newY, boolean pawnHasDiagonal);
  public abstract String toString ();
}