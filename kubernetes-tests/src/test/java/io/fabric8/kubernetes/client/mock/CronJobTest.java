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
import io.fabric8.kubernetes.api.model.batch.*;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class CronJobTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testList() {
    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs").andReturn(200, new CronJobListBuilder().build()).once();
    server.expect().withPath("/apis/batch/v1beta1/namespaces/ns1/cronjobs").andReturn(200, new CronJobListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

    server.expect().withPath("/apis/batch/v1beta1/cronjobs").andReturn(200, new CronJobListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();

    KubernetesClient client = server.getClient();
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
  public void testListWithLables() {
    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new CronJobListBuilder().build()).always();
    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new CronJobListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = server.getClient();
    CronJobList cronJobList = client.batch().cronjobs()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .withLabel("key3","value3")
      .list();


    assertNotNull(cronJobList);
    assertEquals(0, cronJobList.getItems().size());

    cronJobList = client.batch().cronjobs()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .list();

    assertNotNull(cronJobList);
    assertEquals(3, cronJobList.getItems().size());
  }
  @Test
  public void testGet() {
    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs/cronjob1").andReturn(200, new CronJobBuilder().build()).once();
    server.expect().withPath("/apis/batch/v1beta1/namespaces/ns1/cronjobs/cronjob2").andReturn(200, new CronJobBuilder().build()).once();

    KubernetesClient client = server.getClient();

    CronJob cronjob = client.batch().cronjobs().withName("cronjob1").get();
    assertNotNull(cronjob);

    cronjob = client.batch().cronjobs().withName("cronjob2").get();
    assertNull(cronjob);

    cronjob = client.batch().cronjobs().inNamespace("ns1").withName("cronjob2").get();
    assertNotNull(cronjob);
  }

  @Test
  public void testDelete() {
    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs/cronJob1").andReturn(200, new CronJobBuilder().withNewMetadata()
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
      .build()).once();

    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs/cronJob2").andReturn(200, new CronJobBuilder().withNewMetadata()
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
      .build()).once();

    KubernetesClient client = server.getClient();

    Boolean deleted = client.batch().cronjobs().withName("cronJob1").delete();
    assertNotNull(deleted);
    assertTrue(deleted);

    deleted = client.batch().cronjobs().withName("cronJob2").delete();
    assertTrue(deleted);
  }

  @Test
  public void testDeleteMulti() {
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
    server.expect().withPath("/apis/batch/v1beta1/namespaces/test/cronjobs/cronjob1").andReturn(200, new CronJobBuilder(cronjob1)
      .editStatus().endStatus().build()).times(5);
    server.expect().withPath("/apis/batch/v1beta1/namespaces/ns1/cronjobs/cronjob2").andReturn(200, cronjob2).once();
    server.expect().withPath("/apis/batch/v1beta1/namespaces/ns1/cronjobs/cronjob2").andReturn(200, new CronJobBuilder(cronjob2)
      .editStatus().endStatus().build()).times(5);

    KubernetesClient client = server.getClient();

    Boolean deleted = client.batch().cronjobs().inAnyNamespace().delete(cronjob1, cronjob2);
    assertNotNull(deleted);

    deleted = client.batch().cronjobs().inAnyNamespace().delete(cronjob3);
    assertFalse(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testDeleteWithNamespaceMismatch() {
    CronJob cronjob1 = new CronJobBuilder().withNewMetadata().withName("cronjob1").withNamespace("test").and().build();
    KubernetesClient client = server.getClient();

    Boolean deleted = client.batch().cronjobs().inNamespace("test1").delete(cronjob1);
    assertFalse(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testCreateWithNameMismatch() {
    CronJob cronjob1 = new CronJobBuilder().withNewMetadata().withName("cronjob1").withNamespace("test").and().build();
    KubernetesClient client = server.getClient();

    client.batch().cronjobs().inNamespace("test1").withName("mycronjob1").create(cronjob1);
  }

  @Test
  public void testLoadFromFile() {
    KubernetesClient client = server.getClient();
    assertNotNull(client.batch().cronjobs().load(getClass().getResourceAsStream("/test-cronjob.yml")).get());
  }
  @Test
  public void testHandlersLoadFromFile() {
    KubernetesClient client = server.getClient();
    List<HasMetadata> hasMetadata = client.load(getClass().getResourceAsStream("/test-cronjob.yml")).get();

    assertNotNull("Handlers did not return a valid resource", hasMetadata);
    assertTrue("Handler did not return expected single resource", 1==hasMetadata.size());
    assertEquals("hasMetadata found did not match the expected name of the test input", "pi", hasMetadata.get(0).getMetadata().getName());
  }
}
