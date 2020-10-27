package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

public class Water extends Ground {

  /**
   * Constructor.
   * of water type terrian
   *
   */
  public Water() {
    super('~');
  }

  @Override
  /**
   * Override this to implement impassable terrain, or terrain that is only passable if conditions are met.
   *
   * @param actor the Actor to check
   * @return true
   */
  public boolean canActorEnter(Actor actor) {
    return actor.hasCapability(GameCapability.FLY);
  }
}
