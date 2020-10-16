package game;

import edu.monash.fit2099.engine.*;

/**
 * A class that figures out a MoveAction that will move the actor one step 
 * closer to a target Actor.
 */
public class FollowBehaviour extends CommonStuffBehaviour {

	private Actor target;

	/**
	 * Constructor.
	 *
	 * @param subject the Actor to follow
	 */
	public FollowBehaviour(Actor subject) {
		this.target = subject;
	}

	/**
	 * returns the action determined by the behaviour
	 * @param actor the Actor acting
	 * @param map the GameMap containing the Actor
	 * @return the action determined by the behaviour
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		if(!map.contains(target) || !map.contains(actor))
			return null;

		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);

		int currentDistance = distance(here, there);
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				int newDistance = distance(destination, there);
				if (newDistance < currentDistance) {
					if (!destination.containsAnActor()) {
						return new MoveActorAction(destination, exit.getName());
					}
				}
			}
		}
		return null;
	}
}
