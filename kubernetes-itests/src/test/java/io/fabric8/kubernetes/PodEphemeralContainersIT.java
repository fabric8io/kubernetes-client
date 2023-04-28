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
package io.fabric8.kubernetes;

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.EphemeralContainer;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ExecWatch;
import io.fabric8.kubernetes.client.dsl.PodResource;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/pod-it.yml")
@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 25)
class PodEphemeralContainersIT {

  KubernetesClient client;

  @Test
  void edit() {
    Pod pod = client.pods().withName("pod-standard")
        .ephemeralContainers()
        .edit(p -> new PodBuilder(p)
            .editMetadata().withResourceVersion(null).endMetadata()
            .editSpec()
            .addNewEphemeralContainer()
            .withName("debugger-1")
            .withImage("alpine")
            .withCommand("sh")
            .endEphemeralContainer()
            .endSpec()
            .build());

    List<EphemeralContainer> containers = pod.getSpec().getEphemeralContainers();
    assertTrue(containers.stream().anyMatch(c -> c.getName().equals("debugger-1")));
  }

  @Test
  void replace() {
    Pod item = client.pods().withName("pod-standard").get();
    Pod replacement = new PodBuilder(item)
        .editSpec()
        .addNewEphemeralContainer()
        .withName("debugger-2")
        .withImage("busybox")
        .withCommand("sleep", "36000")
        .endEphemeralContainer()
        .endSpec()
        .build();

    Pod pod = client.pods()
        .resource(replacement)
        .ephemeralContainers()
        .replace();

    List<EphemeralContainer> containers = pod.getSpec().getEphemeralContainers();
    assertTrue(containers.stream().anyMatch(c -> c.getName().equals("debugger-2")));
  }

  @Test
  void exec() {
    PodResource resource = client.pods().withName("pod-standard");
    resource.ephemeralContainers()
        .edit(p -> new PodBuilder(p)
            .editMetadata().withResourceVersion(null).endMetadata()
            .editSpec()
            .addNewEphemeralContainer()
            .withName("debugger-3")
            .withImage("busybox")
            .withCommand("sleep", "36000")
            .endEphemeralContainer()
            .endSpec()
            .build());

    resource.waitUntilCondition(p -> {
      return p.getStatus()
          .getEphemeralContainerStatuses()
          .stream()
          .filter(s -> s.getName().equals("debugger-3"))
          .anyMatch(s -> s.getState().getRunning() != null);
    }, 2, TimeUnit.MINUTES);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    try (ExecWatch watch = resource.inContainer("debugger-3")
        .writingOutput(out)
        .exec("sh", "-c", "echo 'hello world!'")) {
      assertEquals(0, watch.exitCode().join());
      assertEquals("hello world!\n", out.toString());
    }
  }

}
