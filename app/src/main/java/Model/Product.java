package Model;

import java.io.Serializable;

public class Product implements Serializable {
    private String pictureId;
    private String productName;
    private float cost;
    private float fees;

    public Product(String pictureId, String productName, float cost, float fees) {
        this.pictureId = pictureId;
        this.productName = productName;
        this.cost = cost;
        this.fees = fees;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getFees() {
        return fees;
    }

    public void setFees(float fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "\t" + productName ;
    }
}
