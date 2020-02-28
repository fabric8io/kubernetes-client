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
package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.batch.CronJob;
import io.fabric8.kubernetes.api.model.batch.CronJobBuilder;
import io.fabric8.kubernetes.api.model.batch.CronJobList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
public class CronJobCrudTest {
  @Rule
  public KubernetesServer server = new KubernetesServer(true, true);

  @Test
  public void testCrud() {
    KubernetesClient client = server.getClient();

    CronJob cronJob1 = new CronJobBuilder().withNewMetadata()
      .withName("cronJob1")
      .withResourceVersion("1")
      .addToLabels("foo", "bar")
      .endMetadata()
      .withNewSpec()
      .withSchedule("1 2-14 * * 0-1,5-6")
      .withNewJobTemplate()
      .withNewSpec()
      .withNewTemplate()
      .withNewSpec()
      .addNewImagePullSecret()
      .withName("gcr-secret")
      .endImagePullSecret()
      .addNewContainer()
      .withName("devopsish-netlify-cronjob")
      .withImage("gcr.io/chrisshort-net/devopsish-netlify-cron:latest")
      .addNewEnv()
      .withName("URL")
      .withNewValueFrom()
      .withNewSecretKeyRef()
      .withName("devops-build-hook")
      .withKey("url")
      .endSecretKeyRef()
      .endValueFrom()
      .endEnv()
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec()
      .endJobTemplate()
      .endSpec()
      .build();

    CronJob cronJob2 = new CronJobBuilder().withNewMetadata()
      .withName("cronJob2")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withSchedule("*/1 * * * *")
      .withNewJobTemplate()
      .withNewSpec()
      .withNewTemplate()
      .withNewSpec()
      .addNewContainer()
      .withName("app")
      .withImage("bitnami/kubecfg:0.5.0")
      .addNewEnv()
      .withName("TOKEN")
      .withNewValueFrom()
      .withNewSecretKeyRef()
      .withName("default-token-rtw2m")
      .withKey("token")
      .endSecretKeyRef()
      .endValueFrom()
      .endEnv()
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec()
      .endJobTemplate()
      .endSpec()
      .build();

    client.batch().cronjobs().inNamespace("ns1").create(cronJob1);
    client.batch().cronjobs().inNamespace("ns2").create(cronJob2);

    CronJobList cronJobList = client.batch().cronjobs().list();
    assertNotNull(cronJobList);
    assertEquals(0, cronJobList.getItems().size());

    cronJobList = client.batch().cronjobs().inAnyNamespace().list();
    assertNotNull(cronJobList);
    assertEquals(2, cronJobList.getItems().size());

    cronJobList = client.batch().cronjobs().inNamespace("ns1").list();
    assertNotNull(cronJobList);
    assertEquals(1, cronJobList.getItems().size());

    cronJobList = client.batch().cronjobs().inNamespace("ns2").list();
    assertNotNull(cronJobList);
    assertEquals(1, cronJobList.getItems().size());

    cronJobList = client.batch().cronjobs().inNamespace("ns1").withLabels(Collections.singletonMap("foo", "bar")).list();
    assertNotNull(cronJobList);
    assertEquals(1, cronJobList.getItems().size());

    boolean bDeleted = client.batch().cronjobs().inNamespace("ns1").withName("cronJob1").delete();
    cronJobList = client.batch().cronjobs().inNamespace("ns1").list();
    assertTrue(bDeleted);
    assertEquals(0, cronJobList.getItems().size());

    cronJob2 = client.batch().cronjobs().inNamespace("ns2").withName("cronJob2").edit().editSpec().withSchedule("*/1 * * * *").and().done();
    assertNotNull(cronJob2);
    assertEquals("*/1 * * * *", cronJob2.getSpec().getSchedule());
  }
}
