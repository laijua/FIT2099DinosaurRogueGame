package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;

public abstract class Dinosaur extends Actor {
    private int foodLevel;
    private int turnAge;
    private boolean adult = false;
    private boolean male;
    private boolean pregnant = false;
    private int pregnantCounter = 0;
    private Enum<?> edibleType;
    private Capabilities capabilities;
    private ArrayList<Behaviour> behaviour;

    private SeekFoodBehaviour seekFoodBehaviour = new SeekFoodBehaviour();

    private int hungryFoodLevel = 15;
    private int wellFedFoodLevel = 50;

    /**
     * Constructor.
     * All Dinosaurs are represented by a 'd' and have 100 hit points.
     *
     * @param name the name of this Stegosaur
     */
    public Dinosaur(String name, int foodLevel, int turnAge, boolean male, Capabilities capabilities, ArrayList<Behaviour> behaviour, Enum<?> edibleType) {
        super(name, 'd', 100);

        this.foodLevel = foodLevel;
        this.turnAge = turnAge;
        this.male = male;
        this.capabilities = capabilities;
        this.behaviour = behaviour;
        this.edibleType = edibleType;

        this.behaviour.add(new WanderBehaviour());
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return new Actions(new AttackAction(this));
    }

    /**
     * Figure out what to do next.
     * <p>
     * FIXME: Stegosaur wanders around at random, or if no suitable MoveActions are available, it
     * just stands there.  That's boring.
     *
     * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
     */

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        turnAge ++;
        if (turnAge > 30)
            adult = true;

//        Action wander = behaviour.getAction(this, map);
//        if (wander != null)
//            return wander;

        if (foodLevel < hungryFoodLevel && adult) {
            Action action = seekFoodBehaviour.getAction(this, map);
        }
        else if (foodLevel > wellFedFoodLevel){

        }

        for (Behaviour behaviours : behaviour) {
            Action action = behaviours.getAction(this, map);
            if (action != null) {
                return action;
            }
        }

        if(pregnant){
            pregnantCounter ++;
            if (pregnantCounter == 10){
                pregnantCounter = 0;
                return new BreedingAction(this);
            }
        }

            return new DoNothingAction();
    }

    boolean isMale(){
        return male;
    }

    boolean isAdult(){
        return adult;
    }

    public void increaseFoodLevel(int foodLevel){
        this.foodLevel += foodLevel;
    }

    public Enum<?> getEdibleType(){
        return edibleType;
    }

}
