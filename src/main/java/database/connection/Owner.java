package database.connection;

import java.util.Objects;
public class Owner {
    private  int id;
    private  String name;
    private  String address;
    private  int phone;
    private  String email;
    private  String shopName;
    private  int age;

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
    public String getShopName() {
        return shopName;
    }
    public int getAge() {
        return age;
    }

    public static class Builder{
        private Owner owner;
        public Builder(){
            owner = new Owner();
        }

        public Builder setId(int id){
            owner.id = id;
            return this;
        }
        public Builder setName(String name){
            owner.name = name;
            return this;
        }
        public Builder setAddress(String address){
            owner.address = address;
            return this;
        }
        public Builder setPhone(int phone){
            owner.phone = phone;
            return this;
        }
        public Builder setEmail(String email){
            owner.email = email;
            return this;
        }
        public Builder setShopName(String shopName){
            owner.shopName = shopName;
            return this;
        }
        public Builder setAge(int age){
            owner.age = age;
            return this;
        }
        public Owner build(){
            return owner;
        }
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", shopName='" + shopName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id == owner.id &&
                phone == owner.phone &&
                age == owner.age &&
                Objects.equals(name, owner.name) &&
                Objects.equals(address, owner.address) &&
                Objects.equals(email, owner.email) &&
                Objects.equals(shopName, owner.shopName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, phone, email, shopName, age);
    }
}
