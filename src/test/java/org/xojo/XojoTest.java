package org.xojo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class XojoTest {
  final String parent = "parent";
  final String child = "child";

  Xojo xj;

  @BeforeEach
  void setUp() {
    this.xj = new Xojo(this.parent);
  }

  @Test
  void addNodeSuccess() {
    final Xojo expected = new Xojo("parent/child");
    final Xojo actual = this.xj.addNode(new Node(this.child));
    assertEquals(expected, actual);
  }

  @Test
  void addAttrSuccess() {
    final Xojo expected = new Xojo("parent[@key=\"value\"]");
    final Xojo actual = this.xj.addAttr(new Attr("key", "value"));
    assertEquals(expected, actual);
  }

  @Test
  void addAttrsSuccess() {
    final Xojo expected = new Xojo("parent@attrs");
    final Xojo actual = this.xj.addAttrs(new Node("attrs"));
    assertEquals(expected, actual);
  }

  @Test
  void addAttrsThrowsIllegalStateException() {
    assertThrows(IllegalStateException.class, () -> this.xj.addAttrs(new Node("")));
  }
}
