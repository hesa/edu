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

package com.sandklef.edu.Examples.ConsoleMenu;

import com.sandklef.edu.ConsoleMenu.*;

public class SubMenuExample {

    public static void main(String args[]) {
	/* 
	 * Top menu
	 *
	 */

	ConsoleMenu menu = new ConsoleMenu("-= Member management =-");



	/*
	 * Sub menu: List Members
	 *
	*/
	ConsoleMenu listMenu = new ConsoleMenu("List members");

	listMenu.addMenuItem(new MenuItem(){
                             public void menuItemSelected() { 
				 System.out.println(" -- listing Player...."); } 
			 },"Players" );
	listMenu.addMenuItem(new MenuItem(){
                             public void menuItemSelected() { 
				 System.out.println(" -- listing parents..."); } 
			 },"Parents" );
	listMenu.addMenuItem(new MenuItem(){
                             public void menuItemSelected() { 
				 System.out.println(" -- listing coaches..."); } 
			 },"Coaches" );

	// Add listMenu to top menu
	menu.addMenuItem(listMenu,"List members (--->)" );

	// Add remove menu item to top menu
	menu.addMenuItem(new MenuItem(){
                             public void menuItemSelected() { 
				 System.out.println(" removeMember() code"); } 
			 },"Remove member" );

	// Display the menu
	menu.run();
    }

}