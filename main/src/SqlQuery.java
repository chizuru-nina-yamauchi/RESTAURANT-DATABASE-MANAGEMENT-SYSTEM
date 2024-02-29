package src;

/*
*  Make an enum class called SqlQuery with the following constants:
* */

public enum SqlQuery {
    // Enum constants
    GET_MENU_ITEM_BY_ITEM_ID("SELECT * FROM menu_items WHERE item_id = ?"),
    GET_MENU_ITEM_BY_NAME("SELECT * FROM menu_items WHERE name = ?"),
    GET_ALL_MENU_ITEMS("SELECT * FROM menu_items"),
    INSERT_MENU_ITEM("INSERT INTO menu_items (name, price) VALUES (?, ?)"),
    UPDATE_MENU_ITEM("UPDATE menu_items SET name = ?, price = ? WHERE item_id = ?"),
    DELETE_MENU_ITEM("DELETE FROM menu_items WHERE item_id = ?"),
    GET_ORDER_BY_ORDER_ID("SELECT * FROM orders WHERE order_id = ?"),
    GET_ALL_ORDERS("SELECT * FROM orders"),
    INSERT_ORDER("INSERT INTO orders (item_id, quantity, order_time) VALUES (?, ?, ?)"),
    UPDATE_ORDER("UPDATE orders SET item_id = ?, quantity = ?, order_time = ? WHERE order_id = ?"),
    DELETE_ORDER("DELETE FROM orders WHERE order_id = ?");

    // Attribute
    private String query;

    // Constructor
    SqlQuery(String query) {
        this.query = query;
    }

    // Getter
    public String getQuery() {
        return query;
    }



}
