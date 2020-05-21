/*
 * Ivy Guo - Flavours of Fractals / INSTRUCTIONS PAGE
 * This class reads the StringExplanation.txt file and outputs the 
 * instructions on how the fractals are generated for the user to read
 * Home button takes user's input and returns them to the MainMenu page
*/

package Culminating_IvyGuo;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Instructions implements ActionListener
{
    //Declaration of variables
    private JFrame frame;
    private JLabel title, description;
    private JPanel contentPanel, buttonPanel;
    private String instructions;
    private JButton returnHome;
    private JEditorPane textPane;

    public Instructions ()
    {
	//Make new JFrame object
	frame = new JFrame ("Flavours of Fractals - How It Works");

	//Create new buttons objects for navigation
	returnHome = new JButton ("Return Home");
	returnHome.setBackground (Style.LIGHT);
	returnHome.setForeground (Style.SEMI);
	returnHome.setFont (Style.REGULAR_FONT);
	returnHome.addActionListener (this);

	//Create new panel for home button
	buttonPanel = new JPanel ();
	buttonPanel.setBorder (new EmptyBorder
		(new Insets (10, 10, 10, 10)));
	buttonPanel.setBackground (Style.LIGHT);
	buttonPanel.add (returnHome);

	//Throws an error if instruction file is not found
	try
	{
	    //Use file path to get html stylized text file with file reader
	    //Initialize bufferedreader filereader object and
	    FileReader fr = new FileReader
		("Culminating_IvyGuo/StringExplanation.txt");
	    BufferedReader br = new BufferedReader (fr);

	    //Reads first line
	    instructions = br.readLine ();

	    //Iterates through each line of textfile
	    for (int i = 0 ; i < 33 ; i++)
	    {
		instructions += br.readLine ();
	    }
	    //Close file when done reading
	    br.close ();
	}
	catch (IOException e)
	{
	    System.out.println ("File not found?");
	}

	//Create next Text pane to hold instructions text
	textPane = new JEditorPane ();
	textPane.setContentType ("text/html");
	textPane.setText (instructions);
	textPane.setBorder (new EmptyBorder
		(new Insets (10, 30, 30, 30)));
	textPane.setEditable (false);

	//Set textpane to be scrollable
	JScrollPane scrollPane = new JScrollPane (textPane);
	JScrollBar scrollBar = scrollPane.getVerticalScrollBar ();
	scrollBar.setUnitIncrement (20);

	//Make new JPanel Object with grid layout to hold instructions/buttons
	contentPanel = new JPanel ();
	contentPanel.setBorder (new EmptyBorder
		(new Insets (30, 30, 30, 30)));
	contentPanel.setLayout (new BorderLayout ());
	contentPanel.setBackground (Style.FAINT);
	contentPanel.add (scrollPane, BorderLayout.CENTER);
	contentPanel.add (returnHome, BorderLayout.SOUTH);

	//Add JPanel contentPanel to Jframe
	frame.getContentPane ().add (contentPanel);

	// Set the frame's size and show the frame
	frame.setSize (600, 500);
	frame.setResizable (false);
	frame.setVisible (true);
    } // Constructor


    //Method handles on click for return home button
    public void actionPerformed (ActionEvent e)
    {
	Object buttonObj = e.getSource ();

	//Recycles current frame to return back home
	if (buttonObj == returnHome)
	{
	    frame.dispose ();
	    MainMenu mainMenu_page = new MainMenu ();
	}
    }
} // Instructions class
