package org.xojo;

import java.util.Objects;

public class Xojo {
  private final String body;

  public Xojo(final String body) {
    this.body = body;
  }

  public Xojo addNode(final String node) throws IllegalAccessException {
    this.checkNode(node);
    return new Xojo(this.body + "/" + node);
  }

  public Xojo addAttr(final String key, final String value) throws IllegalAccessException {
    this.checkNode(key);
    return new Xojo(
      this.body.concat(
        String.format(
          "[@%s=\"%s\"]",
          key,
          value
        )
      )
    );
  }

  public Xojo addAttrs(final String node) throws IllegalAccessException {
    this.checkNode(node);
    return new Xojo(this.body + "@" + node);
  }

  @Override
  public String toString() {
    return this.body;
  }

  @Override
  public boolean equals(final Object obj) {
    if (null == obj) throw new IllegalArgumentException("Object can't be a null!");
    if (!obj.getClass().equals(Xojo.class)) return false;
    else return Objects.equals(Xojo.class.cast(obj).body, this.body);
  }

  private void checkNode(final String node) throws IllegalAccessException {
    if (node.isEmpty() || node.isBlank()) {
      throw new IllegalAccessException("Node can't be empty!");
    }
  }
}
