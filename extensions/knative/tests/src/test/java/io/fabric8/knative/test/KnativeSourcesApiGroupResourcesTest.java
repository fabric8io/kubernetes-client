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
import io.fabric8.knative.mock.KnativeServer;
import io.fabric8.knative.sources.v1.ApiServerSource;
import io.fabric8.knative.sources.v1.ApiServerSourceBuilder;
import io.fabric8.knative.sources.v1.ContainerSource;
import io.fabric8.knative.sources.v1.ContainerSourceBuilder;
import io.fabric8.knative.sources.v1.PingSource;
import io.fabric8.knative.sources.v1.PingSourceBuilder;
import io.fabric8.knative.sources.v1.SinkBinding;
import io.fabric8.knative.sources.v1.SinkBindingBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.PodTemplateSpecBuilder;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
class KnativeSourcesApiGroupResourcesTest {
  @Rule
  public KnativeServer server = new KnativeServer();

  @Test
  void testPingSourceCreateOrReplace() {
    // Given
    PingSource pingSource = new PingSourceBuilder()
      .withNewMetadata().withName("test-ping-source").endMetadata()
      .withNewSpec()
      .withSchedule("*/1 * * * *")
      .withData("{\"message\": \"Hello world!\"}")
      .withNewSink()
      .withNewRef()
      .withApiVersion("v1")
      .withKind("Service")
      .withName("event-display")
      .endRef()
      .endSink()
      .endSpec()
      .build();
    server.expect().post().withPath("/apis/sources.knative.dev/v1/namespaces/ns1/pingsources")
      .andReturn(HttpURLConnection.HTTP_OK, pingSource)
      .once();
    KnativeClient kn = server.getKnativeClient();

    // When
    pingSource = kn.pingSources().inNamespace("ns1").createOrReplace(pingSource);

    // Then
    assertNotNull(pingSource);
    assertEquals("test-ping-source", pingSource.getMetadata().getName());
  }

  @Test
  void testApiServerSourceCreateOrReplace() {
    // Given
    ApiServerSource apiServerSource = new ApiServerSourceBuilder()
      .withNewMetadata()
      .withName("testevents")
      .endMetadata()
      .withNewSpec()
      .withServiceAccountName("events-sa")
      .withMode("Resource")
      .addNewResource()
      .withApiVersion("v1")
      .withKind("Event")
      .endResource()
      .withNewSink()
      .withNewRef()
      .withApiVersion("v1")
      .withKind("Service")
      .withName("event-display")
      .endRef()
      .endSink()
      .endSpec()
      .build();
    server.expect().post().withPath("/apis/sources.knative.dev/v1/namespaces/ns1/apiserversources")
      .andReturn(HttpURLConnection.HTTP_OK, apiServerSource)
      .once();
    KnativeClient kn = server.getKnativeClient();

    // When
    apiServerSource = kn.apiServerSources().inNamespace("ns1").createOrReplace(apiServerSource);

    // Then
    assertNotNull(apiServerSource);
    assertEquals("testevents", apiServerSource.getMetadata().getName());
  }

  @Test
  void testSinkBindingCreateOrReplace() {
    // Given
    SinkBinding sinkBinding = new SinkBindingBuilder()
      .withNewMetadata().withName("bind-heartbeat").endMetadata()
      .withNewSpec()
      .withNewSubject()
      .withApiVersion("batch/v1")
      .withKind("Job")
      .withSelector(new LabelSelectorBuilder().addToMatchLabels("app", "heatbeat-cron").build())
      .endSubject()
      .withNewSink()
      .withNewRef()
      .withApiVersion("v1")
      .withKind("Service")
      .withName("event-display")
      .endRef()
      .endSink()
      .endSpec()
      .build();
    server.expect().post().withPath("/apis/sources.knative.dev/v1/namespaces/ns1/sinkbindings")
      .andReturn(HttpURLConnection.HTTP_OK, sinkBinding)
      .once();
    KnativeClient kn = server.getKnativeClient();

    // When
    sinkBinding = kn.sinkBindings().inNamespace("ns1").createOrReplace(sinkBinding);

    // Then
    assertNotNull(sinkBinding);
    assertEquals("bind-heartbeat", sinkBinding.getMetadata().getName());
  }

  @Test
  void testContainerSourceCreateOrReplace() {
    // Given
    ContainerSource containerSource = new ContainerSourceBuilder()
      .withNewMetadata().withName("test-heartbeats").endMetadata()
      .withNewSpec()
      .withTemplate(new PodTemplateSpecBuilder()
        .withNewSpec()
        .addNewContainer()
        .withImage("test-image")
        .withName("heartbeats")
        .addToArgs("--period=1")
        .addNewEnv().withName("POD_NAME").withValue("mypod").endEnv()
        .addNewEnv().withName("POD_NAMESPACE").withValue("event-test").endEnv()
        .endContainer()
        .endSpec()
        .build())
      .withNewSink()
      .withNewRef()
      .withApiVersion("v1")
      .withName("Service")
      .withName("event-test")
      .endRef()
      .endSink()
      .endSpec()
      .build();
    server.expect().post().withPath("/apis/sources.knative.dev/v1/namespaces/ns1/containersources")
      .andReturn(HttpURLConnection.HTTP_OK, containerSource)
      .once();
    KnativeClient kn = server.getKnativeClient();

    // When
    containerSource = kn.containerSources().inNamespace("ns1").createOrReplace(containerSource);

    // Then
    assertNotNull(containerSource);
    assertEquals("test-heartbeats", containerSource.getMetadata().getName());


  }
}
