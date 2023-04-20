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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.api.model.batch.v1.CronJob;
import io.fabric8.kubernetes.api.model.batch.v1.CronJobBuilder;
import io.fabric8.kubernetes.api.model.batch.v1.CronJobList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/cronjob-it.yml")
@RequireK8sSupport(CronJob.class)
class CronJobIT {

  KubernetesClient client;

  @Test
  void load() {
    CronJob aCronJob = client.batch().v1().cronjobs().load(getClass().getResourceAsStream("/test-cronjob.yml")).item();
    assertNotNull(aCronJob);
    assertEquals("hello", aCronJob.getMetadata().getName());
  }

  @Test
  void get() {
    CronJob cronJob1 = client.batch().v1().cronjobs().withName("hello-get").get();
    assertThat(cronJob1).isNotNull();
  }

  @Test
  void list() {
    CronJobList cronJobList = client.batch().v1().cronjobs().list();
    assertNotNull(cronJobList);
    assertTrue(cronJobList.getItems().size() >= 1);
  }

  @Test
  void update() {
    CronJob cronJob1 = client.batch().v1().cronjobs().withName("hello-update")
        .edit(c -> new CronJobBuilder(c)
            .editMetadata().withResourceVersion(null).endMetadata()
            .editSpec().withSchedule("*/1 * * * *").endSpec()
            .build());
    assertEquals("*/1 * * * *", cronJob1.getSpec().getSchedule());
  }

  @Test
  void delete() {
    assertTrue(client.batch().v1().cronjobs().withName("hello-delete").delete().size() == 1);
  }
}
