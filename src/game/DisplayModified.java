package game;

import edu.monash.fit2099.engine.Display;
import java.util.InputMismatchException;

public class DisplayModified extends Display {
  public int readInt() {
    boolean notfoundInt = true;
    while (notfoundInt) {
      try {
        Integer val = this.keyboard.nextInt();
        if (val>=1)
        return val;
        System.out.println("cant be negative try again");
      } catch (InputMismatchException e) {
        System.out.println("Invalid input type (must be an integer): try again");
        this.keyboard.nextLine();
      }

    }
    return 0;
  }
}
