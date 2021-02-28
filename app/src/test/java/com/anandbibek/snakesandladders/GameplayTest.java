package com.anandbibek.snakesandladders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.anandbibek.snakesandladders.api.Dice;
import com.anandbibek.snakesandladders.api.GameInterface;
import com.anandbibek.snakesandladders.game.GameImpl;
import com.anandbibek.snakesandladders.game.StandardDice;
import com.anandbibek.snakesandladders.model.Board;
import com.anandbibek.snakesandladders.model.Snake;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameplayTest {

  Board board;
  GameInterface game;

  @BeforeEach
  public void setup() {

    Dice dice = new MockDice(5);
    board = new Board(100);
    game = new GameImpl(board, dice);
  }

  @Test
  void gameStart() {
    game.nextTurn();
    assertEquals(5, board.getPlayerPosition(), "Player should be at 5 after first turn");

  }

  @Test
  void gameEnd() {
    int count = 1;
    while (!game.nextTurn()) {
      count++;
    }
    assertEquals(20, count, "Game should be finished in 20 turns");

  }

  @Test
  void snakeMetabolism() {
    game = new GameImpl(board, new MockDice(14), Collections.singletonList(new Snake(14, 7)));
    game.nextTurn();
    assertEquals(7, board.getPlayerPosition(),
        "Player should be at 7 after being digested by snake");
  }

  private static class MockDice extends StandardDice {

    private final int fixedRoll;

    private MockDice(int fixedRoll) {
      this.fixedRoll = fixedRoll;
    }

    @Override
    public int roll() {
      return fixedRoll;
    }
  }
}
