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

import io.fabric8.kubernetes.api.model.batch.CronJob;
import io.fabric8.kubernetes.api.model.batch.CronJobBuilder;
import io.fabric8.kubernetes.api.model.batch.CronJobList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class CronJobIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private CronJob cronJob1, cronJob2;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    cronJob1 = new CronJobBuilder().withApiVersion("batch/v1beta1").withNewMetadata()
      .withName("cronjob1")
      .endMetadata()
      .withNewSpec()
      .withSchedule("*/1 * * * *")
      .withNewJobTemplate()
      .withNewSpec()
      .withNewTemplate()
      .withNewSpec()
      .addNewContainer()
      .withName("hello")
      .withImage("busybox")
      .withArgs("/bin/sh", "-c", "date; echo Hello from Kubernetes")
      .endContainer()
      .withRestartPolicy("OnFailure")
      .endSpec()
      .endTemplate()
      .endSpec()
      .endJobTemplate()
      .endSpec()
      .build();
    cronJob2 = new CronJobBuilder().withApiVersion("batch/v1beta1").withNewMetadata()
      .withName("cronjob2")
      .endMetadata()
      .withNewSpec()
      .withSchedule("*/1 * * * *")
      .withNewJobTemplate()
      .withNewSpec()
      .withNewTemplate()
      .withNewSpec()
      .addNewContainer()
      .withName("pi")
      .withImage("perl")
      .withCommand("perl")
      .withArgs(Arrays.asList("-Mbignum=bpi", "-wle", "print bpi(2000)"))
      .endContainer()
      .withRestartPolicy("OnFailure")
      .endSpec()
      .endTemplate()
      .endSpec()
      .endJobTemplate()
      .endSpec()
      .build();

    client.batch().cronjobs().inNamespace(currentNamespace).create(cronJob1);
    client.batch().cronjobs().inNamespace(currentNamespace).create(cronJob2);
  }

  @Test
  public void load() {
    CronJob aCronJob = client.batch().cronjobs().load(getClass().getResourceAsStream("/test-cronjob.yml")).get();
    assertNotNull(aCronJob);
    assertEquals("hello", aCronJob.getMetadata().getName());
  }

  @Test
  public void get() {
    cronJob1 = client.batch().cronjobs().inNamespace(currentNamespace).withName(cronJob1.getMetadata().getName()).get();
    assertThat(cronJob1).isNotNull();
    cronJob2 = client.batch().cronjobs().inNamespace(currentNamespace).withName(cronJob2.getMetadata().getName()).get();
    assertThat(cronJob2).isNotNull();
  }

  @Test
  public void list() {
    CronJobList cronJobList = client.batch().cronjobs().inNamespace(currentNamespace).list();
    assertNotNull(cronJobList);
    assertEquals(2, cronJobList.getItems().size());
  }

  @Test
  public void update() {
    cronJob1 = client.batch().cronjobs().inNamespace(currentNamespace).withName(cronJob1.getMetadata().getName())
      .edit()
      .editSpec()
      .withSchedule("*/1 * * * *")
      .endSpec()
      .done();
    cronJob2 = client.batch().cronjobs().inNamespace(currentNamespace).withName(cronJob2.getMetadata().getName())
      .edit()
      .editSpec()
      .withSuspend(false)
      .endSpec()
      .done();

    assertEquals("*/1 * * * *", cronJob1.getSpec().getSchedule());
    assertFalse(cronJob2.getSpec().getSuspend());

  }

  @Test
  public void delete() {
    assertTrue(client.batch().cronjobs().inNamespace(currentNamespace).withName(cronJob1.getMetadata().getName()).delete());
    assertTrue(client.batch().cronjobs().inNamespace(currentNamespace).withName(cronJob2.getMetadata().getName()).delete());
  }

  @After
  public void cleanup() {
    client.batch().cronjobs().inNamespace(currentNamespace).delete();
  }
}
