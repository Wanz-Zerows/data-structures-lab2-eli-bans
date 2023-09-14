import java.sql.Timestamp;
import java.util.HashMap;

/**
 * a generic data storage system that can store and manage various types
 * of data.
 * @param <E>
 */
public class DataStorage<E> {
    private HashMap<String,DataEntry<E>> store; //hashMap that takes the unique identifier : the entire data entry

    public DataStorage(){
        this.store = new HashMap<String,DataEntry<E>>();
    }
    public void addEntry(DataEntry<E> entry){ //adds a data entry to the store
        this.store.put(entry.getUnique(), entry);
    }
    public DataEntry<E> retrieveEntry(String identifier){ //Retrieves a data entry based on its identifier
        return this.store.get(identifier);
    }
    public int getEntryCount(){ // Returns the total number of data entries.
        return store.size();
    }
    public Timestamp getAverageTimeStamp(){ //Calculates and returns the average timestamp of all data entries
        if (store.isEmpty()) return new Timestamp(0) ;
        long milliseconds = 0;
        for (DataEntry<E> entry: store.values() ) {
            milliseconds +=entry.getTS();
        }
        long totMilli = milliseconds /this.store.size();

        Timestamp ts = new Timestamp(totMilli);
        return  ts;
    }

    public void listAllEntries(){ //print out all storage entries
        for (DataEntry<E> entry: store.values() ) {
            System.out.println(entry);
        }
    }

    public void removeEntry(String identifier){ //remove data entry from store
        store.remove(identifier);
    }


    public static void main(String[] args) {

     DataStorage<String> storage1 = new DataStorage<>(); //declaring and instantiation a storage object

        //create timestamp
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        //creating data entries for tests
      DataEntry<String>  test = new DataEntry<String>("PH-K", "FirstData", timestamp.getTime());
      DataEntry<Integer> test2 = new DataEntry<Integer>("AJP-5",2, timestamp.getTime());
      DataEntry<String> test3 = new DataEntry<String>("CA-L","Tirddata",timestamp.getTime());

      //testing the add method
        storage1.addEntry(test);
        storage1.addEntry(test3);

        //testing the getEntryCount method
        System.out.println("Total Entries: " + storage1.getEntryCount());

        //testing the getAverageTimeStamp method
        System.out.println("Average Timestamp: " + storage1.getAverageTimeStamp());

        //retrieve data
        System.out.println(storage1.retrieveEntry("PH-K")+" was retrieved");

        //list all entries
        storage1.listAllEntries();

        //list entry count
        System.out.println("There are currently "+ storage1.getEntryCount() +" entrie(s)");

    }
    
}
