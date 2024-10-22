/*
 * Ivy Guo - Flavours of Fractals / MAIN MENU PAGE
 * This class handles the onClick input from the user to redirect them to 
 * their desired page 
*/

package Culminating_IvyGuo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainMenu implements ActionListener
{
    //Declaration of variables
    private JFrame frame;
    private JLabel title, description;
    private JPanel contentPanel;

    //Make new JButtons for menu
    private JButton[] menuButtons = {
	new JButton ("Get Started"),
	new JButton ("How It Works"),
	new JButton ("Exit")
	};

    public MainMenu ()
    {
	//Make new JFrame object
	frame = new JFrame ("Flavours of Fractals - Menu");

	//Make new JLabel for title
	title = new JLabel ("Flavours of Fractals", JLabel.CENTER);
	title.setFont (Style.TITLE_FONT);
	title.setForeground (Style.DARK);

	//Make new Jlabel for description
	description = new JLabel ("ICS 2020 - Ivy Guo", JLabel.CENTER);
	description.setFont (Style.REGULAR_FONT);
	description.setForeground (Style.SEMI);

	//Make new JPanel Object with grid layout to hold title JLabel
	contentPanel = new JPanel ();
	contentPanel.setBorder (new EmptyBorder
		(new Insets (30, 30, 30, 30)));
	contentPanel.setLayout (new GridLayout (5, 1, 0, 10));
	contentPanel.setBackground (Style.FAINT);
	contentPanel.add (title);
	contentPanel.add (description);

	//Add JButton Objects to GridLayout Panel/onClick listeners
	for (int i = 0 ; i < menuButtons.length ; i++)
	{
	    menuButtons [i].addActionListener (this);
	    menuButtons [i].setBackground (Style.LIGHT);
	    menuButtons [i].setForeground (Style.SEMI);
	    menuButtons [i].setFont (Style.REGULAR_FONT);
	    contentPanel.add (menuButtons [i]);
	}

	//Add JPanel contentPanel to Jframe
	frame.getContentPane ().add (contentPanel);

	// Set the frame's size and show the frame
	frame.setSize (600, 500);
	frame.setResizable(false);
	frame.setVisible (true);

    } // Constructor

    //Method handles button clicks of menu and redirects user to next page
    public void actionPerformed (ActionEvent e)
    {
	Object buttonObj = e.getSource ();
	
	//Recycles current frame to replace with choosen activity
	if (buttonObj == menuButtons [0])
	{
	    frame.dispose ();
	    SurveyPages survey_page = new SurveyPages ();

	}
	else if (buttonObj == menuButtons [1])
	{
	    frame.dispose ();
	    Instructions instructions_page = new Instructions ();

	}
	else if (buttonObj == menuButtons [2])
	{
	    frame.dispose();
	}

    } //action onclick listener method for menu Jbuttons
} // MainMenu class
