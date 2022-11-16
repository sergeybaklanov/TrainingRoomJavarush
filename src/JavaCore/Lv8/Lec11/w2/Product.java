package JavaCore.Lv8.Lec11.w2;

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
}
