package pl.ihorsavchak.ecommerce.payu;

public class Product {
    String name;
    String utilPrice;
    String quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUtilPrice() {
        return utilPrice;
    }

    public void setUtilPrice(String utilPrice) {
        this.utilPrice = utilPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
