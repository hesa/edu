package com.sandklef.edu.MoveMe;

import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;


import com.sandklef.edu.MoveMe.Box;

public class Field extends JPanel {
    
    private Random rand ;

    private Box boxes[][];
    private int xSize;
    private int ySize;

    private int rows ;
    private int cols ;


    /**
     *
     * Creates a Field 
     *
     * @param xSize Size of the field - horizontal
     * @param ySize Size of the field - vertical
     *
     */
    public Field(int xSize, int ySize, int cols, int rows) {

	rand = new Random();

	this.rows=rows;
	this.cols=cols;
	this.xSize = xSize ;
	this.ySize = ySize ;

	boxes = new Box[cols][rows];
	setLayout(new GridLayout(cols,rows));

	for (int i=0;i<rows;i++) {
	    for (int j=0;j<cols;j++) {
		Box tmp = new Box(xSize/cols,ySize/rows);
		add(tmp);

		// j=cols, i=rows
		boxes[j][i]=tmp;
	    } 
	}
	int startPosX =  1 + rand.nextInt(cols-2) ;
	int stopPosX =  1 + rand.nextInt(cols-2) ;
	
	//	pack();
	setVisible(true);
	setMinimumSize(new Dimension(ySize, xSize));

	createRandomBarriers((cols+rows));

	System.out.println("Start: " + startPosX + " - " + stopPosX);
	boxes[startPosX][0].setStart();
	boxes[stopPosX][rows-1].setStop();

    }


    public void createRandomBarriers(int nr) {
	for (int i=0;i<nr/2;i++) {
	    createRandomBarrierCol(cols/2);
	}

	for (int i=0;i<nr/2;i++) {
	    createRandomBarrierRow(cols/2);
	}
    }

    public void createRandomBarrier() {
	int row = rand.nextInt(rows);
	int col = rand.nextInt(cols);

	boxes[row][col].setBarrier();
    }

    public void createRandomBarrierCol(int size) {
	int col = 1 + rand.nextInt(cols-1);
	int row = 1 + rand.nextInt(rows-size-2);

	for (int i=row;i<size;i++) {
	    boxes[i][col].setBarrier();
	}
    }

    public void createRandomBarrierRow(int size) {
	int col = 1 + rand.nextInt(cols-size-1);
	int row = 1 + rand.nextInt(rows-1);

	for (int i=col;i<size;i++) {
	    boxes[row][i].setBarrier();
	}
    }

    

}
