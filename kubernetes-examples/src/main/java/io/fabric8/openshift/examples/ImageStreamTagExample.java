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
import io.fabric8.openshift.api.model.ImageStreamTag;
import io.fabric8.openshift.api.model.ImageStreamTagBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class ImageStreamTagExample {

  private static final Logger logger = LoggerFactory.getLogger(ImageStreamTagExample.class);

  public static void main(String[] args) throws InterruptedException {

    try (OpenShiftClient client = new KubernetesClientBuilder().build().adapt(OpenShiftClient.class)) {
      final String project = Optional.ofNullable(client.getNamespace()).orElse("myproject");
      final String isTagName = "bar1:1.0.12";
      final ImageStreamTag isTag = client.imageStreamTags().inNamespace(project).resource(
          new ImageStreamTagBuilder().withNewMetadata().withName(isTagName).endMetadata()
              .withNewTag().withNewFrom().withKind("DockerImage").withName("openshift/wildfly-81-centos7:latest").endFrom()
              .endTag()
              .build())
          .createOrReplace();
      logger.info("Created ImageStreamTag: {}", isTag.getMetadata().getName());
      int limit = 0;
      while (client.imageStreamTags().inNamespace(project).withName(isTagName).get() == null && limit++ < 10) {
        TimeUnit.SECONDS.sleep(1);
      }
      logger.info("ImageStreamTags in {}:", project);
      client.imageStreamTags().inNamespace(project).list().getItems()
          .forEach(ist -> logger.info(" - {}", ist.getMetadata().getName()));
      final boolean deletedIsTag = client.imageStreamTags().withName(isTagName).delete().size() == 1;
      logger.info("Deleted ImageStreamTag: {}", deletedIsTag);
    }
  }
}
