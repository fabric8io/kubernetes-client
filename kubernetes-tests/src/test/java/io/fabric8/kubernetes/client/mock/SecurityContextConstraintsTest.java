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

import io.fabric8.kubernetes.api.model.SecurityContextConstraintsBuilder;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsList;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SecurityContextConstraintsTest extends KubernetesMockServerTestBase {

  @Test
  public void testList() {
    expect().withPath("/api/v1/securitycontextconstraints").andReturn(200, new SecurityContextConstraintsListBuilder()
            .addNewItem().endItem()
            .build()).once();


    KubernetesClient client = getClient();
    SecurityContextConstraintsList sccList = client.securityContextConstraints().list();
    assertNotNull(sccList);
    assertEquals(1, sccList.getItems().size());
  }


  @Test
  public void testDelete() {
    expect().withPath("/api/v1/securitycontextconstraints/scc1").andReturn(200, new SecurityContextConstraintsBuilder().build()).once();
    expect().withPath("/api/v1/securitycontextconstraints/scc2").andReturn(200, new SecurityContextConstraintsBuilder().build()).once();

    KubernetesClient client = getClient();

    Boolean deleted = client.securityContextConstraints().withName("scc1").delete();
    assertNotNull(deleted);

    deleted = client.securityContextConstraints().withName("scc1").delete();
    assertFalse(deleted);

    deleted = client.securityContextConstraints().withName("scc2").delete();
    assertTrue(deleted);
  }

}
