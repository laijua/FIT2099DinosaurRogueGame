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
    private int unconsciousTurns = 0;
    private boolean unconscious = false;


    private ArrayList<Behaviour> behaviour;


    /**
     * Constructor.
     * All Dinosaurs are represented by a 'd' and have 100 hit points.
     *
     * @param name the name of this Stegosaur
     */
    public Dinosaur(String name, int foodLevel, int turnAge, boolean male, ArrayList<Behaviour> behaviour, Enum<?> edibleType, char displayChar) {
        super(name, displayChar, 100);
        if (foodLevel < 0) {
            throw new ArithmeticException("foodLevel cant be below 0");
        }
        if (foodLevel > 100) {
            throw new ArithmeticException("foodLevel cant be above 100");
        }
        if (turnAge < 0) {
            throw new ArithmeticException("age cant be below 0");
        }
        if (behaviour == null) {
            throw new NullPointerException("behaviour cant be null");
        }

        this.foodLevel = foodLevel;
        this.turnAge = turnAge;
        this.male = male;
        this.behaviour = behaviour;
        this.edibleType = edibleType;

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
        final int DEATHTURN = 1;
        final int ADULTAGE = 30;
        turnAge++;
        if (turnAge > ADULTAGE)
            adult = true;
        if (!unconscious) {

            foodLevel--;
            if (foodLevel <= 0) {
                unconscious = true;
            }


            if (pregnant) {
                pregnantCounter++;
                if (pregnantCounter >= 5) {
                    pregnant = false;
                    pregnantCounter = 0;
                    return new LayEggAction(this);
                }
            }


            for (Behaviour behaviours : behaviour) {
                Action action = behaviours.getAction(this, map);
                if (action != null) {
                    return action;
                }
            }

        } else {
            unconsciousTurns++;
            if (unconsciousTurns >= DEATHTURN) {
                return new DieAction();
            }
        }


        return new DoNothingAction();
    }

    boolean isMale() {
        return male;
    }

    boolean isAdult() {
        return adult;
    }

    public void increaseFoodLevel(int foodLevel) {
        this.foodLevel += foodLevel;
    }

    public Enum<?> getEdibleType() {
        return edibleType;
    }

    public void impregnate() {
        if (!male) {
            pregnant = true;
        }
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public int getFoodLevel() {
        return foodLevel;
    }

}
