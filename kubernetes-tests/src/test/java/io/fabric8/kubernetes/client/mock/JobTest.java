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

import io.fabric8.kubernetes.api.model.Job;
import io.fabric8.kubernetes.api.model.JobBuilder;
import io.fabric8.kubernetes.api.model.JobList;
import io.fabric8.kubernetes.api.model.JobListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class JobTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testList() {
   server.expect().withPath("/apis/batch/v1/namespaces/test/jobs").andReturn(200, new JobListBuilder().build()).once();
   server.expect().withPath("/apis/batch/v1/namespaces/ns1/jobs").andReturn(200, new JobListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

   server.expect().withPath("/apis/batch/v1/jobs").andReturn(200, new JobListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();


    KubernetesClient client = server.getClient();
    JobList jobList = client.extensions().jobs().list();
    assertNotNull(jobList);
    assertEquals(0, jobList.getItems().size());

    jobList = client.extensions().jobs().inNamespace("ns1").list();
    assertNotNull(jobList);
    assertEquals(2, jobList.getItems().size());

    jobList = client.extensions().jobs().inAnyNamespace().list();
    assertNotNull(jobList);
    assertEquals(3, jobList.getItems().size());
  }

  @Test
  public void testListWithLables() {
   server.expect().withPath("/apis/batch/v1/namespaces/test/jobs?labelSelector=" + toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new JobListBuilder().build()).always();
   server.expect().withPath("/apis/batch/v1/namespaces/test/jobs?labelSelector=" + toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new JobListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = server.getClient();
    JobList jobList = client.extensions().jobs()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .withLabel("key3","value3")
      .list();


    assertNotNull(jobList);
    assertEquals(0, jobList.getItems().size());

    jobList = client.extensions().jobs()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .list();

    assertNotNull(jobList);
    assertEquals(3, jobList.getItems().size());
  }


  @Test
  public void testGet() {
   server.expect().withPath("/apis/batch/v1/namespaces/test/jobs/job1").andReturn(200, new JobBuilder().build()).once();
   server.expect().withPath("/apis/batch/v1/namespaces/ns1/jobs/job2").andReturn(200, new JobBuilder().build()).once();

    KubernetesClient client = server.getClient();

    Job job = client.extensions().jobs().withName("job1").get();
    assertNotNull(job);

    job = client.extensions().jobs().withName("job2").get();
    assertNull(job);

    job = client.extensions().jobs().inNamespace("ns1").withName("job2").get();
    assertNotNull(job);
  }


  @Test
  public void testDelete() {
   server.expect().withPath("/apis/batch/v1/namespaces/test/jobs/job1").andReturn(200, new JobBuilder().withNewMetadata()
      .withName("job1")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withParallelism(0)
      .endSpec()
      .withNewStatus()
      .withActive(1)
      .endStatus()
      .build()).once();
   server.expect().withPath("/apis/batch/v1/namespaces/test/jobs/job1").andReturn(200, new JobBuilder().withNewMetadata()
      .withName("job1")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withParallelism(0)
      .endSpec()
      .withNewStatus()
      .withActive(0)
      .endStatus()
      .build()).times(5);

   server.expect().withPath("/apis/batch/v1/namespaces/test/jobs/job2").andReturn(200, new JobBuilder().withNewMetadata()
      .withName("job2")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withParallelism(0)
      .endSpec()
      .withNewStatus()
      .withActive(1)
      .endStatus()
      .build()).once();
   server.expect().withPath("/apis/batch/v1/namespaces/test/jobs/job2").andReturn(200, new JobBuilder().withNewMetadata()
      .withName("job2")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withParallelism(0)
      .endSpec()
      .withNewStatus()
      .withActive(0)
      .endStatus()
      .build()).times(5);

    KubernetesClient client = server.getClient();

    Boolean deleted = client.extensions().jobs().withName("job1").delete();
    assertNotNull(deleted);

    deleted = client.extensions().jobs().withName("job2").delete();
    assertTrue(deleted);
  }


  @Test
  public void testDeleteMulti() {
    Job job1 = new JobBuilder().withNewMetadata()
      .withNamespace("test")
      .withName("job1")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withParallelism(0)
      .endSpec()
      .withNewStatus()
      .withActive(1)
      .endStatus()
      .build();
    Job job2 = new JobBuilder().withNewMetadata()
      .withNamespace("ns1")
      .withName("job2")
      .withResourceVersion("1")
      .endMetadata()
      .withNewSpec()
      .withParallelism(0)
      .endSpec()
      .withNewStatus()
      .withActive(1)
      .endStatus()
      .build();
    Job job3 = new JobBuilder().withNewMetadata().withName("job3").withNamespace("any").and().build();

   server.expect().withPath("/apis/batch/v1/namespaces/test/jobs/job1").andReturn(200, job1).once();
   server.expect().withPath("/apis/batch/v1/namespaces/test/jobs/job1").andReturn(200, new JobBuilder(job1)
      .editStatus().withActive(0).endStatus().build()).times(5);
   server.expect().withPath("/apis/batch/v1/namespaces/ns1/jobs/job2").andReturn(200, job2).once();
   server.expect().withPath("/apis/batch/v1/namespaces/ns1/jobs/job2").andReturn(200, new JobBuilder(job2)
      .editStatus().withActive(0).endStatus().build()).times(5);

    KubernetesClient client = server.getClient();

    Boolean deleted = client.extensions().jobs().inAnyNamespace().delete(job1, job2);
    assertNotNull(deleted);

    deleted = client.extensions().jobs().inAnyNamespace().delete(job3);
    assertFalse(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testDeleteWithNamespaceMismatch() {
    Job job1 = new JobBuilder().withNewMetadata().withName("job1").withNamespace("test").and().build();
    Job job2 = new JobBuilder().withNewMetadata().withName("job2").withNamespace("ns1").and().build();
    KubernetesClient client = server.getClient();

    Boolean deleted = client.extensions().jobs().inNamespace("test1").delete(job1);
    assertNotNull(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testCreateWithNameMismatch() {
    Job job1 = new JobBuilder().withNewMetadata().withName("job1").withNamespace("test").and().build();
    Job job2 = new JobBuilder().withNewMetadata().withName("job2").withNamespace("ns1").and().build();
    KubernetesClient client = server.getClient();

    client.extensions().jobs().inNamespace("test1").withName("myjob1").create(job1);
  }

  /**
   * Converts string to URL encoded string.
   * It's not a fullblown converter, it serves just the purpose of this test.
   * @param str
   * @return
   */
  private static final String toUrlEncoded(String str) {
    return str.replaceAll("=", "%3D");
  }
}
