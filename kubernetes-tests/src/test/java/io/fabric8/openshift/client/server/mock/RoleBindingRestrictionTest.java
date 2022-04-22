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

import io.fabric8.openshift.api.model.RoleBindingRestriction;
import io.fabric8.openshift.api.model.RoleBindingRestrictionBuilder;
import io.fabric8.openshift.api.model.RoleBindingRestrictionList;
import io.fabric8.openshift.api.model.RoleBindingRestrictionListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class RoleBindingRestrictionTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/authorization.openshift.io/v1/namespaces/ns1/rolebindingrestrictions/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewRoleBindingRestriction("test-get"))
        .once();

    // When
    RoleBindingRestriction roleBindingRestriction = client.roleBindingRestrictions().inNamespace("ns1").withName("test-get")
        .get();

    // Then
    assertThat(roleBindingRestriction)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/authorization.openshift.io/v1/namespaces/ns1/rolebindingrestrictions")
        .andReturn(HttpURLConnection.HTTP_OK, new RoleBindingRestrictionListBuilder()
            .addToItems(createNewRoleBindingRestriction("test-list"))
            .build())
        .once();

    // When
    RoleBindingRestrictionList roleBindingRestrictionList = client.roleBindingRestrictions().inNamespace("ns1").list();

    // Then
    assertThat(roleBindingRestrictionList).isNotNull();
    assertThat(roleBindingRestrictionList.getItems()).hasSize(1);
    assertThat(roleBindingRestrictionList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/authorization.openshift.io/v1/namespaces/ns1/rolebindingrestrictions/cluster")
        .andReturn(HttpURLConnection.HTTP_OK, createNewRoleBindingRestriction("cluster"))
        .once();

    // When
    boolean isDeleted = client.roleBindingRestrictions().inNamespace("ns1").withName("cluster").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private RoleBindingRestriction createNewRoleBindingRestriction(String name) {
    return new RoleBindingRestrictionBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewGrouprestriction()
        .addToGroups("groups-rolebindingrestriction")
        .endGrouprestriction()
        .endSpec()
        .build();
  }

}
