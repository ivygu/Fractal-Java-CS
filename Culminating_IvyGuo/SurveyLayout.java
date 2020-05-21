/*
 * Ivy Guo - Flavours of Fractals / SURVEY LAYOUT PAGE
 * This class contains survey layouting methods that are used in the 
 * SurveyPages class to return customized jpanels 
*/

package Culminating_IvyGuo;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SurveyLayout
{
    //Declaration of variables
    static String[] questionOptionsList = {
	"How are you feeling today?",
	"How stressed do you feel?",
	"Where would you like to take a walk?"
	};
    static int[] userResponse;

    public static JPanel makePanel (int questionIndex)
    {
	//Make new JLabel for title
	String question = questionOptionsList [questionIndex];
	JLabel label = new JLabel (question, JLabel.CENTER);
	label.setFont (Style.HEADING_FONT);
	label.setForeground (Style.DARK);

	//Make new JPanel Object with grid layout
	JPanel panel = new JPanel (new GridLayout (4, 1, 0, 10));
	panel.setBorder (new EmptyBorder
		(new Insets (30, 30, 30, 30)));
	panel.setBackground (Style.FAINT);
	panel.add (label);

	return panel;

    } //makePanel Method

    //Overloaded method to create first page
    public static JPanel makePanel (String introTitle, String description)
    {
	//Make new JLabel for title
	JLabel title = new JLabel (introTitle, JLabel.CENTER);
	title.setFont (Style.HEADING_FONT);
	title.setForeground (Style.DARK);

	//Make new JLabel for description
	JLabel label = new JLabel (description, JLabel.CENTER);
	label.setFont (Style.READ_FONT);
	label.setForeground (Style.DARK);

	//Make new JPanel Object with grid layout
	JPanel panel = new JPanel (new BorderLayout());
	panel.setBorder (new EmptyBorder
		(new Insets (50, 30, 80, 30)));
	panel.setBackground (Style.FAINT);
	panel.add (title, BorderLayout.NORTH);
	panel.add (label, BorderLayout.CENTER);

	return panel;
    }

} // SurveyLayout class


