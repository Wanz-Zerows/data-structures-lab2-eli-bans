/**
 * Generic class that can store information about a data entry.
 * @param <D>
 */
public class DataEntry<D> {
  private String unique;
  private D data; //data can be any datatype
  private long time;

    public DataEntry(String unique, D data, long time) {
        this.unique = unique;
        this.data = data;
        this.time = time;
    }

    public String getUnique() {
        return this.unique;
    }

    public D getData() {
        return this.data;
    }

    public long getTS() {
        return this.time;
    }

    @Override
    public String toString() {
        return "DataEntry{" +
                "unique='" + this.unique + '\'' +
                ", data=" + this.data +
                ", time=" + this.time +
                '}';
    }
}
