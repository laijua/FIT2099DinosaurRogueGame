package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

import java.util.Objects;

public class LocationModified extends Location {

    GameMapModified map;

    public LocationModified(GameMap map, int x, int y) {
        super(map, x, y);
    }

    @Override
    public GameMapModified map() {
        return super.map();
    }

    /**
     * Accessor to determine whether there is Food at this location.
     *
     * @return true if and only if there is Food at this location.
     */
    public boolean containsFood() {
        return map().isAnActorAt(this);
    }

    /**
     * Accessor to retrieve the Actor at this location.
     *
     * @return the Actor at this location, if there is one
     */
    public Actor getActor() {
        return map().getActorAt(this);
    }

    /**
     * Add an Actor to the Location.
     * This is really only here for consistency for the Location API.
     *
     * @param actor the Actor to add
     */
    public void addActor(Actor actor) {
        Objects.requireNonNull(actor);
        map().addActor(actor, this);
    }
}
