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

import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventBuilder;
import io.fabric8.kubernetes.api.model.EventList;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class EventsIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @Test
  public void listAllNamespaceEvents() {
    // Given + When
    EventList eventList = client.v1().events().inAnyNamespace().list();

    // Then
    assertNotNull(eventList);
    assertTrue(eventList.getItems().size() > 0);
  }

  @Test
  public void create() {
    // Given
    Event event = createEvent("custom-event-create");

    // When
    Event createdEvent = client.v1().events().inNamespace(session.getNamespace()).create(event);

    // Then
    assertNotNull(createdEvent);
    assertEquals("custom-event-create", createdEvent.getMetadata().getName());
    assertEquals("Custom Event", createdEvent.getReason());
  }

  @Test
  public void delete() {
    // Given
    Event event = createEvent("custom-event-delete");

    // When
    Event createdEvent = client.v1().events().inNamespace(session.getNamespace()).create(event);
    Boolean isDeleted = client.v1().events().inNamespace(session.getNamespace()).withName("custom-event-delete").delete();

    // Then
    assertNotNull(createdEvent);
    assertTrue(isDeleted);
  }

  private Event createEvent(String name) {
    return new EventBuilder()
      .withNewMetadata().withName(name).endMetadata()
      .withAction("Test")
      .withInvolvedObject(new ObjectReferenceBuilder()
        .withKind("Pod")
        .withName("test-pod")
        .withNamespace(session.getNamespace())
        .build())
      .withReason("Custom Event")
      .build();
  }
}
