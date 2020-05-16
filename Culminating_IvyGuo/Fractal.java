package Culminating_IvyGuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Fractal extends Canvas
{
    JFrame frame;
    DrawingCanvas canvas; //displays fractal patterns

    public Fractal ()
    {
	frame = new JFrame ("Flavours of Fractals - Fractal Build");
	canvas = new DrawingCanvas ();
	frame.getContentPane ().add (canvas);
	// Set the frame's size and show the frame
	frame.setSize (600, 500);
	frame.setVisible (true);

    } // Constructor


    class DrawingCanvas extends JPanel
    {
	public DrawingCanvas ()
	{
	    this.setPreferredSize (new Dimension (600, 300));
	    this.setBackground (Color.white);
	} //end constructor

	public void paint (Graphics g)
	{
	    super.paint (g);
	    g.setColor (Style.MIDNIGHT_BLUE);
	    drawSierpinski (g);

	} // paint method

	public void drawSierpinski (Graphics g)
	{
	    Polygon basicTriangle = new Polygon ();

	    basicTriangle.addPoint (100, 400);
	    basicTriangle.addPoint (500, 400);
	    basicTriangle.addPoint (300, 50);

	    g.fillPolygon (basicTriangle);

	}

	public void drawTriangle ();


    } // DrawingCanvas Class
} // Fractal class
