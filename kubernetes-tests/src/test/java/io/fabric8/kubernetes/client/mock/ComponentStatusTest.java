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

import io.fabric8.kubernetes.api.model.ComponentCondition;
import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusBuilder;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.ComponentStatusListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ComponentStatusTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

	ComponentStatus status = new ComponentStatusBuilder().withConditions(new ComponentCondition(null, "ok",
			"True", "Healthy")).build();

	ComponentStatusList list = new ComponentStatusListBuilder().addNewItem().addNewCondition()
			.and().endItem().build();

	@Test
	public void testComponentStatus() {
    server.expect().withPath("/api/v1/componentstatuses/scheduler").andReturn(200, status).once();

		KubernetesClient client = server.getClient();
		ComponentStatus stat = client.componentstatuses().withName("scheduler").get();
	    assertNotNull(stat);
	    assertEquals(1, stat.getConditions().size());
	}

	@Test
	public void testComponentStatusList() {
    server.expect().withPath("/api/v1/componentstatuses").andReturn(200, status).once();

		KubernetesClient client = server.getClient();
		ComponentStatusList stats = client.componentstatuses().list();
	    assertNotNull(stats);
	}
}
