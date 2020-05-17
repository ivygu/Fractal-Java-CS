package Culminating_IvyGuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Fractal extends Canvas
{
    JFrame frame;
    int colourSchemeIndex, complexityIndex, shapeIndex;
    DrawingCanvas canvas; //displays fractal patterns

    //Starting points for base triangle (x,y)
    int point1_x = 300, point1_y = 50;
    int point2_x = 100, point2_y = 400;
    int point3_x = 500, point3_y = 400;

    //Starting points for base circle (x,y) & radius
    int center_x = 300, center_y = 250;
    int radius = 200;

    int limit;

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
	    Graphics2D g2 = (Graphics2D) g;
	    //Get survey response to customize fractals
	    colourSchemeIndex = SurveyPages.getSurveyAnswers (0);
	    complexityIndex = SurveyPages.getSurveyAnswers (1);
	    shapeIndex = SurveyPages.getSurveyAnswers (2);

	    switch (complexityIndex)
	    {
		case 0: //less stress == less crowded
		    limit = 4;
		    break;

		case 1: //some stress == a bit crowded
		    limit = 6;
		    break;

		case 2: //a lot of stress == bery crowed
		    limit = 7;
		    break;
	    }

	    switch (shapeIndex)
	    {
		case 0: //trees--> organic + literal, trees
		    break;

		case 1: //wildfires--> organic, circles
		    fancyCircle (g, colourSchemeIndex, center_x, center_y,
			    radius, limit);

		    break;

		case 2: //buildings --> more geometric, triangles
		    drawSierpinski (g, colourSchemeIndex, point1_x, point1_y,
			    point2_x, point2_y, point3_x, point3_y, limit);
		    break;
	    }



	} // paint method

	//Sierpinski Fractal ----------------------------------------------
	public void drawTriangle (Graphics g, int colorIndex, int point1_x,
		int point1_y, int point2_x, int point2_y, int point3_x,
		int point3_y)
	{
	    Polygon simpleTriangle = new Polygon ();
	    simpleTriangle.addPoint (point1_x, point1_y);
	    simpleTriangle.addPoint (point2_x, point2_y);
	    simpleTriangle.addPoint (point3_x, point3_y);

	    g.setColor (Style.colorSchemeList [colorIndex] [0]);
	    g.fillPolygon (simpleTriangle);
	}

	public void drawSierpinski (Graphics g, int colorIndex, int point1_x,
		int point1_y, int point2_x, int point2_y, int point3_x,
		int point3_y, int limit)
	{
	    if (limit > 0)
	    {
		int pointa_x = (point1_x + point2_x) / 2;
		int pointa_y = (point1_y + point2_y) / 2;

		int pointb_x = (point1_x + point3_x) / 2;
		int pointb_y = (point1_y + point3_y) / 2;

		int pointc_x = (point2_x + point3_x) / 2;
		int pointc_y = (point2_y + point3_y) / 2;

		drawSierpinski (g, colorIndex, point1_x, point1_y, pointa_x,
			pointa_y, pointb_x, pointb_y, limit - 1);

		drawSierpinski (g, colorIndex, pointa_x, pointa_y, point2_x,
			point2_y, pointc_x, pointc_y, limit - 1);

		drawSierpinski (g, colorIndex, pointb_x, pointb_y, pointc_x,
			pointc_y, point3_x, point3_y, limit - 1);
	    }
	    else
	    {
		drawTriangle (g, 1, point1_x, point1_y,
			point2_x, point2_y, point3_x, point3_y);
	    }

	}
	//------------------------------------------------------------------

	//Circle Fractal ---------------------------------------------------

	public void drawCircle (Graphics g, int colorIndex, int center_x,
		int center_y, int radius)
	{

	    g.setColor (Style.colorSchemeList [1] [0]);
	    g.drawOval (center_x, center_y, radius, radius);
	}

	public void fancyCircle (Graphics g, int colorIndex, int center_x,
		int center_y, int radius, int limit)
	{
	    if (limit > 0)
	    {
		int newRadius = radius / 2;

		int centerA_x = (center_x - radius / 2);
		int centerB_x = (center_x + radius / 2);
		int centerC_y = (center_y - radius / 2);
		int centerD_y = (center_y + radius / 2);

		 g.drawOval (
			center_x - radius / 2,
			center_y - radius / 2,
			radius, radius
			);

		g.drawOval (
			centerA_x - newRadius / 2,
			center_y - newRadius / 2,
			newRadius, newRadius);

		g.drawOval (
			centerB_x - newRadius / 2,
			center_y - newRadius / 2,
			newRadius, newRadius);

		g.drawOval (
			center_x - newRadius / 2,
			centerC_y - newRadius / 2,
			newRadius, newRadius);

		g.drawOval (
			center_x - newRadius / 2,
			centerD_y - newRadius / 2,
			newRadius, newRadius);
	    }

	}
    } // DrawingCanvas Class
} // Fractal class
