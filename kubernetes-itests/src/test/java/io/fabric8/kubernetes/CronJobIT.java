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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJob;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobBuilder;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class CronJobIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private String currentNamespace;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(CronJobIT.class.getResourceAsStream("/cronjob-it.yml"));
  }

  @Test
  public void load() {
    CronJob aCronJob = client.batch().v1().cronjobs().load(getClass().getResourceAsStream("/test-cronjob.yml")).get();
    assertNotNull(aCronJob);
    assertEquals("hello", aCronJob.getMetadata().getName());
  }

  @Test
  public void get() {
    currentNamespace = session.getNamespace();
    CronJob cronJob1 = client.batch().v1().cronjobs().inNamespace(currentNamespace).withName("hello-get").get();
    assertThat(cronJob1).isNotNull();
  }

  @Test
  public void list() {
    currentNamespace = session.getNamespace();
    CronJobList cronJobList = client.batch().v1().cronjobs().inNamespace(currentNamespace).list();
    assertNotNull(cronJobList);
    assertTrue(cronJobList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    currentNamespace = session.getNamespace();
    CronJob cronJob1 = client.batch().v1().cronjobs().inNamespace(currentNamespace).withName("hello-update")
      .edit(c -> new CronJobBuilder(c)
      .editSpec()
      .withSchedule("*/1 * * * *")
      .endSpec()
      .build());
    assertEquals("*/1 * * * *", cronJob1.getSpec().getSchedule());
  }

  @Test
  public void delete() {
    currentNamespace = session.getNamespace();
    assertTrue(client.batch().v1().cronjobs().inNamespace(currentNamespace).withName("hello-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(CronJobIT.class.getResourceAsStream("/cronjob-it.yml"));
  }
}
