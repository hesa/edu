package com.sandklef.edu.MoveMe;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;


public class Box extends JLabel {

    private int width;
    private int height;

    private boolean barrier;
    private boolean stop;
    private boolean start;

    public Box (int width, int height) {
	super("  ");
	this.width = width;
	this.height = height;

	setOpaque(true);
	setVisible(true);
	setBorder(BorderFactory.createLineBorder(Color.black));

    }

    public Box (int size) {
	this(size, size);
    }

    public void setBarrier() {
	setBackground(Color.RED);
	setText("");
	barrier=true;
    }

    public void unSetBarrier() {
	setBackground(Color.WHITE);
	barrier=false;
    }

    public boolean isBarrier() {
	return barrier;
    }

    public void setStart() {
	setBackground(Color.GREEN);
	barrier=false;
	start=true;
	setText("Start");
    }

    public void setStop() {
	setBackground(Color.YELLOW);
	setText("Goal");
	barrier=false;
	stop=true;
    }

    public void haveSetFoot() {
	setBackground(Color.LIGHT_GRAY);
    }

}