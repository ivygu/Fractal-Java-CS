/*
 * Ivy Guo - Flavours of Fractals / STYLE PAGE
 * This class stores all constant stylistic elements of the program including
 * fonts and colours
*/

package Culminating_IvyGuo;

import java.awt.*;
import javax.swing.*;

public class Style
{
    //Declaration of Color objects with rgb values and font objects
    final static Color
	FAINT = new Color (244, 245, 250),
	LIGHT = new Color (179, 188, 245),
	SEMI = new Color (32, 46, 120),
	DARK = new Color (0, 6, 57),

	//Cool Color Scheme (blue)
	MIDNIGHT_BLUE = new Color (3, 26, 107),
	YALE_BLUE = new Color (0, 67, 133),
	AERO_BLUE = new Color (121, 190, 238),

	//Warm Color Scheme (red)
	TULIP_PURPLE = new Color (81, 24, 76),
	SALSA_RED = new Color (199, 0, 57),
	FLAME_ORANGE = new Color (255, 87, 51),

	//Bright Color Scheme
	AQUA = new Color (5, 255, 180),
	LIME_GREEN = new Color (222, 255, 5),
	WHITE = new Color (255, 255, 255);
    
    //Accessible array to call upon color packages
    final static Color[] [] colorSchemeList = {
	    {AQUA, LIME_GREEN, WHITE},
	    {AERO_BLUE, YALE_BLUE, MIDNIGHT_BLUE},
	    {TULIP_PURPLE, SALSA_RED, FLAME_ORANGE}

	};
    //Accessible array to call upon font packages
    final static Font
	TITLE_FONT = new Font ("Georgia", Font.PLAIN, 50),
	HEADING_FONT = new Font ("Georgia", Font.PLAIN, 30),
	REGULAR_FONT = new Font ("Georgia", Font.ITALIC, 20),
	READ_FONT = new Font ("Georgia", Font.PLAIN, 18);
}
