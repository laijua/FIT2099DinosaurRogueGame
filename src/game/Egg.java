package game;

import edu.monash.fit2099.engine.Capabilities;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Random;

public class Egg extends Food {

    private Class dinosaurToHatch;

    public Egg(  Dinosaur parentDinosaur) {
        super(10, "egg", 'e', true);
        this.capabilities.addCapability(GameCapability.CARNIVOREEDIBLE);
        this.dinosaurToHatch = parentDinosaur.getClass();
    }

    public Dinosaur hatch() {
//        Class<Dinosaur> temp = dinosaurToHatch.getClass();
//        Constructor<Dinosaur> con = temp.getConstructor();
//        return new dinosaurToHatch.getClass();
//        boolean male = new Random().nextInt(1) == 1;
        boolean male = Math.random()*2 == 1;

        if (dinosaurToHatch == Stegosaur.class){
            return new Stegosaur("babyA", 50, 0, male) ;
        }
        else if (dinosaurToHatch == Allosaur.class){
            return new Allosaur("babyA", 50, 0, male)  ;
        }
        return null;
    }

}
