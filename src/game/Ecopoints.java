package game;

/**
 * A class that holds the balance of ecopoints in which Player uses so that they can purchase stuff.
 */
public class Ecopoints {
  private int ecopoints =0;

  /**
   * Method to add to the current balance, can be negative to reduce the balance and requires less code
   * @param ecopoints Integer Value that is added onto current balance
   */
  public void addEcopoints(int ecopoints) {
    this.ecopoints = this.ecopoints + ecopoints;
  }

  /**
   * Getter methods that returns Ecopoints
   * @return Integer Value of ecopoints
   */
  public int getEcopoints() {
    return ecopoints;
  }

}
