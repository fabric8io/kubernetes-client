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

package io.fabric8.openshift.examples;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.openshift.api.model.config.v1.Project;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdaptClient {

  private static final Logger logger = LoggerFactory.getLogger(AdaptClient.class);

  public static void main(String[] args) {
    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      if (Boolean.FALSE.equals(client.supports(Project.class))) {
        logger.warn("Target cluster is not OpenShift compatible");
        return;
      }
      OpenShiftClient oClient = client.adapt(OpenShiftClient.class);
      logger.info("Client adapted to OpenShiftClient: {}", oClient.getClass().getCanonicalName());
      logger.info("URL: {}", oClient.getOpenshiftUrl());
    }
  }
}
