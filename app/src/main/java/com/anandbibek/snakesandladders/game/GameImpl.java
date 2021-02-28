package com.anandbibek.snakesandladders.game;

import com.anandbibek.snakesandladders.api.Dice;
import com.anandbibek.snakesandladders.api.GameInterface;
import com.anandbibek.snakesandladders.model.Board;
import com.anandbibek.snakesandladders.model.Snake;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GameImpl implements GameInterface {

  private final Board board;
  private final Dice dice;

  public GameImpl(Board board, Dice dice) {
    this.board = board;
    this.dice = dice;
    this.board.setPlayerPosition(0);

    this.board.setSnakes(new ArrayList<>());
  }

  public GameImpl(Board board, Dice dice, List<Snake> snakes) {
    this.board = board;
    this.dice = dice;
    this.board.setPlayerPosition(0);

    this.board.setSnakes(snakes);
  }

  @Override
  public boolean nextTurn() {
    //TODO will implement
    // 1. Can't start without a six on dice
    // 2. Can't reach final point without an exact roll

    final int roll = dice.roll();
    log.info("Player rolled dice : {}", roll);
    board.setPlayerPosition(board.getPlayerPosition() + roll);

    // if there's a snake on that position, go down to its tail
    board.getSnakes().stream()
        .filter(snake -> snake.getHead() == board.getPlayerPosition())
        .findFirst()
        .ifPresent(snake -> {
          log.info("Player devoured by snake. Landed at : {}", snake.getTail());
          board.setPlayerPosition(snake.getTail());
        });

    if (board.getPlayerPosition() >= board.getBoardLength()) {
      log.info("Player crossed the finishing line... ******");
      return true;
    } else {
      log.info("Player position : {}", board.getPlayerPosition());
      return false;
    }
  }
}
