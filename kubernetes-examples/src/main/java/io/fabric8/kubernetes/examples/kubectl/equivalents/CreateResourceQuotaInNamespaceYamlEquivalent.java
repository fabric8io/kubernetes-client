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
package io.fabric8.kubernetes.examples.kubectl.equivalents;

import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This sample code is Java equivalent to `kubectl create -f quota.yaml --namespace=default`.
 * It loads YAML manifest with specified name and creates it.
 */
public class CreateResourceQuotaInNamespaceYamlEquivalent {
  private static final Logger logger = LoggerFactory.getLogger(CreateResourceQuotaInNamespaceYamlEquivalent.class.getName());

  public static void main(String[] args) {

    try (KubernetesClient client = new KubernetesClientBuilder().build()) {
      /*
       * If namespace is specified in YAML client would pick it up from there,
       * otherwise you would need to specify it in operation context like being done
       * here.
       */
      ResourceQuota resourceQuota = client.resourceQuotas().inNamespace("default")
          .load(CreateResourceQuotaInNamespaceYamlEquivalent.class.getResourceAsStream("/quota.yaml"))
          .create();
      logger.info("Successfully created ResourceQuota {} in {} namespace", resourceQuota.getMetadata().getName(),
          resourceQuota.getMetadata().getNamespace());
    }
  }
}
