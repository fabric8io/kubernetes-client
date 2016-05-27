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

package io.fabric8.openshift.client.mock;

import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigBuilder;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.DeploymentConfigListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DeploymentConfigTest extends OpenShiftMockServerTestBase {

  @Test
  public void testList() {
    expect().withPath("/oapi/v1/namespaces/test/deploymentconfigs").andReturn(200, new DeploymentConfigListBuilder().build()).once();
    expect().withPath("/oapi/v1/namespaces/ns1/deploymentconfigs").andReturn(200, new DeploymentConfigListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

    expect().withPath("/oapi/v1/deploymentconfigs").andReturn(200, new DeploymentConfigListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();

    OpenShiftClient client = getOpenshiftClient();

    DeploymentConfigList buildConfigList = client.deploymentConfigs().list();
    assertNotNull(buildConfigList);
    assertEquals(0, buildConfigList.getItems().size());

    buildConfigList = client.deploymentConfigs().inNamespace("ns1").list();
    assertNotNull(buildConfigList);
    assertEquals(2, buildConfigList.getItems().size());

    buildConfigList = client.deploymentConfigs().inAnyNamespace().list();
    assertNotNull(buildConfigList);
    assertEquals(3, buildConfigList.getItems().size());
  }


  @Test
  public void testGet() {
    expect().withPath("/oapi/v1/namespaces/test/deploymentconfigs/dc1").andReturn(200, new DeploymentConfigBuilder()
      .withNewMetadata().withName("dc1").endMetadata()
      .build()).once();

    expect().withPath("/oapi/v1/namespaces/ns1/deploymentconfigs/dc2").andReturn(200, new DeploymentConfigBuilder()
      .withNewMetadata().withName("dc2").endMetadata()
      .build()).once();

    OpenShiftClient client = getOpenshiftClient();

    DeploymentConfig buildConfig = client.deploymentConfigs().withName("dc1").get();
    assertNotNull(buildConfig);
    assertEquals("dc1", buildConfig.getMetadata().getName());

    buildConfig = client.deploymentConfigs().withName("dc2").get();
    assertNull(buildConfig);

    buildConfig = client.deploymentConfigs().inNamespace("ns1").withName("dc2").get();
    assertNotNull(buildConfig);
    assertEquals("dc2", buildConfig.getMetadata().getName());
  }


  @Test
  public void testDelete() {
    expect().withPath("/oapi/v1/namespaces/test/deploymentconfigs/dc1").andReturn(200, new DeploymentConfigBuilder().build()).once();
    expect().withPath("/oapi/v1/namespaces/ns1/deploymentconfigs/dc2").andReturn( 200, new DeploymentConfigBuilder().build()).once();

    OpenShiftClient client = getOpenshiftClient();

    Boolean deleted = client.deploymentConfigs().withName("dc1").delete();
    assertNotNull(deleted);

    deleted = client.deploymentConfigs().withName("dc2").delete();
    assertFalse(deleted);

    deleted = client.deploymentConfigs().inNamespace("ns1").withName("dc2").delete();
    assertTrue(deleted);
  }

}
