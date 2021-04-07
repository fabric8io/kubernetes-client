package io.fabric8.kubernetes.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class PluralizeTest {
  @Test
  void pluralizeShouldWork() {
    assertNull(Pluralize.toPlural(null));
    assertEquals("", Pluralize.toPlural(""));
    
    assertEquals("equipment", Pluralize.toPlural("equipment"));
    assertEquals("news", Pluralize.toPlural("news"));

    assertEquals("people", Pluralize.toPlural("person"));
    assertEquals("children", Pluralize.toPlural("child"));
    assertEquals("shoes", Pluralize.toPlural("shoe"));
    assertEquals("loves", Pluralize.toPlural("love"));
    assertEquals("movies", Pluralize.toPlural("movie"));
    assertEquals("lives", Pluralize.toPlural("life"));
    assertEquals("chives", Pluralize.toPlural("chive"));
    assertEquals("diminutives", Pluralize.toPlural("diminutive"));
    assertEquals("dice", Pluralize.toPlural("die"));
    assertEquals("scarves", Pluralize.toPlural("scarf"));
    assertEquals("humans", Pluralize.toPlural("human"));

    assertEquals("definitions", Pluralize.toPlural("definition"));
    assertEquals("statuses", Pluralize.toPlural("status"));
    assertEquals("endpoints", Pluralize.toPlural("endpoints"));
  }

}
