package src;

import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Set;

public class OrderDaoImplTest {

    private OrderDao orderDao;
    private MenuItemDao menuItemDao;
    /*
    @BeforeEach
    void setUp() {
        orderDao = new OrderDaoImpl();
        menuItemDao = new MenuItemDaoImpl();
    }

     */
    @Test
    void testGetOrderById() {
        orderDao = new OrderDaoImpl();
        // Assuming order_id 1 exists in the database
        Order order = orderDao.getOrderById(1);
        assertNotNull(order);
        assertNotNull(order.getMenuItem());
        assertNotNull(order.getOrderTime());
    }

    @Test
    void testGetAllOrders() {
        orderDao = new OrderDaoImpl();
        Set<Order> orders = orderDao.getAllOrders();
        assertNotNull(orders);
        assertTrue(orders.size() > 0);
    }

    @Test
    void testInsertOrder() {
        orderDao = new OrderDaoImpl();
        menuItemDao = new MenuItemDaoImpl();
        // Assuming there is an existing menu item with item_id 20
        MenuItem menuItem = menuItemDao.getMenuItemById(20);
        assertNotNull(menuItem);

        // Create a new order
        Order newOrder = new Order(150, menuItem, 2, LocalDateTime.now());
        Order insertedOrder = orderDao.insertOrder(newOrder);

        assertNotNull(insertedOrder);
        assertNotNull(insertedOrder.getOrderId()); // Assuming auto-generated ID
        assertEquals(newOrder.getMenuItem().getItemId(), insertedOrder.getMenuItem().getItemId());
        assertEquals(newOrder.getQuantity(), insertedOrder.getQuantity());

    }


    @Test
    void testUpdateOrder() {
        orderDao = new OrderDaoImpl();
        // Assuming there is an existing order with order_id 2
        Order existingOrder = orderDao.getOrderById(2);
        assertNotNull(existingOrder);

        // Update the order's quantity
        existingOrder.setQuantity(7);

        boolean updateResult = orderDao.updateOrder(existingOrder);
        assertTrue(updateResult);

        // Check if the order is updated successfully
        Order updatedOrder = orderDao.getOrderById(2);
        assertNotNull(updatedOrder);
        assertEquals(existingOrder.getQuantity(), updatedOrder.getQuantity());

        // Clean up: Revert the changes
        existingOrder.setQuantity(3);
        orderDao.updateOrder(existingOrder);
    }

    @Test
    void testDeleteOrder() {
        orderDao = new OrderDaoImpl();
        // Assuming there is an existing order with order_id 5
        boolean deleteResult = orderDao.deleteOrder(5);
        assertTrue(deleteResult);

        // Check if the order is deleted successfully
        Order deletedOrder = orderDao.getOrderById(5);
        assertNull(deletedOrder);
    }


}
