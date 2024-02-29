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
        /*
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
        */

        /*
        boolean deleted = menuItemDao.deleteMenuItem(1);
        if (deleted) {
            System.out.println("Menu item deleted");
        } else {
            System.out.println("Menu item not deleted");
        }

        boolean deleted2 = menuItemDao.deleteMenuItem(3);
        if (deleted) {
            System.out.println("Menu item deleted");
        } else {
            System.out.println("Menu item not deleted");
        }

        boolean deleted3 = menuItemDao.deleteMenuItem(4);
        if (deleted) {
            System.out.println("Menu item deleted");
        } else {
            System.out.println("Menu item not deleted");
        }

        boolean deleted4 = menuItemDao.deleteMenuItem(5);
        if (deleted) {
            System.out.println("Menu item deleted");
        } else {
            System.out.println("Menu item not deleted");
        }

        */


        MenuItem beaconCheeseBurger = new MenuItem("Beacon Cheese Burger", new BigDecimal("15.0"));
        beaconCheeseBurger = menuItemDao.insertMenuItem(beaconCheeseBurger);
        if (beaconCheeseBurger != null){
            System.out.println("Inserted menu item: " + beaconCheeseBurger);
        }

        MenuItem seafoodPasta = new MenuItem("Seafood Pasta", new BigDecimal("20.0"));
        seafoodPasta = menuItemDao.insertMenuItem(seafoodPasta);
        if (seafoodPasta != null){
            System.out.println("Inserted menu item: " + seafoodPasta);
        }

        MenuItem chickenCaesarSalad = new MenuItem("Chicken Caesar Salad", new BigDecimal("18.0"));
        chickenCaesarSalad = menuItemDao.insertMenuItem(chickenCaesarSalad);
        if (chickenCaesarSalad != null){
            System.out.println("Inserted menu item: " + chickenCaesarSalad);
        }


        // Insert a new order
        System.out.println("Insert a new order");
        Order order1 = new Order();

        order1.setMenuItem(beaconCheeseBurger);
        order1.setQuantity(2);
        order1.setOrderTime(java.time.LocalDateTime.now());

        order1 = orderDao.insertOrder(order1);

        if (order1 != null) {
            System.out.println("Order1: " + order1);
        }

        Order order2 = new Order(seafoodPasta, 1, java.time.LocalDateTime.now());

        /*
        order2.setMenuItem(seafoodPasta);
        order2.setQuantity(1);
        order2.setOrderTime(java.time.LocalDateTime.now());

         */

        order2 = orderDao.insertOrder(order2);

        if (order2 != null) {
            System.out.println("Order2: " + order2);
        }

        Order order3 = new Order(chickenCaesarSalad, 3, java.time.LocalDateTime.now());
        /*
        order3.setMenuItem(chickenCaesarSalad);
        order3.setQuantity(3);
        order3.setOrderTime(java.time.LocalDateTime.now());
        */
        order3 = orderDao.insertOrder(order3);

        if (order3 != null) {
            System.out.println("Order3: " + order3);
        }

        // Get all orders
        System.out.println("Get all orders");

        Set<Order> orders = orderDao.getAllOrders();

        if (orders != null) {
            for (Order eachOrder : orders) {
                System.out.println(eachOrder);
            }
        } else {
            System.out.println("No orders found");
        }

        System.out.println();



    }

}
