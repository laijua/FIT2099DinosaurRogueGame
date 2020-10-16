package game;


/**
 * An Food item class that can be dropped via Trees or purchaseable.
 */
public class Fruit extends Food {
  private int fruitDecay = 20;
  /***
   * Constructor.
   * Also adds capability if the type of dinosaur is able to eat it.
   *  @param name the name of this Item
   * @param displayChar the character to use to represent this item if it is on the ground
   * @param portable true if and only if the Item can be picked up
   */
  public Fruit(String name, char displayChar, boolean portable) {
    super(30,name, displayChar, portable,0.6);
    addCapability(GameCapability.HERBIVOREEDIBLE);
  }

  /**
   * Decay the fruits age as it may rot
   */
  public void decayFruit() {
    fruitDecay--;
  }

  /**
   * Simple Getter that returns the Fruits Age
   * @return Integer value
   */
  public int getDecay() {
    return fruitDecay;
  }


}

