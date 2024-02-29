package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OrderDaoImpl implements OrderDao{


    /*
    *  uses try-with-resources to ensure that the Connection and PreparedStatement are properly closed
    *  after use.
    *  prepares an SQL query using a constant SqlQuery.GET_ORDER_BY_ORDER_ID.getQuery()
    *  and sets parameters using the properties of the Order object.
    * */
    @Override
    public Order getOrderById(Integer orderId) {
        try(
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(SqlQuery.GET_ORDER_BY_ORDER_ID.getQuery())
                ){
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return extractOrderFromResultSet(rs);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /*
    *  Get a connection to the database
    * Prepare a statement
    * Execute the query
    * Extract the data from the result set
    * Add the order to the set
    * Return the orders
    *
    * */

    @Override
    public Set<Order> getAllOrders() {
        Set<Order> orders = new HashSet<>();
        try(
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(SqlQuery.GET_ALL_ORDERS.getQuery())
                ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(extractOrderFromResultSet(rs));
            }
        }catch (SQLException e){
                e.printStackTrace();
            }
        return orders;
    }

    /*
    *  Get a connection to the database
    * Prepare a statement
    * Set the parameters
    * Execute the query
    * Return the order
    *
    * */

    @Override
    public Order insertOrder(Order order) {

        try(
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(SqlQuery.INSERT_ORDER.getQuery())
                ){
            ps.setInt(1, order.getMenuItem().getItemId());
            ps.setInt(2, order.getQuantity());
            // Convert the LocalDateTime to a java.sql.Timestamp to be able to set it as a parameter
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(order.getOrderTime()));
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                    return order;
                }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /*
    * Get a connection to the database
    * Prepare a statement
    * Set the parameters
    * Execute the query
    * Check if the update operation was successful
    * Return true if the update operation was successful
    * Return false if the update operation failed
    * */

    @Override
    public boolean updateOrder(Order order) {
        try(
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(SqlQuery.UPDATE_ORDER.getQuery())
                ){
            ps.setInt(1, order.getMenuItem().getItemId());
            ps.setInt(2, order.getQuantity());
            // Convert the LocalDateTime to a java.sql.Timestamp to be able to set it as a parameter
            ps.setTimestamp(3, java.sql.Timestamp.valueOf(order.getOrderTime()));
            ps.setInt(4, order.getOrderId());
            int affectedRows = ps.executeUpdate();
            // if affectedRows > 0, then the update operation was successful
            if (affectedRows > 0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    /*
    * Get a connection to the database
    * Prepare a statement
    * Set the parameters
    * Execute the query
    * Check if the delete operation was successful
    * Return true if the delete operation was successful
    * Return false if the delete operation failed
    *
    * */
    @Override
    public boolean deleteOrder(Integer orderId) {
        try(
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(SqlQuery.DELETE_ORDER.getQuery())
                ){
            ps.setInt(1, orderId);
            int affectedRows = ps.executeUpdate();
            // if affectedRows > 0, then the delete operation was successful
            if (affectedRows > 0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    /*
    *  Extract the data from the result set
    *  Create a new order object
    *  Set the order id, menu item, quantity, and order time
    *  Return the order
    * */

    private Order extractOrderFromResultSet(ResultSet rs)  throws SQLException {
        Order order = new Order();
        order.setOrderId(rs.getInt("order_id"));
        order.setMenuItem(new MenuItemDaoImpl().getMenuItemById(rs.getInt("item_id")));
        order.setQuantity(rs.getInt("quantity"));
        order.setOrderTime(rs.getTimestamp("order_time").toLocalDateTime());
        return order;
    }

}
