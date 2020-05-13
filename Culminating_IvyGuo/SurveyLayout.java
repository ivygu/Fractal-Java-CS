// The "SurveyLayout" class.

package Culminating_IvyGuo;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SurveyLayout
{
    //Fields of Survey Layout
    static JPanel panel;
    
    public static JPanel makePanel (String question, String [] options)
    {
	//Make new JLabel for title
	title = new JLabel (question , JLabel.CENTER);
	title.setFont (Style.TITLE_FONT);
	title.setForeground (Style.DARK);
	
	//Make new JPanel Object with grid layout to hold title JLabel
	panel = new JPanel ();
	panel.setBorder (new EmptyBorder
		(new Insets (30, 30, 30, 30)));
	panel.setLayout (new GridLayout (3, 1, 0, 10));
	panel.setBackground (Style.FAINT);
	
	panel.add (title);
	
	return panel;

    } //makePanel Method


} // SurveyLayout class


