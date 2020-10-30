package game;

import edu.monash.fit2099.engine.Location;

/**
 * Class for when grass is about to be eaten off the ground
 */
public class GrassAsFood extends Food {
    /**
     * Constructor for the GrassAsFood class
     * @param location location of where grass is being eaten
     */
    public GrassAsFood(Location location) {
        super(5, "grass", 'g', true);
        location.setGround(new Dirt());
    }
}
