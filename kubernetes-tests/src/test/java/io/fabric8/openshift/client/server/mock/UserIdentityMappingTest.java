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

import io.fabric8.openshift.api.model.UserIdentityMapping;
import io.fabric8.openshift.api.model.UserIdentityMappingBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import static java.net.HttpURLConnection.HTTP_CREATED;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableOpenShiftMockClient
class UserIdentityMappingTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void create() {
    // Given
    UserIdentityMapping userIdentityMapping = createNewUserIdentityMapping("ldap_provider:foo_s", "foo");
    server.expect().post().withPath("/apis/user.openshift.io/v1/useridentitymappings")
        .andReturn(HTTP_CREATED, userIdentityMapping)
        .once();

    // When
    UserIdentityMapping userIdentityMappingCreated = client.userIdentityMappings().create(userIdentityMapping);

    // Then
    assertNotNull(userIdentityMappingCreated);
  }

  private UserIdentityMapping createNewUserIdentityMapping(String name, String userName) {
    return new UserIdentityMappingBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewIdentity()
        .withName(name)
        .endIdentity()
        .withNewUser()
        .withName(userName)
        .endUser()
        .build();
  }
}
