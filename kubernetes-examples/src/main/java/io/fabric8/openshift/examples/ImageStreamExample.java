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

import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamBuilder;
import io.fabric8.openshift.api.model.TagReferenceBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class ImageStreamExample {

  private static final Logger logger = LoggerFactory.getLogger(ImageStreamExample.class);

  public static void main(String[] args) {
    try (OpenShiftClient client = new KubernetesClientBuilder().build().adapt(OpenShiftClient.class)) {
      final String project = Optional.ofNullable(client.getNamespace()).orElse("myproject");
      final String imageStreamName = "slave-jenkins";
      final ImageStream imageStream = client.imageStreams().inNamespace(project).resource(
          new ImageStreamBuilder()
              .withNewMetadata()
              .withName(imageStreamName)
              .endMetadata()
              .withNewSpec()
              .addToTags(0, new TagReferenceBuilder()
                  .withName("base")
                  .withFrom(new ObjectReferenceBuilder()
                      .withKind("DockerImage")
                      .withName("docker.io/openshift/jenkins-slave-maven-centos7:latest")
                      .build())
                  .build())
              .addToTags(1, new TagReferenceBuilder()
                  .addToAnnotations("role", "jenkins-slave")
                  .addToAnnotations("slave-label", "jenkins-slave")
                  .withName("latest")
                  .withFrom(new ObjectReferenceBuilder()
                      .withKind("ImageStreamTag")
                      .withName("base")
                      .build())
                  .build())
              .endSpec()
              .build())
          .create();
      logger.info("Created ImageStream: {}/{}", project, imageStream.getMetadata().getName());
      final ImageStream isFromServer = client.imageStreams().inNamespace(project).withName(imageStreamName).get();
      logger.info("Tags in ImageStream are:");
      logger.info(" -  {}", isFromServer.getSpec().getTags().get(0).getName());
      logger.info(" -  {}", isFromServer.getSpec().getTags().get(1).getName());

      logger.info("Deleting ImageStream");
      client.imageStreams().inNamespace(project).withName(imageStreamName).delete();
    }
  }
}
