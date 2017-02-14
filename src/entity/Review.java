package entity;
import java.io.Serializable;
import java.util.HashMap;

public class Review implements Serializable {

    String productname;
    String username;
    String producttype;
    String reviewrating;
    String reviewdate;
    String reviewtext;
    String zipcode;


    public Review(String productname, String username, String producttype, String reviewrating, String reviewdate, String reviewtext, String zipcode) {
        this.productname = productname;
        this.username = username;
        this.producttype = producttype;
        this.reviewrating = reviewrating;
        this.reviewdate = reviewdate;
        this.reviewtext = reviewdate;
        this.zipcode = zipcode;
    }

    public Review(String productName, String userName, String productType, String reviewRating, String reviewDate, String reviewText) {
    }

    public Review() {

    }

    public String getProductname() {
        return productname;
    }

    public String getUsername() {
        return username;
    }

    public String getProducttype() {
        return producttype;
    }

    public String getReviewrating() {
        return reviewrating;
    }

    public String getReviewdate() {
        return reviewdate;
    }

    public String getReviewtext() {
        return reviewtext;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
    public void setUsername(String username) {
        this.productname = username;
    }
    public void setProducttype(String producttypr) {
        this.productname = producttype;
    }
    public void setReviewrating(String reviewrating) {
        this.reviewrating = reviewrating;
    }
    public void setReviewdate(String reviewdate) {
        this.reviewdate = reviewdate;
    }
    public void setReviewtext(String reviewtext) { this.reviewtext = reviewtext;}
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }


}