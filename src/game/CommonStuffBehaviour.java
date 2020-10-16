package game;

import edu.monash.fit2099.engine.Location;

/**
 * Abstract behaviour class that contains common data members. To be inherited by behaviour class that needs its data members.
 */
public abstract class CommonStuffBehaviour implements Behaviour {
    /**
     * data for determining the range a dinosaur can see
     */
    protected int[] dinosaurSearchRadius = {0, 1, -1, 2, -2, 3, -3, 4, -4};
    /**
     * the range a dinosaur can interact with objects and other dinosaurs
     */
    protected int[] dinosaurInteractionRadius = {0, 1, -1};

    /**
     * Compute the Manhattan distance between two locations.
     *
     * @param a the first location
     * @param b the first location
     * @return the number of steps between a and b if you only move in the four cardinal directions.
     */
    public static int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
