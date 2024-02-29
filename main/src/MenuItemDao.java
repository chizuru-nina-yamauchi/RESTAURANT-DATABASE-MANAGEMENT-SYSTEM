package src;

/*
*  This is the interface for the MenuItemDao class.
*  This interface is used to define the methods that will be used in the MenuItemDaoImpl class.
* */

import java.util.Set;

public interface MenuItemDao {
    MenuItem getMenuItemById(Integer menuId);
    MenuItem getMenuItemByName(String menuItemName);
    Set<MenuItem> getAllMenuItems();
    MenuItem insertMenuItem(MenuItem menuItem);
    boolean updateMenuItem(MenuItem menuItem);
    boolean deleteMenuItem(Integer menuId);
}
