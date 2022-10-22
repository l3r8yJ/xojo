package org.xojo;

public class Unit {
  protected void check(final String unit) {
    if (unit.isEmpty() || unit.isBlank()) {
      throw new IllegalStateException("Node can't be empty!");
    }
  }
}
