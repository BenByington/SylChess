import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;

/*class that handles the drawing of the actual play area and the handling of mouse
 *events*/
public class VisPlay extends JPanel implements MouseListener, MouseMotionListener
{
    private Image pic;                        //used for when dragging an image
    private int width = 63;                   //width of play area
    private int size;                         //how many squares wide
    private int mouse[] = {-1, -1};           //mouse loc
    private int move[] = {-1, -1, -1, -1};    //source and dest coord for a move
    private boolean turn = true;              //true = white, false = black
    
    private Board board;                      //board object
    
    public VisPlay()
    {
        super();
        setImage();
        repaint();
        size = Main.getSize();
        
        //sets up the listeners for the mouse
        addMouseListener(this);
        addMouseMotionListener(this);
        
        board = new Board();                        //initialize the board
    }
    
    public void paint(Graphics g)
    {   
        /*runs through and draws all of the squares for the board.  Each square is 13 pixles
         *wide, and alternate between white and gray*/
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            { 
               if((i + j) % 2 == 1)
                    g.setColor(Color.LIGHT_GRAY);
                else
                    g.setColor(Color.WHITE);
                g.fillRect(i*width, j*width, width, width);
                g.drawImage(board.getImage(i, j), 13 + i * width, 13 + j * width, 40, 40, g.getColor(), null);
                g.setColor(Color.BLACK);
                g.drawRect(i*width, j*width, width, width);
            }
        }
        /*if the mouse is depressed, and a piece is being dragged, draw that piece wherever
         *the mouse is currently located*/
        if(mouse[0]!= -1 && pic != null)
            g.drawImage(pic, mouse[0], mouse[1], 40, 40, Color.WHITE, null);
        
        /*draw the letters and numbers for labeling the sides of the board*/
        g.drawString("      [a]                [b]                 [c]                [d]                  [e]                [f]                 [g]                [h]",10, 525); 
        g.drawString("[8]", 515, 35);
        g.drawString("[7]", 515, 35 + width);
        g.drawString("[6]", 515, 35 + 2*width);
        g.drawString("[5]", 515, 35 + 3*width);
        g.drawString("[4]", 515, 35 + 4*width);
        g.drawString("[3]", 515, 35 + 5*width);
        g.drawString("[2]", 515, 35 + 6*width);
        g.drawString("[1]", 515, 35 + 7*width);
    }
    
    public void setImage(Image i)
    {
        pic = i;
    }
    
    public void setImage()
    {
        pic = null;
    }
    

    /*events we don't care about*/
    public void mouseExited(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    
    /*mouse has been released.  Check to see if we have a valid move to process*/
    public void mouseReleased(MouseEvent e)
    {
        //exit if mouse was not originally depressed over a piece
        if(move[1] == -1)
            return;
        
        boolean valid = false;
        /*resets mouse depressed coordinates.  already stored in move 0,1*/
        mouse[0] = -1;
        mouse[1] = -1;
        
        /*convert mouse coordinates to board cordinates.  if cordinates are outside the
         *valid range, set to -1 so that not move is processed*/
        move[2] = e.getX() / width;
        move[3] = e.getY() / width;
        if(move[2] > 7 || move[2] < 0)
        {
            move[2] = -1;
            move[3] = -1;
        }
        if(move[3] > 7 || move[3] < 0)
        {
            move[2] = -1;
            move[3] = -1;
        }
        //debug statment*/
        System.out.printf("Move made: %d %d %d %d\n", move[0], move[1], move[2], move[3]);
        
        /*if move[3] is non-zero at this point, then we have a valid attempt at a move.  send
         *to chess for processing*/
        if(move[3] != -1)
            valid = board.movePiece(move[0], move[1], move[2], move[3]);
        /*if the move returned successful, rotate to the next players turn*/
        if(valid != true)
        {
            turn = !turn;
            Main.setStatus(getTurn());
            /*check to see if game has been won*/
            if(checkMate(turn))
            {
                Main.setStatus("Checkmate!!");
                Main.addHistory("Checkmate!!\n");
            }
            /*check to see if the player is currently in check*/
            else if(check(turn))
            {
                Main.setStatus(getTurn() + "  You Are in Check.");
                Main.addHistory("Check\n");
            }
            // SYLVIE TODO call addHistory with the information about the move made (if you want)
            
        }
        /*else move was not valid. inform player of this via status bar, and then wait for
         *more impute*/
        else
        {
            Main.setStatus("You Cannot Move There...  " + getTurn());
            if (check(turn))
                Main.setStatus("You Cannot Move There...  " + getTurn() + "  You Are in Check.");
        }
        for(int i = 0; i < move.length; i++)
            move[i] = -1;
        pic = null;
        repaint();
    }
    
    public void mouseMoved(MouseEvent e){}
    
    /*updates the curent mouse location so that any dragged piece can be drawn.  the 20 is the
     *offset between the start of the play area and the side of the window*/
    public void mouseDragged(MouseEvent e)
    {
        mouse[0] = e.getX() - 20;
        mouse[1] = e.getY() - 20;
        repaint();
    }
    
    /*mouse was depressed.  check to see if it is over a valid square, and if a piece is 
     *selected*/
    public void mousePressed(MouseEvent e)
    {
        move[0] = e.getX() / width;
        move[1] = e.getY() / width;
        if(move[0] > 7 || move[0] < 0)
        {
            move[0] = -1;
            move[1] = -1;
        }
        if(move[1] > 7 || move[1] < 0)
        {
            move[0] = -1;
            move[1] = -1;
        }
        
        System.out.printf(" %d %d\n", move[0], move[1]);
        if(move[0] != -1)
            pic = board.getImage(move[0], move[1]);
    }
    
    public void mouseClicked(MouseEvent e){}
    
    public String getTurn()
    {
        if(turn)
            return "White Player's Turn.";
        else
            return "Black Player's Turn.";
    }
    
    public void changeTurn()
    {
        turn = !turn;
    }
    
    /*makes it white players turn.  used for game init and reset*/
    public void resetTurn()
    {
        turn = true;
    }
    
    /*checks to see if the other player is put in check by the move*/
    public boolean check(boolean c)
    {
        // SYLVIE TODO
        return false;
        // return board.IsCheckState();
    }
    
    /*checks to see if there are any valid moves left.  */
    public boolean checkMate(boolean c)
    {
        // SYLVIE TODO
        return false;
        // return board.IsCheckMateState();
    }
    
    
}
