/*
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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.events.v1.Event;
import io.fabric8.kubernetes.api.model.events.v1.EventBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.extended.events.EventBroadcaster;
import io.fabric8.kubernetes.client.extended.events.EventBroadcasterBuilder;
import io.fabric8.kubernetes.client.extended.events.EventRecorder;
import io.fabric8.kubernetes.client.extended.events.EventType;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.mockwebserver.http.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(https = false)
class EventRecorderTest {

  private static final String NAMESPACE = "my-namespace";
  private static final Instant NOW = Instant.parse("2024-01-01T10:00:00Z");
  private static final String EVENT_NAME = "my-pod." + Long.toHexString(NOW.getEpochSecond() * 1_000_000_000L);
  private static final String EVENTS_PATH = "/apis/events.k8s.io/v1/namespaces/" + NAMESPACE + "/events";

  KubernetesClient client;
  KubernetesMockServer server;

  private EventBroadcaster broadcaster;

  @AfterEach
  void tearDown() {
    if (broadcaster != null) {
      broadcaster.shutdown();
    }
  }

  private EventRecorder recorder() {
    // a fixed clock makes the generated event name predictable, so the test can expect the patch on it
    broadcaster = new EventBroadcasterBuilder()
        .withKubernetesClient(client)
        .withClock(Clock.fixed(NOW, ZoneOffset.UTC))
        .withHostname("node-1")
        .build();
    broadcaster.startRecordingToSink();
    return broadcaster.newRecorder("example.com/my-controller");
  }

  private static Pod pod() {
    return new PodBuilder()
        .withNewMetadata()
        .withName("my-pod")
        .withNamespace(NAMESPACE)
        .withUid("pod-uid")
        .endMetadata()
        .build();
  }

  private static Event recordedEvent() {
    return new EventBuilder()
        .withNewMetadata().withName(EVENT_NAME).withNamespace(NAMESPACE).endMetadata()
        .build();
  }

  @Test
  @DisplayName("an event is created in the events.k8s.io/v1 API group, in the namespace of the object it is about")
  void createsTheEventInTheEventsApiGroup() throws InterruptedException {
    server.expect().post().withPath(EVENTS_PATH)
        .andReturn(HttpURLConnection.HTTP_CREATED, recordedEvent())
        .once();

    recorder().event(pod(), EventType.WARNING, "Failed", "Creating", "could not create the pod");
    final RecordedRequest request = awaitRequest("POST", EVENTS_PATH);

    final Event sent = Serialization.unmarshal(request.getUtf8Body(), Event.class);
    assertThat(sent.getMetadata().getName()).isEqualTo(EVENT_NAME);
    assertThat(sent.getMetadata().getNamespace()).isEqualTo(NAMESPACE);
    assertThat(sent.getType()).isEqualTo("Warning");
    assertThat(sent.getReason()).isEqualTo("Failed");
    assertThat(sent.getAction()).isEqualTo("Creating");
    assertThat(sent.getNote()).isEqualTo("could not create the pod");
    assertThat(sent.getReportingController()).isEqualTo("example.com/my-controller");
    assertThat(sent.getReportingInstance()).isEqualTo("example.com/my-controller-node-1");
    assertThat(sent.getEventTime().getTime()).isEqualTo("2024-01-01T10:00:00.000000Z");
    assertThat(sent.getRegarding()).satisfies(regarding -> {
      assertThat(regarding.getKind()).isEqualTo("Pod");
      assertThat(regarding.getApiVersion()).isEqualTo("v1");
      assertThat(regarding.getName()).isEqualTo("my-pod");
      assertThat(regarding.getNamespace()).isEqualTo(NAMESPACE);
      assertThat(regarding.getUid()).isEqualTo("pod-uid");
    });
  }

  @Test
  @DisplayName("a repeat of the event is aggregated with a strategic merge patch onto the series of the recorded one")
  void aggregatesARepeatOntoTheRecordedEvent() throws InterruptedException {
    server.expect().post().withPath(EVENTS_PATH)
        .andReturn(HttpURLConnection.HTTP_CREATED, recordedEvent())
        .once();
    server.expect().patch().withPath(EVENTS_PATH + "/" + EVENT_NAME)
        .andReturn(HttpURLConnection.HTTP_OK, recordedEvent())
        .once();

    final EventRecorder recorder = recorder();
    recorder.event(pod(), EventType.WARNING, "Failed", "Creating", "could not create the pod");
    awaitRequest("POST", EVENTS_PATH);
    recorder.event(pod(), EventType.WARNING, "Failed", "Creating", "still could not create the pod");
    final RecordedRequest patch = awaitRequest("PATCH", EVENTS_PATH + "/" + EVENT_NAME);

    assertThat(patch.getHeader("Content-Type")).startsWith("application/strategic-merge-patch+json");
    assertThat(patch.getUtf8Body())
        .isEqualTo("{\"series\":{\"count\":2,\"lastObservedTime\":\"2024-01-01T10:00:00.000000Z\"}}");
  }

  private RecordedRequest awaitRequest(String method, String path) throws InterruptedException {
    RecordedRequest request;
    do {
      request = server.takeRequest(10, TimeUnit.SECONDS);
      assertThat(request).as("expected a %s request to %s", method, path).isNotNull();
    } while (!method.equals(request.getMethod()) || !request.getPath().startsWith(path));
    return request;
  }
}
