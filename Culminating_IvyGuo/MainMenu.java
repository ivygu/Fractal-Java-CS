package Culminating_IvyGuo;

import java.awt.*;
import javax.swing.*;

public class MainMenu extends JFrame
{
    //Color themeColor = new Color(123, 111, 222);
    final Font THEME_FONT = new Font ("Arial", Font.PLAIN, 30);
    static JFrame frame;
    static JLabel title;
    static JPanel contentPanel;

    public MainMenu ()
    {
	//Make new JFrame object
	frame = new JFrame ("Flavours of Fractals - Menu");
	
	//Make new JLabel for title
	title = new JLabel("Flavours of Fractals", JLabel.CENTER);
	title.setFont(THEME_FONT);

	//Make new JPanel Object to hold title JLabel
	contentPanel = new JPanel (); 
	contentPanel.add (title);   
	contentPanel.setBackground(Color.white); 
	contentPanel.setBounds(100,100,100,100);
	
	//Add JPanel contentPanel to Jframe 
	frame.getContentPane ().add (contentPanel); 
	
	// Set the frame's size and show the frame
	frame.setSize (600, 500); 
	frame.setVisible (true); 

    } // Constructor


    public void paint (Graphics g)
    {
	// Place the drawing code here
    } // paint method
} // MainMenu class
