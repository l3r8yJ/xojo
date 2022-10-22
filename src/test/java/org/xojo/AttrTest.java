package org.xojo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AttrTest {

  @Test
  void failsWithIllegalStateException() {
    assertThrows(IllegalStateException.class, () -> new Attr("", ""));
  }
}