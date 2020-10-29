package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class EatAction extends Action {
    Food food;
    Location locationOfFood;

    public EatAction(Food food, Location locationOfFood) {
        this.food = food;
        this.locationOfFood = locationOfFood;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
//        if (food instanceof GrassAsFood){
//            locationOfFood.setGround(new Dirt());
//        }
        Dinosaur dinosaur = (Dinosaur) actor;
        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();
        dinosaur.increaseFoodLevel(food.getFoodLevelPoint());
        locationOfFood.removeItem(food);
        return dinosaur + " at " + "(" + dinoX + ", " + dinoY + ") eats " + food;

    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
