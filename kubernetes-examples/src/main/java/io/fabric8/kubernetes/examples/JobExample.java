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

import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobBuilder;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/*
 * Creates a simple run to complete job that computes π to 2000 places and prints it out.
 */
public class JobExample {
  private static final Logger logger = LoggerFactory.getLogger(JobExample.class);

  public static void main(String[] args) {
    final ConfigBuilder configBuilder = new ConfigBuilder();
    if (args.length > 0) {
      configBuilder.withMasterUrl(args[0]);
    }
    try (KubernetesClient client = new KubernetesClientBuilder().withConfig(configBuilder.build()).build()) {
      final String namespace = "default";
      final Job job = new JobBuilder()
          .withApiVersion("batch/v1")
          .withNewMetadata()
          .withName("pi")
          .withLabels(Collections.singletonMap("label1", "maximum-length-of-63-characters"))
          .withAnnotations(Collections.singletonMap("annotation1", "some-very-long-annotation"))
          .endMetadata()
          .withNewSpec()
          .withNewTemplate()
          .withNewSpec()
          .addNewContainer()
          .withName("pi")
          .withImage("perl")
          .withArgs("perl", "-Mbignum=bpi", "-wle", "print bpi(2000)")
          .endContainer()
          .withRestartPolicy("Never")
          .endSpec()
          .endTemplate()
          .endSpec()
          .build();

      logger.info("Creating job pi.");

      client.batch().v1().jobs().inNamespace("default").resource(job).create();

      // Get All pods created by the job
      PodList podList = client.pods().inNamespace(namespace).withLabel("job-name", job.getMetadata().getName()).list();

      // Wait for pod to complete         
      client.pods().inNamespace(namespace).withName(podList.getItems().get(0).getMetadata().getName())
          .waitUntilCondition(pod -> pod.getStatus().getPhase().equals("Succeeded"), 2, TimeUnit.MINUTES);

      // Print Job's log
      String joblog = client.batch().v1().jobs().inNamespace(namespace).withName("pi").getLog();
      logger.info(joblog);

    } catch (KubernetesClientException e) {
      logger.error("Unable to create job", e);
    }
  }
}
