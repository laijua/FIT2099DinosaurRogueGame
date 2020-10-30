package game;

import edu.monash.fit2099.engine.*;

/**
 * Behaviour for finding food
 */
public class SeekFoodBehaviour extends CommonStuffBehaviour {


    /**
     * Method for finding food and determining what to do when finding food
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return an action to do when finding food
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        final int HUNGERLEVEL = 30;
        Dinosaur dinosaur = (Dinosaur) actor;

        if (dinosaur.getFoodLevel() < HUNGERLEVEL) {
            System.out.println(dinosaur + " at " + "(" + map.locationOf(dinosaur).x() + ", " + map.locationOf(dinosaur).y() + ") is getting hungry!");
            Location dinosaurLocation = map.locationOf(actor);

            // grazes on grass that it is on top of grass and a herbivore
            if (dinosaur.containsEdible(GameCapability.HERBIVOREEDIBLE)) {
                if (dinosaurLocation.getGround() instanceof Grass) {
                    return new EatAction(new GrassAsFood(dinosaurLocation), dinosaurLocation);

                }
            }
//
            // check if any food source in eat range
            if (findFood(dinosaur, dinosaurLocation, 1) != null) {
                FoodAndLocation foodAndLocation = findFood(dinosaur, dinosaurLocation, 1);
                Food food = foodAndLocation.food;
                Location locationOfFood = foodAndLocation.location;
                if (food == null) { // null when food is grass
                    return move(actor, dinosaurLocation, locationOfFood);
                }
                return new EatAction(food, locationOfFood);

            }

            // move towards food source
            if (findFood(dinosaur, dinosaurLocation, 4) != null) {
                FoodAndLocation foodAndLocation = findFood(dinosaur, dinosaurLocation, 4);
                Location locationOfFood = foodAndLocation.location;
                return move(actor, dinosaurLocation, locationOfFood);
            }

            // moves towards a prey
            if (dinosaur.containsEdible(GameCapability.CARNIVOREEDIBLE)) {
                if (findDinosaur(dinosaur, dinosaurLocation, 4, GameCapability.ATTACK) != null) {
                    return new FollowBehaviour(findDinosaur(dinosaur, dinosaurLocation, 4, GameCapability.ATTACK)).getAction(actor, map);
                }
            }
        }
        return null;
    }

    /**
     * Method to find food
     * @param dinosaur the dinosaur finding food
     * @param location current location of dinosaur finding food
     * @param range how far the dinosaur can see when finding food
     * @return a FoodAndLocation class which stores the food and its location
     */
    private FoodAndLocation findFood(Dinosaur dinosaur, Location location, int range) {
        for (Item items : location.getItems()) {
            if (items instanceof Food) {
                Food food = (Food) items;
                if (food.canBeEaten(dinosaur.getEdibleType())) {
                    boolean canEat = true;
                    if (food instanceof Egg) {
                        Egg egg = (Egg) food;
                        if (egg.getDinosaurToHatch() == dinosaur.getClass()) {
                            canEat = false;
                        }
                    }
                    if (canEat) {
                        return new FoodAndLocation(food, location);

                    }
                }
            }
        }

        // moves towards grass
        if (location.getGround() instanceof Grass && dinosaur.containsEdible(GameCapability.HERBIVOREEDIBLE)) {
            return new FoodAndLocation(null, location);

        }
        if (range > 0) {
            for (Exit exits : location.getExits()) {
                if (findFood(dinosaur, exits.getDestination(), range - 1) != null) {
                    return findFood(dinosaur, exits.getDestination(), range - 1);
                }
            }
        }
        return null;
    }

    /**
     * private nested class for storing food and its location
     */
    private class FoodAndLocation {
        // no need to make private as its a nested private class and so we can access data without needing methods
        Food food;
        Location location;
        /**
         * Constructor
         * @param food the food
         * @param location the food's location
         */
        public FoodAndLocation(Food food, Location location) {
            this.food = food;
            this.location = location;
        }
    }
}



