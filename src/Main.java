import java.awt.Graphics;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;

class Main 
{
    private static final int SIZE = 8;               //size of chessboard  
    private static VisChessBoard visual;             //object for graphics
    
    public static void main( String args[] )
    {
        // SYLVIE TODO probably want to move this to a class meant for dedicated testing
        Board board = new Board();
        System.out.println(board.toString());
        System.out.println(board.isMoveValid(0,1,0,3)); //true
        System.out.println(board.isMoveValid(5,1,5,6)); //false
        System.out.println(board.isMoveValid(3,1,3,2)); //true
        System.out.println(board.isMoveValid(7,1,3,2)); //false

        //initialize and set up the visual window game is played in.  All actions from here on
        //out are event driven
        visual = new VisChessBoard();               
        visual.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        visual.setSize(800, 600);
        visual.setVisible(true);
    }
    
    public static int getSize()
    {
        return SIZE;
    }
    
    /*Sets a string that is displayed to the user*/
    public static void setStatus(String str)
    {
        if(str == "")
            visual.setStatus();
        else
            visual.setStatus(str);
    }
    
    /*errases the game history.  Used when setting up a new game*/
    public static void clearHistory()
    {
        visual.clearHistory();
    }
    
    /*appends a move to the history text*/
    public static void addHistory(String str)
    {
        visual.addHistory(str);
    }
}
