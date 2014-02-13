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

public class MenuExample {

    public static void main(String args[]) {
	ConsoleMenu menu = new ConsoleMenu("-= MenuExample =-");

	Menu1 m1 = new Menu1();

	menu.addMenuItem(m1, "Add Member");
	menu.addMenuItem(new MenuItem(){
                             public void menuItemSelected() { 
				 System.out.println(" removeMember() code"); } 
			 },"Remove member" );

	menu.run();
    }

}