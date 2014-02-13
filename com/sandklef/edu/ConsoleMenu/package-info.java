/**
 * Simple package to ease up console menus
 *
 * The main purpose is, rather than easing up writing a console menu,
 * to show the use of Interfaces. In the examples we show how to
 * create and add MenuItem classes and also how to add anonymous
 * classes/objects.
 * 
 * ConsoleMenu supports sub menu. Simply add a ConsoleMenu to another
 * ConsoleMenu using the addMenuItem method
 *
 * You can either extend the ConsoleMenu class or create an object
 * from it, just as you can with JPanel.
 * 
 *
 * <br>
 * <br>
 * <hr>
 * <br>
 * <h2>Creating ConsoleMenu object to use as a menu</h2>  
 * <br>
 * <h3>Example with anonymous class:</h3>  
 * <pre>
 * <code>
 * 
 *   ConsoleMenu menu = new ConsoleMenu("-= MenuExample =-");
 *   menu.addMenuItem(new MenuItem(){
 *                    public void menuItemSelected() {
 *                           System.out.println(" removeMember() code"); }
 *                    },"Remove member" );
 *
 *   menu.run();
 *
 * </code>
 * </pre>
 *
 *
 * <h3>Example with separate class:</h3>  
 * <pre>
 * <code>
 * import com.sandklef.edu.ConsoleMenu.MenuItem;
 * 
 * public class RemoveMenu implements MenuItem {
 *
 *   public void menuItemSelected() {
 *	System.out.println("remove selected");
 *   }
 * }
 * 
 * </code>
 * </pre>
 * 
 * <h3>.... and the coresponding code to create and run the menu. </h3>
 *
 * <pre>
 * <code>
 *   ConsoleMenu menu = new ConsoleMenu("-= MenuExample =-");
 *   RemoveMenu remove = new RemoveMenu();
 *   menu.addMenuItem(remove, "Remove member" );
 *   menu.run();
 * </code>
 * </pre>
 *
 *
 * <br>
 * <br>
 * <hr>
 * <br>
 * <h2>Extending your class to use the menu.</h2>  
 * <br>
 * <pre>
 * <code>
 * import com.sandklef.edu.ConsoleMenu.*;
 * public class MenuExtendedExample extends ConsoleMenu {
 *
 *    public void createMenu() {
 *	setMenuTitle ("-= MenuExample =-");
 *	addMenuItem(new MenuItem(){
 *		public void menuItemSelected() 
 *		{ System.out.println("Buy Mudhoney records") ; } },
 *		    "Mudhoney" );
 *	addMenuItem(new MenuItem(){
 *		public void menuItemSelected() 
 *		{ System.out.println("Buy Mule records") ; } },
 *	    "Mule" );
 *	addMenuItem(new MenuItem(){
 *		public void menuItemSelected() 
 *		{ System.out.println("Buy Will Oldham records") ; } },
 *	    "Will" );
 *	
 *	run();
 *    }
 *
 *    public static void main(String args[]) {
 *	MenuExtendedExample me = new MenuExtendedExample();
 *	me.createMenu();
 *    }
 *    
 *}
 * </code>
 * </pre>
 *
 * <br>
 * <br>
 * <hr>
 * <br>
 * <h2>The last example will look like this when executed </h2>  
 * <br>
 * <pre>
 * <code>
 *-= MenuExample =-
 *=============
 *0.  Mudhoney
 *1.  Mule
 *2.  Will
 *3.  Exit menu
 *> 
 * </code>
 * </pre>
 *
 *
 * See package com.sandklef.edu.examples for examples on how to use it.
 */

package com.sandklef.edu.ConsoleMenu;
