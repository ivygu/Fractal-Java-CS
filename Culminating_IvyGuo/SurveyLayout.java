// The "SurveyLayout" class.

package Culminating_IvyGuo;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SurveyLayout
{
    //Fields of Survey Layout
    static JPanel panel;

    private String[] [] questionOptionsList = {
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
	question = questionList [questionIndex][0];
	JLabel label = new JLabel (question, JLabel.CENTER);
	label.setFont (Style.HEADING_FONT);
	label.setForeground (Style.DARK);

	//Make new JPanel Object with grid layout
	panel = new JPanel (new GridLayout (4, 1, 0, 10));
	panel.setBorder (new EmptyBorder
		(new Insets (30, 30, 30, 30)));
	panel.setBackground (Style.FAINT);
	
	for(int i = 1; i < 4; i++) {
	    JLabel option = new JLabel(questionList[questionIndex][i]);
	    
	}

	panel.add (label);

	return panel;

    } //makePanel Method
} // SurveyLayout class


