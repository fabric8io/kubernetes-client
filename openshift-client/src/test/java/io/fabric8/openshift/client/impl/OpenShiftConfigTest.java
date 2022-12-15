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
package io.fabric8.openshift.client.impl;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.openshift.client.OpenShiftConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpenShiftConfigTest {

  private Config kubernetesConfig;

  private String version;

  @BeforeEach
  void setup() {
    this.kubernetesConfig = new ConfigBuilder()
        .withMasterUrl("https://2.2.2.2")
        .build();

    this.version = "v1";
    System.setProperty(OpenShiftConfig.KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY, this.version);
  }

  @AfterEach
  void tearDown() {
    System.clearProperty(OpenShiftConfig.OPENSHIFT_URL_SYSTEM_PROPERTY);
    System.clearProperty(OpenShiftConfig.KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY);
  }

  @Test
  void testOpenshiftURLAsRoot() {
    System.setProperty(OpenShiftConfig.OPENSHIFT_URL_SYSTEM_PROPERTY, "https://1.1.1.1");
    OpenShiftConfig config = new OpenShiftConfig(kubernetesConfig);
    assertEquals("https://1.1.1.1/oapi/" + version + "/", config.getOpenShiftUrl());
  }

  @Test
  void testOpenshiftURLAsRootWithSlash() {
    System.setProperty(OpenShiftConfig.OPENSHIFT_URL_SYSTEM_PROPERTY, "https://1.1.1.1/");
    OpenShiftConfig config = new OpenShiftConfig(kubernetesConfig);
    assertEquals("https://1.1.1.1/oapi/" + version + "/", config.getOpenShiftUrl());
  }

  @Test
  void testFullOpenshiftURL() {
    System.setProperty(OpenShiftConfig.OPENSHIFT_URL_SYSTEM_PROPERTY, "https://1.1.1.1/xxx");
    OpenShiftConfig config = new OpenShiftConfig(kubernetesConfig);
    assertEquals("https://1.1.1.1/xxx/", config.getOpenShiftUrl());
  }

  @Test
  void testNoOpenshiftURL() {
    System.clearProperty(OpenShiftConfig.OPENSHIFT_URL_SYSTEM_PROPERTY);
    OpenShiftConfig config = new OpenShiftConfig(kubernetesConfig);
    // Use the master URL
    assertEquals("https://2.2.2.2/oapi/" + version + "/", config.getOpenShiftUrl());
  }

  @Test
  void shouldInstantiateClientUsingSerializeDeserialize() {
    OpenShiftClientImpl original = new OpenShiftClientImpl();
    String json = Serialization.asJson(original.getConfiguration());
    KubernetesClient copy = new KubernetesClientBuilder().withConfig(json).build();

    assertEquals(original.getConfiguration().getMasterUrl(), copy.getConfiguration().getMasterUrl());
    assertEquals(original.getConfiguration().getOauthToken(), copy.getConfiguration().getOauthToken());
    assertEquals(original.getConfiguration().getNamespace(), copy.getConfiguration().getNamespace());
    assertEquals(original.getConfiguration().getUsername(), copy.getConfiguration().getUsername());
    assertEquals(original.getConfiguration().getPassword(), copy.getConfiguration().getPassword());
  }
}
