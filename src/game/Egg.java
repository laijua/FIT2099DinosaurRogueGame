package game;

import edu.monash.fit2099.engine.Capabilities;
import edu.monash.fit2099.engine.Location;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
        Constructor c = dinosaurToHatch.getConstructors()[0];
        try {
            return ((Dinosaur) c.newInstance(dinosaurToHatch.getName().replace("game.",""), 10, 0, male));
        }catch (Exception e){
            e.printStackTrace();
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
        if (eggAge >= 2 && !currentLocation.containsAnActor()){
            System.out.println("Egg has hatched into a "+ dinosaurToHatch.getSimpleName() + "!!!");
            currentLocation.addActor(hatch());
            currentLocation.removeItem(this);
        }
    }
}
