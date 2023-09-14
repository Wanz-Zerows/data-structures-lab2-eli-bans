import java.util.ArrayList;

/**
 *  Generic class inventory system for a store.
 * @param <P>
 */
public class StoreInventory<P extends Product>{
    private ArrayList<Product> inventory = new ArrayList<Product>();

    public StoreInventory(Product product) {//create a storeInventory
        this.inventory.add(product);
    }

    /**
     * adds a product to the inventory
     * @param product
     */
    public void addProduct(Product product){
        if (this.inventory.add(product)){
            System.out.println("Successfully added");
        };
    }

    /**
     * removes a product from the inventory
     * @param product
     */
    public void removeProduct(Product product){
        if (this.inventory.remove(product)){
            System.out.println("Successfully removed");
        };
    }

    /**
     * finds a product in the inventory
     * @param name
     * @return
     */

    public Product findProduct(String name){
        for (Product product : inventory) {
            if(name.equalsIgnoreCase(product.getName())){
                return product;
            }
        }
        return null;
    }

    /**
     * list all products in the inventory
     */
    public void listAllProducts(){
        for (Product product : inventory) {
            System.out.println(product.getName());
        }
    }

    /**
     * computes the total value of products in the inventory
     * @return
     */
    public double getTotalValue(){
        double tot = 0.0;
        for (Product product : inventory) {
            tot+= (product.getPrice() * product.getQuantity());
        }
        return tot;
    }

    /**
     * changes the price of a product in the inventory
     * @param name
     * @param newPrice
     */
    public void updatePrice(String name,Double newPrice ){
        Product product = findProduct(name);
        if (product!=null)
        product.setPrice(newPrice);
    }

    /**
     * changes the quantity of a product in the inventory
     * @param name
     * @param quantity
     */
    public void updateQuantity(String name, Integer quantity){
        Product product = findProduct(name);
        if (product!=null) product.setQuantity(quantity);
    }

    public static void main(String[] args) {
        Product product1 = new Product<>("bag", 222.99, 5);
        StoreInventory<Product> storeInventory = new StoreInventory<>(product1);

        Product product2 = new Product<>("Tablet", 499.99, 10);
        storeInventory.addProduct(product2);

        ElectronicProduct laptop = new ElectronicProduct("HyperX",899.45,1);
        storeInventory.addProduct(laptop);

        ClothingProduct clothe = new ClothingProduct("LV-X723",120.00,3);
        storeInventory.addProduct(clothe); //testing the addProduct method

        BookProduct book = new BookProduct("Goldy and Bear",13.69,2);
        storeInventory.addProduct(book);

        StoreInventory<Product> storeInventory2 = new StoreInventory<>(book);

        //testing the listALlProducts method
        storeInventory.listAllProducts();

        //testing the getTotalValue
        System.out.println("Total value: $"+ storeInventory.getTotalValue());

        //testing the remove method
        storeInventory2.removeProduct(book);

        //testing the updatePrice method
        storeInventory.updatePrice("LV-X723",7.99);

        //testing the updateQuantity metbod
        storeInventory.updateQuantity("LV-X723",5);
        System.out.println("Total value: $"+ storeInventory.getTotalValue());
    }

}
