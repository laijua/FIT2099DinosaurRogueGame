package game;

import edu.monash.fit2099.engine.IntrinsicWeapon;

import java.util.ArrayList;

/**
 * An Allosaur, a carnivorous dinosaur.
 */
public class Allosaur extends Dinosaur {

    /**
     * Constructs an Allosaur
     *
     * @param name      String to name the Allosaur
     * @param foodLevel Int representing food level of Allosaur
     * @param turnAge   Int representing age of Allosaur
     * @param male      Boolean to tell if Allosaur is male or not
     */
    public Allosaur(String name, int foodLevel, int turnAge, boolean male, int thirstLevel) {
        super(name, foodLevel, turnAge, male, allosaurBehaviour(), allosaurEdibleType(), 'A', 1000, thirstLevel, 40);
    }

    /**
     * Method to input an array list of Allosaur behaviours into the parent constructor
     *
     * @return an ArrayList of behaviours
     */
    private static ArrayList<Behaviour> allosaurBehaviour() {
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new SeekFoodBehaviour());
        behaviours.add(new ThirstBehaviour());
        behaviours.add(new BreedingBehaviour());
        behaviours.add(new AttackBehaviour());
        behaviours.add(new WanderBehaviour());
        return behaviours;
    }

    private static ArrayList<Enum<?>> allosaurEdibleType() {
        ArrayList<Enum<?>> edibleTypes = new ArrayList<>();
        edibleTypes.add(GameCapability.CARNIVOREEDIBLE);
        return edibleTypes;
    }

    /**
     * Returns the weapon available for the Allosaur
     *
     * @return Returns the weapon available for the Allosaur
     */
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(40, "bites");
    }
}
