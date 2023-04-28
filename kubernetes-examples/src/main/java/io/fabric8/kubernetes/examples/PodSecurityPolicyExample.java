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

import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicyBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PodSecurityPolicyExample {

  //You need to be login as admin on OpenShift for this Example
  //command for that is
  //oc login -u system:admin

  private static final Logger logger = LoggerFactory.getLogger(PodSecurityPolicyExample.class);

  public static void main(String[] args) {
    try (final KubernetesClient client = new KubernetesClientBuilder().build()) {
      final String localYamlToCreate = "/PodSecurityPolicy.yml";
      logger.info("Creating PodSecurityPolicy from Yaml file: {}", localYamlToCreate);
      try (final InputStream localYamlStream = PodSecurityPolicyExample.class.getResourceAsStream(localYamlToCreate)) {
        final PodSecurityPolicy podSecurityPolicy = client.policy().v1beta1().podSecurityPolicies().load(localYamlStream)
            .item();
        client.policy().v1beta1().podSecurityPolicies().withName(podSecurityPolicy.getMetadata().getName()).delete();
        client.policy().v1beta1().podSecurityPolicies().withName(podSecurityPolicy.getMetadata().getName())
            .waitUntilCondition(Objects::isNull, 5, TimeUnit.SECONDS);
        client.policy().v1beta1().podSecurityPolicies().resource(podSecurityPolicy).create();
        logger.info("PodSecurityPolicy created with Name : {}", podSecurityPolicy.getMetadata().getName());
      }

      logger.info("Starting creating PodSecurityPolicy programmatically");
      final String podSecurityPolicyName = "example2";
      client.policy().v1beta1().podSecurityPolicies().withName(podSecurityPolicyName).delete();
      client.policy().v1beta1().podSecurityPolicies().withName(podSecurityPolicyName)
          .waitUntilCondition(Objects::isNull, 5, TimeUnit.SECONDS);
      final PodSecurityPolicy programmaticPodSecurityPolicy = new PodSecurityPolicyBuilder().withNewMetadata()
          .withName(podSecurityPolicyName)
          .endMetadata()
          .withNewSpec()
          .withPrivileged(false)
          .withNewRunAsUser().withRule("RunAsAny").endRunAsUser()
          .withNewFsGroup().withRule("RunAsAny").endFsGroup()
          .withNewSeLinux().withRule("RunAsAny").endSeLinux()
          .withNewSupplementalGroups().withRule("RunAsAny").endSupplementalGroups()
          .endSpec()
          .build();
      client.policy().v1beta1().podSecurityPolicies().resource(programmaticPodSecurityPolicy).create();
      logger.info("PodSecurityPolicy created with Name: {}", programmaticPodSecurityPolicy.getMetadata().getName());
    } catch (KubernetesClientException clientException) {
      logger.error("Problem encountered with Kubernetes client!!", clientException);
    } catch (Exception e) {
      logger.error("Exception encountered : {}", e.getMessage(), e);
    }
  }
}
