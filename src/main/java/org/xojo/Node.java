package org.xojo;

public class Node extends Unit {

  private final String value;

  public Node(final String value) {
    this.value = value;
  }

  public String value() {
    this.check(this.value);
    return this.value;
  }
}
