package com.anandbibek.snakesandladders.game;

import com.anandbibek.snakesandladders.api.Dice;
import com.anandbibek.snakesandladders.api.GameInterface;
import com.anandbibek.snakesandladders.model.Board;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GameImpl implements GameInterface {

  private final Board board;
  private final Dice dice;

  public GameImpl(Board board, Dice dice) {
    this.board = board;
    this.dice = dice;
    this.board.setPlayerPosition(0);

    //TODO reptiles aren't out yet
    this.board.setSnakes(new ArrayList<>());
  }

  @Override
  public boolean nextTurn() {
    //TODO will implement
    // 1. Can't start without a six on dice
    // 2. Can't reach final point without an exact roll

    final int roll = dice.roll();
    log.info("Player rolled dice : {}", roll);
    board.setPlayerPosition(board.getPlayerPosition() + roll);
    if (board.getPlayerPosition() >= board.getBoardLength()) {
      log.info("Player crossed the finishing line... ******");
      return true;
    } else {
      log.info("Player advanced to position : {}", board.getPlayerPosition());
      return false;
    }
  }
}
