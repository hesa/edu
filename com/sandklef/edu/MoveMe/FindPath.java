package com.sandklef.edu.MoveMe;

import java.util.ArrayList;
import java.util.Random;

public class FindPath {

    private static Random rand;

    private static int calls=0;

    private static final int DIR_LEFT  = 0 ;
    private static final int DIR_UP    = 1 ;
    private static final int DIR_DOWN  = 2 ;
    private static final int DIR_RIGHT = 3 ;

    private static boolean beenHere[][]=null;
    private static boolean path[][];


    public static void initRand() {
	if (rand==null) {
	    rand = new Random();
	}
    }
    
    public static void initArray(Field f) {
	beenHere = new boolean[f.getCols()][f.getRows()];
	path     = new boolean[f.getCols()][f.getRows()];

	calls=0;

	for (int i=0;i<f.getCols();i++) {
	    for (int j=0;j<f.getRows();j++) {
		beenHere[i][j]=false;
		path[i][j]=false;
	    }
	}
	    
	    

    }
    
    public static void waitAWhile(int del) {
	try {
	    Thread.sleep(del);
	} catch (InterruptedException e) {
	    System.out.println("waitAWhile() - exception\n");
	}
    }

    
    public static void printStart(int depth) {
	for (int i=0;i<depth;i++) {
	    System.out.print(" ");
	}
    }

    public static boolean[][] getPath() {
	return path;
    }

    public static boolean getRecursivePath(Field f, 
					   Point point, 
					   int depth) {
	
	// System.out.println("waitAWhile() - \n");
	// waitAWhile(1000);
	// System.out.println("waitAWhile() - done\n");

	//	printStart(depth++);

	System.out.println("recursive: " + 
			   point + " " + 
			   f.isBarrier(point));

	if (calls++>10000) {
	    System.out.println(" calls end");
	    return true;
	}


	
	if (point==null) {
	    System.out.println(" point null");
	    return false;
	}

	if ( point.equals(f.getStop()) ) {
	    System.out.println(" ======================= End :) " + calls);
	    return true;
	}

	if ( f.isBarrier(point) || 
	     f.isWall(point) || 
	     beenHere[point.getCol()][point.getRow()]) {

	    System.out.println(" <===  barrier || been here: " +
			       f.isBarrier(point) + " " +
			       f.isWall(point)    + " " );

	    return false;
	}

	f.markPointPath(point, "" + calls);

	beenHere[point.getCol()][point.getRow()]=true;
	    
	if (getRecursivePath(f, f.getLeft(point), depth)) { 
	    System.out.println(" --> left");
	    path[point.getCol()][point.getRow()] = true; 
	    return true;
	}
	if (getRecursivePath(f, f.getUp(point), depth)) { 
	    System.out.println(" --> up ");
	    path[point.getCol()][point.getRow()] = true; 
	    return true;
	}
	if (getRecursivePath(f, f.getRight(point), depth)) { 
	    System.out.println(" --> right");
	    path[point.getCol()][point.getRow()] = true; 
	    return true;
	}
	if (getRecursivePath(f, f.getDown(point), depth)) { 
	    System.out.println(" --> down");
	    path[point.getCol()][point.getRow()] = true; 
	    return true;
	}



	return false;
    }


    public static ArrayList getRandomMousePath(Field f, 
					       Point startPoint, 
					       int currentDir) {
	initRand();

	ArrayList<Point> path = new ArrayList<Point>();
	

	f.markPointPath(startPoint, "");

	Point nextPoint = null;
	if (currentDir==DIR_LEFT) {
	    nextPoint = f.getLeft(startPoint);
	} else if (currentDir==DIR_UP) {
	    nextPoint = f.getUp(startPoint);
	} else if (currentDir==DIR_DOWN) {
	    nextPoint = f.getDown(startPoint);
	} else if (currentDir==DIR_RIGHT) {
	    nextPoint = f.getRight(startPoint);
	} else {
	    System.out.println("DIR: " + currentDir);
	    System.exit(0);
	}


	System.out.println("Start: " + startPoint + "  dir: " + currentDir + "  np: " + nextPoint);

	if ( (nextPoint==null) || f.isBarrier(nextPoint)  ) {
	    int dir = currentDir;
	    while (dir == currentDir ) {
		dir = rand.nextInt(3);
	    }
	    getRandomMousePath(f, 
			       startPoint, 
			       dir);
	} else {
	    getRandomMousePath(f, 
			       nextPoint, 
			       currentDir);
	}
	return null;
    }
    

}