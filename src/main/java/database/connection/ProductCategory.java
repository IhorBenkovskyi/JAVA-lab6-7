package database.connection;

import java.util.Objects;

public class ProductCategory {

    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder{
        private ProductCategory productCategory;
        public Builder(){
            productCategory = new ProductCategory();
        }

        public Builder setId(int id){
            productCategory.id = id;
            return this;
        }
        public Builder setName(String name){
            productCategory.name = name;
            return this;
        }
        public Builder setDescription(String description){
            productCategory.description = description;
            return this;
        }
        public ProductCategory build(){
            return productCategory;
        }
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategory that = (ProductCategory) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

}
