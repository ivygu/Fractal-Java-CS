package Culminating_IvyGuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.geom.AffineTransform;


public class Fractal extends Canvas
{
    JFrame frame;
    int colourSchemeIndex, complexityIndex, shapeIndex;
    DrawingCanvas canvas; //displays fractal patterns

    //Starting points for base triangle (x,y)
    int point1_x = 300, point1_y = 50;
    int point2_x = 100, point2_y = 400;
    int point3_x = 500, point3_y = 400;
    int i = 10;

    //Starting points for base circle (x,y) & radius
    int center_x = 300, center_y = 250;
    int radius = 200;

    //Starting points for trunk of tree (x,y)
    int endPointA_x = 300, endPointA_y = 450;
    int branchLength = 300;

    int limit;

    //Frame to hold fractal drawings
    public Fractal ()
    {
	frame = new JFrame ("Flavours of Fractals - Fractal Build");
	canvas = new DrawingCanvas ();
	frame.getContentPane ().add (canvas);
	// Set the frame's size and show the frame
	frame.setSize (600, 550);
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
	    Graphics2D g2 = (Graphics2D) g; //for rotating graphics

	    //Get survey response to customize fractals
	    colourSchemeIndex = SurveyPages.getSurveyAnswers (0);
	    complexityIndex = SurveyPages.getSurveyAnswers (1);
	    shapeIndex = SurveyPages.getSurveyAnswers (2);

	    //sets properties of fractals to use in fractal building methods
	    switch (complexityIndex)
	    {
		case 0: //less stress == less crowded
		    limit = 4;
		    break;

		case 1: //some stress == a bit crowded
		    limit = 5;
		    break;

		case 2: //a lot of stress == bery crowed
		    limit = 6;
		    break;
	    }

	    switch (shapeIndex)
	    {
		case 0: //trees--> organic + literal, trees
		    drawLine (g, g2, colourSchemeIndex, endPointA_x,
			    endPointA_y, branchLength, i);
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

	//FRACTAL BUILDING METHODS-----------------------------------------

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
	    g.setColor (Style.colorSchemeList [colorIndex] [0]);
	    g.drawOval (center_x - radius / 2, center_y - radius / 2, radius,
		    radius);
	}

	public void fancyCircle (Graphics g, int colorIndex, int center_x,
		int center_y, int radius, int limit)
	{
	    drawCircle (g,
		    colorIndex,
		    center_x,
		    center_y,
		    radius);

	    //Calls back to iself until level of complexity (limit) is met
	    if (limit > 0)
	    {
		//Halves radius to create smaller surrounding circles
		int newRadius = radius / 2;

		//Calculates new orgin points for 4 new circles
		int centerA_x = (center_x - radius / 2);
		int centerB_x = (center_x + radius / 2);
		int centerC_y = (center_y - radius / 2);
		int centerD_y = (center_y + radius / 2);

		//Draws smaller circle to the left
		fancyCircle (g,
			colorIndex,
			centerA_x,
			center_y,
			newRadius, limit - 1);

		//Draws smaller circle to the right
		fancyCircle (g,
			colorIndex,
			centerB_x,
			center_y,
			newRadius, limit - 1);

		//Draws smaller circle bellow
		fancyCircle (g,
			colorIndex,
			center_x,
			centerC_y,
			newRadius, limit - 1);

		//Draws smaller circle above
		fancyCircle (g,
			colorIndex,
			center_x,
			centerD_y,
			newRadius, limit - 1);
	    }
	}
	//------------------------------------------------------------------

	//Tree Fractal
	public void drawLine (Graphics g, Graphics2D g2, int colorIndex,
		int endPointA_x, int endPointA_y, int branchLength, int i)
	{
	    g.setColor (Style.colorSchemeList [colorIndex] [0]);
	    AffineTransform old = g2.getTransform ();

	    int newBranchLength = branchLength / 2;
	    int endPointB_y = endPointA_y - newBranchLength;

	    //middle branch of tree
	    g.drawLine (endPointA_x, endPointA_y, endPointA_x, endPointB_y);

	    //Left branch of tree + translate 45 degrees left
	    g2.rotate (Math.toRadians (315), endPointA_x, endPointA_y);
	    g.drawLine (endPointA_x, endPointA_y, endPointA_x, endPointB_y);

	    //Reset angle back to 0 radians
	    g2.rotate (Math.toRadians (-315), endPointA_x, endPointA_y);

	    //Right Branch of tree + translate 45 degrees right
	    g2.rotate (Math.toRadians (45), endPointA_x, endPointA_y);
	    g.drawLine (endPointA_x, endPointA_y, endPointA_x, endPointB_y);

	    //Stop rotations
	    g2.setTransform (old);
	    endPointA_y = endPointB_y;

	    if (i >= 1)
	    {
		drawLine (g, g2, colourSchemeIndex,
			endPointA_x, endPointA_y, newBranchLength, i -1);
	    }
	}

	public void drawTree (Graphics g, Graphics2D g2, int colorIndex,
		int endPointA_x, int endPointA_y, int branchLength)
	{

	}


    } // DrawingCanvas Class
} // Fractal class
