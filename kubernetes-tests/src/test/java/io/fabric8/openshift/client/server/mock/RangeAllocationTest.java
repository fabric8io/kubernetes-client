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

import io.fabric8.openshift.api.model.RangeAllocation;
import io.fabric8.openshift.api.model.RangeAllocationBuilder;
import io.fabric8.openshift.api.model.RangeAllocationList;
import io.fabric8.openshift.api.model.RangeAllocationListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class RangeAllocationTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    RangeAllocation featureGate = getRangeAllocation();
    server.expect().post()
        .withPath("/apis/security.openshift.io/v1/rangeallocations")
        .andReturn(HttpURLConnection.HTTP_OK, featureGate)
        .once();

    // When
    featureGate = client.rangeAllocations().create(featureGate);

    // Then
    assertNotNull(featureGate);
    assertEquals("foo", featureGate.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/security.openshift.io/v1/rangeallocations/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getRangeAllocation())
        .once();

    // When
    RangeAllocation f = client.rangeAllocations().withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/security.openshift.io/v1/rangeallocations")
        .andReturn(HttpURLConnection.HTTP_OK, new RangeAllocationListBuilder().withItems(getRangeAllocation()).build())
        .once();

    // When
    RangeAllocationList fgList = client.rangeAllocations().list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/security.openshift.io/v1/rangeallocations/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getRangeAllocation())
        .once();

    // When
    boolean deleted = client.rangeAllocations().withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private RangeAllocation getRangeAllocation() {
    return new RangeAllocationBuilder()
        .withNewMetadata().withName("foo").endMetadata()
        .withData("wf////////8=")
        .withRange("1000000000-1999999999/10000")
        .build();
  }
}
