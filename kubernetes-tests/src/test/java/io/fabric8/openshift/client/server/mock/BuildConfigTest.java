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

package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildBuilder;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildConfigListBuilder;
import io.fabric8.openshift.api.model.BuildListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;

import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BuildConfigTest {
  @Rule
  public OpenShiftServer server = new OpenShiftServer();

  @Test
  public void testList() {
   server.expect().withPath("/oapi/v1/namespaces/test/buildconfigs").andReturn(200, new BuildConfigListBuilder().build()).once();
   server.expect().withPath("/oapi/v1/namespaces/ns1/buildconfigs").andReturn(200, new BuildConfigListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

   server.expect().withPath("/oapi/v1/buildconfigs").andReturn(200, new BuildConfigListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

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
   server.expect().withPath("/oapi/v1/namespaces/test/buildconfigs/bc1").andReturn(200, new BuildConfigBuilder()
      .withNewMetadata().withName("bc1").endMetadata()
      .build()).once();

   server.expect().withPath("/oapi/v1/namespaces/ns1/buildconfigs/bc2").andReturn(200, new BuildConfigBuilder()
      .withNewMetadata().withName("bc2").endMetadata()
      .build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

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
  public void testBinaryBuildFromInputStream() {
   server.expect().post().withPath("/oapi/v1/namespaces/ns1/buildconfigs/bc2/instantiatebinary?commit=some%20commit&revision.authorName=author%20name&revision.authorEmail=author@someorg.com&revision.committerName=committer%20name&revision.committerEmail=committer@someorg.com")
      .andReturn(201, new BuildBuilder()
      .withNewMetadata().withName("bc2").endMetadata().build()).once();


    OpenShiftClient client = server.getOpenshiftClient();
    InputStream dummy = new ByteArrayInputStream("".getBytes() );

    Build build = client.buildConfigs().inNamespace("ns1").withName("bc2").instantiateBinary()
      .withCommitterName("committer name")
      .withCommitterEmail("committer@someorg.com")
      .withAuthorName("author name")
      .withAuthorEmail("author@someorg.com")
      .withMessage("some commit")
      .fromInputStream(dummy);

    assertNotNull(build);
  }

  @Test
  public void testBinaryBuildFromFile() throws IOException {
    File warFile = new File("target/test.war");
    warFile.createNewFile();

    server.expect().post().withPath("/oapi/v1/namespaces/ns1/buildconfigs/bc2/instantiatebinary?commit=&asFile=" + warFile.getName())
      .andReturn(201, new BuildBuilder()
      .withNewMetadata().withName("bc2").endMetadata().build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

    Build build = client.buildConfigs()
      .inNamespace("ns1")
      .withName("bc2")
      .instantiateBinary()
      .asFile(warFile.getName())
      .fromFile(warFile);
  }

  // TODO Add delay to mockwebserver. Disabled as too dependent on timing issues right now.
  //@Test
  public void testBinaryBuildWithTimeout() {
   server.expect().post().delay(200).withPath("/oapi/v1/namespaces/ns1/buildconfigs/bc2/instantiatebinary?commit=")
      .andReturn(201, new BuildBuilder()
      .withNewMetadata().withName("bc2").endMetadata().build()).once();

    OpenShiftClient client = server.getOpenshiftClient();
    InputStream dummy = new ByteArrayInputStream("".getBytes() );

    try {
      client.buildConfigs().inNamespace("ns1").withName("bc2").instantiateBinary()
        .withTimeout(100, TimeUnit.MILLISECONDS)
        .fromInputStream(dummy);
    } catch (KubernetesClientException e) {
      assertEquals(SocketTimeoutException.class, e.getCause().getClass());
      return;
    }
    fail("Expected exception");
  }


  @Test
  public void testDelete() {
   server.expect().withPath("/oapi/v1/namespaces/test/buildconfigs/bc1").andReturn(200, new BuildConfigBuilder().withNewMetadata().withName("bc1").and().build()).once();
   server.expect().withPath("/oapi/v1/namespaces/test/builds?labelSelector=openshift.io/build-config.name%3Dbc1").andReturn( 200, new BuildListBuilder().build()).once();
   server.expect().withPath("/oapi/v1/namespaces/ns1/buildconfigs/bc2").andReturn( 200, new BuildConfigBuilder().withNewMetadata().withName("bc2").and().build()).once();
   server.expect().withPath("/oapi/v1/namespaces/ns1/builds?labelSelector=openshift.io/build-config.name%3Dbc2").andReturn( 200, new BuildListBuilder().build()).once();

    OpenShiftClient client = server.getOpenshiftClient();

    Boolean deleted = client.buildConfigs().withName("bc1").delete();
    assertNotNull(deleted);

    deleted = client.buildConfigs().withName("bc2").delete();
    assertFalse(deleted);

    deleted = client.buildConfigs().inNamespace("ns1").withName("bc2").delete();
    assertTrue(deleted);
  }

}
