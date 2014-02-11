/*
 *                                                                   
 *         Educational software
 *                      
 *   Copyright (C) 2014 Henrik Sandklef 
 *                                                                   
 * This program is free software; you can redistribute it and/or     
 * modify it under the terms of the GNU General Public License       
 * as published by the Free Software Foundation; either version 3    
 * of the License, or any later version.                             
 *                                                                   
 *                                                                   
 * This program is distributed in the hope that it will be useful,   
 * but WITHOUT ANY WARRANTY; without even the implied warranty of    
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the     
 * GNU General Public License for more details.                      
 *                                                                   
 * You should have received a copy of the GNU General Public License 
 * along with this program; if not, write to the Free Software       
 * Foundation, Inc., 51 Franklin Street, Boston,            
 * MA  02110-1301, USA.                                              
 ****/

/**
 *
 * Simple class to ease up console menus
 *
 */
package com.sandklef.edu.ConsoleMenu;

import java.util.ArrayList;
import java.util.Scanner; 

public class ConsoleMenu {

    private String title;
    private ArrayList<InternalMenuItem> menuItems;
    boolean debugMode = false;

    class InternalMenuItem {
	MenuItem m;
	String title;

	InternalMenuItem(String title, MenuItem m) {
	    this.m     = m;
	    this.title = title;
	}

	public String getTitle() {
	    return this.title;
	}

	public MenuItem getMenuItem() {
	    return this.m;
	}
    }



    /**
     *
     * Constructs a Constructs with default Menu title: "ConsoleMenu"
     *
     */
    public ConsoleMenu() {
	title = "ConsoleMenu";
	menuItems = new ArrayList<InternalMenuItem>();
	debugMode = false;
    }

    /**
     *
     * Constructs a Constructs with title as given by user
     *
     * @param s Title for ConsoleMenu
     */
    public ConsoleMenu(String s) {
	this();
	setMenuTitle(s);
    }

    /**
     *
     * Sets the title of the ConsoleMenu
     *
     * @param s Title for ConsoleMenu
     */
    public void setMenuTitle(String s) {
	title = s;
    }

    private void debug(String s) {
	if (debugMode) {
	    System.out.println(s);
	}
    }

    public void setDebug() {
	debugMode = true;
    }

    public void unSetDebug() {
	debugMode = false;
    }


    /**
     *
     * Displays the menu containing all menu items added by user.  An
     * extra menu item is added at the end which provides a way to
     * exit the ConsoleMenu
     *
     * The menu loops intil exit is chosen.
     *
     */
    public void run() {
	while (true) {
	    System.out.println(title);
	    System.out.println("=============");
	    int i=0;
	    for (i=0; i<menuItems.size(); i++) {
		System.out.println(i + ".  " + 
				   menuItems.get(i).getTitle());
	    }
	    System.out.println(i + ".  Exit menu");
	    
	    System.out.print("> ");
	    Scanner userInput = new Scanner(System.in);
	    String choice = userInput.nextLine();
	    
	    int index = Integer.parseInt(choice);
	    if ( index >= 0 && index < menuItems.size() ) {
		menuItems.get(index).getMenuItem().menuItemSelected();
	    } else if ( index == menuItems.size() ) {
		return;
	    } else {
		System.out.println("Invalid input (\"" +  choice +"\")");
	    }
	}
    }

    /**
     *
     *@param m - menutiem containing the code to perform when chosen
     *@param s - title for the menu item
     *
     */
    public void addMenuItem(MenuItem m, String s) {
	debug("Adding MenuItem: \"" + " \"" + s + "\" ");
	menuItems.add(new InternalMenuItem(s, m));
    }

}