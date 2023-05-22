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
package io.fabric8.openshift.client.impl;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 */
class ViewCurrentUser {
  @Test
  void testShowCurrentUser() throws Exception {
    OpenShiftClient client = new KubernetesClientBuilder().build().adapt(OpenShiftClient.class);
    User user = client.currentUser();

    System.out.println("Current user is: " + user);
    assertNotNull(user);
    ObjectMeta metadata = user.getMetadata();
    assertNotNull(metadata);
    String name = metadata.getName();
    System.out.println("User name is: " + name);
    assertNotNull(name);
  }

}
