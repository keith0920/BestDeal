package entity;

import java.util.HashMap;

public class Console implements java.io.Serializable{
    public String id;
    public String name;
    public double price;
    public String retailer;
    public String condition;
   // private double discount;
    public String category;

    public Console(String name, double price, String retailer, String condition, double discount, String category){
        this.name=name;
        this.price=price;
        this.retailer = retailer;
        this.condition=condition;
        //this.discount = discount;
        this.category=category;
    }


    public Console(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getRetailer() {
        return retailer;
    }
    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

//   // public double getDiscount() {
//        return discount;
//    }
//
//    public void setDiscount(double discount) {
//        this.discount = discount;
//    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
