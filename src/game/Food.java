package game;

import edu.monash.fit2099.engine.Item;

public abstract class Food extends Item {
    private int foodLevelPoint;

    public Food(int foodLevelPoint,String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
        this.foodLevelPoint = foodLevelPoint;
    }
}
