package org.xojo;

public class Attr extends Unit {
  private final String key;
  private final String value;

  public Attr(final String key, final String value) {
    this.check(key);
    this.check(value);
    this.key = key;
    this.value = value;
  }

  public String key() {
    return this.key;
  }

  public String value() {
    return this.value;
  }
}
