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
    //int i = 10;

    //Starting points for base circle (x,y) & radius
    int center_x = 300, center_y = 300;
    int radius = 200;

    //Phyllotaxis spirals from flower seeds create the golden angle
    //This is the angle at which one seed is placed relative to another (variation)
    double goldenAngle = Math.toRadians (360 * Math.pow (((Math.sqrt (2) + 1) / 2), -2));
    double c = 1.5; //scale factor for each row of petals/seeds
    int spread = 2000; //Number of iterations of seeds/petals
    int seedRadius = 5;

    int limit;

    //Frame to hold fractal drawings
    public Fractal ()
    {
	frame = new JFrame ("Flavours of Fractals - Fractal Build");
	canvas = new DrawingCanvas ();
	frame.getContentPane ().add (canvas);
	// Set the frame's size and show the frame
	frame.setSize (600, 600);
	frame.setResizable (false);
	frame.setVisible (true);

    } // Constructor


    class DrawingCanvas extends JPanel
    {
	public DrawingCanvas ()
	{
	    this.setPreferredSize (new Dimension (600, 600));
	    this.setBackground (Color.yellow);
	} //end constructor

	public void paint (Graphics g)
	{
	    super.paint (g);
	    Graphics2D g2 = (Graphics2D) g; //for rotating graphics
	    int width = getWidth ();
	    int height = getHeight ();
	    
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
		    multipleFlowers (g, g2, 0, 300, 300, width, height, seedRadius, 10);
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

	//Flower/Seeds "fractal"

   public void drawSeeds (Graphics g, Graphics2D g2, int colorIndex, int center_x,
		int center_y, int width, int height, int radius)
	{
	    g.setColor (Color.black);

	    for (int i = 0 ; i < spread ; i += 2)
	    {
		double theta = Math.toRadians (i * goldenAngle);
		double spiralRadius = c * Math.sqrt (i);
		Color brown = new Color (210, 105, 30);

		int x = (int) (spiralRadius * Math.cos (theta) + center_x);
		int y = (int) (spiralRadius * Math.sin (theta) + center_y);

		if (spiralRadius < 30 && spiralRadius % 2 != 1)
		{

		    g.setColor (Color.black);
		    g.drawOval (x - seedRadius / 2, y - seedRadius / 2, seedRadius,
			    seedRadius);
		}
		else if (spiralRadius > 30 && i % 10 == 0)
		{
		    AffineTransform old = g2.getTransform ();

		    for (int n = 0 ; n <= 360 ; n += 45)
		    {
			g2.rotate (Math.toRadians (n), x, y);
			g.setColor (Color.yellow);
			g.fillOval (x - seedRadius / 2, y - seedRadius / 2, seedRadius,
				seedRadius * 2);
			g.setColor (brown);
			g.drawOval (x - seedRadius / 2, y - seedRadius / 2, seedRadius,
				seedRadius * 2);
		    }
		    g2.setTransform (old);
		}
	    }
	}

	public void drawSeeds (Graphics g, int colorIndex, int width, int height, int radius, int spread)
	{
	    g.setColor (Color.black);

	    for (int i = 0 ; i < spread ; i += 2)
	    {
		double theta = Math.toRadians (i * goldenAngle);
		double spiralRadius = c * Math.sqrt (i);
		Color brown = new Color (210, 105, 30);

		int x = (int) (spiralRadius * Math.cos (theta) + width / 2);
		int y = (int) (spiralRadius * Math.sin (theta) + height / 2);

		if (spiralRadius < 100 && spiralRadius % 2 != 1)
		{

		    g.setColor (Color.black);
		    g.drawOval (x - seedRadius / 2, y - seedRadius / 2, seedRadius,
			    seedRadius);
		}
		else if (spiralRadius > 100)
		{
		    g.setColor (brown);
		    g.drawOval (x - seedRadius / 2, y - seedRadius / 2, seedRadius,
			    seedRadius);
		}
	    }
	}

	public void multipleFlowers (Graphics g, Graphics2D g2, int colorIndex, int center_x,
		int center_y, int width, int height, int radius, int limit)
	{
	    drawSeeds (g, 0, width, height, radius, 3000);

	    int newradius = (int) (radius / 1.2);

	    for (int i = 45 ; i <= 360 ; i += 45)
	    {
		int new_x = (int) (width / 2 + 150 * Math.cos (Math.toRadians (i)));
		int new_y = (int) (height / 2 + 150 * Math.sin (Math.toRadians (i)));

		drawSeeds (g, g2, 0, new_x, new_y, width, height, 300);
	    }

	    int[] [] angleList = {
		    {25, 270, 15},
		    {15, 350, 10},
		    {10, 400, 5}
		};


	    for (int h = 0 ; h < 3 ; h++)
	    {
		for (int e = angleList [h] [0] ; e <= 360 ; e += angleList [h] [0])
		{
		    int new_x = (int) (width / 2 + angleList [h] [1] * Math.cos (Math.toRadians (e)));
		    int new_y = (int) (height / 2 + angleList [h] [1] * Math.sin (Math.toRadians (e)));

		    drawFlower (g, g2, 0, new_x, new_y, angleList [h] [2]);
		}
	    }
	}

	public void drawFlower (Graphics g, Graphics2D g2, int colorIndex,
		int center_x, int center_y, int radius)
	{
	    AffineTransform old = g2.getTransform ();

	    for (int i = 0 ; i <= 360 ; i += 45)
	    {
		g2.rotate (Math.toRadians (i), center_x, center_y);
		g.drawOval (center_x - radius / 2, center_y - radius / 2, radius,
			radius * 2);
	    }
	    g2.setTransform (old);

	    for (int i = 0 ; i <= 360 ; i += 15)
	    {
		g2.rotate (Math.toRadians (i), center_x, center_y);
		g.drawOval (center_x - radius / 2, center_y - radius / 2, radius,
			radius * limit);
	    }
	    g2.setTransform (old);
	}
	
    } // DrawingCanvas Class
} // Fractal class
