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

import io.fabric8.kubernetes.api.model.EventBuilder;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.not;

@EnableKubernetesMockClient
public class ErrorMessageTest {

  KubernetesMockServer server;
  KubernetesClient client;


  @Test
  public void testCustomMessage() {

    client.getConfiguration().getErrorMessages().put(403, "MSG");
    server.expect().withPath("/api/v1/namespaces/test/events").andReturn(200, new io.fabric8.kubernetes.api.model.EventListBuilder()
      .addNewItem()
      .withNewMetadata()
      .withName("event1")
      .endMetadata()
      .endItem().build()).once();
    server.expect().withPath("/api/v1/namespaces/test/events/event1").andReturn(403, Boolean.FALSE).once();


    try{
      client.v1().events().inNamespace("test").delete();
      fail();
    } catch (Exception e){
      System.out.println("exception: "+e);
      Assertions.assertThat(e.getMessage().startsWith("Failure executing: DELETE"));
      Assertions.assertThat(e.getMessage().contains("Message: MSG"));
      Assertions.assertThat(not(e.getMessage().contains("Received status")));
    }
  }

  private void fail() {
  }

  @Test
  public void testServerErrorWithStatus() {

    server.expect().withPath("/api/v1/namespaces/test/events").andReturn(500, new StatusBuilder()
      .withMessage("This operation is not allowed for some reason")
      .withReason("Some reason")
      .withCode(500)
      .build()).once();



    try{
      client.v1().events().inNamespace("test").create(new EventBuilder().withNewMetadata().withName("event1").endMetadata().build());
      fail();
    } catch( Exception e){
      Assertions.assertThat(e.getMessage().startsWith("Failure executing: POST"));
      Assertions.assertThat(e.getMessage().contains("Received status"));
      Assertions.assertThat(not(e.getMessage().contains("Message: This operation")));
    }
  }
}
