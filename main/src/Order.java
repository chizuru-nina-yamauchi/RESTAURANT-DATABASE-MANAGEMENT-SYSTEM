package src;

import java.time.LocalDateTime;

public class Order {
    // Attributes
    private Integer orderId;
    private MenuItem menuItem; // This is a reference to the MenuItem class
    private Integer quantity;
    private LocalDateTime orderTime;

    // Constructor with all attributes
    public Order(Integer orderId, MenuItem menuItem, Integer quantity, LocalDateTime orderTime) {
        this.orderId = orderId;
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.orderTime = orderTime;
    }

    // Constructor without id
    public Order(MenuItem menuItem, Integer quantity, LocalDateTime orderTime) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.orderTime = orderTime;
    }

    // Default constructor
    public Order() {
    }

    // Getters and setters

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    // toString method

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", menuItem=" + menuItem +
                ", quantity=" + quantity +
                ", orderTime=" + orderTime +
                '}';
    }




}
