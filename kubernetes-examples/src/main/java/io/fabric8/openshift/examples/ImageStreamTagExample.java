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

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.openshift.api.model.ImageStreamTag;
import io.fabric8.openshift.api.model.ImageStreamTagBuilder;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageStreamTagExample {

  private static final Logger logger = LoggerFactory.getLogger(ImageStreamTagExample.class);

  public static void main(String[] args) throws InterruptedException {

    String namespace = "myproject";
    String master = "CLUSTER_URL";
    Config config = new ConfigBuilder().withMasterUrl(master).build();
    OpenShiftClient client = new DefaultOpenShiftClient(config);

    try {

      ImageStreamTag istag = new ImageStreamTagBuilder().withNewMetadata().withName("bar1:1.0.12").endMetadata()
        .withNewTag().withNewFrom().withKind("DockerImage").withName("openshift/wildfly-81-centos7:latest").endFrom().endTag()
        .build();

      log("Created istag", client.imageStreamTags().inNamespace(namespace).create(istag));
      
      Thread.sleep(30000);

    }finally {

      log("ImageStreamTags are :");
      log(client.imageStreamTags().inNamespace(namespace).withName("bar1:1.0.12").get().toString());

      log("ImageStreamTags using list are :");
      log(client.imageStreamTags().list().getItems().get(0).toString());
      log("Deleted istag",client.imageStreamTags().withName("bar1:1.0.12").delete());
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
