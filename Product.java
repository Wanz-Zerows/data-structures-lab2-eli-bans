/**
 * Parent class for all products; electronic, clothing, book
 * @param <T>
 */
public class Product<T>  {
    private String name;
    private Double  price;
    private Integer quantity;

    Product(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }
    public Integer getQuantity(){
        return this.quantity;
    }
    public Double getPrice(){
       return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
