package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class BuyAction extends Action {
  protected Item item;
  protected Integer cost;
  public BuyAction (Item item,Integer cost){
    this.item = item;
    this.cost = cost;
  }
  @Override
  public String execute(Actor actor, GameMap map) {
    actor.addItemToInventory(item);
    ((GameMapModified)map).increaseEcopoints(-cost);
    return actor + " has bought  "+ item +" for " + cost+" ecopoints";
  }

  @Override
  public String menuDescription(Actor actor) {

    return actor + " can buy "+ item +" for " + cost+" ecopoints";
  }
}
