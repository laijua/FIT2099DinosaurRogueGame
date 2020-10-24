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
    super(20,"Hay",'H',true,10);
    addCapability(GameCapability.HERBIVOREEDIBLE);
  }
}
