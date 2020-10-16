package game;

import edu.monash.fit2099.engine.*;

public class SeekFoodBehaviour extends CommonStuffBehaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Dinosaur dinosaur = (Dinosaur) actor;

        final int HUNGRYFOODLEVEL = 15;
        if (dinosaur.getFoodLevel() < HUNGRYFOODLEVEL) {
            System.out.println(dinosaur + " at " + "(" + map.locationOf(dinosaur).x() + ", " + map.locationOf(dinosaur).y() + ") is getting hungry!");
            Location dinosaurLocation = map.locationOf(actor);
            int dinoX = dinosaurLocation.x();
            int dinoY = dinosaurLocation.y();


            if (dinosaur.getEdibleType() == GameCapability.HERBIVOREEDIBLE) {
                if (dinosaurLocation.getGround() instanceof Grass) {
                    dinosaurLocation.setGround(new Dirt());
                    dinosaur.increaseFoodLevel(5);
                    System.out.println(actor + " at " + "(" + dinoX + ", " + dinoY + ") eats Grass");
                    return null;
                }

            }

            for (int x : dinosaurSearchRadius) {
                for (int y : dinosaurSearchRadius) {
                    if (dinoX + x <= 79 && dinoY + y <= 24 && dinoX + x >= 0 && dinoY + y >= 0) {
                        Location location = map.at(dinoX + x, dinoY + y);
                        for (Item items : location.getItems()) {
                            if (items instanceof Food) {
                                Food food = (Food) items;
                                if (food.hasCapability(dinosaur.getEdibleType())) {
                                    boolean canEat = true;
                                    if (food instanceof Egg) {
                                        Egg egg = (Egg) food;
                                        if (egg.getDinosaurToHatch() == dinosaur.getClass()) {
                                            canEat = false;
                                        }
                                    }
                                    if (canEat) {
                                        if (distance(dinosaurLocation, location) == 1) {

                                            dinosaur.increaseFoodLevel(food.getFoodLevelPoint());
                                            location.removeItem(food);
                                            System.out.println(actor + " at " + "(" + dinoX + ", " + dinoY + ") eats " + food);
                                            return null;

                                        }
                                        Location there = location;
                                        int currentDistance = distance(dinosaurLocation, there);
                                        for (Exit exit : dinosaurLocation.getExits()) {
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
                                    }
                                }
                            }
                        }
                        if (location.getGround() instanceof Grass && dinosaur.getEdibleType() == GameCapability.HERBIVOREEDIBLE) {
                            int currentDistance = distance(dinosaurLocation, location);
                            for (Exit exit : dinosaurLocation.getExits()) {
                                Location destination = exit.getDestination();
                                if (destination.canActorEnter(actor)) {
                                    int newDistance = distance(destination, location);
                                    if (newDistance < currentDistance) {
                                        if (!destination.containsAnActor()) {
                                            return new MoveActorAction(destination, exit.getName());
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }

            if (dinosaur.getEdibleType() == GameCapability.CARNIVOREEDIBLE) {
                for (int x : dinosaurSearchRadius) {
                    for (int y : dinosaurSearchRadius) {
                        if (dinoX + x <= 79 && dinoY + y <= 24 && dinoX + x >= 0 && dinoY + y >= 0) {
                            Location location = map.at(dinoX + x, dinoY + y);
                            if (location.containsAnActor()) {
                                if (location.getActor() instanceof Dinosaur) {
                                    Dinosaur target = (Dinosaur) location.getActor();
                                    if (target.hasCapability(GameCapability.ALLOSAURATTACKABLE)) {
                                        return new FollowBehaviour(target).getAction(actor, map);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}


