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

import io.fabric8.openshift.api.model.operator.v1alpha1.ImageContentSourcePolicy;
import io.fabric8.openshift.api.model.operator.v1alpha1.ImageContentSourcePolicyBuilder;
import io.fabric8.openshift.api.model.operator.v1alpha1.ImageContentSourcePolicyList;
import io.fabric8.openshift.api.model.operator.v1alpha1.ImageContentSourcePolicyListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class ImageContentSourcePolicyTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    ImageContentSourcePolicy imageContentSourcePolicy = getImageContentSourcePolicy();
    server.expect().post()
        .withPath("/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies")
        .andReturn(HttpURLConnection.HTTP_OK, imageContentSourcePolicy)
        .once();

    // When
    imageContentSourcePolicy = client.operator().imageContentSourcePolicies().create(imageContentSourcePolicy);

    // Then
    assertNotNull(imageContentSourcePolicy);
    assertEquals("foo", imageContentSourcePolicy.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getImageContentSourcePolicy())
        .once();

    // When
    ImageContentSourcePolicy f = client.operator().imageContentSourcePolicies().withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies")
        .andReturn(HttpURLConnection.HTTP_OK,
            new ImageContentSourcePolicyListBuilder().withItems(getImageContentSourcePolicy()).build())
        .once();

    // When
    ImageContentSourcePolicyList fgList = client.operator().imageContentSourcePolicies().list();

    // Then
    assertNotNull(fgList);
    assertNotNull(fgList.getItems());
    assertEquals(1, fgList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/operator.openshift.io/v1alpha1/imagecontentsourcepolicies/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getImageContentSourcePolicy())
        .once();

    // When
    boolean deleted = client.operator().imageContentSourcePolicies().withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private ImageContentSourcePolicy getImageContentSourcePolicy() {
    return new ImageContentSourcePolicyBuilder()
        .withNewMetadata().withName("foo").endMetadata()
        .withNewSpec()
        .addNewRepositoryDigestMirror()
        .withSource("registry.redhat.io/openshift-service-mesh/proxyv2-rhel8")
        .addToMirrors("image-registry.openshift-image-registry.svc:5000/openshift/proxyv2-rhel8")
        .endRepositoryDigestMirror()
        .endSpec()
        .build();
  }
}
