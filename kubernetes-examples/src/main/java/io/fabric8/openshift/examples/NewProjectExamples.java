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
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewProjectExamples {
  private static final Logger logger = LoggerFactory.getLogger(NewProjectExamples.class);

  public static void main(String[] args) throws InterruptedException {
    String master = "https://localhost:8443/";
    if (args.length == 1) {
      master = args[0];
    }

    Config config = new ConfigBuilder().withMasterUrl(master).build();

    try (OpenShiftClient client = new DefaultOpenShiftClient(config)) {
      ProjectRequest request = null;
      try {
        request = client.projectrequests().createNew().withNewMetadata().withName("thisisatest").endMetadata().withDescription("Jimmi").withDisplayName("Jimmi").done();
      } finally {
        if (request != null) {
          client.projects().withName(request.getMetadata().getName()).delete();
        }
      }
    }
  }


  private static void log(String action, Object obj) {
    logger.info("{}: {}", action, obj);
  }

  private static void log(String action) {
    logger.info(action);
  }
}
