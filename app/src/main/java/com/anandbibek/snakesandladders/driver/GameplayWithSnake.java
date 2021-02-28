package com.anandbibek.snakesandladders.driver;

import com.anandbibek.snakesandladders.api.Dice;
import com.anandbibek.snakesandladders.api.GameInterface;
import com.anandbibek.snakesandladders.game.GameImpl;
import com.anandbibek.snakesandladders.game.StandardDice;
import com.anandbibek.snakesandladders.model.Board;
import com.anandbibek.snakesandladders.model.Snake;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GameplayWithSnake {

  private static final int BOARD_LENGTH = 100;

  public static void main(String[] args) {
    log.info("====== GAME START ======");

    Board board = new Board(BOARD_LENGTH);
    Dice dice = new StandardDice();

    List<Snake> snakes = new ArrayList<>();
    snakes.add(new Snake(14, 7));
    snakes.add(new Snake(20, 5));
    snakes.add(new Snake(58, 29));
    snakes.add(new Snake(65, 5));

    GameInterface game = new GameImpl(board, dice, snakes);

    while (!game.nextTurn()) {
      log.info("Continuing to next turn...");
    }

    log.info("====== GAME END ======");
  }
}
