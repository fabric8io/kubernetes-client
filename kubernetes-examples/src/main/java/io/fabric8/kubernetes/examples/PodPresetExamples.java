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
package io.fabric8.kubernetes.examples;

import io.fabric8.kubernetes.api.model.EmptyDirVolumeSourceBuilder;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.VolumeBuilder;
import io.fabric8.kubernetes.api.model.VolumeMountBuilder;
import io.fabric8.kubernetes.api.model.settings.PodPreset;
import io.fabric8.kubernetes.api.model.settings.PodPresetBuilder;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.internal.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

// Tips for running with Minikube: https://github.com/fabric8io/kubernetes-client/pull/1286#issuecomment-447353662
public class PodPresetExamples {

  private static final Logger logger = LoggerFactory.getLogger(PodPresetExamples.class);

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
      logger.info("Using master with URL: {}", args[0]);
    }
    try (KubernetesClient client = new DefaultKubernetesClient(configBuilder.build())) {
      String namespace = "default";
      logger.info("Namespace: {}", namespace);
      Pod pod = client.pods().inNamespace(namespace).load(PodPresetExamples.class.getResourceAsStream("/pod-preset-example.yml")).get();
      logger.info("Pod created");
      client.pods().inNamespace(namespace).create(pod);

      PodPreset podPreset = new PodPresetBuilder()
        .withNewMetadata().withName("allow-database").endMetadata()
        .withNewSpec()
        .withNewSelector().withMatchLabels(Collections.singletonMap("role", "frontend")).endSelector()
        .withEnv(new EnvVarBuilder().withName("DB_PORT").withValue("6379").build())
        .withVolumeMounts(new VolumeMountBuilder().withMountPath("/cache").withName("cache-volume").build())
        .withVolumes(new VolumeBuilder().withName("cache-volume").withEmptyDir(new EmptyDirVolumeSourceBuilder().build()).build())
        .endSpec()
        .build();

      logger.info("Creating Pod Preset : {}", podPreset.getMetadata().getName());
      client.settings().podPresets().inNamespace(namespace).create(podPreset);

      pod = client.pods().inNamespace(namespace).withName(pod.getMetadata().getName()).get();
      logger.info("Updated pod: ");
      logger.info(SerializationUtils.dumpAsYaml(pod));
    } catch (Exception e) {
      logger.error("Exception occurred: {}", e.getMessage(), e);
    }
  }
}
