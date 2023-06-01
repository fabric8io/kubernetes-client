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
import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.autoscaling.v1.Scale;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RequireK8sSupport(CustomResourceDefinition.class)
@LoadKubernetesManifests("/scale-it.yml")
class ScaleIT {

  KubernetesClient client;

  @BeforeEach
  void setUp() {
    Awaitility.await().atMost(30, TimeUnit.SECONDS).until(() -> {
      try {
        client.genericKubernetesResources("stable.example.com/v1", "CronTab");
        return true;
      } catch (KubernetesClientException e) {
        return false;
      }
    });
  }

  @Test
  void scaleGeneric() {
    GenericKubernetesResource cronTab = Serialization.unmarshal("apiVersion: \"stable.example.com/v1\"\n"
        + "kind: CronTab\n"
        + "metadata:\n"
        + "  name: cron\n"
        + "spec:\n"
        + "  cronSpec: \"* * * * */5\"\n"
        + "  image: my-awesome-cron-image\n"
        + "  replicas: 3", GenericKubernetesResource.class);

    Resource<GenericKubernetesResource> resource = client.resource(cronTab);

    Awaitility.await().atMost(30, TimeUnit.SECONDS).until(() -> {
      try {
        resource.create();
        return true;
      } catch (KubernetesClientException e) {
        return false; // the crd has not been processed yet
      }
    });

    Scale scale = resource.scale();

    assertEquals(3, scale.getSpec().getReplicas());
    assertEquals(0, scale.getStatus().getReplicas());

    cronTab = resource.scale(1);
    assertEquals(1, (Integer) cronTab.get("spec", "replicas"));

    scale = resource.scale();
    assertEquals(1, scale.getSpec().getReplicas());
  }

}
