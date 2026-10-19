/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.DefaultKubernetesResourceList;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJob;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobList;
import io.fabric8.kubernetes.client.Good;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.data.MapEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import tools.jackson.core.JacksonException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.inferListType;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.argumentSet;

class KubernetesResourceUtilTest {
  private ConfigMap configMap1;

  /**
   * To verify null in Thread.currentThread().getContextClassLoader() would be handled in loadRelated()
   */
  @Test
  void testNullContextClassLoader() {
    ClassLoader currContextClassLoader = Thread.currentThread().getContextClassLoader();
    try {
      Thread.currentThread().setContextClassLoader(null);
      assertEquals(PodList.class, inferListType(Pod.class));
    } finally {
      Thread.currentThread().setContextClassLoader(currContextClassLoader);
    }
  }

  @BeforeEach
  public void createTestResource() {
    configMap1 = new ConfigMapBuilder()
        .withNewMetadata()
        .withName("configmap1")
        .withNamespace("ns1")
        .withAnnotations(Collections.singletonMap("foo", "bar"))
        .withLabels(Collections.singletonMap("foo-label", "bar-label"))
        .endMetadata()
        .addToData("one", "1")
        .build();
  }

  @Test
  void testNullSafeOperationsForName() {
    String resourceName = KubernetesResourceUtil.getName(configMap1);
    assertNotNull(resourceName);
    assertEquals("configmap1", resourceName);
  }

  @Test
  void testNullSafeOperationsForNamespace() {
    String namespace = KubernetesResourceUtil.getNamespace(configMap1);
    assertNotNull(namespace);
    assertEquals("ns1", namespace);
    assertEquals("ns1/configmap1", KubernetesResourceUtil.getQualifiedName(configMap1));
  }

  @Test
  void testNullSafeOperationsForLabels() {
    Map<String, String> labels = KubernetesResourceUtil.getOrCreateLabels(configMap1);
    assertNotNull(labels);
    assertEquals(Collections.singletonMap("foo-label", "bar-label"), labels);
  }

  @Test
  void testNullSafeOperationsForAnnotations() {
    Map<String, String> annos = KubernetesResourceUtil.getOrCreateAnnotations(configMap1);
    assertNotNull(annos);
    assertEquals(Collections.singletonMap("foo", "bar"), annos);
  }

  @Nested
  @DisplayName("isValidName")
  class IsValidName {

    @ParameterizedTest
    @MethodSource("validNames")
    @DisplayName("name validation passes when the name is up to 63 lowercase alphanumeric characters or '-', starting and ending with an alphanumeric character")
    void passesForValidName(String name) {
      assertThat(KubernetesResourceUtil.isValidName(name)).isTrue();
    }

    static Stream<Arguments> validNames() {
      return Stream.of(
          argumentSet("lowercase with digits", "configmap1"),
          argumentSet("63 characters", "a".repeat(63)));
    }

    @ParameterizedTest
    @MethodSource("invalidNames")
    @DisplayName("name validation fails when the name is too long or has characters other than lowercase alphanumerics and '-'")
    void failsForInvalidName(String name) {
      assertThat(KubernetesResourceUtil.isValidName(name)).isFalse();
    }

    static Stream<Arguments> invalidNames() {
      return Stream.of(
          argumentSet("contains '.'", "test.invalid.name"),
          argumentSet("64 characters", "a".repeat(64)));
    }
  }

  @Nested
  @DisplayName("isValidSubdomainName")
  class IsValidSubdomainName {

    @ParameterizedTest
    @MethodSource("validSubdomainNames")
    @DisplayName("subdomain name validation passes when the name is up to 253 characters of '.'-separated DNS labels")
    void passesForValidSubdomainName(String name) {
      assertThat(KubernetesResourceUtil.isValidSubdomainName(name)).isTrue();
    }

    static Stream<Arguments> validSubdomainNames() {
      return Stream.of(
          argumentSet("two labels", "a.b"),
          argumentSet("253 characters",
              String.join(".", "a".repeat(63), "b".repeat(63), "c".repeat(63), "d".repeat(61))));
    }

    @ParameterizedTest
    @MethodSource("invalidSubdomainNames")
    @DisplayName("subdomain name validation fails when the name is too long or has an empty label")
    void failsForInvalidSubdomainName(String name) {
      assertThat(KubernetesResourceUtil.isValidSubdomainName(name)).isFalse();
    }

    static Stream<Arguments> invalidSubdomainNames() {
      return Stream.of(
          argumentSet("empty label", "a..b"),
          argumentSet("254 characters",
              String.join(".", "a".repeat(63), "b".repeat(63), "c".repeat(63), "d".repeat(62))));
    }
  }

  @Nested
  @DisplayName("sanitizeName")
  class SanitizeName {

    @ParameterizedTest
    @MethodSource("namesToSanitize")
    @DisplayName("sanitized name is a valid name")
    void sanitizedNameIsValidName(String name) {
      assertThat(KubernetesResourceUtil.isValidName(KubernetesResourceUtil.sanitizeName(name))).isTrue();
    }

    static Stream<Arguments> namesToSanitize() {
      return Stream.of(
          argumentSet("contains '.'", "test.invalid.name"),
          argumentSet("contains '@'", "90notcool-n@me"),
          argumentSet("longer than 63 characters with '_' and spaces",
              "90notcool-n@me_______waytoooooooooolooooooooongand should be shorten for sure"),
          argumentSet("starts with '-'", "-name"),
          argumentSet("ends with '-'", "name-"));
    }

    @Test
    @DisplayName("sanitizeName returns an empty name unchanged")
    void returnsEmptyNameUnchanged() {
      assertThat(KubernetesResourceUtil.sanitizeName("")).isEmpty();
    }

    @Test
    @DisplayName("sanitized name is a valid name regardless of the default locale")
    void sanitizedNameIsValidNameInAnyLocale() {
      final Locale defaultLocale = Locale.getDefault();
      try {
        // Turkish lowercases 'I' to the dotless 'ı'
        Locale.setDefault(Locale.forLanguageTag("tr"));
        assertThat(KubernetesResourceUtil.isValidName(KubernetesResourceUtil.sanitizeName("MyIngress"))).isTrue();
      } finally {
        Locale.setDefault(defaultLocale);
      }
    }
  }

  @Nested
  @DisplayName("isValidKey")
  class IsValidKey {

    @ParameterizedTest
    @MethodSource("validKeys")
    @DisplayName("label key validation passes when the key is a name of up to 63 characters, optionally prefixed by a DNS subdomain of up to 253 characters and '/'")
    void passesForValidKey(String key) {
      assertThat(KubernetesResourceUtil.isValidKey(key)).isTrue();
    }

    static Stream<Arguments> validKeys() {
      return Stream.of(
          argumentSet("prefix and name with dots", "domain.prefix.io/label.key"),
          argumentSet("name with uppercase and '_'", "domain.prefix.io/MyLabel_Key"),
          argumentSet("name of 63 characters", "a".repeat(63)),
          argumentSet("prefix and name of 63 characters", "example.com/" + "a".repeat(63)),
          argumentSet("prefix of 200 characters and name of 53 characters",
              String.join(".", "a".repeat(63), "b".repeat(63), "c".repeat(63), "d".repeat(8)) + "/" + "e".repeat(53)),
          argumentSet("prefix of 253 characters",
              String.join(".", "a".repeat(63), "b".repeat(63), "c".repeat(63), "d".repeat(61)) + "/name"));
    }

    @ParameterizedTest
    @MethodSource("invalidKeys")
    @DisplayName("label key validation fails when the name or the prefix is too long or has invalid characters")
    void failsForInvalidKey(String key) {
      assertThat(KubernetesResourceUtil.isValidKey(key)).isFalse();
    }

    static Stream<Arguments> invalidKeys() {
      return Stream.of(
          argumentSet("'?' instead of '/'", "domain.prefix.io?label.key"),
          argumentSet("uppercase prefix", "UPPER.PREFIX.IO/key"),
          argumentSet("name of 64 characters", "a".repeat(64)),
          argumentSet("prefix and name of 64 characters", "example.com/" + "a".repeat(64)),
          argumentSet("prefix of 254 characters",
              String.join(".", "a".repeat(63), "b".repeat(63), "c".repeat(63), "d".repeat(62)) + "/name"));
    }
  }

  @Nested
  @DisplayName("isValidLabelValue")
  class IsValidLabelValue {

    @ParameterizedTest
    @MethodSource("validValues")
    @DisplayName("label value validation passes when the value is empty or up to 63 alphanumeric characters with '-', '_' or '.' inside")
    void passesForValidValue(String value) {
      assertThat(KubernetesResourceUtil.isValidLabelValue(value)).isTrue();
    }

    static Stream<Arguments> validValues() {
      return Stream.of(
          argumentSet("uppercase", "MyValue"),
          argumentSet("'_' and '.' inside", "My_Value.1"),
          argumentSet("empty", ""),
          argumentSet("63 characters", "a".repeat(63)));
    }

    @ParameterizedTest
    @MethodSource("invalidValues")
    @DisplayName("label value validation fails when the value is null, too long, has invalid characters or doesn't start and end with an alphanumeric character")
    void failsForInvalidValue(String value) {
      assertThat(KubernetesResourceUtil.isValidLabelValue(value)).isFalse();
    }

    static Stream<Arguments> invalidValues() {
      return Stream.of(
          argumentSet("null", (Object) null),
          argumentSet("starts with '-'", "-bad"),
          argumentSet("ends with '_'", "bad_"),
          argumentSet("contains a space", "a b"),
          argumentSet("64 characters", "a".repeat(64)));
    }
  }

  @Nested
  @DisplayName("areLabelsValid")
  class AreLabelsValid {

    @ParameterizedTest
    @MethodSource("validLabels")
    @DisplayName("labels validation passes when every key and value is valid")
    void passesForValidLabels(Map<String, String> labels) {
      assertThat(KubernetesResourceUtil.areLabelsValid(labels)).isTrue();
    }

    static Stream<Arguments> validLabels() {
      return Stream.of(
          argumentSet("lowercase key and value", Map.of("foo", "bar")),
          argumentSet("uppercase key and value", Map.of("MyApp", "MyValue")),
          argumentSet("value with '_' and '.'", Map.of("app", "My_Value.1")),
          argumentSet("empty value", Map.of("app", "")));
    }

    @ParameterizedTest
    @MethodSource("invalidLabels")
    @DisplayName("labels validation fails when a key or a value is invalid")
    void failsForInvalidLabels(Map<String, String> labels) {
      assertThat(KubernetesResourceUtil.areLabelsValid(labels)).isFalse();
    }

    static Stream<Arguments> invalidLabels() {
      return Stream.of(
          argumentSet("'=' in key", Map.of("special=char-in-key", "bar")),
          argumentSet("value starting with '-'", Map.of("app", "-bad")));
    }
  }

  @Test
  void testAnnotationValidation() {
    assertTrue(
        KubernetesResourceUtil.areAnnotationsValid(Collections.singletonMap("simple-key", "Something not valid for a label!")));
  }

  @Test
  void testSortEventListBasedOnTimestamp() {
    // Given
    List<Event> eventList = new ArrayList<>();
    eventList.add(new EventBuilder()
        .withNewMetadata().withName("event2").endMetadata()
        .withLastTimestamp("2020-06-12T06:45:16Z")
        .build());
    eventList.add(new EventBuilder()
        .withNewMetadata().withName("event1").endMetadata()
        .withLastTimestamp("2020-06-10T06:45:16Z")
        .build());
    eventList.add(new EventBuilder()
        .withNewMetadata().withName("event3").endMetadata()
        .withLastTimestamp("2020-06-13T06:45:16Z")
        .build());
    eventList.add(new EventBuilder()
        .withNewMetadata().withName("eventWithoutLastTimestamp").endMetadata()
        .build());

    // When
    KubernetesResourceUtil.sortEventListBasedOnTimestamp(eventList);

    // Then
    assertEquals("eventWithoutLastTimestamp", eventList.get(0).getMetadata().getName());
    assertEquals("event3", eventList.get(1).getMetadata().getName());
    assertEquals("event2", eventList.get(2).getMetadata().getName());
    assertEquals("event1", eventList.get(3).getMetadata().getName());
  }

  @Test
  @DisplayName("Should be able to get resource version")
  void testGetResourceVersion() {
    // Given
    Pod pod = new PodBuilder()
        .withNewMetadata().withName("test").withResourceVersion("1001").endMetadata()
        .build();

    // When
    String resourceVersion = KubernetesResourceUtil.getResourceVersion(pod);

    // Then
    assertEquals("1001", resourceVersion);
  }

  @Test
  @DisplayName("Should be able to update resource version")
  void testSetResourceVersion() {
    // Given
    Pod pod = new PodBuilder()
        .withNewMetadata().withName("test").withResourceVersion("1001").endMetadata()
        .build();

    // When
    KubernetesResourceUtil.setResourceVersion(pod, "1002");

    // Then
    assertEquals("1002", pod.getMetadata().getResourceVersion());
  }

  @Test
  void testIsResourceReadyReturnsTrue() {
    // Given
    Deployment deployment = new DeploymentBuilder()
        .withNewMetadata().withName("test").endMetadata()
        .withNewSpec().withReplicas(1).endSpec()
        .withNewStatus()
        .withReplicas(1)
        .withAvailableReplicas(1)
        .endStatus()
        .build();

    // When
    boolean result = KubernetesResourceUtil.isResourceReady(deployment);

    // Then
    assertTrue(result);
  }

  @Test
  void testIsResourceReadyReturnsFalse() {
    // Given
    Deployment deployment = new DeploymentBuilder()
        .withNewMetadata().withName("test").endMetadata()
        .withNewSpec().withReplicas(2).endSpec()
        .withNewStatus()
        .withReplicas(1)
        .withAvailableReplicas(1)
        .endStatus()
        .build();

    // When
    boolean result = KubernetesResourceUtil.isResourceReady(deployment);

    // Then
    assertFalse(result);
  }

  @Test
  void testGetAge() {
    // Given
    Pod pod = new PodBuilder()
        .withNewMetadata().withName("test").withCreationTimestamp("2020-11-03T13:22:22Z").endMetadata()
        .build();

    // When
    Duration duration = KubernetesResourceUtil.getAge(pod);

    // Then
    assertFalse(duration.isNegative());
  }

  @Nested
  @DisplayName("inferListType")
  class InferListType {

    @ParameterizedTest
    @MethodSource("typesWithList")
    @DisplayName("infers the list type as the resource class name suffixed with 'List'")
    void infersListClassByName(Class<? extends HasMetadata> type, Class<?> expectedListType) {
      assertThat(KubernetesResourceUtil.inferListType(type)).isEqualTo(expectedListType);
    }

    static Stream<Arguments> typesWithList() {
      return Stream.of(
          argumentSet("Pod", Pod.class, PodList.class),
          argumentSet("ConfigMap", ConfigMap.class, ConfigMapList.class),
          argumentSet("batch/v1beta1 CronJob", CronJob.class, CronJobList.class));
    }

    @Test
    @DisplayName("falls back to DefaultKubernetesResourceList when there is no class named after the resource class with 'List'")
    void fallsBackToDefaultList() {
      assertThat(KubernetesResourceUtil.inferListType(Good.class)).isEqualTo(DefaultKubernetesResourceList.class);
    }
  }

  @Test
  void testCreateDefaultDockerRegistrySecret() throws JacksonException {
    Secret secret = KubernetesResourceUtil.createDockerRegistrySecret("http://harbor.inner.com", "SecretAdmin",
        "TestingSecret");

    String header = new String(Base64.getDecoder().decode(secret.getData().get(".dockerconfigjson")));

    assertEquals(
        "{\"auths\":{\"http://harbor.inner.com\":{\"password\":\"TestingSecret\",\"auth\":\"U2VjcmV0QWRtaW46VGVzdGluZ1NlY3JldA==\",\"username\":\"SecretAdmin\"}}}",
        header);
    assertEquals("container-image-registry-secret", secret.getMetadata().getName());
  }

  @Test
  void testCreateDockerRegistrySecret() throws JacksonException {
    Secret secret = KubernetesResourceUtil.createDockerRegistrySecret("http://harbor.inner.com", "SecretAdmin",
        "TestingSecret", "TestSecretName");

    String header = new String(Base64.getDecoder().decode(secret.getData().get(".dockerconfigjson")));

    assertEquals(
        "{\"auths\":{\"http://harbor.inner.com\":{\"password\":\"TestingSecret\",\"auth\":\"U2VjcmV0QWRtaW46VGVzdGluZ1NlY3JldA==\",\"username\":\"SecretAdmin\"}}}",
        header);
    assertEquals("TestSecretName", secret.getMetadata().getName());
  }

  @Test
  void createNewConfigMapFromDirOrFiles_whenInvalidFileProvided_shouldThrowException() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> KubernetesResourceUtil.addEntriesFromDirOrFileToConfigMap(new ConfigMapBuilder(), "test-configmap",
            Paths.get("does-not-exist")))
        .withMessage("invalid file path provided does-not-exist");
  }

  @Test
  void createNewConfigMapFromDirOrFiles_whenFileProvided_shouldCreateConfigMapFromFile() throws IOException {
    // Given
    Path path = new File(getClass().getResource("/configmap-from-file/game-config/game.properties").getFile()).toPath();

    // When
    ConfigMap configMap = KubernetesResourceUtil.createConfigMapFromDirOrFiles("test-configmap", path);

    // Then
    assertConfigMapContainsData(configMap, createExpectedEntry("game.properties", path));
  }

  @Test
  void createNewConfigMapFromDirOrFiles_whenDirProvided_shouldCreateConfigMapFromDir() throws IOException {
    // Given
    Path filePath = new File(getClass().getResource("/configmap-from-file/game-config").getFile()).toPath();

    // When
    ConfigMap configMap = KubernetesResourceUtil
        .addEntriesFromDirOrFileToConfigMap(new ConfigMapBuilder(), "test-configmap", filePath).build();

    // Then
    assertConfigMapContainsData(configMap,
        createExpectedEntry("game.properties", filePath.resolve("game.properties")),
        createExpectedEntry("ui.properties", filePath.resolve("ui.properties")));
  }

  @Test
  void createNewConfigMapFromDirOrFiles_whenMultipleDirsProvided_shouldCreateConfigMapFromDirs() throws IOException {
    // Given
    Path dir1Path = new File(getClass().getResource("/configmap-from-file/game-config").getFile()).toPath();
    Path dir2Path = new File(getClass().getResource("/configmap-from-file/test-config").getFile()).toPath();

    // When
    ConfigMap configMap = KubernetesResourceUtil.createConfigMapFromDirOrFiles("test-configmap", dir1Path, dir2Path);

    // Then
    assertConfigMapContainsData(configMap,
        createExpectedEntry("game.properties", dir1Path.resolve("game.properties")),
        createExpectedEntry("ui.properties", dir1Path.resolve("ui.properties")),
        createExpectedEntry("test.properties", dir2Path.resolve("test.properties")));
  }

  @Test
  void createNewConfigMapFromDirOrFiles_whenBinaryFileProvided_shouldCreateConfigMapFromFile() throws IOException {
    // Given
    Path path = new File(getClass().getResource("/test.bin").getFile()).toPath();

    // When
    ConfigMap configMap = KubernetesResourceUtil.createConfigMapFromDirOrFiles("test-configmap", path);

    // Then
    assertThat(configMap)
        .extracting(ConfigMap::getBinaryData)
        .asInstanceOf(InstanceOfAssertFactories.MAP)
        .contains(entry("test.bin", "wA=="));
  }

  @SafeVarargs
  private final void assertConfigMapContainsData(ConfigMap configMap, MapEntry<String, String>... mapEntries) {
    assertThat(configMap)
        .extracting(ConfigMap::getData)
        .asInstanceOf(InstanceOfAssertFactories.MAP)
        .contains(mapEntries);
  }

  @ParameterizedTest(name = "S5998: KUBERNETES_SUBDOMAIN_REGEX matches valid subdomain ''{0}''")
  @ValueSource(strings = {
      "a",
      "abc",
      "a-b",
      "a--b",
      "a.b.c",
      "my-app.example.com",
      "a1.b2.c3",
      "0"
  })
  void subdomainRegex_shouldMatchValidSubdomains(String validSubdomain) {
    assertThat(KubernetesResourceUtil.KUBERNETES_SUBDOMAIN_REGEX.matcher(validSubdomain).matches()).isTrue();
  }

  @ParameterizedTest(name = "S5998: KUBERNETES_SUBDOMAIN_REGEX rejects invalid subdomain ''{0}''")
  @ValueSource(strings = {
      "-a",
      "a-",
      ".a",
      "a.",
      "a..b",
      "a.-b",
      "A",
      "a!b"
  })
  void subdomainRegex_shouldRejectInvalidSubdomains(String invalidSubdomain) {
    assertThat(KubernetesResourceUtil.KUBERNETES_SUBDOMAIN_REGEX.matcher(invalidSubdomain).matches()).isFalse();
  }

  private MapEntry<String, String> createExpectedEntry(String key, Path filePath) throws IOException {
    String fileContent = new String(Files.readAllBytes(filePath));
    return entry(key, fileContent);
  }
}
