package entity;
import java.io.Serializable;

public class Order implements Serializable {
    String mingzi;
    String orderid;
    double price;
    String first;
    String last;
    String address;


    public Order(String mingzi, String orderid, double price, String first, String last, String address) {
        this.mingzi = mingzi;
        this.orderid = orderid;
        this.price = price;
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public Order() {

    }


    public String getMingzi() {
        return mingzi;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getAddress() {
        return address;
    }

    public String getOrderid() {
        return orderid;
    }

    public double getPrice() {
        return price;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMingzi(String mingzi) {
        this.mingzi = mingzi;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
