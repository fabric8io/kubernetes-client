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

import io.fabric8.kubernetes.api.model.batch.Job;
import io.fabric8.kubernetes.api.model.batch.JobBuilder;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    Job job = new JobBuilder()
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
      .endSpec()
      .build();

    // When
    client.batch().jobs().inNamespace(session.getNamespace()).createOrReplace(job);
    ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
    LogWatch logWatch = client.batch().jobs().inNamespace(session.getNamespace())
      .withName(job.getMetadata().getName())
      .watchLog(baos);

    await().atMost(5, TimeUnit.SECONDS).until(() -> baos.toString().length() > 0);
    // Then
    assertNotNull(baos.toString());
    assertEquals("This is a message!\n", baos.toString());
    logWatch.close();
  }
}
