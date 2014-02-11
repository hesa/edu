package com.sandklef.edu.Examples.ConsoleMenu;

import com.sandklef.edu.ConsoleMenu.*;

public class MenuExample {

    public static void main(String args[]) {
	ConsoleMenu menu = new ConsoleMenu("MenuExempel...tja");
	Menu1 m1 = new Menu1();

	menu.addMenuItem(m1, "Lägg till medlem");
	menu.addMenuItem(new MenuItem(){
                             public void menuItemSelected() { 
				 System.out.println("interna grejen....."); } 
			 },"En meny till" );

	System.out.println("Visar menyn...");
	menu.run();
	System.out.println("Menyn fardigvisad!!");
    }

}