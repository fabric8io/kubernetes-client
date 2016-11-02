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

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.api.model.ProjectRequestBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageStreamTagExample {
  private static final Logger logger = LoggerFactory.getLogger(ImageStreamTagExample.class);

  public static void main(String[] args) throws InterruptedException {
    KubernetesClient kubernetesClient = new DefaultKubernetesClient();
    OpenShiftClient client = kubernetesClient.adapt(OpenShiftClient.class);

    try {
      // Create a namespace for all our stuff
      ProjectRequest proj = new ProjectRequestBuilder().withNewMetadata().withName("thisisatest").addToLabels("this", "rocks").endMetadata().build();
      log("Created project", client.projectrequests().create(proj));

      /* ---
apiVersion: "v1"
kind: "ImageStreamTag"
metadata:
  name: "bar1:1.0.12"
tag:
  from:
    kind: "ImageStreamImage"
    name: "bar1@sha256:1e924a1281084eea8e882d1bd96ee020cd077b48d71fea201de85f8ab3f67874"
    namespace: "default"
  name: "1.0.12"
  */

      log("Created istag", client.imageStreamTags().createNew()
        .withNewMetadata().withName("bar1:1.0.12")
        .and()
        .withNewTag().withNewFrom().withKind("DockerImage").withName("openshift/wildfly-81-centos7:latest")
        .and()
        .and()
        .done()
      );
    }finally {
      kubernetesClient.namespaces().withName("thisisatest").delete();
      client.close();
    }
  }


  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
