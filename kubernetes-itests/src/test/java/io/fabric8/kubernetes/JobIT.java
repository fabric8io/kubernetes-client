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
package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobBuilder;
import io.fabric8.kubernetes.api.model.batch.v1.JobStatus;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JobIT {

  KubernetesClient client;

  @Test
  void testGetLog() {
    final String jobName = "job-get-log";
    client.batch().v1().jobs().createOrReplace(initJob("job-get-log").build());
    client.batch().v1().jobs().withName(jobName).waitUntilCondition(
        j -> Optional.ofNullable(j).map(Job::getStatus).map(JobStatus::getSucceeded).orElse(0) > 0,
        1, TimeUnit.MINUTES);
    ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
    try (LogWatch ignore = client.batch().v1().jobs()
        .withName(jobName)
        .withLogWaitTimeout(30)
        .watchLog(baos)) {
      await().atMost(30, TimeUnit.SECONDS).until(() -> baos.toString().length() > 0);
      assertNotNull(baos.toString());
      assertEquals("This is a message!\n", baos.toString());
    }
  }

  @Test
  void testCreateWithGenerateName() {
    // Given
    Job job = initJob("job-generate-name").editMetadata()
        .withName(null)
        .withGenerateName("test-job-")
        .endMetadata()
        .editOrNewSpec().withSuspend(true).endSpec()
        .build();

    // When
    Job jobCreated = client.batch().v1().jobs().create(job);

    // Then
    assertNotNull(jobCreated);
    assertTrue(jobCreated.getMetadata().getName().contains("test-job-"));
    assertEquals("test-job-", jobCreated.getMetadata().getGenerateName());
    assertNotNull(jobCreated.getMetadata().getName());
    assertNotEquals("test-job-", jobCreated.getMetadata().getName());
    assertTrue(client.batch().v1().jobs().withName(jobCreated.getMetadata().getName()).delete().size() == 1);
  }

  private JobBuilder initJob(String name) {
    return new JobBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewTemplate()
        .withNewSpec()
        .addNewContainer()
        .withName("hello")
        .withImage("registry.access.redhat.com/ubi8/ubi-minimal")
        .withCommand("echo", "This is a message!")
        .endContainer()
        .withRestartPolicy("Never")
        .endSpec()
        .endTemplate()
        .endSpec();
  }
}
