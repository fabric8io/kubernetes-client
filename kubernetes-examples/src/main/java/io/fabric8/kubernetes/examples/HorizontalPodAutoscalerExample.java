/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import io.fabric8.kubernetes.api.model.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.HorizontalPodAutoscalerBuilder;
import io.fabric8.kubernetes.api.model.MetricSpecBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HorizontalPodAutoscalerExample {
  private static final Logger logger = LoggerFactory.getLogger(HorizontalPodAutoscalerExample.class);

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
    }
    try (final KubernetesClient client = new DefaultKubernetesClient(configBuilder.build())) {
      HorizontalPodAutoscaler horizontalPodAutoscaler = new HorizontalPodAutoscalerBuilder()
        .withNewMetadata().withName("the-hpa").withNamespace("default").endMetadata()
        .withNewSpec()
          .withNewScaleTargetRef()
            .withApiVersion("apps/v1")
            .withKind("Deployment")
            .withName("the-deployment")
          .endScaleTargetRef()
          .withMinReplicas(1)
          .withMaxReplicas(10)
          .addToMetrics(new MetricSpecBuilder()
            .withType("Resource")
            .withNewResource()
              .withName("cpu")
              .withNewTarget()
                .withType("Utilization")
                .withAverageUtilization(50)
              .endTarget()
            .endResource()
            .build())
        .endSpec()
        .build();

      client.autoscaling().horizontalPodAutoscalers().inNamespace("default").create(horizontalPodAutoscaler);
    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    }
  }
}
