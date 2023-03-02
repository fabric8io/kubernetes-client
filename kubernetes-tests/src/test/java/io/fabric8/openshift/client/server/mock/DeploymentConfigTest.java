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

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.model.APIGroupListBuilder;
import io.fabric8.kubernetes.api.model.ContainerFluent;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.ListMeta;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import io.fabric8.kubernetes.client.utils.InputStreamPumper;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigBuilder;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.DeploymentConfigListBuilder;
import io.fabric8.openshift.api.model.DeploymentConfigSpecFluent;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class DeploymentConfigTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void testList() {
    server.expect().withPath("/apis/apps.openshift.io/v1/namespaces/test/deploymentconfigs")
        .andReturn(200, new DeploymentConfigListBuilder().build()).once();
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
    server.expect().withPath("/apis/apps.openshift.io/v1/namespaces/ns1/deploymentconfigs")
        .andReturn(200, new DeploymentConfigListBuilder()
            .addNewItem().and()
            .addNewItem().and().build())
        .once();

    server.expect().withPath("/apis/apps.openshift.io/v1/deploymentconfigs").andReturn(200, new DeploymentConfigListBuilder()
        .addNewItem().and()
        .addNewItem().and()
        .addNewItem()
        .and().build()).once();

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
  void testGet() {
    server.expect().withPath("/apis/apps.openshift.io/v1/namespaces/test/deploymentconfigs/dc1")
        .andReturn(200, new DeploymentConfigBuilder()
            .withNewMetadata().withName("dc1").endMetadata()
            .build())
        .once();

    server.expect().withPath("/apis/apps.openshift.io/v1/namespaces/ns1/deploymentconfigs/dc2")
        .andReturn(200, new DeploymentConfigBuilder()
            .withNewMetadata().withName("dc2").endMetadata()
            .build())
        .once();

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
  void testDelete() throws InterruptedException {
    DeploymentConfig dc1 = new DeploymentConfigBuilder()
        .withNewMetadata()
        .withName("dc1")
        .endMetadata()
        .withNewSpec()
        .withReplicas(1)
        .addToSelector("name", "dc1")
        .withNewTemplate()
        .withNewSpec()
        .addNewContainer()
        .withName("container")
        .withImage("image")
        .endContainer()
        .endSpec()
        .endTemplate()
        .endSpec()
        .build();

    DeploymentConfig dc2 = new DeploymentConfigBuilder()
        .withNewMetadata()
        .withName("dc2")
        .endMetadata()
        .withNewSpec()
        .withReplicas(1)
        .addToSelector("name", "dc1")
        .withNewTemplate()
        .withNewSpec()
        .addNewContainer()
        .withName("container")
        .withImage("image")
        .endContainer()
        .endSpec()
        .endTemplate()
        .endSpec()
        .withNewStatus()
        .withObservedGeneration(1L)
        .endStatus()
        .build();

    server.expect().withPath("/apis/apps.openshift.io/v1/namespaces/test/deploymentconfigs/dc1").andReturn(200, dc1).times(2);
    server.expect().withPath("/apis/apps.openshift.io/v1/namespaces/ns1/deploymentconfigs/dc2").andReturn(200, dc2).times(5);

    boolean deleted = client.deploymentConfigs().withName("dc1").delete().size() == 1;
    deleted = client.deploymentConfigs().withName("dc2").delete().size() == 1;
    assertFalse(deleted);

    deleted = client.deploymentConfigs().inNamespace("ns1").withName("dc2").delete().size() == 1;
    assertTrue(deleted);

    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Background\"}",
        server.getLastRequest().getBody().readUtf8());
  }

  @Test
  void testDeleteWithPropagationPolicy() throws InterruptedException {
    server.expect().delete()
        .withPath("/apis/apps.openshift.io/v1/namespaces/test/deploymentconfigs/dc1")
        .andReturn(200, new DeploymentConfigBuilder().build())
        .once();

    boolean isDeleted = client.deploymentConfigs().inNamespace("test").withName("dc1")
        .withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;
    assertTrue(isDeleted);
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
        server.getLastRequest().getBody().readUtf8());
  }

  @Test
  void testDeployingLatest() {
    server.expect().withPath("/apis/apps.openshift.io/v1/namespaces/test/deploymentconfigs/dc1")
        .andReturn(200, new DeploymentConfigBuilder().withNewMetadata().withName("dc1").endMetadata()
            .withNewStatus().withLatestVersion(1L).endStatus().build())
        .always();

    server.expect().patch().withPath("/apis/apps.openshift.io/v1/namespaces/test/deploymentconfigs/dc1")
        .andReturn(200, new DeploymentConfigBuilder().withNewMetadata().withName("dc1").endMetadata()
            .withNewStatus().withLatestVersion(2L).endStatus().build())
        .once();

    DeploymentConfig deploymentConfig = client.deploymentConfigs().withName("dc1").deployLatest();
    assertNotNull(deploymentConfig);
    assertEquals(Long.valueOf(2), deploymentConfig.getStatus().getLatestVersion());
  }

  @Test
  void testDeployingLatestHandlesMissingLatestVersion() {
    server.expect().withPath("/apis/apps.openshift.io/v1/namespaces/test/deploymentconfigs/dc1")
        .andReturn(200, new DeploymentConfigBuilder().withNewMetadata().withName("dc1").endMetadata()
            .withNewStatus().endStatus().build())
        .always();

    server.expect().patch().withPath("/apis/apps.openshift.io/v1/namespaces/test/deploymentconfigs/dc1")
        .andReturn(200, new DeploymentConfigBuilder().withNewMetadata().withName("dc1").endMetadata()
            .withNewStatus().withLatestVersion(1L).endStatus().build())
        .once();

    DeploymentConfig deploymentConfig = client.deploymentConfigs().withName("dc1").deployLatest();
    assertNotNull(deploymentConfig);
    assertEquals(Long.valueOf(1), deploymentConfig.getStatus().getLatestVersion());
  }

  //This is a test that verifies a recent fix (sundrio #135).
  //According to this issue when editing a list of buildables using predicates, the object visitors get overwrriten.
  @Test
  void testDeploymentConfigVisitor() {
    AtomicBoolean visitedContainer = new AtomicBoolean();
    DeploymentConfig dc1 = getDeploymentConfig().build();

    DeploymentConfig dc2 = new DeploymentConfigBuilder(dc1)
        .accept(new TypedVisitor<DeploymentConfigSpecFluent<?>>() {
          @Override
          public void visit(DeploymentConfigSpecFluent<?> spec) {
            spec.editMatchingTrigger(b -> b.buildImageChangeParams().getContainerNames().contains("container"))
                .withType("ImageChange")
                .endTrigger();
          }
        })
        .accept(new TypedVisitor<ContainerFluent<?>>() {
          @Override
          public void visit(ContainerFluent<?> container) {
            container.addNewEnv().withName("FOO").withValue("BAR").endEnv();
            visitedContainer.set(true);

          }
        }).build();
    assertNotNull(dc2);
    assertTrue(visitedContainer.get());
  }

  @Test
  void testGetLog() {
    // Given
    server.expect().get().withPath("/apis/apps.openshift.io/v1/namespaces/ns1/deploymentconfigs/dc1/log?pretty=false")
        .andReturn(HttpURLConnection.HTTP_OK, "testlog")
        .times(2);

    // When
    String log = client.deploymentConfigs().inNamespace("ns1").withName("dc1").getLog();

    // Then
    assertNotNull(log);
    assertEquals("testlog", log);
  }

  @Test
  void testWatchLog() {
    // Given
    setupWatchLog();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    // When
    LogWatch logWatch = client.deploymentConfigs().inNamespace("ns1").withName("dc1").watchLog(byteArrayOutputStream);

    // Then
    await().atMost(10, TimeUnit.SECONDS).until(() -> byteArrayOutputStream.toString().length() > 0);
    assertNotNull(byteArrayOutputStream.toString());
    assertEquals("testlog", byteArrayOutputStream.toString());
    logWatch.close();
  }

  @Test
  void testWatchLogOutput() throws IOException {
    // Given
    setupWatchLog();

    // When
    LogWatch logWatch = client.deploymentConfigs().inNamespace("ns1").withName("dc1").watchLog();
    InputStream is = logWatch.getOutput();

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    Executor exec = Executors.newSingleThreadExecutor();

    InputStreamPumper.pump(is, byteArrayOutputStream::write, exec);

    // Then
    await().atMost(10, TimeUnit.SECONDS).until(() -> byteArrayOutputStream.toString().length() > 0);
    assertNotNull(byteArrayOutputStream.toString());
    assertEquals("testlog", byteArrayOutputStream.toString());
    // graceful close
    assertEquals(-1, is.read());
    logWatch.close();
  }

  @Test
  void testGetLogWithTimestamps() {
    // Given
    server.expect().get()
        .withPath("/apis/apps.openshift.io/v1/namespaces/ns1/deploymentconfigs/dc1/log?pretty=false&timestamps=true")
        .andReturn(HttpURLConnection.HTTP_OK, "testlogtimestamps")
        .times(2);

    // When
    String log = client.deploymentConfigs().inNamespace("ns1").withName("dc1").usingTimestamps().getLog();

    // Then
    assertNotNull(log);
    assertEquals("testlogtimestamps", log);
  }

  @Test
  void testWatchLogWithTimestamps() {
    // Given
    setupWatchLog();
    server.expect().get()
        .withPath(
            "/apis/apps.openshift.io/v1/namespaces/ns1/deploymentconfigs/dc1/log?pretty=false&timestamps=true&follow=true")
        .andReturn(HttpURLConnection.HTTP_OK, "testlogtimestamps")
        .once();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    // When
    LogWatch logWatch = client.deploymentConfigs().inNamespace("ns1").withName("dc1").usingTimestamps()
        .watchLog(byteArrayOutputStream);

    // Then
    await().atMost(2, TimeUnit.SECONDS).until(() -> byteArrayOutputStream.toString().length() > 0);
    assertNotNull(byteArrayOutputStream.toString());
    assertEquals("testlogtimestamps", byteArrayOutputStream.toString());
    logWatch.close();
  }

  @Test
  void testWatchLogOutputWithTimestamps() throws IOException {
    // Given
    setupWatchLog();
    server.expect().get()
        .withPath(
            "/apis/apps.openshift.io/v1/namespaces/ns1/deploymentconfigs/dc1/log?pretty=false&timestamps=true&follow=true")
        .andReturn(HttpURLConnection.HTTP_OK, "testlogtimestamps")
        .once();
    // When
    LogWatch logWatch = client.deploymentConfigs().inNamespace("ns1").withName("dc1").usingTimestamps().watchLog();
    InputStream is = logWatch.getOutput();

    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    Executor exec = Executors.newSingleThreadExecutor();

    InputStreamPumper.pump(is, byteArrayOutputStream::write, exec);

    // Then
    await().atMost(2, TimeUnit.SECONDS).until(() -> byteArrayOutputStream.toString().length() > 0);
    assertNotNull(byteArrayOutputStream.toString());
    assertEquals("testlogtimestamps", byteArrayOutputStream.toString());
    // graceful close
    assertEquals(-1, is.read());
    logWatch.close();
  }

  private void setupWatchLog() {
    server.expect().get().withPath("/apis/apps.openshift.io/v1/namespaces/ns1/deploymentconfigs/dc1")
        .andReturn(HttpURLConnection.HTTP_OK, getDeploymentConfig().build())
        .times(2);
    server.expect().get()
        .withPath("/api/v1/namespaces/ns1/pods?labelSelector=" + Utils.toUrlEncoded("openshift.io/deployment-config.name=dc1"))
        .andReturn(HttpURLConnection.HTTP_OK, new PodListBuilder()
            .addToItems(new PodBuilder()
                .withNewStatus()
                .addNewCondition()
                .withType("Ready")
                .endCondition()
                .endStatus()
                .build())
            .build())
        .always();
    server.expect().get()
        .withPath("/apis/apps.openshift.io/v1/namespaces/ns1/deploymentconfigs/dc1/log?pretty=false&follow=true")
        .andReturn(HttpURLConnection.HTTP_OK, "testlog")
        .once();
  }

  @Test
  void testWaitUntilReady() throws InterruptedException {
    // Given
    DeploymentConfig deploymentConfig = getDeploymentConfig().withNewStatus()
        .addNewCondition()
        .withType("Available")
        .endCondition()
        .withReplicas(1).withAvailableReplicas(1)
        .endStatus().build();
    server.expect().get()
        .withPath(
            "/apis/apps.openshift.io/v1/namespaces/ns1/deploymentconfigs?fieldSelector=metadata.name%3Ddc1")
        .andReturn(HttpURLConnection.HTTP_OK,
            new DeploymentConfigListBuilder().withItems(deploymentConfig).withMetadata(new ListMeta()).build())
        .always();

    // When
    deploymentConfig = client.deploymentConfigs().inNamespace("ns1").withName("dc1").waitUntilReady(10, TimeUnit.SECONDS);

    // Then
    assertNotNull(deploymentConfig);
    assertEquals(1, deploymentConfig.getStatus().getAvailableReplicas().intValue());
    assertTrue(deploymentConfig.getStatus().getConditions().stream().anyMatch(c -> c.getType().equals("Available")));
  }

  @Test
  void testIsReady() {
    // Given
    DeploymentConfig deploymentConfig = getDeploymentConfig().withNewStatus()
        .addNewCondition()
        .withType("Available")
        .endCondition()
        .withReplicas(1).withAvailableReplicas(1)
        .endStatus().build();

    // When using a resource, it should still consult the server
    boolean result = client.resource(deploymentConfig).isReady();

    // Then
    assertFalse(result);

    server.expect().get().withPath("/apis/apps.openshift.io/v1/namespaces/ns1/deploymentconfigs/dc1")
        .andReturn(HttpURLConnection.HTTP_OK, deploymentConfig)
        .always();

    // When
    result = client.deploymentConfigs().inNamespace("ns1").withName("dc1").isReady();

    // Then
    assertTrue(result);

    // When missing
    result = client.deploymentConfigs().inNamespace("ns1").withName("dc2").isReady();

    // Then
    assertFalse(result);
  }

  private DeploymentConfigBuilder getDeploymentConfig() {
    return new DeploymentConfigBuilder()
        .withNewMetadata()
        .withName("dc1")
        .endMetadata()
        .withNewSpec()
        .withReplicas(1)
        .addToSelector("name", "dc1")
        .addNewTrigger()
        .withType("ImageChange")
        .withNewImageChangeParams()
        .withAutomatic(true)
        .withContainerNames("container")
        .withNewFrom()
        .withKind("ImageStreamTag")
        .withName("image:1.0")
        .endFrom()
        .endImageChangeParams()
        .endTrigger()
        .withNewTemplate()
        .withNewSpec()
        .addNewContainer()
        .withName("container")
        .withImage("image")
        .endContainer()
        .endSpec()
        .endTemplate()
        .endSpec();
  }
}
