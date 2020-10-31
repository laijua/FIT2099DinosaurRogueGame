package game;

import edu.monash.fit2099.engine.*;

/**
 * Abstract behaviour class that contains common data members. To be inherited by behaviour class that needs its data members.
 */
public abstract class CommonStuffBehaviour implements Behaviour {

    /**
     * Compute the Manhattan distance between two locations.
     *
     * @param a the first location
     * @param b the first location
     * @return the number of steps between a and b if you only move in the four cardinal directions.
     */
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }

    /**
     * Method for finding any dinosaur in range
     *
     * @param dinosaur the dinosaur searching
     * @param location the location to search from, aka the location of the dinosaur searching
     * @param range    the range/radius the dinosaur can search
     * @param reason   reason for searching
     * @return dinosaur if any found
     */
    protected Actor findDinosaur(Dinosaur dinosaur, Location location, int range, Enum<?> reason) {
        if (location.containsAnActor()) {
            if (location.getActor() instanceof Dinosaur) {
                Dinosaur target = (Dinosaur) location.getActor();

                if (reason.equals(GameCapability.ATTACK)) {
                    if (target.hasCapability(dinosaur.getCanAttackTier()) && target.getClass() != dinosaur.getClass()) {
                        return target;
                    }
                } else if (reason.equals(GameCapability.BREED)) {
                    if (location.getActor().getClass() == dinosaur.getClass()) {
                        Dinosaur otherDinosaur = (Dinosaur) location.getActor();
                        if ((otherDinosaur.isMale() && !dinosaur.isMale() || (!otherDinosaur.isMale() && dinosaur.isMale()))) {
                            if (otherDinosaur.isAdult() && !otherDinosaur.isPregnant()) {
                                return otherDinosaur;
                            }
                        }
                    }
                }
            }
        }
        if (range > 0) {
            for (Exit exits : location.getExits()) {
                if (findDinosaur(dinosaur, exits.getDestination(), range - 1, reason) != null) {
                    return findDinosaur(dinosaur, exits.getDestination(), range - 1, reason);
                }
            }
        }
        return null;
    }

    /**
     * Method to move an Actor
     *
     * @param actor Actor to be moved
     * @param here  current location of Actor
     * @param there new location of Actor
     * @return instance of MoveActorAction
     */
    protected Action move(Actor actor, Location here, Location there) {

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
