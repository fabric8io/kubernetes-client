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

import io.fabric8.kubernetes.api.model.APIGroupListBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildBuilder;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildConfigListBuilder;
import io.fabric8.openshift.api.model.BuildListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@EnableOpenShiftMockClient
class BuildConfigTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void testList() {
    server.expect().withPath("/apis/build.openshift.io/v1/namespaces/test/buildconfigs")
        .andReturn(200, new BuildConfigListBuilder().build()).once();

    server.expect().withPath("/apis").andReturn(200, new APIGroupListBuilder()
        .addNewGroup()
        .withApiVersion("v1")
        .withName("autoscaling.k8s.io")
        .endGroup()
        .addNewGroup()
        .withApiVersion("v1")
        .withName("security.openshift.io")
        .endGroup()
        .build()).always();

    server.expect().withPath("/apis/build.openshift.io/v1/namespaces/ns1/buildconfigs")
        .andReturn(200, new BuildConfigListBuilder()
            .addNewItem().and()
            .addNewItem().and().build())
        .once();

    server.expect().withPath("/apis/build.openshift.io/v1/buildconfigs").andReturn(200, new BuildConfigListBuilder()
        .addNewItem().and()
        .addNewItem().and()
        .addNewItem()
        .and().build()).once();

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
  void testGet() {
    server.expect().withPath("/apis/build.openshift.io/v1/namespaces/test/buildconfigs/bc1")
        .andReturn(200, new BuildConfigBuilder()
            .withNewMetadata().withName("bc1").endMetadata()
            .build())
        .once();

    server.expect().withPath("/apis/build.openshift.io/v1/namespaces/ns1/buildconfigs/bc2")
        .andReturn(200, new BuildConfigBuilder()
            .withNewMetadata().withName("bc2").endMetadata()
            .build())
        .once();

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
  @Disabled //Seems that in this version of mockwebserver, posting using an inputstream doesn't work that well, so we'll have to ignore.
  void testBinaryBuildFromInputStream() {
    server.expect().post().withPath(
        "/apis/build.openshift.io/v1/namespaces/ns1/buildconfigs/bc2/instantiatebinary?commit=some%20commit&revision.authorName=author%20name&revision.authorEmail=author@someorg.com&revision.committerName=committer%20name&revision.committerEmail=committer@someorg.com")
        .andReturn(201, new BuildBuilder()
            .withNewMetadata().withName("bc2").endMetadata().build())
        .once();

    InputStream dummy = new ByteArrayInputStream("".getBytes());

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
  void testBinaryBuildFromFile() throws IOException {
    File warFile = new File("target/test.war");
    warFile.createNewFile();

    server.expect().post()
        .withPath("/apis/build.openshift.io/v1/namespaces/ns1/buildconfigs/bc2/instantiatebinary?name=bc2&namespace=ns1&asFile="
            + warFile.getName())
        .andReturn(201, new BuildBuilder()
            .withNewMetadata().withName("bc2").endMetadata().build())
        .once();

    Build build = client.buildConfigs()
        .inNamespace("ns1")
        .withName("bc2")
        .instantiateBinary()
        .asFile(warFile.getName())
        .fromFile(warFile);
    assertNotNull(build);
    assertEquals("bc2", build.getMetadata().getName());
  }

  // TODO Add delay to mockwebserver. Disabled as too dependent on timing issues right now.
  //  @Test
  void testBinaryBuildWithTimeout() {
    server.expect().post().delay(200)
        .withPath("/apis/build.openshift.io/v1/namespaces/ns1/buildconfigs/bc2/instantiatebinary?commit=")
        .andReturn(201, new BuildBuilder()
            .withNewMetadata().withName("bc2").endMetadata().build())
        .once();

    InputStream dummy = new ByteArrayInputStream("".getBytes());

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
  void testDelete() {
    server.expect().withPath("/apis/build.openshift.io/v1/namespaces/test/buildconfigs/bc1")
        .andReturn(200, new BuildConfigBuilder().withNewMetadata().withName("bc1").and().build()).once();
    server.expect()
        .withPath("/apis/build.openshift.io/v1/namespaces/test/builds?labelSelector=openshift.io%2Fbuild-config.name%3Dbc1")
        .andReturn(200, new BuildListBuilder().build()).once();
    server.expect().withPath("/apis/build.openshift.io/v1/namespaces/ns1/buildconfigs/bc2")
        .andReturn(200, new BuildConfigBuilder().withNewMetadata().withName("bc2").and().build()).once();
    server.expect()
        .withPath("/apis/build.openshift.io/v1/namespaces/ns1/builds?labelSelector=openshift.io%2Fbuild-config.name%3Dbc2")
        .andReturn(200, new BuildListBuilder().build()).once();

    boolean deleted = client.buildConfigs().withName("bc1").delete().size() == 1;

    deleted = client.buildConfigs().withName("bc2").delete().size() == 1;
    assertFalse(deleted);

    deleted = client.buildConfigs().inNamespace("ns1").withName("bc2").delete().size() == 1;
    assertTrue(deleted);
  }

  @Test
  void testBinaryBuildFromFileWithDefaults() throws IOException {
    File warFile = new File("target/test.war");
    warFile.createNewFile();

    server.expect().post()
        .withPath("/apis/build.openshift.io/v1/namespaces/ns1/buildconfigs/bc2/instantiatebinary?name=bc2&namespace=ns1")
        .andReturn(201, new BuildBuilder()
            .withNewMetadata().withName("bc2").endMetadata().build())
        .once();

    Build build = client.buildConfigs()
        .inNamespace("ns1")
        .withName("bc2")
        .instantiateBinary()
        .fromFile(warFile);
    assertNotNull(build);
    assertEquals("bc2", build.getMetadata().getName());
  }

}
