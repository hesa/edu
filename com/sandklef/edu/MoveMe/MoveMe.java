package com.sandklef.edu.MoveMe;


public class MoveMe  {

    
    public static void createGui() {
	MoveMeControl m = new MoveMeControl(600,500, 5, 5);
    }

    public static void main(String args[]) {
	
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		    createGui();
		}
	    });
    }

}