import java.util.ArrayList;

public class StoreInventory<P> {
    private ArrayList<Product> inventory = new ArrayList<Product>();

    public StoreInventory(Product product) {//create a storeInventory
        this.inventory.add(product);
    }
    void addProduct(Product product){ //adds a product to the inventory
        if (this.inventory.add(product)){
            System.out.println("Successfully added ");
        };
    }
    void removeProduct(Product product){ //removes a product from the inventory
        if (this.inventory.remove(product)){
            System.out.println("Successfully removed");
        };

    }
    Product findProduct(String name){ //inventory can't ever be null bro, i'm safe
        for (Product product : inventory) {
            if(name.equalsIgnoreCase(product.getName())){
                return product;
            }
        }
        return null;
    }
    void listAllProducts(){
        for (Product product : inventory) {
            System.out.println(product.getName());
        }
    }
    double getTotalValue(){
        double tot = 0.0;
        for (Product product : inventory) {
            tot+= product.getPrice();
        }
        return tot;
    }

    public static void main(String[] args) {
        Product product1 = new Product<>("bag", 222.99, 5);
        StoreInventory<Product> storeInventory = new StoreInventory<>(product1);

        Product product2 = new Product<>("Tablet", 499.99, 10);
        storeInventory.addProduct(product2);

        ElectronicProduct laptop = new ElectronicProduct("HyperX",899.45,1);
        storeInventory.addProduct(laptop);

        ClothingProduct clothe = new ClothingProduct("LV-X723",120.00,3);
        storeInventory.addProduct(clothe);

        BookProduct book = new BookProduct("Goldy and Bear",10.24,2);
        storeInventory.addProduct(book);

        StoreInventory<Product> storeInventory2 = new StoreInventory<>(book);

        //testing the listALlProducts method
        storeInventory.listAllProducts();

        //testing the getTotalValue
        System.out.println(storeInventory.getTotalValue());

    }

}
