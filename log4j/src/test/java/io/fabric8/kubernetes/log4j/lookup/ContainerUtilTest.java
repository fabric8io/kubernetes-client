package io.fabric8.kubernetes.log4j.lookup;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.URL;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ContainerUtilTest {

  private static final String CONTAINER_ID = "3dd988081e7149463c043b5d9c57d7309e079c5e9290f91feba1cc45a04d6a5b";

  static Stream<Arguments> should_recognize_container_id() {
    return Stream.of(
        // Some possible example /proc/self/cgroup
        Arguments.of("cgroups/positive/case_0.txt", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_1.txt", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_2.txt", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_3.txt", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_4.txt", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_5.txt", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_6.txt", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_7.txt", CONTAINER_ID),
        Arguments.of("cgroups/positive/case_8.txt", CONTAINER_ID),
        // Smoke test in case the file changes format
        Arguments.of("cgroups/negative/case_0.txt", null),
        Arguments.of("cgroups/negative/case_1.txt", null));
  }

  @ParameterizedTest
  @MethodSource
  void should_recognize_container_id(String resourceFile, String expectedContainerId) throws Exception {
    final URL url = ContainerUtilTest.class.getClassLoader().getResource(resourceFile);
    assertThat(url).hasProtocol("file");
    assertThat(ContainerUtil.getContainerId(Paths.get(url.toURI()))).isEqualTo(expectedContainerId);
  }
}
