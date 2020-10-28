package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;

/**
 * An abstract Dinosaur class
 */
public abstract class Dinosaur extends Actor {
    private int foodLevel;
    private int thirstLevel;
    private int turnAge;
    private boolean adult = false;
    private boolean male;
    private boolean pregnant = false;
    private int pregnantCounter = 0;
    private ArrayList<Enum<?>> edibleType;
    private int unconsciousTurns = 0;
    private boolean unconscious = false;
    private ArrayList<Behaviour> behaviour;
    private int ecopoints;
    private int foodValue;
    private Enum<?> canAttackTier;

    /**
     * Constructor.
     *
     * @param name        the name of the dinosaur in String
     * @param foodLevel   the food level of the dinosaur in int
     * @param turnAge     the age of the dinosaur in int
     * @param male        boolean to determine gender of dinosaur
     * @param behaviour   arraylist of behaviours of dinosaur
     * @param edibleType  Enum to determine what dinosaur can eat
     * @param displayChar the display character on the console for the dinosaur
     */
    public Dinosaur(String name, int foodLevel, int turnAge, boolean male, ArrayList<Behaviour> behaviour, ArrayList<Enum<?>> edibleType, char displayChar, int ecopoints,
                    int thirstLevel, int foodValue, Enum<?> canAttackTier)
    {
        super(name, displayChar, 100);
        if (foodLevel < 0) {
            throw new ArithmeticException("foodLevel cant be below 0");
        }
        if (foodLevel > 100) {
            throw new ArithmeticException("foodLevel cant be above 100");
        }
        if (thirstLevel < 0) {
            throw new ArithmeticException("foodLevel cant be below 0");
        }
        if (thirstLevel > 100) {
            throw new ArithmeticException("foodLevel cant be above 100");
        }
        if (turnAge < 0) {
            throw new ArithmeticException("age cant be below 0");
        }
        if (behaviour == null) {
            throw new NullPointerException("behaviour cant be null");
        }
        if (foodValue < 0) {
            throw new ArithmeticException("foodLevel cant be below 0");
        }

        this.foodLevel = foodLevel;
        this.turnAge = turnAge;
        this.male = male;
        this.behaviour = behaviour;
        this.edibleType = edibleType;
        this.ecopoints = ecopoints;
        this.thirstLevel = thirstLevel;
        this.foodValue = foodValue;
        this.canAttackTier = canAttackTier;

    }

    /**
     * Returns a collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return allowable actions
     */
    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return new Actions(new AttackAction(this));
    }


    /**
     * Select and return an action to perform on the current turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {

        int x = map.locationOf(this).x();
        int y = map.locationOf(this).y();

        final int DEATHTURN = 20;
        final int ADULTAGE = 30;
        final int PREGNANTDUE = 5;
        turnAge++;
        if (turnAge > ADULTAGE) {
            adult = true;
        }

        if (foodLevel > 0 && unconscious && thirstLevel > 0) {
            unconscious = false;
            unconsciousTurns = 0;
            System.out.println(this + " at " + "(" + x + ", " + y + ") is back from being unconscious");
        }

        if (!unconscious) {
            thirstLevel--;
            foodLevel--;
            if (foodLevel <= 0 || thirstLevel <= 0) {
                unconscious = true;
                System.out.println(this + " at " + "(" + x + ", " + y + ") is unconscious");
            }


            if (pregnant) {
                pregnantCounter++;
                if (pregnantCounter >= PREGNANTDUE) {
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

    /**
     * checks what gender dinosaur is
     *
     * @return boolean. true if male, false otherwise
     */
    boolean isMale() {
        return male;
    }

    /**
     * checks if dinosaur is an adult
     *
     * @return boolean. true if dinosaur is adult, false otherwise
     */
    boolean isAdult() {
        return adult;
    }

    /**
     * increases food level of dinosaur
     *
     * @param foodLevel food level to increase by
     */
    public void increaseFoodLevel(int foodLevel) {
        if (foodLevel < 0) {
            throw new ArithmeticException("foodLevel cant be below 0");
        }
        this.foodLevel += foodLevel;
        if (this.foodLevel > 100) {
            this.foodLevel = 100;
        }
    }

    /**
     * returns the type of food the dinosaur can eat
     *
     * @return Enum representing the capability of type of food the dinosaur can eat
     */
    public ArrayList<Enum<?>> getEdibleType() {
        return edibleType;
    }

    public boolean containsEdible(Enum<?> edibleType) {
        return this.edibleType.contains(edibleType);
    }

    /**
     * makes the dinosaur pregnant if it is female
     */
    public void impregnate() {
        if (!male) {
            pregnant = true;
        }
    }

    /**
     * returns true if the dinosaur is pregnant
     *
     * @return true if the dinosaur is pregnant, false otherwise
     */
    public boolean isPregnant() {
        return pregnant;
    }

    /**
     * returns the food level of the dinosaur
     *
     * @return food level of the dinosaur
     */
    public int getFoodLevel() {
        return foodLevel;
    }

    /**
     * returns the ecopoints of the dinosaur in the event of egg hatched.
     *
     * @return Integer Value
     */
    public int getEcopoints() {
        return ecopoints;
    }


    public int getThirstLevel() {
        return thirstLevel;
    }

    public void increaseThirstLevel() {
        this.thirstLevel += 10;
        if (this.thirstLevel > 100) {
            this.thirstLevel = 100;
        }
    }

    public int getFoodValue() {
        return foodValue;
    }

    public Enum<?> getCanAttackTier() {
        return canAttackTier;
    }
}
