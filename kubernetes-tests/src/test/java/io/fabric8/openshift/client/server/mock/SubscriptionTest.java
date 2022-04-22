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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.openshift.api.model.operatorhub.v1alpha1.Subscription;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.SubscriptionBuilder;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.SubscriptionList;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.SubscriptionListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class SubscriptionTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    Subscription subscription = getSubscription();
    server.expect().post()
        .withPath("/apis/operators.coreos.com/v1alpha1/namespaces/ns1/subscriptions")
        .andReturn(HttpURLConnection.HTTP_OK, subscription)
        .once();

    // When
    subscription = client.operatorHub().subscriptions().inNamespace("ns1").create(subscription);

    // Then
    assertNotNull(subscription);
    assertEquals("foo", subscription.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/operators.coreos.com/v1alpha1/namespaces/ns1/subscriptions/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getSubscription())
        .once();

    // When
    Subscription f = client.operatorHub().subscriptions().inNamespace("ns1").withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/operators.coreos.com/v1alpha1/namespaces/ns1/subscriptions")
        .andReturn(HttpURLConnection.HTTP_OK, new SubscriptionListBuilder().withItems(getSubscription()).build())
        .once();

    // When
    SubscriptionList fgList = client.operatorHub().subscriptions().inNamespace("ns1").list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/operators.coreos.com/v1alpha1/namespaces/ns1/subscriptions/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getSubscription())
        .once();

    // When
    boolean deleted = client.operatorHub().subscriptions().inNamespace("ns1").withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private Subscription getSubscription() {
    return new SubscriptionBuilder()
        .withNewMetadata()
        .withName("foo")
        .withNamespace("ns1")
        .endMetadata()
        .withNewSpec()
        .withChannel("alpha")
        .withName("foo")
        .withSource("example")
        .withSourceNamespace("ns1")
        .endSpec()
        .build();
  }

}
