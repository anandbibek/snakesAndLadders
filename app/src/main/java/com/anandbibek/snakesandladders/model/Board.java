package com.anandbibek.snakesandladders.model;

import java.util.List;
import lombok.Data;

@Data
public class Board {

  private final int boardLength;
  private int playerPosition;
  private List<Snake> snakes;
}
