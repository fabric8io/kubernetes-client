/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.batch.Job;
import io.fabric8.kubernetes.api.model.batch.JobBuilder;
import io.fabric8.kubernetes.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
 * Creates a simple run to complete job that computes π to 2000 places and prints it out.
 */
public class JobExample {
    private static final Logger logger = LoggerFactory.getLogger(JobExample.class);

    public static void main(String[] args) {
        String master = "https://localhost:8443/";
        if (args.length == 1) {
            master = args[0];
        }

        final Config config = new ConfigBuilder().withMasterUrl(master).build();
        try (final KubernetesClient client = new DefaultKubernetesClient(config)) {
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
          client.batch().jobs().inNamespace(namespace).create(job);

          String joblog = client.batch().jobs().inNamespace(namespace).withName("pi").getLog();
          logger.info(joblog);

        } catch (final KubernetesClientException e) {
            logger.error("Unable to create job", e);
        }
    }
}
