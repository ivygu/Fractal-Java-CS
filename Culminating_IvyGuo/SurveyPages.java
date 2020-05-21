/*
 * Ivy Guo - Flavours of Fractals / SURVEY PAGES PAGE
 * This class calls upon the SurveyLayout class to create survey pages.
 * The user inputs reponses to the questions, which are passed to the
 * Fractal class
*/

package Culminating_IvyGuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SurveyPages implements ActionListener
{
    //Declaration of variables
    static int[] userResponse = new int [3];
    private JFrame frame;
    private JButton backButton, nextButton;
    private JPanel mainPanel, cardPanel, buttonPanel, card0, card1,
	card2, card3;
    private String welcomeInfo =
	"<html>Following this page, you will be redirected to a survey." + 
	"<p><br>We will be generating fractal designs with varying colours," +
	" shapes and levels of complexity based on your responses.</p>" +
	"<p><br>Have fun! :) </p></html>";

    private JToggleButton[] [] surveyButtons = {
	    {
	    new JToggleButton ("Joyful, Content, Delighted"),
	    new JToggleButton ("Upset, Frustrated, Hallow"),
	    new JToggleButton ("Angry, Bitter, Annoyed")
	},

	    {
	    new JToggleButton
	    ("Very tranquil. Nothing is too stressful."),
	    new JToggleButton
	    ("A bit of stress, but it's alright."),
	    new JToggleButton
	    ("Extremely stressed! My mind is all over the place.")
	},
	    {
	    new JToggleButton
	    ("In the forest, home to ancient trees and mini shrubs."),
	    new JToggleButton
	    ("In the meadows, covered in blankets of wildflowers."),
	    new JToggleButton
	    ("In the city, surrounded by modern architecture.")
	}
	};
    public CardLayout cardLayout;
    private JPanel[] cardList = {
	card1,
	card2,
	card3
	};
    //Groups survey buttons so only 1 can be selected per page at a time
    private ButtonGroup question1Group, question2Group, question3Group;
    private ButtonGroup[] buttonGroup = {
	question1Group = new ButtonGroup (),
	question2Group = new ButtonGroup (),
	question3Group = new ButtonGroup ()
	};
    private int currentView = 1;

    public SurveyPages ()
    {
	//creates frame object
	frame = new JFrame ("Flavours of Fractals - Survey");

	//Create new buttons objects for navigation
	backButton = new JButton ("< Back");
	nextButton = new JButton ("Next >");
	backButton.addActionListener (this);
	nextButton.addActionListener (this);

	//Create main frame layout for cards
	mainPanel = new JPanel (new BorderLayout ());
	cardLayout = new CardLayout ();
	cardPanel = new JPanel (cardLayout);
	cardLayout.show (cardPanel, "Card 1");

	mainPanel.add (cardPanel, BorderLayout.CENTER);

	//default introduction card stylized with html
	card0 = SurveyLayout.makePanel ("Welcome to Flavours of Fractals"
		,welcomeInfo);
	cardPanel.add (card0, BorderLayout.NORTH);

	//Create survey pages (JPanels) for cardlayout
	for (int i = 0 ; i < 3 ; i++)
	{
	    cardList [i] = SurveyLayout.makePanel (i);

	    //Creates survey buttons for each survey page and adds to jpanel
	    for (int n = 0 ; n < 3 ; n++)
	    {
		//temp. local variable to pass to inner class
		final int button = i, buttonVal = n;
		surveyButtons [i] [n].addActionListener (
			//Anonymous Listener Class for survey buttons
			new ActionListener ()
		{
		    //Handles/stores reponses into user reponse array
		    public void actionPerformed (ActionEvent e)
		    {
			userResponse [button] = buttonVal;
		    }
		}
		);
		surveyButtons [i] [n].setBackground (Style.LIGHT);
		surveyButtons [i] [n].setForeground (Style.SEMI);
		surveyButtons [i] [n].setFont (Style.REGULAR_FONT);
		buttonGroup [i].add (surveyButtons [i] [n]);
		cardList [i].add (surveyButtons [i] [n]);
	    }

	    cardPanel.add (cardList [i], "Card " + i);
	}

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
	frame.setResizable (false);
	frame.setVisible (true);

    } // Constructor


    //Method handles back/next button and redirects to desired survey page
    public void actionPerformed (ActionEvent e)
    {
	Object buttonObj = e.getSource ();

	//updates page number and redirects to other page using cardlayout
	if (buttonObj == backButton && currentView == 1)
	{
	    currentView = 0;
	    frame.dispose ();
	    MainMenu mainMenu_page = new MainMenu ();
	}

	else if (buttonObj == backButton)
	{
	    cardLayout.previous (cardPanel);
	    currentView -= 1;
	}

	else if (buttonObj == nextButton)
	{
	    if (currentView != 4)
	    {
		cardLayout.next (cardPanel);
		currentView += 1;
	    }
	    else
	    {
		frame.dispose ();
		Fractal fractal_page = new Fractal ();
	    }
	}
    } //On click button listener for next/back buttons


    //Method gets reponses from survey for fractal parameters
    static int getSurveyAnswers (int a)
    {
	return userResponse [a];

    }
} // SurveyPages class
