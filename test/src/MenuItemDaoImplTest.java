package src;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Set;

public class MenuItemDaoImplTest {

    private MenuItemDao menuItemDao;

    @BeforeEach
    void setUp() {
        menuItemDao = new MenuItemDaoImpl();
    }
/*
    @Test
    void testGetMenuItemById() {
        // Assuming item_id 6 exists in the database
        MenuItem menuItem = menuItemDao.getMenuItemById(6);
        assertNotNull(menuItem);
        assertEquals("Beacon Cheese Burger", menuItem.getName());
    }

    @Test
    void testGetMenuItemByName() {
        // Assuming there is an item with the name "Sample Item" in the database
        MenuItem menuItem = menuItemDao.getMenuItemByName("Seafood Pasta");
        assertNotNull(menuItem);
        assertEquals(7, menuItem.getItemId());
    }

    @Test
    void testGetAllMenuItems() {
        Set<MenuItem> menuItems = menuItemDao.getAllMenuItems();
        assertNotNull(menuItems);
        assertTrue(menuItems.size() > 0);
    }

    @Test
    void testInsertMenuItem() {
        MenuItem newItem = new MenuItem("New Item", new BigDecimal("5.00"));
        MenuItem insertedItem = menuItemDao.insertMenuItem(newItem);

        assertNotNull(insertedItem);
        assertNotNull(insertedItem.getItemId());    // Assuming auto-generated ID
        assertEquals(newItem.getName(), insertedItem.getName());
        assertEquals(newItem.getPrice(), insertedItem.getPrice());

        // Clean up: Delete the inserted item
        boolean deleteResult = menuItemDao.deleteMenuItem(insertedItem.getItemId());
        assertTrue(deleteResult);
    }
*/

    @Test
    void testUpdateMenuItem() {
        // Assuming there is an item with item_id 16 in the database
        MenuItem existingItem = menuItemDao.getMenuItemById(16);
        assertNotNull(existingItem);

        // Update the item's name and price
        existingItem.setName("Updated Item");
        existingItem.setPrice(new BigDecimal("10.00"));

        boolean updateResult = menuItemDao.updateMenuItem(existingItem);
        assertTrue(updateResult);

        // Check if the item is updated successfully
        MenuItem updatedItem = menuItemDao.getMenuItemById(16);
        assertNotNull(updatedItem);
        assertEquals(existingItem.getName(), updatedItem.getName());
        assertEquals(existingItem.getPrice(), updatedItem.getPrice());

        // Clean up: Revert the changes
        existingItem.setName("Seafood Pasta");
        existingItem.setPrice(new BigDecimal("20.00"));
        menuItemDao.updateMenuItem(existingItem);
    }

    @Test
    void testDeleteMenuItem() {
        // Assuming there is an item with item_id 21 in the database
        boolean deleteResult = menuItemDao.deleteMenuItem(21);
        assertTrue(deleteResult);

        // Check if the item is deleted successfully
        MenuItem deletedItem = menuItemDao.getMenuItemById(21);
        assertNull(deletedItem);
    }




}
