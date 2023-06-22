
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
import io.fabric8.junit.jupiter.api.KubernetesTest;
import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.Version;
import io.fabric8.kubernetes.client.dsl.NamespaceableResource;
import io.fabric8.kubernetes.client.dsl.PodResource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@KubernetesTest
@LoadKubernetesManifests(value = { "checker-infra.yaml", "control-infra.yaml" })
public class ChaosIT {
  protected Logger logger = LoggerFactory.getLogger(getClass().getName());

  KubernetesClient client;

  String checkerImage = Optional.ofNullable(System.getenv("CHECKER_IMAGE")).orElse("chaos-test-checker:latest");
  String controlImage = Optional.ofNullable(System.getenv("CONTROL_IMAGE")).orElse("chaos-test-control:latest");
  String chaosTest = Optional.ofNullable(System.getenv("CHAOS_TEST")).orElse("network-delay.yaml");

  @BeforeEach
  void beforeEach() throws Exception {
    logger.info("BeforeEach execution");
    // this needs to be executed before the pods are started
    client.configMaps().inNamespace(client.getNamespace()).withName("chaos-test").delete();
  }

  @AfterEach
  void afterEach() throws Exception {
    logger.info("AfterEach execution");

    try {
      String checkerLogs = checkerSelector().getLog();
      logger.info("*** Checker Logs ***\n" + checkerLogs);
      logger.info("******");
    } catch (Exception e) {
      // ignore
    }

    try {
      String controlLogs = controlSelector().getLog();
      logger.info("*** Control Logs ***\n" + controlLogs);
      logger.info("******");
    } catch (Exception e) {
      // ignore
    }
  }

  private static final int TOTAL_COUNT = 1 * 60 * 20; // 1 count each second, for 20 minutes

  private static void setArgs(Pod pod, String namespace) {
    List<String> command = pod.getSpec().getContainers().get(0).getCommand();
    command.add("java");
    command.add("-jar");
    command.add("/maven/chaos-tests-" + Version.clientVersion() + ".jar");
    command.add("--namespace");
    command.add(namespace);
    command.add("--num");
    command.add(Integer.toString(TOTAL_COUNT));
    pod.getSpec().getContainers().get(0).setCommand(command);
  }

  private static void setImage(Pod pod, String image) {
    pod.getSpec().getContainers().get(0).setImage(image);
  }

  private PodResource checkerSelector() {
    return client.pods().inNamespace(client.getNamespace()).withName("checker");
  }

  private PodResource controlSelector() {
    return client.pods().inNamespace(client.getNamespace()).withName("checker");
  }

  @Test
  void test() throws IOException {
    logger.warn("Running test with chaos settings from: " + chaosTest);
    logger.warn("Using checker image: " + checkerImage);
    logger.warn("Using control image: " + controlImage);

    try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("checker-pod.yaml")) {
      Stream<NamespaceableResource<HasMetadata>> resources = client.load(is).resources();
      resources
          .filter(r -> r.item().getKind().equals("Pod"))
          .forEach(r -> {
            if (checkerImage != null) {
              setImage(((Pod) r.item()), checkerImage);
            }
            setArgs(((Pod) r.item()), client.getNamespace());
            r.inNamespace(client.getNamespace()).create();
          });
    }
    await().pollInterval(1, TimeUnit.SECONDS).ignoreExceptions().atMost(1, TimeUnit.MINUTES).until(() -> {
      assertEquals("Running", checkerSelector().get().getStatus().getPhase());
      return true;
    });

    try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("control-pod.yaml")) {
      Stream<NamespaceableResource<HasMetadata>> resources = client.load(is).resources();
      resources
          .filter(r -> r.item().getKind().equals("Pod"))
          .forEach(r -> {
            if (controlImage != null) {
              setImage(((Pod) r.item()), controlImage);
            }
            setArgs(((Pod) r.item()), client.getNamespace());
            r.inNamespace(client.getNamespace()).create();
          });
    }
    await().pollInterval(1, TimeUnit.SECONDS).ignoreExceptions().atMost(1, TimeUnit.MINUTES).until(() -> {
      assertTrue(checkerSelector().getLog().contains("Update received, and it's in the correct order, counter: 1"));
      return true;
    });

    try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(chaosTest)) {
      client.load(is).inNamespace(client.getNamespace()).createOrReplace();
    }

    await().pollInterval(10, TimeUnit.SECONDS).ignoreExceptions().atMost(30, TimeUnit.MINUTES).until(() -> {
      logger.info("Checking status");
      logger.info("checker: " + checkerSelector().get().getStatus().getPhase());
      logger.info("control: " + controlSelector().get().getStatus().getPhase());
      assertEquals("Succeeded", checkerSelector().get().getStatus().getPhase());
      assertEquals("Succeeded", controlSelector().get().getStatus().getPhase());
      return true;
    });
  }

}
