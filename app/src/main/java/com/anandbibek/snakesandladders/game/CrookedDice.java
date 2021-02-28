package com.anandbibek.snakesandladders.game;

public class CrookedDice extends StandardDice {

  @Override
  public int roll() {
    return (random.nextInt(3) + 1) * 2;
  }
}
