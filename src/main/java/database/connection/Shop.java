package database.connection;

import java.util.Objects;
public class Shop {
    private int id;
    private String name;
    private String address;
    private int phone;
    private String email;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public int getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }

    public static class Builder{
        private Shop shop;
        public Builder(){
            shop = new Shop();
        }

        public Builder setId(int id){
            shop.id = id;
            return this;
        }
        public Builder setName(String name){
            shop.name = name;
            return this;
        }
        public Builder setAddress(String address){
            shop.address = address;
            return this;
        }
        public Builder setPhone(int phone){
            shop.phone = phone;
            return this;
        }
        public Builder setEmail(String email){
            shop.email = email;
            return this;
        }
        public Shop build(){
            return shop;
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return id == shop.id &&
                phone == shop.phone &&
                Objects.equals(name, shop.name) &&
                Objects.equals(address, shop.address) &&
                Objects.equals(email, shop.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone, email);
    }
}
