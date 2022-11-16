package JavaCore.Lv8.Lec11.w3;

import java.io.IOException;

public class Product {
    String id;
    String productName;
    String price;
    String quantity;

    public Product() {
    }

    public Product(String id, String productName, String price, String quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%-8s%-30s%-8s%-4s",id,productName,price,quantity);
    }

    public static Product parseFile(String temp) throws IOException {
        if (temp == null) {
            throw new IOException();
        }
        Product product = new Product();
        product.setId(temp.substring(0, 8).trim());
        product.setProductName(temp.substring(8, 38).trim());
        product.setPrice(temp.substring(38, 46).trim());
        product.setQuantity(temp.substring(46).trim());
        return product;
    }
}
