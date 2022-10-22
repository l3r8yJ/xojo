package org.xojo;

import java.util.Objects;

public final class Xojo {
  private final String body;

  public Xojo(final String body) {
    this.body = body;
  }

  public Xojo addAttr(final Attr attr) {
    return new Xojo(String.format("%s[@%s=\"%s\"]", this.body, attr.key(), attr.value()));
  }

  public Xojo addAttrs(final Node node) {
    return new Xojo(this.formatted("@%s", node));
  }

  public Xojo addNode(final Node node) {
    return new Xojo(this.formatted("/%s", node));
  }

  public Xojo addNodes(final Node node) {
    return new Xojo(this.formatted("//%s", node));
  }

  public Xojo addProperty(final Node node) {
    return new Xojo(this.formatted("%s()", node));
  }

  public Xojo all() {
    return new Xojo(String.format("%s*", this.body));
  }

  public Xojo at(final int pos) {
    return new Xojo(String.format("%s[%d]", this.body, pos));
  }

  @Override
  public String toString() {
    return this.body;
  }

  @Override
  public boolean equals(final Object obj) {
    if (null == obj) throw new IllegalArgumentException("Object can't be a null!");
    if (!obj.getClass().equals(Xojo.class)) return false;
    else return Objects.equals(((Xojo) obj).body, this.body);
  }

  private String formatted(final String format, final Node node) {
    return String.format("%s".concat(format), this.body, node.value());
  }
}
