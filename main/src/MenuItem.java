package src;

import java.math.BigDecimal;

public class MenuItem {
    // Attributes
    private Integer itemId;
    private String name;
    private BigDecimal price;

    // Constructor with all attributes
    public MenuItem(Integer itemId, String name, BigDecimal price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    // Constructor without id
    public MenuItem(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    // Default constructor
    public MenuItem() {
    }

    // Getters and setters
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // toString method

    @Override
    public String toString() {
        return "MenuItem{" +
                "itemId=" + itemId +
                ", name=" + name +
                ", price=" + price +
                '}';
    }

}
