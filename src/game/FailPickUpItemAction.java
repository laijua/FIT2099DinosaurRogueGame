package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;

/**
 *  Similar to PickUpItemAction just in execute it does nothing but return a failed pick up item
 *  message
 */
public class FailPickUpItemAction extends PickUpItemAction {

  /**
   * Constructor.
   *Initialize the item to fail
   * @param item the item to pick up
   */
  public FailPickUpItemAction(Item item) {
    super(item);
  }
  /**
   * Does nothing but return fail pick up message
   *
   * @see Action#execute(Actor, GameMap)
   * @param actor The actor performing the action.
   * @param map The map the actor is on.
   * @return a suitable description to display in the UI
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    return actor + "Unfortunately was not able to pick up: "+ item;
  }

  /**
   * Describe the action in a format suitable for displaying in the menu.
   *
   * @see Action#menuDescription(Actor)
   * @param actor The actor performing the action.
   * @return a string, e.g. "Player picks up the rock"
   */
  @Override
  public String menuDescription(Actor actor) {
    return actor + " picks up the " + item;
  }
}
