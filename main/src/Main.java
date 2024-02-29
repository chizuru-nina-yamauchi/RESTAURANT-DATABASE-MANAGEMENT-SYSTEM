package src;

/*
*  1. instantiate the MenuItemDaoImpl and OrderDaoImpl classes in the Main class to interact with the database.
*  2. connect to the database using the connect() method.
*  3. use the methods from the MenuItemDaoImpl and OrderDaoImpl classes to interact with the database.
* */

import java.math.BigDecimal;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Instantiate the MenuItemDaoImpl and OrderDaoImpl classes
        MenuItemDaoImpl menuItemDao = new MenuItemDaoImpl();
        OrderDaoImpl orderDao = new OrderDaoImpl();

        // Print the connection status
        ConnectionFactory.printConnectionMessage();

        System.out.println();

        System.out.println("Insert a new menu item");
        // Insert a new menu item
        MenuItem cheeseBurger = new MenuItem("Cheese Burger", new BigDecimal("10.0"));
        MenuItem shrimpPasta = new MenuItem("Shrimp Pasta", new BigDecimal("15.0"));
        MenuItem chickenSalad = new MenuItem("Chicken Salad", new BigDecimal("12.0"));
        MenuItem salamiPizza = new MenuItem("Salami Pizza", new BigDecimal("13.0"));
        MenuItem margheritaPizza = new MenuItem("Margherita Pizza", new BigDecimal("12.0"));

        // Insert the menu items
        cheeseBurger = menuItemDao.insertMenuItem(cheeseBurger);
        if (cheeseBurger != null){
            System.out.println("Inserted menu item: " + cheeseBurger);
        }

        shrimpPasta = menuItemDao.insertMenuItem(shrimpPasta);
        if (shrimpPasta != null){
            System.out.println("Inserted menu item: " + shrimpPasta);
        }

        chickenSalad = menuItemDao.insertMenuItem(chickenSalad);
        if (chickenSalad != null){
            System.out.println("Inserted menu item: " + chickenSalad);
        }

        salamiPizza = menuItemDao.insertMenuItem(salamiPizza);
        if (salamiPizza != null){
            System.out.println("Inserted menu item: " + salamiPizza);
        }

        margheritaPizza = menuItemDao.insertMenuItem(margheritaPizza);
        if (margheritaPizza != null){
            System.out.println("Inserted menu item: " + margheritaPizza);
        }

        System.out.println();

        System.out.println("Get a menu item by id");
        // Get a menu item by id
        MenuItem menuItem_1 = menuItemDao.getMenuItemById(1);
        if (menuItem_1 != null) {
            System.out.println("Menu item: " + menuItem_1);
        } else {
            System.out.println("Menu item not found");
        }


        // Get all menu items
        System.out.println("Get all menu items");
        Set<MenuItem> menuItems = menuItemDao.getAllMenuItems();
        if (menuItems != null) {
            for (MenuItem menuItem : menuItems) {
                System.out.println(menuItem);
            }
        } else {
            System.out.println("No menu items found");
        }

        System.out.println();


        System.out.println("Update a menu item");
        // Update price for menu item id 1
        MenuItem updatedMenuItem = new MenuItem(1, "Cheese Burger", new BigDecimal("12.0"));
        boolean updated = menuItemDao.updateMenuItem(updatedMenuItem);
        if (updated) {
            System.out.println("Menu item updated: " + updatedMenuItem);
        } else {
            System.out.println("Menu item not updated");
        }

        System.out.println();

        System.out.println("Delete a menu item");
        // Delete menu item id 2
        boolean deleted = menuItemDao.deleteMenuItem(2);
        if (deleted) {
            System.out.println("Menu item deleted");
        } else {
            System.out.println("Menu item not deleted");
        }




    }

}
