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
package io.fabric8.kubernetes.log4j.lookup;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Pod;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Validate the Kubernetes Lookup.
 */
class KubernetesLookupTest {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  static Stream<Arguments> basicLookups() {
    return Stream.of(
        Arguments.of("/localPod.json",
            "sampleapp",
            "docker://818b0098946c67e6ac56cb7c0934b7c2a9f50feb7244b422b2a7f566f7e5d0df",
            "docker-desktop",
            "sampleapp-584f99476d-mnrp4"),
        Arguments.of(
            "/clusterPod.json",
            "platform-forms-service",
            "docker://2b7c2a93dfb48334aa549e29fdd38039ddd256eec43ba64c145fa4b75a1542f0",
            "k8s-tmpcrm-worker-s03-04",
            "platform-forms-service-primary-5ddfc4f9b8-kfpzv"));
  }

  @ParameterizedTest
  @MethodSource
  void basicLookups(String jsonResource,
      String containerName,
      String containerId,
      String hostName,
      String podName) throws Exception {
    final Pod pod = objectMapper.readValue(KubernetesLookupTest.class.getResource(jsonResource), Pod.class);
    final Namespace namespace = createNamespace();
    final URL masterUrl = new URL("http://localhost:443/");
    final KubernetesLookup lookup = new KubernetesLookup(pod, namespace, masterUrl);
    try {
      assertEquals(containerName, lookup.lookup("containerName"), "Incorrect container name");
      assertEquals(
          containerId,
          lookup.lookup("containerId"), "Incorrect container id");
      assertEquals(hostName, lookup.lookup("host"), "Incorrect host name");
      assertEquals(podName, lookup.lookup("podName"), "Incorrect pod name");
    } finally {
      lookup.clearInfo();
    }
  }

  private Namespace createNamespace() {
    final Namespace namespace = new Namespace();
    final ObjectMeta meta = new ObjectMeta();
    final Map<String, String> annotations = new HashMap<>();
    annotations.put("test", "name");
    meta.setAnnotations(annotations);
    final Map<String, String> labels = new HashMap<>();
    labels.put("ns", "my-namespace");
    meta.setLabels(labels);
    meta.setUid(UUID.randomUUID().toString());
    namespace.setMetadata(meta);
    return namespace;
  }
}
