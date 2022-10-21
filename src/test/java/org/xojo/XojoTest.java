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
  void addNodeSuccess() throws IllegalAccessException {
    final Xojo expected = new Xojo("parent/child");
    final Xojo actual = this.xj.addNode(this.child);
    assertEquals(expected, actual);
  }

  @Test
  void addNodeThrowsIllegalStateException() {
    assertThrows(IllegalAccessException.class, () -> this.xj.addNode(""));
  }

  @Test
  void addAttrSuccess() throws IllegalAccessException {
    final Xojo expected = new Xojo("parent[@key=\"value\"]");
    final Xojo actual = this.xj.addAttr("key", "value");
    assertEquals(expected, actual);
  }

  @Test
  void addAttrsSuccess() throws IllegalAccessException {
    final Xojo expected = new Xojo("parent@attrs");
    final Xojo actual = this.xj.addAttrs("attrs");
    assertEquals(expected, actual);
  }

  @Test
  void addAttrsThrowsIllegalStateException() {
    assertThrows(IllegalAccessException.class, () -> this.xj.addAttrs(""));
  }
}
