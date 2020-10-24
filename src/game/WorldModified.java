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
import java.util.ArrayList;

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

  /**
   * Grabs a reference to ecopoints so that other classes can interact and add to current Balance
   * @param gameMap the GameMap to add
   */
  @Override
  public void addGameMap(GameMap gameMap) {
    super.addGameMap(gameMap);
    ((GameMapModified) gameMap).initializeEcopoints(ecopoints);

  }

  /**
   * Depending on what Actions has occured then
   * @param actor the Actor whose turn it is.
   */
  @Override
  protected void processActorTurn(Actor actor) {

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
    // IF player is currently in the bottom map with y coordinates = 0 and go to top map
    if (actor instanceof Player && here.y() == 0 && !((GameMapModified)map).isTopMap()){
      actions.add(new MoveMapAction(this,true));
    }else if (actor instanceof Player && here.y() == 24 && ((GameMapModified)map).isTopMap()){
      actions.add(new MoveMapAction(this,false));
    }




    Action action = actor.playTurn(actions, lastActionMap.get(actor), map, display);
    if (action instanceof HarvestAction){
      ecopoints.addEcopoints(1);
    }
    if (action instanceof FeedAction){
      ecopoints.addEcopoints(((FeedAction) action).item.getEcopoints());
    }
    lastActionMap.put(actor, action);

    String result = action.execute(actor, map);
    display.println(result);
  }
  /**
   * Run the game.
   *
   * On each iteration the gameloop does the following: - displays the player's
   * map - processes the actions of every Actor in the game, regardless of map
   *
   * We could either only process the actors on the current map, which would make
   * time stop on the other maps, or we could process all the actors. We chose to
   * process all the actors.
   *
   * @throws IllegalStateException if the player doesn't exist
   */
  @Override
  public void run() {
    if (player == null)
      throw new IllegalStateException();

    // initialize the last action map to nothing actions;
    for (Actor actor : actorLocations) {
      lastActionMap.put(actor, new DoNothingAction());
    }

    // This loop is basically the whole game
    while (stillRunning()) {
      System.out.println("Ecopoints Balance: "+ecopoints.getEcopoints());
      GameMap playersMap = actorLocations.locationOf(player).map();
      playersMap.draw(display);

      // Process all the actors.
      for (Actor actor : actorLocations) {
        if (stillRunning())
          processActorTurn(actor);
      }

      // Tick over all the maps. For the map stuff.
      for (GameMap gameMap : gameMaps) {
        gameMap.tick();
      }

    }
    display.println(endGameMessage());
  }
  /**
   * Simple Getter that returns arraylist used to change players map
   * @return  Gamemaps Arraylist
   */
  public ArrayList<GameMap> getGameMap() {
    return this.gameMaps;
  }
}
