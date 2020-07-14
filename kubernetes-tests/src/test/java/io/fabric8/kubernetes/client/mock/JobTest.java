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

import io.fabric8.kubernetes.api.model.OwnerReference;
import io.fabric8.kubernetes.api.model.OwnerReferenceBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.api.model.batch.Job;
import io.fabric8.kubernetes.api.model.batch.JobBuilder;
import io.fabric8.kubernetes.api.model.batch.JobList;
import io.fabric8.kubernetes.api.model.batch.JobListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import io.fabric8.kubernetes.client.utils.Utils;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

@EnableRuleMigrationSupport
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
    JobList jobList = client.batch().jobs().list();
    assertNotNull(jobList);
    assertEquals(0, jobList.getItems().size());

    jobList = client.batch().jobs().inNamespace("ns1").list();
    assertNotNull(jobList);
    assertEquals(2, jobList.getItems().size());

    jobList = client.batch().jobs().inAnyNamespace().list();
    assertNotNull(jobList);
    assertEquals(3, jobList.getItems().size());
  }

  @Test
  public void testListWithLables() {
   server.expect().withPath("/apis/batch/v1/namespaces/test/jobs?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new JobListBuilder().build()).always();
   server.expect().withPath("/apis/batch/v1/namespaces/test/jobs?labelSelector=" + Utils.toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new JobListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

    KubernetesClient client = server.getClient();
    JobList jobList = client.batch().jobs()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .withLabel("key3","value3")
      .list();


    assertNotNull(jobList);
    assertEquals(0, jobList.getItems().size());

    jobList = client.batch().jobs()
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

    Job job = client.batch().jobs().withName("job1").get();
    assertNotNull(job);

    job = client.batch().jobs().withName("job2").get();
    assertNull(job);

    job = client.batch().jobs().inNamespace("ns1").withName("job2").get();
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

    Boolean deleted = client.batch().jobs().withName("job1").delete();
    assertTrue(deleted);

    deleted = client.batch().jobs().withName("job2").delete();
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

    Boolean deleted = client.batch().jobs().inAnyNamespace().delete(job1, job2);
    assertTrue(deleted);

    deleted = client.batch().jobs().inAnyNamespace().delete(job3);
    assertFalse(deleted);
  }

  @Test
  public void testDeleteWithNamespaceMismatch() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      Job job1 = new JobBuilder().withNewMetadata().withName("job1").withNamespace("test").and().build();
      KubernetesClient client = server.getClient();

      Boolean deleted = client.batch().jobs().inNamespace("test1").delete(job1);
      assertTrue(deleted);
    });
  }

  @Test
  public void testCreateWithNameMismatch() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      Job job1 = new JobBuilder().withNewMetadata().withName("job1").withNamespace("test").and().build();
      Job job2 = new JobBuilder().withNewMetadata().withName("job2").withNamespace("ns1").and().build();
      KubernetesClient client = server.getClient();

      client.batch().jobs().inNamespace("test1").withName("myjob1").create(job1);
    });
  }

  @Test
  @DisplayName("Should append Selector and MatchLabels from exiting job instance while patching a Job")
  public void testCreateOrReplaceWithExistingJob() {
    // Given
    Job jobExistingInServer = getJobBuilder()
      .editSpec()
      .editOrNewTemplate().editOrNewMetadata()
      .addToLabels("controller-uid", "df842342-33bb-4f6c-9707-f76a86748ee6")
      .addToLabels("job-name", "job1")
      .endMetadata()
      .endTemplate()
      .editOrNewSelector().addToMatchLabels("controller-uid", "df842342-33bb-4f6c-9707-f76a86748ee6").endSelector()
      .endSpec()
      .build();

    server.expect().get().withPath("/apis/batch/v1/namespaces/test/jobs/job1")
      .andReturn(200, jobExistingInServer).always();
    server.expect().put().withPath("/apis/batch/v1/namespaces/test/jobs/job1")
      .andReturn(200, getJobBuilder()
        .editOrNewMetadata().addToLabels("foo", "bar").addToLabels("foo1", "bar1").endMetadata()
        .editSpec()
        .editOrNewTemplate().editOrNewMetadata()
        .addToLabels("controller-uid", "df842342-33bb-4f6c-9707-f76a86748ee6")
        .addToLabels("job-name", "job1")
        .endMetadata()
        .endTemplate()
        .editOrNewSelector().addToMatchLabels("controller-uid", "df842342-33bb-4f6c-9707-f76a86748ee6").endSelector()
        .endSpec()
        .build()).once();

    Job job = getJobBuilder()
      .editOrNewMetadata().addToLabels("foo", "bar").addToLabels("foo1", "bar1").endMetadata()
      .build();

    KubernetesClient client = server.getClient();

    // When
    job = client.batch().jobs().inNamespace("test").createOrReplace(job);

    // Then
    assertNotNull(job);
    assertNotNull(job.getMetadata().getLabels());
    assertEquals("bar", job.getMetadata().getLabels().get("foo"));
    assertEquals("bar1", job.getMetadata().getLabels().get("foo1"));
    assertEquals("df842342-33bb-4f6c-9707-f76a86748ee6", job.getSpec().getSelector().getMatchLabels().get("controller-uid"));
    assertEquals("job1", job.getSpec().getTemplate().getMetadata().getLabels().get("job-name"));
    assertEquals("df842342-33bb-4f6c-9707-f76a86748ee6", job.getSpec().getTemplate().getMetadata().getLabels().get("controller-uid"));
  }

  @Test
  @DisplayName("Should get logs for a job")
  void testJobGetLog() {
    // Given
    Pod jobPod = new PodBuilder()
      .withNewMetadata()
      .withOwnerReferences(new OwnerReferenceBuilder().withApiVersion("batch/v1")
        .withBlockOwnerDeletion(true)
        .withController(true)
        .withKind("Job")
        .withName("pi")
        .withUid("3Dc4c8746c-94fd-47a7-ac01-11047c0323b4")
      .build())
      .withName("job1-hk9nf").addToLabels("controller-uid", "3Dc4c8746c-94fd-47a7-ac01-11047c0323b4")
      .endMetadata()
      .build();

    server.expect().get().withPath("/apis/batch/v1/namespaces/ns1/jobs/job1")
      .andReturn(HttpURLConnection.HTTP_OK, getJobBuilder().build())
      .always();

    server.expect().get().withPath("/api/v1/namespaces/ns1/pods?labelSelector=controller-uid%3D3Dc4c8746c-94fd-47a7-ac01-11047c0323b4")
      .andReturn(HttpURLConnection.HTTP_OK, new PodListBuilder().withItems(jobPod).build())
      .once();
    server.expect().get().withPath("/api/v1/namespaces/ns1/pods/job1-hk9nf/log?pretty=false")
      .andReturn(HttpURLConnection.HTTP_OK, "hello")
      .once();
    KubernetesClient client = server.getClient();

    // When
    String log = client.batch().jobs().inNamespace("ns1").withName("job1").getLog();

    // Then
    assertNotNull(log);
    assertEquals("hello", log);
  }

  private JobBuilder getJobBuilder() {
    return new JobBuilder()
      .withApiVersion("batch/v1")
      .withNewMetadata()
      .withName("job1")
      .withUid("3Dc4c8746c-94fd-47a7-ac01-11047c0323b4")
      .withLabels(Collections.singletonMap("label1", "maximum-length-of-63-characters"))
      .withAnnotations(Collections.singletonMap("annotation1", "some-very-long-annotation"))
      .endMetadata()
      .withNewSpec()
      .withNewTemplate()
      .withNewSpec()
      .addNewContainer()
      .withName("pi")
      .withImage("perl")
      .withArgs("perl", "-Mbignum=bpi", "-wle", "print bpi(2000)")
      .endContainer()
      .withRestartPolicy("Never")
      .endSpec()
      .endTemplate()
      .endSpec();
  }
}
