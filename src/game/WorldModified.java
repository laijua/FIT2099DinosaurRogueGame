package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.DoNothingAction;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.World;

public class WorldModified extends World {

  Ecopoints ecopoints = new Ecopoints();


  /**
   * Constructor.
   *
   * @param display the Display that will display this World.
   */
  public WorldModified(Display display) {
    super(display);
  }

  @Override
  public void addGameMap(GameMap gameMap) {
    super.addGameMap(gameMap);
    ((GameMapModified) gameMap).initializeEcopoints(ecopoints);

  }

  @Override
  protected void processActorTurn(Actor actor) {
    System.out.println("Ecopoints Balance: "+ecopoints.getEcopoints());
    Location here = actorLocations.locationOf(actor);
    GameMap map = here.map();

    Actions actions = new Actions();
    for (Item item : actor.getInventory()) {
      actions.add(item.getAllowableActions());
      // Game rule. If you're carrying it, you can drop it.
      actions.add(item.getDropAction());
    }

    for (Exit exit : here.getExits()) {
      Location destination = exit.getDestination();

      // Game rule. You don't get to interact with the ground if someone is standing
      // on it.
      if (actorLocations.isAnActorAt(destination)) {
        actions.add(actorLocations.getActorAt(destination).getAllowableActions(actor, exit.getName(), map));
      } else {
        actions.add(destination.getGround().allowableActions(actor, destination, exit.getName()));
      }
      actions.add(destination.getMoveAction(actor, exit.getName(), exit.getHotKey()));
    }

    for (Item item : here.getItems()) {
      actions.add(item.getAllowableActions());
      // Game rule. If it's on the ground you can pick it up.
      actions.add(item.getPickUpAction());
    }
    actions.add(new DoNothingAction());

    Action action = actor.playTurn(actions, lastActionMap.get(actor), map, display);
    if (action instanceof HarvestAction){
      ecopoints.addEcopoints(1);
    }
    lastActionMap.put(actor, action);

    String result = action.execute(actor, map);
    display.println(result);
  }
}
