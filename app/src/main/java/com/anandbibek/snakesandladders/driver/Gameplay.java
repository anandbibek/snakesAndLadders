package com.anandbibek.snakesandladders.driver;

import com.anandbibek.snakesandladders.api.Dice;
import com.anandbibek.snakesandladders.api.GameInterface;
import com.anandbibek.snakesandladders.game.GameImpl;
import com.anandbibek.snakesandladders.game.StandardDice;
import com.anandbibek.snakesandladders.model.Board;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Gameplay {

  private static final int BOARD_LENGTH = 100;

  public static void main(String[] args) {
    log.info("====== GAME START ======");

    Board board = new Board(BOARD_LENGTH);
    Dice dice = new StandardDice();
    GameInterface game = new GameImpl(board, dice);

    while (!game.nextTurn()) {
      log.info("Continuing to next turn...");
    }

    log.info("====== GAME END ======");
  }
}
