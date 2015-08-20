package vn.kms.lp.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ProductModel {
    int id;
    String name;
    String category;
    String description;
    BigDecimal price;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.id + "-" + this.name + "-" + this.category + "-" + this.description + "-" + this.price;
    }

}
