package com.anandbibek.snakesandladders.game;

import com.anandbibek.snakesandladders.api.Dice;
import java.util.Random;

public class StandardDice implements Dice {

  protected final Random random = new Random();

  /**
   * Roll for a six-faced standard mortal dice
   *
   * @return a random integer between 1 - 6
   */
  @Override
  public int roll() {
    return random.nextInt(6) + 1;
  }
}
