package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
/*
*  This is the implementation of the MenuItemDao class, used to interact with the database.
*
* */
public class MenuItemDaoImpl implements MenuItemDao{
    /*
    * Get a connection to the database
    * Prepare a statement
    * Set the parameter
    * Execute the query
    * Extract the data from the result set
    * Return the menu item
    * Return null if the menu item is not found
    * */

    @Override
    public MenuItem getMenuItemById(Integer menuId){
        try(
                // Get a connection to the database
                Connection conn = ConnectionFactory.getConnection();
                // Prepare a statement
                PreparedStatement ps = conn.prepareStatement(SqlQuery.GET_MENU_ITEM_BY_ITEM_ID.getQuery())
                ){
            // Set the parameter
            ps.setInt(1, menuId);
            // Execute the query
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                // Extract the data from the result set
                return extractMenuItemFromResultSet(rs);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public MenuItem getMenuItemByName(String menuItemName){
        try(
                // Get a connection to the database
                Connection conn = ConnectionFactory.getConnection();
                // Prepare a statement
                PreparedStatement ps = conn.prepareStatement(SqlQuery.GET_MENU_ITEM_BY_NAME.getQuery())
                ){
            // Set the parameter
            ps.setString(1, menuItemName);
            // Execute the query
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                // Extract the data from the result set
                return extractMenuItemFromResultSet(rs);
            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * Use Set to store the menu items
    * Get a connection to the database
    * Prepare a statement
    * Execute the query
    * Extract the data from the result set
    * Return the menu items
    * */
    @Override
    public Set<MenuItem> getAllMenuItems(){
        Set<MenuItem> menuItems = new HashSet<>();
        try(
                // Get a connection to the database
                Connection conn = ConnectionFactory.getConnection();
                // Prepare a statement
                PreparedStatement ps = conn.prepareStatement(SqlQuery.GET_ALL_MENU_ITEMS.getQuery())
                ){
            // Execute the query
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                // Extract the data from the result set
                menuItems.add(extractMenuItemFromResultSet(rs));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return menuItems;
    }
    /*
    * Get a connection to the database
    * Prepare a statement
    * Set the parameters
    * Execute the query
    * Check if the insert operation was successful
    * Return the menu item
    * Return null if the insert operation failed
    * */
    @Override
    public MenuItem insertMenuItem(MenuItem menuItem){
        try(
                // Get a connection to the database
                Connection conn = ConnectionFactory.getConnection();
                // Prepare a statement
                PreparedStatement ps = conn.prepareStatement(SqlQuery.INSERT_MENU_ITEM.getQuery())
                ){
            // Set the parameters
            ps.setString(1, menuItem.getName());
            ps.setBigDecimal(2, menuItem.getPrice());
            // Execute the query
            int affectedRows = ps.executeUpdate();
            // Check if the insert operation was successful
            if(affectedRows > 0){
                return getMenuItemByName(menuItem.getName());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        // Return null if the insert operation failed
        return null;
    }

    /*
    *  Get a connection to the database
    * Prepare a statement
    * Set the parameters
    * Execute the query
    * Check if the update operation was successful
    * Return true if the update operation was successful
    * Return false if the update operation failed
    * */

    @Override
    public boolean updateMenuItem(MenuItem menuItem){
        try(
                // Get a connection to the database
                Connection conn = ConnectionFactory.getConnection();
                // Prepare a statement
                PreparedStatement ps = conn.prepareStatement(SqlQuery.UPDATE_MENU_ITEM.getQuery())
                ){
            // Set the parameters
            ps.setString(1, menuItem.getName());
            ps.setBigDecimal(2, menuItem.getPrice());
            ps.setInt(3, menuItem.getItemId());
            // Execute the query
            int affectedRows = ps.executeUpdate();
            // Check if the update operation was successful
            if(affectedRows > 0){
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /*
    * Get a connection to the database
    * Prepare a statement
    * Set the parameter
    * Execute the query
    * Check if the delete operation was successful
    * Return true if the delete operation was successful
    * Return false if the delete operation failed
    * */
    @Override
    public boolean deleteMenuItem(Integer menuId){
        try(
                // Get a connection to the database
                Connection conn = ConnectionFactory.getConnection();
                // Prepare a statement
                PreparedStatement ps = conn.prepareStatement(SqlQuery.DELETE_MENU_ITEM.getQuery())
                ){
            // Set the parameter
            ps.setInt(1, menuId);
            // Execute the query
            int affectedRows = ps.executeUpdate();
            // Check if the delete operation was successful
            if(affectedRows > 0){
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    /*
    *  Extract the menu item from the result set
    *  Return the menu item
    * */
    private MenuItem extractMenuItemFromResultSet(ResultSet rs) throws Exception{
        MenuItem menuItem = new MenuItem();
        menuItem.setItemId(rs.getInt("item_id"));
        menuItem.setName(rs.getString("name"));
        menuItem.setPrice(rs.getBigDecimal("price"));
        return menuItem;
    }


}
