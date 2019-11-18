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

import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.mock.crd.DoneablePodSet;
import io.fabric8.kubernetes.client.mock.crd.PodSet;
import io.fabric8.kubernetes.client.mock.crd.PodSetList;
import io.fabric8.kubernetes.client.mock.crd.PodSetSpec;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@EnableRuleMigrationSupport
public class TypedCustomResourceApiTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  private MixedOperation<PodSet, PodSetList, DoneablePodSet, Resource<PodSet, DoneablePodSet>> podSetClient;

  private CustomResourceDefinition podSetCrd;

  @Before
  public void setupCrd() {
    podSetCrd = new CustomResourceDefinitionBuilder()
      .withNewMetadata().withName("podsets.demo.k8s.io").endMetadata()
      .withNewSpec()
      .withGroup("demo.k8s.io")
      .withVersion("v1alpha1")
      .withNewNames().withKind("PodSet").withPlural("podsets").endNames()
      .withScope("Namespaced")
      .endSpec()
      .build();
  }

  @Test
  public void create() {
    server.expect().post().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets").andReturn(200, getPodSet()).once();

    podSetClient = server.getClient().customResources(podSetCrd, PodSet.class, PodSetList.class, DoneablePodSet.class);

    PodSet returnedPodSet = podSetClient.inNamespace("test").create(getPodSet());
    assertNotNull(returnedPodSet);
    assertEquals("example-podset", returnedPodSet.getMetadata().getName());
  }

  @Test
  public void list() {
    PodSetList podSetList = new PodSetList();
    podSetList.setItems(Collections.singletonList(getPodSet()));
    server.expect().get().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets").andReturn(200, podSetList).once();
    podSetClient = server.getClient().customResources(podSetCrd, PodSet.class, PodSetList.class, DoneablePodSet.class);

    podSetList = podSetClient.inNamespace("test").list();
    assertNotNull(podSetList);
    assertEquals(1, podSetList.getItems().size());
    assertEquals("example-podset", podSetList.getItems().get(0).getMetadata().getName());
  }

  @Test
  public void createOrReplace() {
    server.expect().get().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets/example-podset").andReturn(200, getPodSet()).times(2);
    server.expect().put().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets/example-podset").andReturn(200, getPodSet()).once();

    podSetClient = server.getClient().customResources(podSetCrd, PodSet.class, PodSetList.class, DoneablePodSet.class);
    PodSet returnedPodSet = podSetClient.inNamespace("test").createOrReplace(getPodSet());

    assertNotNull(returnedPodSet);
    assertEquals("example-podset", returnedPodSet.getMetadata().getName());
  }

  @Test
  public void delete() {
    server.expect().delete().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets/example-podset").andReturn(200, getPodSet()).once();

    podSetClient = server.getClient().customResources(podSetCrd, PodSet.class, PodSetList.class, DoneablePodSet.class);

    boolean isDeleted = podSetClient.inNamespace("test").withName("example-podset").delete();
    assertTrue(isDeleted);
  }

  @Test
  public void testCascadingDeletion() throws InterruptedException {
    server.expect().delete().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets/example-podset").andReturn(200, getPodSet()).once();

    podSetClient = server.getClient().customResources(podSetCrd, PodSet.class, PodSetList.class, DoneablePodSet.class);

    boolean isDeleted = podSetClient.inNamespace("test").withName("example-podset").cascading(true).delete();
    assertTrue(isDeleted);

    RecordedRequest recordedRequest = server.getLastRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"orphanDependents\":false}", recordedRequest.getBody().readUtf8());
  }

  @Test
  public void testPropagationPolicyDeletion() throws InterruptedException {
    server.expect().delete().withPath("/apis/demo.k8s.io/v1alpha1/namespaces/test/podsets/example-podset").andReturn(200, getPodSet()).once();

    podSetClient = server.getClient().customResources(podSetCrd, PodSet.class, PodSetList.class, DoneablePodSet.class);

    boolean isDeleted = podSetClient.inNamespace("test").withName("example-podset").withPropagationPolicy("Orphan").delete();
    assertTrue(isDeleted);

    RecordedRequest recordedRequest = server.getLastRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}", recordedRequest.getBody().readUtf8());
  }

  private PodSet getPodSet() {
    PodSetSpec podSetSpec = new PodSetSpec();
    podSetSpec.setReplicas(5);

    PodSet podSet = new PodSet();
    podSet.setApiVersion("demo.k8s.io/v1alpha1");
    podSet.setMetadata(new ObjectMetaBuilder().withName("example-podset").build());
    podSet.setSpec(podSetSpec);
    return podSet;
  }
}
