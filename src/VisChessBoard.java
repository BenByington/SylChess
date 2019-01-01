import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.event.*;


/*class that handles the window contained in the game and deals with input from the butons*/
public class VisChessBoard extends JFrame implements ActionListener
{
    private VisPlay play;                  //contains actual play area
    private JTextArea history;             //text history of moves
    private JTextField status;             //status bar to give info to user
    private JButton undo;                  //undo button
    private JButton newGame;               //new game button
    private JPanel bar;                    //contains status field and the two buttons
    private JScrollPane box;               //contains the history text
    
    public VisChessBoard()
    {
        super("Sylvie's Chess Program");                     //sets name for window
        setLayout(new BorderLayout());
        
        //creates the play area and adds it to the window
        play = new VisPlay();                           
        play.setSize(550, 500);
        add(play, BorderLayout.CENTER);
        
        /*sets up the history text field and adds it to box which is added to the window*/
        history = new JTextArea("History:\n", 6, 20);
        history.setEditable(false);
        
        box = new JScrollPane(history);
        box.setVerticalScrollBarPolicy(box.VERTICAL_SCROLLBAR_ALWAYS);
        add(box, BorderLayout.EAST);
        
        //sets the status text field
        status = new JTextField("Click and Drag to Move Pieces.  White Player's Turn", 30);
        status.setEditable(false);
        
        //initializes the two buttons
        undo = new JButton("Undo");
        undo.addActionListener(this);
        newGame = new JButton("New Game");
        newGame.addActionListener(this);
        
        /*constructs the bar for the bottom of the window which contains the status field
         *as well as the two buttons*/
        bar = new JPanel();
        bar.add(status);
        bar.add(undo);
        bar.add(newGame);
        add(bar, BorderLayout.SOUTH);
        
    }
    
    /*method that listens for either of the two buttons being activated*/
    public void actionPerformed(ActionEvent e)
    {
        /*new game was selected. */
        if(e.getSource() == newGame)
        {
            // SYLVIE TODO
        }
        /*undo was selected. */
        if(e.getSource() == undo)
        {
            // SYLVIE TODO
        }
        //repaint the play area
        play.repaint();
    }
    
    /*clears the status text*/
    public void setStatus()
    {
        status.setText("");
    }
    
    /*sets the status text to a certain string*/
    public void setStatus(String str)
    {
        status.setText(str);
        repaint();
    }
    
    /*clears the history text*/
    public void clearHistory()
    {
        history.setText("");
    }
    
    /*adds a move to the text history*/
    public void addHistory(String str)
    {
        history.append(str);
    }
    
}
