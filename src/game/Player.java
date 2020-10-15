package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Menu;

/**
 * Class representing the Player.
 */
public class Player extends Actor {

	private Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// Add harvest Action if player is in Grass
		if (map.locationOf(this).getGround() instanceof Grass){
			Hay hay = new Hay();
			actions.add(new HarvestAction(hay));
		};

		for(int i = 0; i<this.getInventory().size();i++){
			if (this.getInventory().get(i) instanceof Hay || this.getInventory().get(i) instanceof Fruit){
				for (int j = 0; j<map.locationOf(this).getExits().size(); j++){
					Location neighbour = map.locationOf(this).getExits().get(j).getDestination();
					if(neighbour.containsAnActor()){
						if (neighbour.getActor() instanceof Dinosaur){
							actions.add(new FeedAction((Food)this.getInventory().get(i), (Dinosaur) neighbour.getActor()));
						}
//						else if (map.locationOf(this).getExits().get(j).getDestination().getActor() instanceof Stegosaur){
//							continue;
//						}
					}
				}
			}
		}

		//actions.get()

		return menu.showMenu(this, actions, display);
	}
}
