package com.anandbibek.snakesandladders.api;

public interface GameInterface {

  /**
   * drives the next turn for players
   *
   * @return true if any of the players reached the end and the game needs to be ended
   */
  boolean nextTurn();

}
