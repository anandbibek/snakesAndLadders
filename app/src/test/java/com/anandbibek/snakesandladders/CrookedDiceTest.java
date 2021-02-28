package com.anandbibek.snakesandladders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.anandbibek.snakesandladders.api.Dice;
import com.anandbibek.snakesandladders.game.CrookedDice;
import org.junit.jupiter.api.RepeatedTest;

class CrookedDiceTest {

  @RepeatedTest(20)
  void diceRollTest() {

    Dice dice = new CrookedDice();
    int roll = dice.roll();
    System.out.println("Roll:: " + roll);

    assertEquals(0, roll % 2, "Dice roll must be even");
    assertTrue(roll >= 1, "Dice roll must be greater than or equal to 1");
    assertTrue(roll <= 6, "Dice roll must be smaller than or equal to 6");
  }

}
