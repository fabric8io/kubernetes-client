/*
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
package io.fabric8.kubernetes.log4j.lookup;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.ContainerStatus;
import io.fabric8.kubernetes.api.model.ContainerStatusBuilder;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.URL;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Validate the Kubernetes Lookup.
 */
@EnableKubernetesMockClient(crud = true)
class KubernetesLookupTest {

  private static final int MAX_CONTAINER_COUNT = 2;
  private static KubernetesClient mockClient;

  private static final ObjectMapper objectMapper = new ObjectMapper();

  @AfterEach
  void cleanUp() {
    KubernetesLookup.clear();
  }

  @Test
  void localPod() throws Exception {
    final Pod pod = objectMapper.readValue(KubernetesLookupTest.class.getResource("/localPod.json"), Pod.class);
    final Namespace namespace = createNamespace();
    final URL masterUrl = new URL("http://localhost:443/");
    final StrLookup lookup = new KubernetesLookup(pod, namespace, masterUrl);
    assertThat(lookup.lookup("accountName")).isEqualTo("default");
    assertThat(lookup.lookup("annotations")).isEqualTo("{}");
    assertThat(lookup.lookup("containerId"))
        .isEqualTo("docker://818b0098946c67e6ac56cb7c0934b7c2a9f50feb7244b422b2a7f566f7e5d0df");
    assertThat(lookup.lookup("containerName")).isEqualTo("sampleapp");
    assertThat(lookup.lookup("host")).isEqualTo("docker-desktop");
    assertThat(lookup.lookup("hostIp")).isEqualTo("192.168.65.3");
    assertThat(lookup.lookup("imageId")).isEqualTo(
        "docker-pullable://localhost:5000/sampleapp@sha256:3cefb2db514db73c69854fee8abd072f27240519432d08aad177a57ee34b7d39");
    assertThat(lookup.lookup("imageName")).isEqualTo("localhost:5000/sampleapp:latest");
    assertThat(lookup.lookup("labels")).isEqualTo("{app=sampleapp, pod-template-hash=584f99476d}");
    assertThat(lookup.lookup("labels.app")).isEqualTo("sampleapp");
    assertThat(lookup.lookup("labels.pod-template-hash")).isEqualTo("584f99476d");
    assertThat(lookup.lookup("masterUrl")).isEqualTo("http://localhost:443/");
    assertThat(lookup.lookup("podId")).isEqualTo("9213879a-479c-42ce-856b-7e2666d21829");
    assertThat(lookup.lookup("podIp")).isEqualTo("10.1.0.47");
    assertThat(lookup.lookup("podName")).isEqualTo("sampleapp-584f99476d-mnrp4");
    assertThat(lookup.lookup("nonExistentProperty")).isNull();
    assertNamespaceLookups(lookup, namespace.getMetadata().getUid());
  }

  @Test
  void clusterPod() throws Exception {
    final Pod pod = objectMapper.readValue(KubernetesLookupTest.class.getResource("/clusterPod.json"), Pod.class);
    final Namespace namespace = createNamespace();
    final URL masterUrl = new URL("http://localhost:443/");
    final StrLookup lookup = new KubernetesLookup(pod, namespace, masterUrl);
    assertThat(lookup.lookup("accountName")).isEqualTo("default");
    assertThat(lookup.lookup("annotations")).isEqualTo(
        "{cni.projectcalico.org/podIP=172.16.55.101/32, cni.projectcalico.org/podIPs=172.16.55.101/32, flagger-id=94d53b7b-cc06-41b3-bbac-a2d14a16d95d, prometheus.io/port=9797, prometheus.io/scrape=true}");
    assertThat(lookup.lookup("containerId"))
        .isEqualTo("docker://2b7c2a93dfb48334aa549e29fdd38039ddd256eec43ba64c145fa4b75a1542f0");
    assertThat(lookup.lookup("containerName")).isEqualTo("platform-forms-service");
    assertThat(lookup.lookup("host")).isEqualTo("k8s-tmpcrm-worker-s03-04");
    assertThat(lookup.lookup("hostIp")).isEqualTo("10.103.220.170");
    assertThat(lookup.lookup("imageId")).isEqualTo(
        "docker-pullable://docker.apache.xyz/platform-forms-service@sha256:45fd19ccd99e218a7685c4cee5bc5b16aeae1cdb8e8773f9c066d4cfb22ee195");
    assertThat(lookup.lookup("imageName")).isEqualTo("docker.apache.xyz/platform-forms-service:0.15.0");
    assertThat(lookup.lookup("labels")).isEqualTo("{app=platform-forms-service-primary, pod-template-hash=5ddfc4f9b8}");
    assertThat(lookup.lookup("labels.app")).isEqualTo("platform-forms-service-primary");
    assertThat(lookup.lookup("labels.pod-template-hash")).isEqualTo("5ddfc4f9b8");
    assertThat(lookup.lookup("masterUrl")).isEqualTo("http://localhost:443/");
    assertThat(lookup.lookup("podId")).isEqualTo("df8cbac1-129c-4cd3-b5bc-65d72d8ba5f0");
    assertThat(lookup.lookup("podIp")).isEqualTo("172.16.55.101");
    assertThat(lookup.lookup("podName")).isEqualTo("platform-forms-service-primary-5ddfc4f9b8-kfpzv");
    assertThat(lookup.lookup("nonExistentProperty")).isNull();
    assertNamespaceLookups(lookup, namespace.getMetadata().getUid());
  }

  static Stream<String> container_statuses_smoke_test() {
    return Stream.of(
        ContainerUtilTest.TEST_GOOD_CGROUP_RESOURCE,
        ContainerUtilTest.TEST_BAD_CGROUP_RESOURCE);
  }

  @ParameterizedTest
  @MethodSource
  void container_statuses_smoke_test(String cgroupPath) throws Exception {
    Namespace namespace = new NamespaceBuilder().build();
    URL masterUrl = new URL("http://localhost:443/");
    // Supports any number of container statuses
    for (int containerCount = 0; containerCount <= MAX_CONTAINER_COUNT; containerCount++) {
      // If more than a status is available ContainerUtil is used, so we set a test file to scan for the container id
      KubernetesLookup.cgroupPath = Paths.get(KubernetesLookupTest.class.getClassLoader().getResource(cgroupPath).toURI());
      ContainerStatus[] containerStatuses = new ContainerStatus[containerCount];
      for (int i = 0; i < containerCount; i++) {
        containerStatuses[i] = new ContainerStatusBuilder().withName("container" + i)
            .withContainerID(i == 0 ? ContainerUtilTest.CONTAINER_ID : null).build();
      }
      Pod pod = new PodBuilder().withNewStatus()
          .withContainerStatuses(containerStatuses)
          .endStatus()
          .build();
      assertDoesNotThrow(() -> new KubernetesLookup(pod, namespace, masterUrl));
      cleanUp();
    }
  }

  static Stream<String> containers_smoke_test() {
    return Stream.of(
        null,
        "container0");
  }

  @ParameterizedTest
  @MethodSource
  void containers_smoke_test(String containerName) throws Exception {
    Namespace namespace = new NamespaceBuilder().build();
    URL masterUrl = new URL("http://localhost:443/");
    // Supports any number of containers in the spec
    for (int containerCount = 0; containerCount <= MAX_CONTAINER_COUNT; containerCount++) {
      Container[] containers = new Container[containerCount];
      for (int i = 0; i < containerCount; i++) {
        containers[i] = new ContainerBuilder().withName("container" + i).build();
      }
      Pod pod = new PodBuilder().withNewSpec()
          .withContainers(containers)
          .endSpec()
          .withNewStatus()
          .addNewContainerStatus()
          .withName(
              containerName)
          .endContainerStatus()
          .endStatus()
          .build();
      assertDoesNotThrow(() -> new KubernetesLookup(pod, namespace, masterUrl));
      cleanUp();
    }
  }

  @Test
  void initialize_works_with_mock_client() {
    KubernetesLookup.clear();
    final Pod pod = mockClient.pods().resource(createPod()).create();
    final Namespace namespace = mockClient.namespaces().resource(createNamespace()).create();
    final StrLookup lookup = new KubernetesLookup() {
      @Override
      protected KubernetesClient createClient() {
        return mockClient;
      }
    };
    assertThat(lookup.lookup("podId")).isEqualTo(pod.getMetadata().getUid());
    assertThat(lookup.lookup("podName")).isEqualTo(KubernetesLookup.getHostName());
    assertNamespaceLookups(lookup, namespace.getMetadata().getUid());
  }

  @Test
  void no_client_should_return_no_data() {
    final StrLookup lookup = new KubernetesLookup() {
      @Override
      protected KubernetesClient createClient() {
        return null;
      }
    };
    assertThat(lookup.lookup("accountName")).isNull();
  }

  private void assertNamespaceLookups(final StrLookup lookup, final String uid) {
    assertThat(lookup.lookup("namespaceAnnotations")).isEqualTo("{test=name}");
    assertThat(lookup.lookup("namespaceLabels")).isEqualTo("{ns=my-namespace}");
    assertThat(lookup.lookup("namespaceName")).isEqualTo("test");
    assertThat(lookup.lookup("namespaceId")).isEqualTo(uid);
  }

  private static Pod createPod() {
    return new PodBuilder().withNewMetadata()
        .withName(KubernetesLookup.getHostName())
        .withNamespace("test")
        .endMetadata()
        .build();
  }

  private Namespace createNamespace() {
    return new NamespaceBuilder().withNewMetadata()
        .withName("test")
        .addToAnnotations("test", "name")
        .addToLabels("ns", "my-namespace")
        .endMetadata()
        .build();
  }
}
