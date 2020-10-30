package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * Action for eating
 */
public class EatAction extends Action {
    private Food food;
    private Location locationOfFood;

    /**
     * Constructor for the EatAction
     * @param food the food to be eaten
     * @param locationOfFood the location of the food
     */
    public EatAction(Food food, Location locationOfFood) {
        this.food = food;
        this.locationOfFood = locationOfFood;
    }

    /**
     * Method to perform the eat action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String to output to console
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Dinosaur dinosaur = (Dinosaur) actor;
        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();
        dinosaur.increaseFoodLevel(food.getFoodLevelPoint());
        locationOfFood.removeItem(food);
        return dinosaur + " at " + "(" + dinoX + ", " + dinoY + ") eats " + food;

    }

    /**
     * Method to describe action
     * @param actor The actor performing the action.
     * @return String describing the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
