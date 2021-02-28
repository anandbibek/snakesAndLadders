package com.anandbibek.snakesandladders;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.anandbibek.snakesandladders.api.Dice;
import com.anandbibek.snakesandladders.game.StandardDice;
import org.junit.jupiter.api.RepeatedTest;

class StandardDiceTest {

  @RepeatedTest(20)
  void diceRollTest() {

    Dice dice = new StandardDice();
    int roll = dice.roll();
    System.out.println("Roll:: " + roll);

    assertTrue(roll >= 1, "Dice roll must be greater than or equal to 1");
    assertTrue(roll <= 6, "Dice roll must be smaller than or equal to 6");
  }

}
