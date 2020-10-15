package game;

import edu.monash.fit2099.engine.Capabilities;
import edu.monash.fit2099.engine.Location;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Random;

public class Egg extends Food {

    private Class dinosaurToHatch;
    private int eggAge = 0;

    public Egg(Dinosaur parentDinosaur) {
        super(10, "egg", 'E', true);
        addCapability(GameCapability.CARNIVOREEDIBLE);
        this.dinosaurToHatch = parentDinosaur.getClass();
    }

    public Dinosaur hatch() {
        boolean male = Math.random()*2 == 1;

        if (dinosaurToHatch == Stegosaur.class){
            return new Stegosaur("Stegosaur", 50, 0, male) ;
        }
        else if (dinosaurToHatch == Allosaur.class){
            return new Allosaur("Allosaur", 50, 0, male)  ;
        }
        return null;
    }

    public Class getDinosaurToHatch() {
        return dinosaurToHatch;
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        eggAge ++;
        if (eggAge >= 10 && !currentLocation.containsAnActor()){
            System.out.println("Egg has hatched into a "+ dinosaurToHatch.getSimpleName() + "!!!");
            currentLocation.addActor(hatch());
            currentLocation.removeItem(this);
        }
    }
}
