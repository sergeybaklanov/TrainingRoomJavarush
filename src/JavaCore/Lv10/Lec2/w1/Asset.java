package JavaCore.Lv10.Lec2.w1;

import java.util.Objects;

public class Asset {
    private String name;
    private double price;

    public Asset(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return Double.compare(asset.price, price) == 0 && name.equals(asset.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
