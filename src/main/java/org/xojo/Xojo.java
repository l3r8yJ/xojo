package org.xojo;

import java.util.Objects;

public class Xojo {
  private final String body;

  public Xojo(final String body) {
    this.body = body;
  }

  public Xojo addNode(final Node node) {
    return new Xojo(this.body + "/" + node.value());
  }

  public Xojo addAttr(final Attr attr) {
    return new Xojo(
      this.body.concat(
        String.format(
          "[@%s=\"%s\"]",
          attr.key(),
          attr.value()
        )
      )
    );
  }

  public Xojo addAttrs(final Node node) {
    return new Xojo(this.body + "@" + node.value());
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
}
