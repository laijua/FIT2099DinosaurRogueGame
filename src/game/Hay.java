package game;

/**
 * An Food item class that can be dropped via Trees or purchaseable.
 */
public class Hay extends Food {
  /***
   * Constructor.
   * Also adds capability if the type of dinosaur is able to eat it.
   */
  public Hay() {
    super(10,"Hay",'H',true);
    addCapability(GameCapability.HERBIVOREEDIBLE);
  }
}
