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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.apps.Deployment;
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
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author wangyushuai2@jd.com
 */
class DefaultKubernetesClientTest {

  private static final String TEST_CONFIG_YML_FILE = Utils
      .filePath(DefaultKubernetesClientTest.class.getResource("/test-config.yml"));

  private DefaultKubernetesClient defaultKubernetesClient;

  @BeforeEach
  public void setUp() {
    defaultKubernetesClient = new DefaultKubernetesClient();
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
        new File(DefaultKubernetesClientTest.class.getResource("/test-list.yml").getFile()).toPath(), StandardCharsets.UTF_8);
    final String crlfFile = String.join(" \r\n", fileLines);
    // When
    final List<HasMetadata> result = new DefaultKubernetesClient()
        .load(new ByteArrayInputStream(crlfFile.getBytes(StandardCharsets.UTF_8))).get();
    // Then
    assertThat(result)
        .hasSize(2)
        .hasAtLeastOneElementOfType(Service.class)
        .hasAtLeastOneElementOfType(Deployment.class);
  }

  @Test
  void shouldInstantiateClientUsingYaml() {
    File configYml = new File(TEST_CONFIG_YML_FILE);
    try (InputStream is = new FileInputStream(configYml)) {
      KubernetesClient client = DefaultKubernetesClient.fromConfig(is);
      assertEquals("http://some.url/", client.getMasterUrl().toString());
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  void shouldInstantiateClientUsingSerializeDeserialize() {
    DefaultKubernetesClient original = new DefaultKubernetesClient();
    String json = Serialization.asJson(original.getConfiguration());
    DefaultKubernetesClient copy = DefaultKubernetesClient.fromConfig(json);

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

    final DefaultKubernetesClient client = new DefaultKubernetesClient(config);
    final Config currentConfig = client.getConfiguration();

    assertEquals("a", currentConfig.getImpersonateUsername());
    assertArrayEquals(new String[] { "b" }, currentConfig.getImpersonateGroups());
    assertEquals(Collections.singletonList("d"), currentConfig.getImpersonateExtras().get("c"));
  }
}
