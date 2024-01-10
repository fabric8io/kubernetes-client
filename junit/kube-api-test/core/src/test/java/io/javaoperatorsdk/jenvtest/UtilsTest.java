package io.javaoperatorsdk.jenvtest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UtilsTest {

  @Test
  void getsLatestVersion() {
    assertThat(
        Utils.getLatestVersion(new ArrayList<>(List.of("1.22.4", "1.26.3", "1.26.1", "1.11.2"))))
        .isEqualTo("1.26.3");
    assertThat(Utils.getLatestVersion(new ArrayList<>(List.of("1.22", "1.23.1", "1.24"))))
        .isEqualTo("1.24");
  }

  @Test
  void checksIfVersionIsWildcard() {
    assertThat(Utils.isWildcardVersion("1.25.*")).isTrue();
    assertThat(Utils.isWildcardVersion("1.26.2")).isFalse();
  }

  @Test
  void wildcardToPrefix() {
    assertThat(Utils.wildcardToPrefix("1.25.*")).isEqualTo("1.25");
  }

}
