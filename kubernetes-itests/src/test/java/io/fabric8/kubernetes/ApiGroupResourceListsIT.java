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

import io.fabric8.kubernetes.api.model.APIGroup;
import io.fabric8.kubernetes.api.model.APIGroupList;
import io.fabric8.kubernetes.api.model.APIResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ApiGroupResourceListsIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @Test
  public void testApiGroups() throws InterruptedException {
    APIGroupList list = client.getApiGroups();

    assertTrue(list.getGroups().stream().anyMatch(g -> "apps".equals(g.getName())));
  }

  @Test
  public void testApiGroup() throws InterruptedException {
    APIGroup group = client.getApiGroup("apps");

    assertNotNull(group);

    group = client.getApiGroup("apps-that-wont-exist");

    assertNull(group);
  }

  @Test
  public void testApiResources() throws InterruptedException {
    APIResourceList list = client.getApiResources("apps/v1");

    assertTrue(list.getResources().stream().anyMatch(r -> "deployments".equals(r.getName())));
  }
}
