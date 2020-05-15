// The "SurveyLayout" class.

package Culminating_IvyGuo;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurveyLayout
{
    //Fields of Survey Layout

    static JButton[] surveyButtons = {
	new JButton ("Option 1"),
	new JButton ("Option 2"),
	new JButton ("Option 3"),
	};

    static String[] [] questionOptionsList = {
	    {"How are you feeling today?",
	    "Joyful, Content, Delighted",
	    "Upset, Frustrated, Hallow",
	    "Angry, Bitter, Annoyed"},

	    {"How stressed do you feel?",
	    "Very tranquil. Nothing is too stressful.",
	    "A bit of stress, but tt's alright.",
	    "Extremely stressed! My mind is all over the place."},

	    {"Where would you want to take a walk?",
	    "In the forest, home to ancient trees and mini shrubs.",
	    "In the meadows, covered in blankets of wildflowers.",
	    "In the city, surrounded by beautiful, modern architecture."}
	};

    public static JPanel makePanel (int questionIndex)
    {
	//Make new JLabel for title
	String question = questionOptionsList [questionIndex] [0];
	JLabel label = new JLabel (question, JLabel.CENTER);
	label.setFont (Style.HEADING_FONT);
	label.setForeground (Style.DARK);

	//Make new JPanel Object with grid layout
	JPanel panel = new JPanel (new GridLayout (4, 1, 0, 10));
	panel.setBorder (new EmptyBorder
		(new Insets (30, 30, 30, 30)));
	panel.setBackground (Style.FAINT);
	panel.add (label);

	for (int i = 0 ; i < 3 ; i++)
	{
	    String option = questionOptionsList [questionIndex] [i + 1];
	    surveyButtons [i].setText (option);

	    //implement anonymous class for button listener in static method
	    surveyButtons [i].addActionListener (new ActionListener ()
	    {
		public void actionPerformed (ActionEvent e)
		{

		}
	    }
	    );

	    surveyButtons [i].setBackground (Style.LIGHT);
	    surveyButtons [i].setForeground (Style.SEMI);
	    surveyButtons [i].setFont (Style.REGULAR_FONT);
	    panel.add (surveyButtons [i]);
	}

	return panel;

    } //makePanel Method


    public static JPanel makePanel (String introTitle, String description)
    {
	
	//Make new JLabel for title
	JLabel title = new JLabel (introTitle, JLabel.CENTER);
	title.setFont (Style.HEADING_FONT);
	title.setForeground (Style.DARK);
	
	//Make new JLabel for description
	JLabel label = new JLabel (description, JLabel.CENTER);
	label.setFont (Style.HEADING_FONT);
	label.setForeground (Style.DARK);

	//Make new JPanel Object with grid layout
	JPanel panel = new JPanel (new GridLayout (3, 1, 0, 10));
	panel.setBorder (new EmptyBorder
		(new Insets (30, 30, 30, 30)));
	panel.setBackground (Style.FAINT);
	panel.add (title);
	panel.add (label);
	
	return panel;
    }


    /*

    private class ButtonListener implements ActionListener
    {

	public void actionPerformed (ActionEvent e)
	{
	    Object buttonObj = e.getSource ();
	    if (buttonObj == surveyButtons [1])
	    {

	    }
	    else if (buttonObj == surveyButtons [2])
	    {
	    }
	    else if (buttonObj == surveyButtons [3])
	    {
	    }


	} //On click button listener for menu buttons

    } //Button listener class for option buttons

    */
} // SurveyLayout class


