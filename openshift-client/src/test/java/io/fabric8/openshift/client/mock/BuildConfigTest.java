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

import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildConfigListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BuildConfigTest extends OpenShiftMockServerTestBase {

  @Test
  public void testList() {
    expect().withPath("/oapi/v1/namespaces/test/buildconfigs").andReturn(200, new BuildConfigListBuilder().build()).once();
    expect().withPath("/oapi/v1/namespaces/ns1/buildconfigs").andReturn(200, new BuildConfigListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

    expect().withPath("/oapi/v1/buildconfigs").andReturn(200, new BuildConfigListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();

    OpenShiftClient client = getOpenshiftClient();

    BuildConfigList buildConfigList = client.buildConfigs().list();
    assertNotNull(buildConfigList);
    assertEquals(0, buildConfigList.getItems().size());

    buildConfigList = client.buildConfigs().inNamespace("ns1").list();
    assertNotNull(buildConfigList);
    assertEquals(2, buildConfigList.getItems().size());

    buildConfigList = client.buildConfigs().inAnyNamespace().list();
    assertNotNull(buildConfigList);
    assertEquals(3, buildConfigList.getItems().size());
  }


  @Test
  public void testGet() {
    expect().withPath("/oapi/v1/namespaces/test/buildconfigs/bc1").andReturn(200, new BuildConfigBuilder()
      .withNewMetadata().withName("bc1").endMetadata()
      .build()).once();

    expect().withPath("/oapi/v1/namespaces/ns1/buildconfigs/bc2").andReturn(200, new BuildConfigBuilder()
      .withNewMetadata().withName("bc2").endMetadata()
      .build()).once();

    OpenShiftClient client = getOpenshiftClient();

    BuildConfig buildConfig = client.buildConfigs().withName("bc1").get();
    assertNotNull(buildConfig);
    assertEquals("bc1", buildConfig.getMetadata().getName());

    buildConfig = client.buildConfigs().withName("bc2").get();
    assertNull(buildConfig);

    buildConfig = client.buildConfigs().inNamespace("ns1").withName("bc2").get();
    assertNotNull(buildConfig);
    assertEquals("bc2", buildConfig.getMetadata().getName());
  }


  @Test
  public void testDelete() {
    expect().withPath("/oapi/v1/namespaces/test/buildconfigs/bc1").andReturn(200, new BuildConfigBuilder().build()).once();
    expect().withPath("/oapi/v1/namespaces/ns1/buildconfigs/bc2").andReturn( 200, new BuildConfigBuilder().build()).once();

    OpenShiftClient client = getOpenshiftClient();

    Boolean deleted = client.buildConfigs().withName("bc1").delete();
    assertNotNull(deleted);

    deleted = client.buildConfigs().withName("bc2").delete();
    assertFalse(deleted);

    deleted = client.buildConfigs().inNamespace("ns1").withName("bc2").delete();
    assertTrue(deleted);
  }

}
