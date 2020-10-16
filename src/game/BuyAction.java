package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
/**
 * An Action to buy items from vendingMachine
 */
public class BuyAction extends Action {
  protected Item item;
  protected Integer cost;
  /***
   * Constructor.
   * @param item The item to be purchased from the vendingMachine
   * @param cost THe cost of the item
   */
  public BuyAction (Item item,Integer cost){
    this.item = item;
    this.cost = cost;
  }
  /**
   * Execute Buy Action, where the actor obtains  items and ecopoints balance is deducted.
   *	 @param actor the Actor acting
   * 	  @param map the GameMap containing the Actor
   * 	  @return A String of player buying item
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    actor.addItemToInventory(item);
    ((GameMapModified)map).increaseEcopoints(-cost);
    return actor + " has bought  "+ item +" for " + cost+" ecopoints";
  }
  /**
   * Execute Buy Action, where the actor obtains  items and ecopoints balance is deducted.
   *	 @param actor the Actor acting
   * 	  @return A String of what  player could be buying as a menu item for the player to choose
   */
  @Override
  public String menuDescription(Actor actor) {
    return actor + " can buy "+ item +" for " + cost+" ecopoints";
  }
}
