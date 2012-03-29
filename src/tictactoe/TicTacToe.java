package tictactoe;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class TicTacToe extends JComponent implements ActionListener
{
    JFrame frame;
    JButton [][] buttons = new JButton [3][3];
    int turn;

    public static void main(String[] args)
    {
        new TicTacToe().getStarted();
    }

    private void getStarted()
    {
        frame = new JFrame("tic tac toe");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 3));
        frame.setVisible(true);
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
               buttons[i] [j] = new JButton("Empty " + i + j);
               buttons [i] [j].addActionListener(this);
               frame.add( buttons[i] [j]);
            }
   
        }
        repaint();
    }

    @Override
    public void paint(Graphics g)
    {
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
      Object o = ae.getSource();
      JButton jb = (JButton)o;
      jb.setFont(new Font("", Font.BOLD, 200));
      jb.setText( turn % 2 == 0 ? "X" : "O");
      turn++;
    }
}
