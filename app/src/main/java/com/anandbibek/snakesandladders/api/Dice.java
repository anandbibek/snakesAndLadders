package com.anandbibek.snakesandladders.api;

public interface Dice {

  /**
   * @return a random number between 1 to N, N being the dice face count based on Impl
   */
  int roll();
}
