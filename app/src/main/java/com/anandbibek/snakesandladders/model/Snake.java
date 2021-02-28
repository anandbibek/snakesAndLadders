package com.anandbibek.snakesandladders.model;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Snake {

  private final int head;
  private final int tail;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Snake snake = (Snake) o;
    return head == snake.head;
  }

  // we don't want duplicate snakes at same "head" position
  @Override
  public int hashCode() {
    return Objects.hash(head);
  }
}
