package tictactoe;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Tic Tac Toe game.
 * 
 * 1.  Problem: Reclick of cell.
 * 
 * @author jamesmaron
 */
public class TicTacToe extends JComponent implements ActionListener
{
    JFrame frame;
    JButton[][] buttons = new JButton[3][3];
    int turn;
    URL clickURL;
    AudioClip click;
    URL fanfareURL;
    AudioClip fanfare;
    URL nowinURL;
    AudioClip nowin;

    public static void main(String[] args)
    {
        new TicTacToe().getStarted();
    }

    /**
     * Set up game.
     */
    private void getStarted()
    {
        clickURL = getClass().getResource("click.wav");
        click = Applet.newAudioClip(clickURL);
        fanfareURL = getClass().getResource("fanfare.wav");
        fanfare = Applet.newAudioClip(fanfareURL);
        nowinURL = getClass().getResource("idiot.wav");
        nowin = Applet.newAudioClip(nowinURL);
        frame = new JFrame("tic tac toe");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));
        frame.setVisible(true);
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                buttons[i][j] = new JButton("");
                buttons[i][j].addActionListener(this);
                frame.add(buttons[i][j]);
            }

        }
        repaint();
    }


    /**
     * Draw X or O.
     * @param jack the action event 
     */
    @Override
    public void actionPerformed(ActionEvent jack)
    {
        click.play();
        Object o = jack.getSource();
        JButton jb = (JButton) o;
        jb.setFont(new Font("", Font.BOLD, 200));
        int x1or0 = turn % 2;
        if (x1or0 == 0)
        {
            jb.setText("O");
        }
        if (x1or0 == 1)
        {
            jb.setText("X");
        }
        if (turn == 8)
        {
            System.out.println("Game over!");
            nowin.play();

        }
        turn++;

        if (!buttons[0][0].getText().equals("") && buttons[0][0].getText().equals(buttons[0][1].getText()) && buttons[0][0].getText().equals(buttons[0][2].getText()))
        {
            //row 1
            System.out.println("Winner! On line 0.");
            fanfare.play();
        }
        if (!buttons[1][0].getText().equals("") && buttons[1][0].getText().equals(buttons[1][1].getText()) && buttons[1][0].getText().equals(buttons[1][2].getText()))
        {
            //row 2
            System.out.println("Winner! On line 1.");
            fanfare.play();
        }
        if (!buttons[2][0].getText().equals("") && buttons[2][0].getText().equals(buttons[2][1].getText()) && buttons[2][0].getText().equals(buttons[2][2].getText()))
        {
            //row 3
            System.out.println("Winner! On line 2.");
            fanfare.play();
        }


        if (!buttons[0][0].getText().equals("") && buttons[0][0].getText().equals(buttons[1][0].getText()) && buttons[0][0].getText().equals(buttons[2][0].getText()))
        {
            //column 1
            System.out.println("Winner! On column 0.");
            fanfare.play();
        }
        if (!buttons[0][1].getText().equals("") && buttons[0][1].getText().equals(buttons[1][1].getText()) && buttons[0][1].getText().equals(buttons[2][1].getText()))
        {
            //column 2
            System.out.println("Winner! On column 1.");
            fanfare.play();
        }
        if (!buttons[0][2].getText().equals("") && buttons[0][2].getText().equals(buttons[1][2].getText()) && buttons[0][2].getText().equals(buttons[2][2].getText()))
        {
            //column 3
            System.out.println("Winner! On column 2.");
            fanfare.play();
        }

    }
}
