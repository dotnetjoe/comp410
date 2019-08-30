package DiGraph_A5;

public class EntryPair implements EntryPair_Interface {
  public String value;
  public long priority;

  public EntryPair(String aValue, long aPriority) {
    value = aValue;
    priority = aPriority;
  }

  public String getValue() { return value; }
  public long getPriority() { return priority; }
}