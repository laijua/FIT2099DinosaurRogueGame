package game;

import edu.monash.fit2099.engine.Capabilities;
import edu.monash.fit2099.engine.IntrinsicWeapon;

import java.util.ArrayList;

/**
 * A carnivorous dinosaur.
 */
public class Allosaur extends Dinosaur {
    private static Capabilities allosaurCapabilities(){
        Capabilities capabilities = new Capabilities();
//        capabilities.addCapability(GameCapability.ALLOSAURATTACKABLE);
        return capabilities;
    }

    private static ArrayList<Behaviour> allosaurBehaviour(){
        ArrayList<Behaviour> behaviours = new ArrayList<>();
//        behaviours.add(new WanderBehaviour());
        behaviours.add(new AttackBehaviour());
        return behaviours;
    }

    public Allosaur(String name, int foodLevel, int turnAge, boolean male) {
        super(name, foodLevel, turnAge, male, allosaurCapabilities(), allosaurBehaviour(), GameCapability.CARNIVOREEDIBLE, 'a');
    }

    @Override
    public String toString() {
        return "Allosaur";
    }

    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "bites");
    }
}
