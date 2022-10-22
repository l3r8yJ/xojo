package org.xojo;

public class Node extends Unit {

  private final String value;

  public Node(final String value) {
    this.check(value);
    this.value = value;
  }

  public String value() {
    return this.value;
  }
}
