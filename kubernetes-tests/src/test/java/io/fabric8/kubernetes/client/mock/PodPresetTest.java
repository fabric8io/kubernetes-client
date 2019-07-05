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

package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.EmptyDirVolumeSourceBuilder;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.VolumeBuilder;
import io.fabric8.kubernetes.api.model.VolumeMountBuilder;
import io.fabric8.kubernetes.api.model.settings.PodPreset;
import io.fabric8.kubernetes.api.model.settings.PodPresetBuilder;
import io.fabric8.kubernetes.api.model.settings.PodPresetList;
import io.fabric8.kubernetes.api.model.settings.PodPresetListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;

import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class PodPresetTest {
  @Rule public KubernetesServer server = new KubernetesServer();

  @Test
  public void testList() {
    server.expect().withPath("/apis/settings.k8s.io/v1alpha1/namespaces/test/podpresets").andReturn(200, new PodPresetListBuilder().build()).once();
    server.expect().withPath("/apis/settings.k8s.io/v1alpha1/namespaces/ns1/podpresets").andReturn(200, new PodPresetListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

    KubernetesClient client = server.getClient();

    PodPresetList podPresetList = client.settings().podPresets().list();
    assertNotNull(podPresetList);
    assertEquals(0, podPresetList.getItems().size());
    podPresetList = client.settings().podPresets().inNamespace("ns1").list();
    assertNotNull(podPresetList);
    assertEquals(2, podPresetList.getItems().size());
  }

  @Test
  public void testGet() {
    server.expect().withPath("/apis/settings.k8s.io/v1alpha1/namespaces/test/podpresets/podpreset1").andReturn(200, new PodPresetBuilder().build()).once();
    server.expect().withPath("/apis/settings.k8s.io/v1alpha1/namespaces/ns1/podpresets/podpreset2").andReturn(200, new PodPresetBuilder().build()).once();

    KubernetesClient client = server.getClient();

    PodPreset podpreset1 = client.settings().podPresets().withName("podpreset1").get();
    assertNotNull(podpreset1);

    PodPreset podpreset2 =  client.settings().podPresets().withName("podpreset2").get();
    assertNull(podpreset2);

    podpreset2 = client.settings().podPresets().inNamespace("ns1").withName("podpreset2").get();
    assertNotNull(podpreset2);
  }

  @Test
  public void load() {
    KubernetesClient client = server.getClient();
    PodPreset podPreset = client.settings().podPresets().load(getClass().getResourceAsStream("/test-podpreset.yml")).get();
    assertNotNull(podPreset);
    assertEquals("podpresetload-test", podPreset.getMetadata().getName());
  }

  @Test
  public void testPodUpdate() {
    try{
      server.expect().withPath("/apis/settings.k8s.io/v1alpha1/namespaces/test/podpresets/podpreset-test").andReturn(200, new PodPresetBuilder()
        .withNewMetadata().withName("podpreset-test").endMetadata()
        .withNewSpec()
        .withNewSelector().withMatchLabels(Collections.singletonMap("app", "website")).endSelector()
        .withEnv(new EnvVarBuilder()
          .withName("DB_PORT")
          .withValue("6379")
          .build())
        .withVolumeMounts(new VolumeMountBuilder()
          .withMountPath("/cache")
          .withName("cache-volume")
          .build())
        .withVolumes(
          new VolumeBuilder()
            .withName("cache-volume")
            .withEmptyDir(new EmptyDirVolumeSourceBuilder().build())
            .build())
        .endSpec()
        .build())
        .once();

      Pod pod = new PodBuilder().withNewMetadata().withName("pod").withNamespace("test").withLabels(Collections.singletonMap("app", "website")).endMetadata()
        .withNewSpec()
        .addToContainers(new ContainerBuilder().withName("website").withImage("nginx").withImagePullPolicy("IfNotPresent").build())
        .endSpec()
        .build();
      server.expect().withPath("/api/v1/namespaces/test/pods/pod").andReturn(200, pod).once();

      KubernetesClient client = server.getClient();
      pod = client.pods().inNamespace("test").withName(pod.getMetadata().getName()).get();
      assertNotNull(pod);
      assertEquals("pod", pod.getMetadata().getName());
      assertNotNull(pod.getSpec().getVolumes().get(0).getName());
      assertEquals("cache-volume", pod.getSpec().getVolumes().get(0).getName());
      PodPreset podpreset = client.settings().podPresets().withName("podpreset-test").get();
      assertNotNull(pod.getSpec().getAdditionalProperties().get("DB_PORT"));
      assertEquals(6379, pod.getSpec().getAdditionalProperties().get("DB_PORT"));
      assertEquals("podpreset-test", podpreset.getMetadata().getName());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testmultiplePodPreset() {
    try{
      KubernetesClient client = server.getClient();

      PodPreset podpreset1 = client.settings().podPresets().load(getClass().getResourceAsStream("/test-multiple1-podpreset.yml")).get();
      server.expect().withPath("/apis/settings.k8s.io/v1alpha1/namespaces/test/podpresets/allow-database").andReturn(200, podpreset1).once();

      PodPreset podpreset2 = client.settings().podPresets().load(getClass().getResourceAsStream("/test-multiple2-podpreset.yml")).get();
      server.expect().withPath("/apis/settings.k8s.io/v1alpha1/namespaces/test/podpresets/proxy").andReturn(200, podpreset2).once();

      Pod pod = client.pods().load(getClass().getResourceAsStream("/test-podpreset-pod.yml")).get();
      server.expect().withPath("/api/v1/namespaces/test/pods/pod-test").andReturn(200, pod).once();

      client = server.getClient();
      pod = client.pods().inNamespace("test").withName(pod.getMetadata().getName()).get();
      assertNotNull(pod);
      assertEquals("pod-test", pod.getMetadata().getName());
      assertNotNull(pod.getSpec().getContainers().get(0).getVolumeMounts().get(0).getName());
      assertEquals("cache-volume", pod.getSpec().getContainers().get(0).getVolumeMounts().get(0).getName());
      assertNotNull(pod.getSpec().getContainers().get(0).getVolumeMounts().get(1).getName());
      assertEquals("proxy-volume", pod.getSpec().getContainers().get(0).getVolumeMounts().get(1).getName());
      assertNotNull(pod.getSpec().getVolumes().get(0));
      assertEquals("cache-volume", pod.getSpec().getVolumes().get(0).getName());
      assertNotNull(pod.getSpec().getVolumes().get(0));
      assertEquals("proxy-volume", pod.getSpec().getVolumes().get(1).getName());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testConflict() {
    KubernetesClient client = server.getClient();

    PodPreset podpreset = client.settings().podPresets().load(getClass().getResourceAsStream("/test-conflict-podpreset.yml")).get();
    server.expect().withPath("/apis/settings.k8s.io/v1alpha1/namespaces/test/podpresets/allow-database").andReturn(200, podpreset).once();

    Pod pod = client.pods().load(getClass().getResourceAsStream("/test-conflict-pod.yml")).get();
    server.expect().withPath("/api/v1/namespaces/test/pods/website").andReturn(200, pod).once();

    client = server.getClient();
    pod = client.pods().inNamespace("test").withName(pod.getMetadata().getName()).get();

    // Pod spec not changed because of conflict
    assertNotNull(pod.getSpec().getVolumes().get(0));
    assertEquals("cache-volume", pod.getSpec().getVolumes().get(0).getName());
  }

  @Test
  public void testDelete() {
    server.expect().withPath("/apis/settings.k8s.io/v1alpha1/namespaces/test/podpresets/podpreset1").andReturn(200, new PodPresetBuilder()
      .withNewMetadata().withName("podpreset1").endMetadata()
      .withNewSpec()
      .withNewSelector().withMatchLabels(Collections.singletonMap("app", "website")).endSelector()
      .withEnv(new EnvVarBuilder()
        .withName("DB_PORT")
        .withValue("6379")
        .build())
      .withVolumeMounts(new VolumeMountBuilder()
        .withMountPath("/cache")
        .withName("cache-volume")
        .build())
      .withVolumes(
        new VolumeBuilder()
          .withName("cache-volume")
          .withEmptyDir(new EmptyDirVolumeSourceBuilder().build())
          .build())
      .endSpec()
      .build())
      .once();

    server.expect().withPath("/apis/settings.k8s.io/v1alpha1/namespaces/ns1/podpresets/podpreset2").andReturn(200, new PodPresetBuilder()
      .withNewMetadata().withName("podpreset2").endMetadata()
      .withNewSpec()
      .withNewSelector().withMatchLabels(Collections.singletonMap("app", "website")).endSelector()
      .withEnv(new EnvVarBuilder()
        .withName("DB_PORT")
        .withValue("6379")
        .build())
      .withVolumeMounts(new VolumeMountBuilder()
        .withMountPath("/cache")
        .withName("cache-volume")
        .build())
      .withVolumes(
        new VolumeBuilder()
          .withName("cache-volume")
          .withEmptyDir(new io.fabric8.kubernetes.api.model
            .EmptyDirVolumeSourceBuilder()
            .build())
          .build())
      .endSpec()
      .build())
      .once();

    KubernetesClient client = server.getClient();

    Boolean deleted = client.settings().podPresets().withName("podpreset1").delete();
    assertTrue(deleted);

    deleted = client.settings().podPresets().withName("podpreset2").delete();
    assertFalse(deleted);

    deleted = client.settings().podPresets().inNamespace("ns1").withName("podpreset2").delete();
    assertTrue(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testDeleteWithNamespaceMismatch() {
    PodPreset podPreset1 = new PodPresetBuilder().withNewMetadata().withName("podPreset1").withNamespace("test").endMetadata().build();

    KubernetesClient client = server.getClient();

    Boolean deleted = client.settings().podPresets().inNamespace("hello").delete(podPreset1);
    assertFalse(deleted);
  }
}
