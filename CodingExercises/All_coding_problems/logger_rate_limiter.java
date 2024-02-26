class Logger {
  private HashMap<String, Integer> map;

  /** Initialize your data structure here. */
  public Logger() {
    map = new HashMap<String, Integer>();
  }

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {

    if (!this.map.containsKey(message)) {
      this.map.put(message, timestamp);
      return true;
    }

    Integer oldTimestamp = this.map.get(message);
    if (timestamp - oldTimestamp >= 10) {
      this.map.put(message, timestamp);
      return true;
    } else
      return false;
  }
}