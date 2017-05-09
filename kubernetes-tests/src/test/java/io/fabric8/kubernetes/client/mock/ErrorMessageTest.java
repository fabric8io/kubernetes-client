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

import io.fabric8.kubernetes.api.model.EventListBuilder;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;

public class ErrorMessageTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();


    @Test
    public void testCustomMessage() {
        expectedEx.expectMessage(startsWith("Failure executing: DELETE"));
        expectedEx.expectMessage(containsString("Message: MSG"));
        expectedEx.expectMessage(not(containsString("Received status")));

        server.getClient().getConfiguration().getErrorMessages().put(403, "MSG");
       server.expect().withPath("/api/v1/namespaces/test/events").andReturn(200, new EventListBuilder()
                .addNewItem()
                .withNewMetadata()
                .withName("event1")
                .endMetadata()
                .endItem().build()).once();
       server.expect().withPath("/api/v1/namespaces/test/events/event1").andReturn(403, Boolean.FALSE).once();

        KubernetesClient client = server.getClient();

        client.events().inNamespace("test").delete();
    }

    @Test
    public void testServerErrorWithStatus() {
        expectedEx.expectMessage(startsWith("Failure executing: POST"));
        expectedEx.expectMessage(containsString("Received status"));
        expectedEx.expectMessage(containsString("Message: This operation"));

       server.expect().withPath("/api/v1/namespaces/test/events").andReturn(500, new StatusBuilder()
                .withMessage("This operation is not allowed for some reason")
                .withReason("Some reason")
                .withCode(500)
                .build()).once();


        KubernetesClient client = server.getClient();

        client.events().inNamespace("test").createNew().withNewMetadata().withName("event1").endMetadata().done();
    }
}
