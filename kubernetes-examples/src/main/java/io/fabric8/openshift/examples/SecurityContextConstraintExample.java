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

import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraintsBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecurityContextConstraintExample {

  private static final Logger logger = LoggerFactory.getLogger(SecurityContextConstraintExample.class);

  //You need to be login as admin on OpenShift for this Example
  //command for that is
  //oc login -u system:admin

  public static void main(String[] args) {
    try (OpenShiftClient client = new KubernetesClientBuilder().build().adapt(OpenShiftClient.class)) {
      logger.info("Cluster SecurityContextConstraints:");
      client.securityContextConstraints().list().getItems().forEach(scc -> logger.info(" - {}", scc.getMetadata().getName()));
      final SecurityContextConstraints scc = client.securityContextConstraints().resource(
          new SecurityContextConstraintsBuilder()
              .withNewMetadata().withName("scc").endMetadata()
              .withAllowPrivilegedContainer(true)
              .withNewRunAsUser()
              .withType("RunAsAny")
              .endRunAsUser()
              .withNewSeLinuxContext()
              .withType("RunAsAny")
              .endSeLinuxContext()
              .withNewFsGroup()
              .withType("RunAsAny")
              .endFsGroup()
              .withNewSupplementalGroups()
              .withType("RunAsAny")
              .endSupplementalGroups()
              .addToUsers("admin")
              .addToGroups("admin-group")
              .build())
          .create();
      logger.info("Created SecurityContextConstraints {}", scc);
    } catch (KubernetesClientException e) {
      logger.error(e.getMessage(), e);
    }
  }

}
