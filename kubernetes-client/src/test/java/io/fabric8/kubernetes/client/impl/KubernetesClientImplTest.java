/**
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
package io.fabric8.kubernetes.client.impl;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.http.BasicBuilder;
import io.fabric8.kubernetes.client.http.HttpHeaders;
import io.fabric8.kubernetes.client.utils.HttpClientUtils;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author wangyushuai2@jd.com
 */
class KubernetesClientImplTest {

  private static final String TEST_CONFIG_YML_FILE = Utils
      .filePath(KubernetesClientImplTest.class.getResource("/test-config.yml"));

  private KubernetesClientImpl defaultKubernetesClient;

  @BeforeEach
  public void setUp() {
    defaultKubernetesClient = new KubernetesClientImpl();
  }

  @AfterEach
  public void tearDown() {
    defaultKubernetesClient.close();
    defaultKubernetesClient = null;
  }

  @Test
  void testInitClientWithCustomHeaderConfiguration() {
    final Map<String, String> customHeaders = new HashMap<>();
    customHeaders.put("user-id", "test-user");
    customHeaders.put("cluster-id", "test-cluster");
    final Config configWithCustomerHeaders = new ConfigBuilder().withCustomHeaders(customHeaders).build();

    BasicBuilder basicBuilder = Mockito.mock(BasicBuilder.class);
    HttpClientUtils.createApplicableInterceptors(configWithCustomerHeaders, null).get("HEADER")
        .before(basicBuilder, Mockito.mock(HttpHeaders.class));
    Mockito.verify(basicBuilder, Mockito.times(1)).header("user-id", "test-user");
  }

  @Test
  void testInitClientWithDefaultConfiguration() {
    final Config defaultEmptyConfig = new ConfigBuilder().build();

    BasicBuilder basicBuilder = Mockito.mock(BasicBuilder.class);
    HttpClientUtils.createApplicableInterceptors(defaultEmptyConfig, null).get("HEADER")
        .before(basicBuilder, Mockito.mock(HttpHeaders.class));

    Mockito.verify(basicBuilder, Mockito.never()).header("user-id", "test-user");
  }

  @Test
  @DisplayName("load, InputStream containing List with windows like line-ends (CRLF), all list items should be available")
  void loadWithWindowsLineSeparatorsString() throws Exception {
    // Given
    final List<String> fileLines = Files.readAllLines(
        new File(KubernetesClientImplTest.class.getResource("/test-list.yml").getFile()).toPath(), StandardCharsets.UTF_8);
    final String crlfFile = String.join(" \r\n", fileLines);
    // When
    final List<HasMetadata> result = new KubernetesClientImpl()
        .load(new ByteArrayInputStream(crlfFile.getBytes(StandardCharsets.UTF_8))).items();
    // Then
    assertThat(result)
        .hasSize(2)
        .hasAtLeastOneElementOfType(Service.class)
        .hasAtLeastOneElementOfType(Deployment.class);
  }

  @Test
  void shouldInstantiateClientUsingYaml() throws Exception {
    File configYml = new File(TEST_CONFIG_YML_FILE);
    try (InputStream is = new FileInputStream(configYml)) {
      KubernetesClient client = new KubernetesClientBuilder().withConfig(is).build();
      assertEquals("http://some.url/", client.getMasterUrl().toString());
    }
  }

  @Test
  void shouldInstantiateClientUsingSerializeDeserialize() {
    KubernetesClientImpl original = new KubernetesClientImpl();
    String json = Serialization.asJson(original.getConfiguration());
    KubernetesClient copy = new KubernetesClientBuilder().withConfig(json).build();

    assertEquals(original.getConfiguration().getMasterUrl(), copy.getConfiguration().getMasterUrl());
    assertEquals(original.getConfiguration().getOauthToken(), copy.getConfiguration().getOauthToken());
    assertEquals(original.getConfiguration().getNamespace(), copy.getConfiguration().getNamespace());
    assertEquals(original.getConfiguration().getUsername(), copy.getConfiguration().getUsername());
    assertEquals(original.getConfiguration().getPassword(), copy.getConfiguration().getPassword());
  }

  @Test
  void shouldPropagateImpersonateSettings() {

    final Map<String, List<String>> extras = new HashMap<>();
    extras.put("c", Collections.singletonList("d"));

    final Config config = new ConfigBuilder()
        .withImpersonateUsername("a")
        .withImpersonateGroups("b")
        .withImpersonateExtras(extras)
        .build();

    final KubernetesClientImpl client = new KubernetesClientImpl(config);
    final Config currentConfig = client.getConfiguration();

    assertEquals("a", currentConfig.getImpersonateUsername());
    assertArrayEquals(new String[] { "b" }, currentConfig.getImpersonateGroups());
    assertEquals(Collections.singletonList("d"), currentConfig.getImpersonateExtras().get("c"));
  }

  @Test
  @DisplayName("resource(String).item with HasMetadata should deserialize")
  void resourceFromStringWithHasMetadata() {
    assertThat(new KubernetesClientImpl().resource("apiVersion: v1\nkind: Pod").item())
        .isInstanceOf(Pod.class);
  }

  @Test
  @DisplayName("resource(String) with no HasMetadata should throwException")
  void resourceFromStringWithInvalid() {
    final KubernetesClient kc = new KubernetesClientImpl();
    assertThatExceptionOfType(KubernetesClientException.class)
        .isThrownBy(() -> kc.resource("NotAPod"))
        .withMessageStartingWith("Unable to create a valid resource from the provided object");
  }

  @Test
  @DisplayName("resource(InputStream).item with HasMetadata should deserialize")
  void resourceFromInputStreamWithHasMetadata() throws IOException {
    final String podYaml = "apiVersion: v1\nkind: Pod";
    try (InputStream is = new ByteArrayInputStream(podYaml.getBytes(StandardCharsets.UTF_8))) {
      assertThat(new KubernetesClientImpl().resource(is).item())
          .isInstanceOf(Pod.class);
    }
  }

  @Test
  @DisplayName("resource(InputStream) with no HasMetadata should throwException")
  void resourceFromInputStreamWithInvalid() throws IOException {
    final KubernetesClient kc = new KubernetesClientImpl();
    final String podYaml = "NotAPod";
    try (InputStream is = new ByteArrayInputStream(podYaml.getBytes(StandardCharsets.UTF_8))) {
      assertThatExceptionOfType(KubernetesClientException.class)
          .isThrownBy(() -> kc.resource(is))
          .withMessageStartingWith("Unable to create a valid resource from the provided object");
    }
  }

  @Test
  @DisplayName("load(InputStream).items with HasMetadata should deserialize")
  void loadFromInputStreamWithHasMetadata() throws IOException {
    final String podYaml = "apiVersion: v1\nkind: Pod";
    try (InputStream is = new ByteArrayInputStream(podYaml.getBytes(StandardCharsets.UTF_8))) {
      assertThat(new KubernetesClientImpl().load(is).items())
          .containsExactly(new Pod());
    }
  }

  @Test
  @DisplayName("load(InputStream).get with no HasMetadata should throwException")
  void loadFromInputStreamWithInvalid() throws IOException {
    final String podYaml = "NotAPod";
    try (InputStream is = new ByteArrayInputStream(podYaml.getBytes(StandardCharsets.UTF_8))) {
      final ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> load = new KubernetesClientImpl()
          .load(is);
      assertThatIllegalArgumentException()
          .isThrownBy(load::get)
          .withMessageStartingWith("Could not convert item to a list of HasMetadata");
    }
  }
}
