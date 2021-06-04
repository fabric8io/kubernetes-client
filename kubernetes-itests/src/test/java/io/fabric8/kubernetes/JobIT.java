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
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.LogWatch;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class JobIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @Test
  public void testGetLog() {
    // Given
    Job job = getJobBuilder().build();

    // When
    client.batch().jobs().inNamespace(session.getNamespace()).createOrReplace(job);
    ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
    LogWatch logWatch = client.batch().jobs().inNamespace(session.getNamespace())
      .withName(job.getMetadata().getName())
      .withLogWaitTimeout(30)
      .watchLog(baos);

    await().atMost(5, TimeUnit.SECONDS).until(() -> baos.toString().length() > 0);
    // Then
    assertNotNull(baos.toString());
    assertEquals("This is a message!\n", baos.toString());
    logWatch.close();
  }

  @Test
  public void testCreateWithGenerateName() {
    // Given
    Job job = getJobBuilder().editMetadata()
      .withName(null)
      .withGenerateName("test-job-")
      .endMetadata().build();

    // When
    Job jobCreated = client.batch().jobs().inNamespace(session.getNamespace()).create(job);

    // Then
    assertNotNull(jobCreated);
    assertTrue(jobCreated.getMetadata().getName().contains("test-job-"));
    assertEquals("test-job-", jobCreated.getMetadata().getGenerateName());
    assertNotNull(jobCreated.getMetadata().getName());
    assertNotEquals("test-job-", jobCreated.getMetadata().getName());
    assertTrue(client.batch().jobs().inNamespace(session.getNamespace()).withName(jobCreated.getMetadata().getName()).delete());
  }

  private JobBuilder getJobBuilder() {
    return new JobBuilder()
      .withNewMetadata().withName("hello").endMetadata()
      .withNewSpec()
      .withNewTemplate()
      .withNewSpec()
      .addNewContainer()
      .withName("hello")
      .withImage("busybox:1.32.0")
      .withCommand("echo", "This is a message!")
      .endContainer()
      .withRestartPolicy("Never")
      .endSpec()
      .endTemplate()
      .endSpec();
  }
}
