/**
 *
 * Interface used in ConsoleMenu. Classes implementing this interface can be added as items to consolemenu.
 *
 */
package com.sandklef.edu.ConsoleMenu;

public interface MenuItem {

    /**
     *
     * This method is invoked by ConsoleMenu when the item is selected
     *
     */
    public void menuItemSelected();

}