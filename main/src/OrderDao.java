package src;

import java.util.Set;

/*
* This is the interface for the OrderDao class.
* This interface is used to define the methods that will be used in the OrderDaoImpl class.
*/


public interface OrderDao {
    Order getOrderById(Integer orderId);
    Order insertOrder(Order order);
    boolean deleteOrder(Integer orderId);
    boolean updateOrder(Order order);
    Set<Order> getAllOrders();

}
