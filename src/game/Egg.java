package game;

import edu.monash.fit2099.engine.Location;

import java.lang.reflect.Constructor;

/**
 * Class representing eggs of dinosaurs, edible by carnivores
 */
public class Egg extends Food {

    private Class dinosaurToHatch;
    private int eggAge = 0;
    private final int HATCHAGE = 7;

    /**
     * constructfor for the egg
     * @param parentDinosaur a parent (not super class) of the egg
     */
    public Egg(Dinosaur parentDinosaur) {
        super(10, "egg", 'E', true, parentDinosaur.getEcopoints());
        addCapability(GameCapability.CARNIVOREEDIBLE);
        this.dinosaurToHatch = parentDinosaur.getClass();
    }

    /**
     * action to hatch the egg
     * @return the dinosaur that hatches from the egg
     */
    public Dinosaur hatch() {
        boolean male = Math.random()*2 == 1;
        Constructor c = dinosaurToHatch.getConstructors()[0];
        try {
            return ((Dinosaur) c.newInstance(dinosaurToHatch.getSimpleName(), 10, 0, male));
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * returns the class of the dinosaur inside the egg
     * @return the class of the dinosaur inside the egg
     */
    public Class getDinosaurToHatch() {
        return dinosaurToHatch;
    }

    /**
     * Inform an Item on the ground of the passage of time.
     * This method is called once per turn, if the item rests upon the ground.
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        eggAge ++;
        if (eggAge >= HATCHAGE && !currentLocation.containsAnActor()){
            System.out.println("Egg has hatched into a "+ dinosaurToHatch.getSimpleName() + "!!!");
            ((GameMapModified)currentLocation.map()).increaseEcopoints(this.getEcopoints());
            currentLocation.addActor(hatch());
            currentLocation.removeItem(this);
        }
    }
}
