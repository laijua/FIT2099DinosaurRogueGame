package game;

import edu.monash.fit2099.engine.Location;

public class GrassAsFood extends Food {
    public GrassAsFood(Location location) {
        super(5, "grass", 'g', true);
        location.setGround(new Dirt());
    }
}
