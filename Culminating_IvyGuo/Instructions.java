// How it works Page

package Culminating_IvyGuo;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Instructions extends JFrame
{
    private JFrame frame;
    private JLabel title, description;
    private JPanel contentPanel;
    
    public Instructions ()
    {
	//Make new JFrame object
	frame = new JFrame ("Flavours of Fractals - How It Works");
	
	//Make new JLabel for title
	//JLabel title = new JLabel (question , JLabel.CENTER);
	title = new JLabel("How It Works", JLabel.CENTER);
	title.setFont (Style.TITLE_FONT);
	title.setForeground (Style.DARK);
	
	//Make new Jlabel for description
	description = new JLabel ("hello", JLabel.CENTER);
	description.setFont (Style.REGULAR_FONT);
	description.setForeground (Style.SEMI);
	
	//Make new JPanel Object with grid layout to hold title JLabel
	contentPanel = new JPanel ();
	contentPanel.setBorder (new EmptyBorder
		(new Insets (30, 30, 30, 30)));
	contentPanel.setLayout (new GridLayout (3, 1, 0, 10));
	contentPanel.setBackground (Style.FAINT);
	contentPanel.add (title);
	contentPanel.add (description);
	
	//Add JPanel contentPanel to Jframe
	frame.getContentPane ().add (contentPanel);
	
	// Set the frame's size and show the frame
	frame.setSize (600, 500);
	frame.setVisible (true);
    } // Constructor

} // Instructions class
