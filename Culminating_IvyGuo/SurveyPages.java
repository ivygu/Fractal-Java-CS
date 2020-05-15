// The "SurveyPages" class.
package Culminating_IvyGuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class SurveyPages extends JFrame implements ActionListener
{
    private JFrame frame;
    private JButton backButton, nextButton;
    private JPanel buttonPanel;

    public SurveyPages ()
    {
	frame = new JFrame ("Survey");

	//Create new buttons objects for navigation
	backButton = new JButton ("Back");
	nextButton = new JButton ("Next");

	//Create new panel for reusable buttons
	buttonPanel = new JPanel ();
	buttonPanel.setBorder (new EmptyBorder
		(new Insets (30, 30, 30, 30)));
	buttonPanel.setBackground (Style.FAINT);
	buttonPanel.add (backButton);
	buttonPanel.add (nextButton);

	frame.getContentPane ().add (buttonPanel);
	// Set the frame's size and show the frame
	frame.setSize (600, 500);
	frame.setVisible (true);
    } // Constructor


    public void actionPerformed (ActionEvent e)
    {
	Object buttonObj = e.getSource ();
    }
} // SurveyPages class
