package database.connection;


import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int price;
    private int quantity;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }

    public static class Builder{
        private Product product;
        public Builder(){
            product = new Product();
        }

        public Builder setId(int id){
            product.id = id;
            return this;
        }
        public Builder setName(String name){
            product.name = name;
            return this;
        }
        public Builder setPrice(int price){
            product.price = price;
            return this;
        }
        public Builder setQuantity(int quantity){
            product.quantity = quantity;
            return this;
        }
        public Product build(){
            return product;
        }
    }

    @Override
    public String toString(){
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                price == product.price &&
                quantity == product.quantity &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity);
    }
}
