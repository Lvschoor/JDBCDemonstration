package model;

public class Beer {
    private int id;
    private String name;
    private int brewerId;
    private int categoryId;
    private double price;
    private int stock;
    private int alcohol;

    public Beer() {
    }

    public Beer(int id, String name, int brewerId, int categoryId, double price, int stock, int alcohol) {
        this.id = id;
        this.name = name;
        this.brewerId = brewerId;
        this.categoryId = categoryId;
        this.price = price;
        this.stock = stock;
        this.alcohol = alcohol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrewerId() {
        return brewerId;
    }

    public void setBrewerId(int brewerId) {
        this.brewerId = brewerId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brewerId=" + brewerId +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", stock=" + stock +
                ", alcohol=" + alcohol +
                '}';
    }
}