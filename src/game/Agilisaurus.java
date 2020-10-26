package game;

import edu.monash.fit2099.engine.IntrinsicWeapon;

import java.util.ArrayList;

public class Agilisaurus extends Dinosaur {

    public Agilisaurus(String name, int foodLevel, int turnAge, boolean male, int thirstLevel) {
        super(name, foodLevel, turnAge, male, agilisaurusBehaviour(), agilisaurusEdibleType(), 'S', 100, thirstLevel);
        addCapability(GameCapability.CARNIVOREATTACKABLE);
        addCapability(GameCapability.CARNIVOREEDIBLE);
    }

    private static ArrayList<Behaviour> agilisaurusBehaviour() {
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new SeekFoodBehaviour());
        behaviours.add(new BreedingBehaviour());
        behaviours.add(new AttackBehaviour());
        behaviours.add(new WanderBehaviour());
        return behaviours;
    }

    private static ArrayList<Enum<?>> agilisaurusEdibleType() {
        ArrayList<Enum<?>> edibleTypes = new ArrayList<>();
        edibleTypes.add(GameCapability.HERBIVOREEDIBLE);
        edibleTypes.add(GameCapability.CARNIVOREEDIBLE);
        return edibleTypes;
    }

    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(25, "bites");
    }

}
