package it.unicam.cs.ids.Model;

public class OrderItem {

    private String id;
    private String orderID;
    private String productID;
    public OrderItem(){

    }



    public String getID() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id='" + id + '\'' +
                ", orderID='" + orderID + '\'' +
                ", productID='" + productID + '\'' +
                '}';
    }
}
