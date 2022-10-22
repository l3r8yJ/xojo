package org.xojo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeTest {

  @Test
  void failsWithIllegalStateException() {
    assertThrows(IllegalStateException.class, () -> new Node(""));
  }
}