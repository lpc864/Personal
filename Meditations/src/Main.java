import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
	
	public static void main (String[] args) {
		
		//This was the previous main. I have improved it
		
		/**
		 * Java provide us a class we can use to create frames
		 */
		JFrame frame = new JFrame();
		
		
		/**
		 * Java provide us a class we can use to work with images
		 * ImagenIcon class inherits from Imagen class which is an abstract class
		 * ImagenIcon defines the abstracts methods inherits from Imagen class to use an imag as an icon
		 */
		ImageIcon image = new ImageIcon("MarcoAurelio.jpg");
		
		/**
		 * Make frame visible
		 */
		frame.setVisible(true); 
		
		/**
		 * Sets the x-dimension, and y dimension
		 */
		frame.setSize(629,629); 
		
		/**
		 * Put the frame in the center of the window
		 */
		frame.setLocationRelativeTo(null);
		
		/**
		 * Sets title of frame
		 */
		frame.setTitle("Meditations"); 
		
		/*
		 * The following method is used to finish the app after closing
		 * the window. Otherwise, the app may be running in the background.
		 * It is not necessary to use it, but it is a good practice
		 */
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		/**
		 * Make the frame resizable
		 */
		frame.setResizable(false); 
		
		/**
		 * Change icon of frame
		 */
		frame.setIconImage(image.getImage());
		
		/**
		 * In Java Swing, a JFrame typically has 
		 * two containers: the content pane and the layered pane.
		 * 
		 * The content pane is the main container where components
		 * are added to create the user interface of the application, 
		 * and it can be accessed using the getContentPanel() method.
		 * 
		 * The layered panes that manages a set of panes, or layers, 
		 * that can be stacked on top of each other. The layered pane allows 
		 * different graphical elements to overlap (appear on top of each other) 
		 * in the same application window.
		 * 
		 * For more information: https://docs.google.com/document/d/1WRMYS7TwSVpD72P9MRyHsJ-fdbtHl3C6Acd5Vwwsbos/edit?usp=share_link
		 */
		frame.getContentPane().setBackground(new Color(119, 221, 119));
	
	}
}
