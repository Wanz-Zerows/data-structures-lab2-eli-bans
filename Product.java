public class Product<T> {
    private String name;
    private Double  price;
    private Integer quantity;

    public Product(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }
    public Double getPrice(){
       return this.price;
    }

}
