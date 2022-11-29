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

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginExample {
  private static final Logger logger = LoggerFactory.getLogger(LoginExample.class);

  public static void main(String[] args) {
    try (KubernetesClient kubernetesClient = new KubernetesClientBuilder().withConfig(new ConfigBuilder()
        .withMasterUrl("cluster_url")
        .withUsername("my_username")
        .withPassword("my_password")
        .build()).build()) {
      final OpenShiftClient openShiftClient = kubernetesClient.adapt(OpenShiftClient.class);
      logger.info("Login Successful");
      final ProjectList pl = openShiftClient.projects().list();
      pl.getItems().stream().map(Project::getMetadata).map(ObjectMeta::getName).forEach(logger::info);
    }
  }
}
