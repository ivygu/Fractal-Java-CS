package Culminating_IvyGuo;

import java.awt.*;
import javax.swing.*;

//Constant Stylistic Elements
public class Style
{

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
	SALSA_RED = new Color (199, 0, 57),
	TULIP_PURPLE = new Color (81, 24, 76),
	FLAME_ORANGE = new Color (255, 87, 51),

	//Bright Color Scheme
	GOLDEN_YELLOW = new Color (255, 226, 5),
	LIME_GREEN = new Color (222, 255, 5),
	AQUA = new Color (5, 255, 180);

    final static Color[] coolColorList = {
	MIDNIGHT_BLUE,
	YALE_BLUE,
	AERO_BLUE
	};

    final static Color[] warmColorList = {
	SALSA_RED,
	TULIP_PURPLE,
	FLAME_ORANGE
	};

    final static Color[] energyColorList = {
	GOLDEN_YELLOW,
	LIME_GREEN,
	AQUA
	};

    final static Font
	TITLE_FONT = new Font ("Georgia", Font.PLAIN, 50),
	HEADING_FONT = new Font ("Georgia", Font.PLAIN, 30),
	REGULAR_FONT = new Font ("Georgia", Font.ITALIC, 20);
}
