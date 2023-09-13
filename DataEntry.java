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

    public long getTime() {
        return this.time;
    }
}
