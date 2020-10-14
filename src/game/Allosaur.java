package game;

import edu.monash.fit2099.engine.Capabilities;

import java.util.ArrayList;

/**
 * A carnivorous dinosaur.
 */
public class Allosaur extends Dinosaur {
    private static Capabilities allosaurCapabilities(){
        return null;
    }

    private static ArrayList<Behaviour> allosaurBehaviour(){
        return null;
    }

    public Allosaur(String name, int foodLevel, int turnAge, boolean male) {
        super(name, foodLevel, turnAge, male, allosaurCapabilities(), allosaurBehaviour());
    }
}
