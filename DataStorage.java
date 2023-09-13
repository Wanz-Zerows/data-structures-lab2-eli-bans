import java.util.HashMap;

public class DataStorage<E> {
    private HashMap<String,DataEntry<E>> storage; //hashMap that takes the unique identfier : the entire data entry

    public DataStorage(){
        this.storage = new HashMap<String,DataEntry<E>>(); //hashmap to store all data entries. Initially empty
    }
    void addEntry(DataEntry<E> entry){//adds a data entry to the storage
        this.storage.put(entry.getUnique(), entry);
    }
    DataEntry<E> retrieveEntry(String identifier){//Retrieves a data entry based on its identifier
        return this.storage.get(identifier);
    }
    int getEntryCount(){// Returns the total number of data entries.
        return storage.size();
    }
    double getAverageTimeStamp(){//Calculates and returns the average timestamp of all data entries
        //but maybe this average just means the most common time
        if (storage.isEmpty()) return 0.00;
        long totalTS = 0;
        for (DataEntry<E> entry: storage.values() ) {
            totalTS+=entry.getTime();
        }
        return totalTS/this.storage.size();
    }
    void listAllEntries(){//print out all storage entries
        for (DataEntry<E> entry: storage.values() ) {
            System.out.println(entry);
        }
    }

    void removeEntry(String identifier){
        storage.remove(identifier);
    }


    public static void main(String[] args) {

     DataStorage<String> storage1 = new DataStorage<>(); //declaring and instantiation a storage object

        //creating data entries for tests
      DataEntry<String>  test = new DataEntry<String>("PH-K", "FirstData", System.currentTimeMillis());
      DataEntry<Integer> test2 = new DataEntry<Integer>("AJP-5",2, System.currentTimeMillis());
      DataEntry<String> test3 = new DataEntry<String>("CA-L","Tirddata",System.currentTimeMillis());

      //testing the add method
        storage1.addEntry(test);
        storage1.addEntry(test3);

        //testing the getEntryCount method
        System.out.println("Total Entries: " + storage1.getEntryCount());

        //testing the getAverageTimeStamp method
        System.out.println("Average Timestamp: " + storage1.getAverageTimeStamp());

        //have a few more tests to do mabr3


    }


}
