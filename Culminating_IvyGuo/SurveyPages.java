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
    private JPanel mainPanel, cardPanel, buttonPanel, card0;
    private JPanel[] cardList = {
	new JPanel (),
	new JPanel (),
	new JPanel (),
	new JPanel ()
	};

    private int currentView = 1;

    public SurveyPages ()
    {
	frame = new JFrame ("Survey");

	//Create new buttons objects for navigation
	backButton = new JButton ("< Back");
	nextButton = new JButton ("Next >");
	backButton.addActionListener (this);
	nextButton.addActionListener (this);


	//Create main frame layout for cards
	mainPanel = new JPanel (new BorderLayout ());
	cardPanel = new JPanel (new CardLayout ());
	mainPanel.add (cardPanel, BorderLayout.CENTER);

	card0 = SurveyLayout.makePanel ("howdy", "yup");
	cardPanel.add(card0, BorderLayout.CENTER);

	//Create survey pages (JPanels) for cardlayout
	for (int i = 0 ; i < 3 ; i++)
	{
	    cardList [i] = SurveyLayout.makePanel (i);
	    //cardPanel.add (cardList [i], BorderLayout.CENTER);

	}
	//Add cards into main frame panel
	//mainPanel.show(card1);


	//Create new panel for reusable buttons
	buttonPanel = new JPanel ();
	buttonPanel.setBorder (new EmptyBorder
		(new Insets (10, 10, 10, 10)));
	buttonPanel.setBackground (Style.LIGHT);
	buttonPanel.add (backButton);
	buttonPanel.add (nextButton);
	mainPanel.add (buttonPanel, BorderLayout.SOUTH);

	//Add button panel/mainframe into the frame
	frame.getContentPane ().add (mainPanel);
	// Set the frame's size and show the frame
	frame.setSize (600, 500);
	frame.setVisible (true);

    } // Constructor


    public void actionPerformed (ActionEvent e)
    {
	Object buttonObj = e.getSource ();
	if (buttonObj == backButton && currentView == 1)
	{
	    frame.dispose ();
	    MainMenu mainMenu_page = new MainMenu ();
 
	}
	else if (buttonObj == backButton)
	{
	    currentView -= 1;

	}
	else if (buttonObj == nextButton)
	{
	    currentView += 1;
	}


    } //On click button listener for next/back buttons
} // SurveyPages class
