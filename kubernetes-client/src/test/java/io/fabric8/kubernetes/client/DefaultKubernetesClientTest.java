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
import io.fabric8.kubernetes.client.utils.SerializationTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author wangyushuai2@jd.com
 * @date 2020/1/13
 */
public class DefaultKubernetesClientTest {

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
  public void testInitClientWithCustomHeaderConfiguration() {
    final Map<String, String> customHeaders = new HashMap<>();
    customHeaders.put("user-id", "test-user");
    customHeaders.put("cluster-id", "test-cluster");
    final Config configWithCustomerHeaders = new ConfigBuilder().withCustomHeaders(customHeaders).build();

    final DefaultKubernetesClient customHeaderConfigClient = new DefaultKubernetesClient(configWithCustomerHeaders);

    assertEquals(1, customHeaderConfigClient.getHttpClient().networkInterceptors().size());
  }

  @Test
  public void testInitClientWithDefaultConfiguration() {
    final Config defaultEmptyConfig =  new ConfigBuilder().build();

    DefaultKubernetesClient defaultConfigClient = new DefaultKubernetesClient(defaultEmptyConfig);

    assertTrue(defaultConfigClient.getHttpClient().networkInterceptors().isEmpty());
  }

  @Test
  @DisplayName("load, InputStream containing List with windows like line-ends (CRLF), all list items should be available")
  public void loadWithWindowsLineSeparatorsString() throws Exception {
    // Given
    final List<String> fileLines = Files.readAllLines(
      new File(SerializationTest.class.getResource("/test-list.yml").getFile()).toPath(), StandardCharsets.UTF_8);
    final String crlfFile = String.join(" \r\n", fileLines);
    // When
    final List<HasMetadata> result = new DefaultKubernetesClient()
      .load(new ByteArrayInputStream(crlfFile.getBytes(StandardCharsets.UTF_8))).get();
    // Then
    assertEquals(2, result.size());
    assertTrue(result.get(0) instanceof Service);
    assertTrue(result.get(1) instanceof Deployment);
  }
}
