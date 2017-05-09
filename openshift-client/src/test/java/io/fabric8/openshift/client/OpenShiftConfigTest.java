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
package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.utils.Serialization;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class OpenShiftConfigTest {


  private Config kubernetesConfig;

  private String version;

  @Before
  public void setup() {
    this.kubernetesConfig = new ConfigBuilder()
      .withMasterUrl("https://2.2.2.2")
      .build();

    this.version = "v1";
    System.setProperty(OpenShiftConfig.KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY, this.version);
  }

  @After
  public void tearDown() {
    System.clearProperty(OpenShiftConfig.OPENSHIFT_URL_SYTEM_PROPERTY);
    System.clearProperty(OpenShiftConfig.KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY);
  }


  @Test
  public void testOpenshiftURLAsRoot() {
    System.setProperty(OpenShiftConfig.OPENSHIFT_URL_SYTEM_PROPERTY, "https://1.1.1.1");
    OpenShiftConfig config = new OpenShiftConfig(kubernetesConfig);
    assertEquals("https://1.1.1.1/oapi/" + version + "/", config.getOpenShiftUrl());
  }

  @Test
  public void testOpenshiftURLAsRootWithSlash() {
    System.setProperty(OpenShiftConfig.OPENSHIFT_URL_SYTEM_PROPERTY, "https://1.1.1.1/");
    OpenShiftConfig config = new OpenShiftConfig(kubernetesConfig);
    assertEquals("https://1.1.1.1/oapi/" + version + "/", config.getOpenShiftUrl());
  }

  @Test
  public void testFullOpenshiftURL() {
    System.setProperty(OpenShiftConfig.OPENSHIFT_URL_SYTEM_PROPERTY, "https://1.1.1.1/xxx");
    OpenShiftConfig config = new OpenShiftConfig(kubernetesConfig);
    assertEquals("https://1.1.1.1/xxx/", config.getOpenShiftUrl());
  }

  @Test
  public void testNoOpenshiftURL() {
    System.clearProperty(OpenShiftConfig.OPENSHIFT_URL_SYTEM_PROPERTY);
    OpenShiftConfig config = new OpenShiftConfig(kubernetesConfig);
    // Use the master URL
    assertEquals("https://2.2.2.2/oapi/" + version + "/", config.getOpenShiftUrl());
  }

  @Test
  public void shouldInstantiateClientUsingSerializeDeserialize() throws MalformedURLException {
    DefaultOpenShiftClient original = new DefaultOpenShiftClient();
    String json = Serialization.asJson(original.getConfiguration());
    DefaultOpenShiftClient copy = DefaultOpenShiftClient.fromConfig(json);

    Assert.assertEquals(original.getConfiguration().getMasterUrl(), copy.getConfiguration().getMasterUrl());
    Assert.assertEquals(original.getConfiguration().getOauthToken(), copy.getConfiguration().getOauthToken());
    Assert.assertEquals(original.getConfiguration().getNamespace(), copy.getConfiguration().getNamespace());
    Assert.assertEquals(original.getConfiguration().getUsername(), copy.getConfiguration().getUsername());
    Assert.assertEquals(original.getConfiguration().getPassword(), copy.getConfiguration().getPassword());
  }
}
