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
package io.fabric8.knative.test;

import io.fabric8.knative.client.KnativeClient;
import io.fabric8.knative.eventing.contrib.awssqs.v1alpha1.AwsSqsSource;
import io.fabric8.knative.eventing.contrib.awssqs.v1alpha1.AwsSqsSourceBuilder;
import io.fabric8.knative.eventing.contrib.couchdb.v1alpha1.CouchDbSource;
import io.fabric8.knative.eventing.contrib.couchdb.v1alpha1.CouchDbSourceBuilder;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubSource;
import io.fabric8.knative.eventing.contrib.github.v1alpha1.GitHubSourceBuilder;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabBinding;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabBindingBuilder;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabSource;
import io.fabric8.knative.eventing.contrib.gitlab.v1alpha1.GitLabSourceBuilder;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaChannel;
import io.fabric8.knative.eventing.contrib.kafka.v1beta1.KafkaChannelBuilder;
import io.fabric8.knative.eventing.contrib.prometheus.v1alpha1.PrometheusSource;
import io.fabric8.knative.eventing.contrib.prometheus.v1alpha1.PrometheusSourceBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient
class EventsContribResourcesTest {

  KnativeClient client;
  KubernetesMockServer server;

  @Test
  void testKafkaChannel() {
    // Given
    KafkaChannel kafkaChannel = new KafkaChannelBuilder()
        .withNewMetadata().withName("my-kafka-channel").endMetadata()
        .withNewSpec()
        .withNumPartitions(1)
        .withReplicationFactor(1)
        .endSpec()
        .build();
    server.expect().post().withPath("/apis/messaging.knative.dev/v1beta1/namespaces/ns1/kafkachannels")
        .andReturn(HttpURLConnection.HTTP_OK, kafkaChannel)
        .once();

    // When
    kafkaChannel = client.kafkaChannels().inNamespace("ns1").createOrReplace(kafkaChannel);

    // Then
    assertNotNull(kafkaChannel);
    assertEquals("my-kafka-channel", kafkaChannel.getMetadata().getName());
  }

  @Test
  void testAwsSqsSource() {
    // Given
    AwsSqsSource awsSqsSource = new AwsSqsSourceBuilder()
        .withNewMetadata().withName("awssqs-sample-source").endMetadata()
        .withNewSpec()
        .withNewAwsCredsSecret("credentials", "aws-credentials", true)
        .withQueueUrl("QUEUE_URL")
        .withSink(new ObjectReferenceBuilder()
            .withApiVersion("messaging.knative.dev/v1alpha1")
            .withKind("Channel")
            .withName("awssqs-test")
            .build())
        .endSpec()
        .build();
    server.expect().post().withPath("/apis/sources.knative.dev/v1alpha1/namespaces/ns1/awssqssources")
        .andReturn(HttpURLConnection.HTTP_OK, awsSqsSource)
        .once();

    // When
    awsSqsSource = client.awsSqsSources().inNamespace("ns1").createOrReplace(awsSqsSource);

    // Then
    assertNotNull(awsSqsSource);
    assertEquals("awssqs-sample-source", awsSqsSource.getMetadata().getName());
  }

  @Test
  void testCouchDbSource() {
    // Given
    CouchDbSource couchDbSource = new CouchDbSourceBuilder()
        .withNewMetadata().withName("couchdb-photographer").endMetadata()
        .withNewSpec()
        .withFeed("continous")
        .withCredentials(new ObjectReferenceBuilder().withName("couchdb-binding").build())
        .withDatabase("photographers")
        .withNewSink()
        .withNewRef()
        .withApiVersion("serving.knative.dev/v1alpha1")
        .withKind("Service")
        .withName("event-display")
        .endRef()
        .endSink()
        .endSpec()
        .build();
    server.expect().post().withPath("/apis/sources.knative.dev/v1alpha1/namespaces/ns1/couchdbsources")
        .andReturn(HttpURLConnection.HTTP_OK, couchDbSource)
        .once();

    // When
    couchDbSource = client.couchDbSources().inNamespace("ns1").createOrReplace(couchDbSource);

    // Then
    assertNotNull(couchDbSource);
    assertEquals("couchdb-photographer", couchDbSource.getMetadata().getName());
  }

  @Test
  void testGithubSource() {
    // Given
    GitHubSource gitHubSource = new GitHubSourceBuilder()
        .withNewMetadata().withName("github-source-sample").endMetadata()
        .withNewSpec()
        .withEventTypes("pull_request")
        .withOwnerAndRepository("test/test-repository")
        .withNewAccessToken()
        .withNewSecretKeyRef("accessToken", "githubsecret", false)
        .endAccessToken()
        .withNewSecretToken()
        .withNewSecretKeyRef("accessToken", "githubsecret", false)
        .endSecretToken()
        .withNewSink()
        .withNewRef("v1alpha1", "messaging.knative.dev", "InMemoryChannel", "githubchannel", "ns1")
        .endSink()
        .endSpec()
        .build();
    server.expect().post().withPath("/apis/sources.knative.dev/v1alpha1/namespaces/ns1/githubsources")
        .andReturn(HttpURLConnection.HTTP_OK, gitHubSource)
        .once();

    // When
    gitHubSource = client.gitHubSources().inNamespace("ns1").createOrReplace(gitHubSource);

    // Then
    assertNotNull(gitHubSource);
    assertEquals("github-source-sample", gitHubSource.getMetadata().getName());
  }

  @Test
  void testGitLabSource() {
    // Given
    GitLabSource gitLabSource = new GitLabSourceBuilder()
        .withNewMetadata().withName("gitlab-source-sample").endMetadata()
        .withNewSpec()
        .withEventTypes("pull_request")
        .withProjectUrl("test/test-repository")
        .withNewAccessToken()
        .withNewSecretKeyRef("accessToken", "gitlabsecret", false)
        .endAccessToken()
        .withNewSecretToken()
        .withNewSecretKeyRef("accessToken", "gitlabsecret", false)
        .endSecretToken()
        .withNewSink()
        .withNewRef("v1alpha1", "messaging.knative.dev", "InMemoryChannel", "gitlabchannel", "ns1")
        .endSink()
        .endSpec()
        .build();
    server.expect().post().withPath("/apis/sources.knative.dev/v1alpha1/namespaces/ns1/gitlabsources")
        .andReturn(HttpURLConnection.HTTP_OK, gitLabSource)
        .once();

    // When
    gitLabSource = client.gitLabSources().inNamespace("ns1").createOrReplace(gitLabSource);

    // Then
    assertNotNull(gitLabSource);
    assertEquals("gitlab-source-sample", gitLabSource.getMetadata().getName());
  }

  @Test
  void testGitLabBinding() {
    // Given
    GitLabBinding gitLabBinding = new GitLabBindingBuilder()
        .withNewMetadata().withName("gitlab-binding").endMetadata()
        .withNewSpec()
        .withNewSubject()
        .withApiVersion("apps/v1")
        .withKind("Deployment")
        .withSelector(new LabelSelectorBuilder().addToMatchLabels("gitlabbinding", "true").build())
        .endSubject()
        .withNewAccessToken()
        .withNewSecretKeyRef("accessToken", "gitlabsecret", false)
        .endAccessToken()
        .endSpec()
        .build();
    server.expect().post().withPath("/apis/bindings.knative.dev/v1alpha1/namespaces/ns1/gitlabbindings")
        .andReturn(HttpURLConnection.HTTP_OK, gitLabBinding)
        .once();

    // When
    gitLabBinding = client.gitLabBindings().inNamespace("ns1").createOrReplace(gitLabBinding);

    // Then
    assertNotNull(gitLabBinding);
    assertEquals("gitlab-binding", gitLabBinding.getMetadata().getName());

  }

  @Test
  void testPrometheusSource() {
    // Given
    PrometheusSource prometheusSource = new PrometheusSourceBuilder()
        .withNewMetadata().withName("prometheus-source").endMetadata()
        .withNewSpec()
        .withServerURL("http://demo.robustperception.io:9090")
        .withPromQL("go_memstats_alloc_bytes{instance=\"demo.robustperception.io:9090\",job=\"prometheus\"}")
        .withSchedule("* * * * *")
        .withStep("15s")
        .withNewSink()
        .withNewRef()
        .withApiVersion("serving.knative.dev/v1")
        .withKind("Service")
        .withName("event-display")
        .endRef()
        .endSink()
        .endSpec()
        .build();
    server.expect().post().withPath("/apis/sources.knative.dev/v1alpha1/namespaces/ns1/prometheussources")
        .andReturn(HttpURLConnection.HTTP_OK, prometheusSource)
        .once();

    // When
    prometheusSource = client.prometheusSources().inNamespace("ns1").createOrReplace(prometheusSource);

    // Then
    assertNotNull(prometheusSource);
    assertEquals("prometheus-source", prometheusSource.getMetadata().getName());
  }
}
