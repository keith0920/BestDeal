import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.Document;
import entity.*;

import java.lang.reflect.Array;
import java.util.*;


public class MongoDBUtil {
    static MongoCollection myReviews;

    public static void getConnection() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("CustomerReview");
        myReviews = db.getCollection("myReviews");
        System.out.println("++++++c+++++++");
    }


    public static void insertReview(String productname, String username, String producttype, String reviewrating, String reviewdate, String reviewtext, String zipcode) {
        getConnection();
        Document doc = new Document("title", "myReviews").
                append("productName", productname).
                append("userName", username).
                append("productType", producttype).
                append("reviewRating", reviewrating).
                append("reviewDate", reviewdate).
                append("reviewText", reviewtext).
                append("zipcode", zipcode);
        myReviews.insertOne(doc);
    }

    public static HashMap<String, ArrayList<Review>> selectReview() {
        getConnection();
        FindIterable<Document> findIterable = myReviews.find();
        HashMap<String, ArrayList<Review>> reviewHashmap = new HashMap<String, ArrayList<Review>>();
        MongoCursor<Document> cursor = findIterable.iterator();
        while (cursor.hasNext()) {
            Document obj = cursor.next();
            if (!reviewHashmap.containsKey(obj.getString("productName"))) {
                ArrayList<Review> arr = new ArrayList<Review>();
                reviewHashmap.put(obj.getString("productName"), arr);
            }
            ArrayList<Review> listReview = reviewHashmap.get(obj.getString("productName"));
            Review review = new Review(obj.getString("productName"), obj.getString("userName"), obj.getString("productType"), obj.getString("reviewRating"), obj.getString("reviewDate"), obj.getString("reviewText"), obj.getString("zipcode"));
            listReview.add(review);
        }
        return reviewHashmap;
    }




    public static void main(String args[]){
        MongoDBUtil u =new MongoDBUtil();

        u.getConnection();
       u.insertReview("testname11","tester","testtype","testrating","testdate","testtext","testzipcode");
        System.out.println("///ced///");


        HashMap map = selectReview();
        ArrayList<Review> uu = (ArrayList<Review>) map.get("Iphone");
        for(int i=0; i<uu.size(); i++){

            System.out.println(uu.get(i).getProductname());
            System.out.println(uu.get(i).getProducttype());
            System.out.println(uu.get(i).getReviewrating());
            System.out.println(uu.get(i).getReviewdate());
            System.out.println(uu.get(i).getReviewtext());
            System.out.println(uu.get(i).getZipcode());

        }

    }

}