package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;

public class HarvestAction extends PickUpItemAction {

  /**
   * Constructor.
   *
   * @param item the item to pick up
   */
  public HarvestAction(Item item) {
    super(item);
  }

  @Override
  public String execute(Actor actor, GameMap map) {
    map.locationOf(actor).setGround(new Dirt());
    actor.addItemToInventory(item);
    return menuDescription(actor);
  }

  @Override
  public String menuDescription(Actor actor) {
    return super.menuDescription(actor);
  }
}
