package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;


public class FeedAction extends Action {
  protected Food item;
  protected Dinosaur dinosaur;


  /**
   * Constructor.
   *
   * @param item the item to pick up
   */
  public FeedAction(Food item,Dinosaur dinosaur) {
    this.item = item;
    this.dinosaur = dinosaur;
  }

  @Override
  public String execute(Actor actor, GameMap map) {
    String getFoodLevelPoint = ""+item.getFoodLevelPoint();
    dinosaur.increaseFoodLevel(item.getFoodLevelPoint());
    actor.removeItemFromInventory(item);
    return dinosaur + " has been fed " + getFoodLevelPoint + " points";
  }

  @Override
  public String menuDescription(Actor actor) {
    return actor + " feeds "+item +" to " + dinosaur;
  }
}
