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

package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJob;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobBuilder;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobList;
import io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class CronJobTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testList() {
    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs").andReturn(200, new CronJobListBuilder().build())
        .once();
    server.expect().withPath("/apis/batch/v1beta1/namespaces/ns1/cronjobs").andReturn(200, new CronJobListBuilder()
        .addNewItem().and()
        .addNewItem().and().build()).once();

    server.expect().withPath("/apis/batch/v1beta1/cronjobs").andReturn(200, new CronJobListBuilder()
        .addNewItem().and()
        .addNewItem().and()
        .addNewItem()
        .and().build()).once();

    CronJobList cronJobList = client.batch().cronjobs().list();
    assertNotNull(cronJobList);
    assertEquals(0, cronJobList.getItems().size());

    cronJobList = client.batch().cronjobs().inNamespace("ns1").list();
    assertNotNull(cronJobList);
    assertEquals(2, cronJobList.getItems().size());

    cronJobList = client.batch().cronjobs().inAnyNamespace().list();
    assertNotNull(cronJobList);
    assertEquals(3, cronJobList.getItems().size());
  }

  @Test
  void testListWithLables() {
    server.expect()
        .withPath("/apis/batch/v1beta1/namespaces/test/cronjobs?labelSelector="
            + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3"))
        .andReturn(200, new CronJobListBuilder().build()).always();
    server.expect()
        .withPath("/apis/batch/v1beta1/namespaces/test/cronjobs?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2"))
        .andReturn(200, new CronJobListBuilder()
            .addNewItem().and()
            .addNewItem().and()
            .addNewItem().and()
            .build())
        .once();

    CronJobList cronJobList = client.batch().cronjobs()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .withLabel("key3", "value3")
        .list();

    assertNotNull(cronJobList);
    assertEquals(0, cronJobList.getItems().size());

    cronJobList = client.batch().cronjobs()
        .withLabel("key1", "value1")
        .withLabel("key2", "value2")
        .list();

    assertNotNull(cronJobList);
    assertEquals(3, cronJobList.getItems().size());
  }

  @Test
  void testGet() {
    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs/cronjob1")
        .andReturn(200, new CronJobBuilder().build()).once();
    server.expect().withPath("/apis/batch/v1beta1/namespaces/ns1/cronjobs/cronjob2")
        .andReturn(200, new CronJobBuilder().build()).once();

    CronJob cronjob = client.batch().cronjobs().withName("cronjob1").get();
    assertNotNull(cronjob);

    cronjob = client.batch().cronjobs().withName("cronjob2").get();
    assertNull(cronjob);

    cronjob = client.batch().cronjobs().inNamespace("ns1").withName("cronjob2").get();
    assertNotNull(cronjob);
  }

  @Test
  void testDelete() {
    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs/cronJob1")
        .andReturn(200, new CronJobBuilder().withNewMetadata()
            .withName("cronJob1")
            .withResourceVersion("1")
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
            .build())
        .once();

    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs/cronJob2")
        .andReturn(200, new CronJobBuilder().withNewMetadata()
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
            .build())
        .once();

    boolean deleted = client.batch().cronjobs().withName("cronJob1").delete().size() == 1;
    assertTrue(deleted);

    deleted = client.batch().cronjobs().withName("cronJob2").delete().size() == 1;
    assertTrue(deleted);
  }

  @Test
  void testDeleteMulti() {
    CronJob cronjob1 = new CronJobBuilder().withNewMetadata()
        .withNamespace("test")
        .withName("cronjob1")
        .withResourceVersion("1")
        .endMetadata()
        .withNewSpec()
        .endSpec()
        .withNewStatus()
        .endStatus()
        .build();
    CronJob cronjob2 = new CronJobBuilder().withNewMetadata()
        .withNamespace("ns1")
        .withName("cronjob2")
        .withResourceVersion("1")
        .endMetadata()
        .withNewSpec()
        .endSpec()
        .withNewStatus()
        .endStatus()
        .build();
    CronJob cronjob3 = new CronJobBuilder().withNewMetadata().withName("cronjob3").withNamespace("any").and().build();

    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs/cronjob1").andReturn(200, cronjob1).once();
    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs/cronjob1")
        .andReturn(200, new CronJobBuilder(cronjob1)
            .editStatus().endStatus().build())
        .times(5);
    server.expect().withPath("/apis/batch/v1beta1/namespaces/ns1/cronjobs/cronjob2").andReturn(200, cronjob2).once();
    server.expect().withPath("/apis/batch/v1beta1/namespaces/ns1/cronjobs/cronjob2").andReturn(200, new CronJobBuilder(cronjob2)
        .editStatus().endStatus().build()).times(5);

    Boolean deleted = client.resourceList(cronjob1, cronjob2).delete().size() == 2;
    assertTrue(deleted);

    deleted = client.batch().cronjobs().inAnyNamespace().delete(cronjob3).size() == 1;
    assertFalse(deleted);
  }

  @Test
  void testDeleteWithNamespaceMismatch() {
    CronJob cronjob1 = new CronJobBuilder().withNewMetadata().withName("cronjob1").withNamespace("test").and().build();

    Boolean deleted = client.batch().cronjobs().inNamespace("test1").delete(cronjob1).size() == 1;
    assertFalse(deleted);
  }

  @Test
  void testCreateWithNameMismatch() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      CronJob cronjob1 = new CronJobBuilder().withNewMetadata().withName("cronjob1").withNamespace("test").and().build();

      client.batch().cronjobs().inNamespace("test1").withName("mycronjob1").create(cronjob1);
    });
  }

  @Test
  void testLoadFromFile() {
    assertNotNull(client.batch().cronjobs().load(getClass().getResourceAsStream("/test-cronjob.yml")).item());
  }

  @Test
  void testHandlersLoadFromFile() {
    List<HasMetadata> hasMetadata = client.load(getClass().getResourceAsStream("/test-cronjob.yml")).items();

    assertNotNull(hasMetadata);
    assertEquals(1, hasMetadata.size());
    assertEquals("pi", hasMetadata.get(0).getMetadata().getName());
  }
}
