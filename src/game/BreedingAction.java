package game;

import edu.monash.fit2099.engine.Capabilities;

public class BreedingAction {
    private Capabilities capabilities;
    private Dinosaur parentDino;

    public Egg breed(){
        return new Egg(capabilities, parentDino);
    }
}
