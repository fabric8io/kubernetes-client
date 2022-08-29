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
package io.fabric8.chaosmesh.examples;

import io.fabric8.chaosmesh.client.ChaosMeshClient;
import io.fabric8.chaosmesh.v1alpha1.IOChaosBuilder;

import java.util.Collections;

@SuppressWarnings("java:S106")
public class CreateIoChaos {

  //apiVersion: chaos-mesh.org/v1alpha1
  //kind: IOChaos
  //metadata:
  //  name: io-delay-example
  //spec:
  //  action: latency
  //  mode: one
  //  selector:
  //    labelSelectors:
  //      app: etcd
  //  volumePath: /var/run/etcd
  //  path: "/var/run/etcd/**/*"
  //  delay: "100ms"
  //  percent: 50
  //  duration: "400s"
  //  scheduler:
  //    cron: "@every 10m"
  public static void main(String[] args) {
    try (ChaosMeshClient client = ClientFactory.newClient(args)) {
      System.out.println("Creating a ioChaos");
      client.ioChaos().inNamespace("default").create(new IOChaosBuilder()
          .withNewMetadata()
          .withName("io-delay-example")
          .endMetadata()
          .withNewSpec()
          .withAction("latency")
          .withMode("one")
          .withNewSelector().withLabelSelectors(Collections.singletonMap("app", "etcd")).endSelector()
          .withVolumePath("/var/run/etcd")
          .withPath("/var/run/etc/**/*")
          .withPercent(50)
          .withDuration("400s")
          .endSpec()
          .build());
    }
  }
}
