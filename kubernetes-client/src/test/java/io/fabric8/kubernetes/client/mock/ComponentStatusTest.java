package io.fabric8.kubernetes.client.mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.fabric8.kubernetes.api.model.ComponentCondition;
import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusBuilder;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.ComponentStatusListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;

public class ComponentStatusTest extends KubernetesMockServerTestBase	 {
	ComponentStatus status = new ComponentStatusBuilder().withConditions(new ComponentCondition(null, "ok", 
			"True", "Healthy")).build();
	
	ComponentStatusList list = new ComponentStatusListBuilder().addNewItem().addNewCondition()
			.and().endItem().build();
	
	@Test
	public void testComponentStatus() {
		expect().withPath("/api/v1/namespaces/test/componentstatuses/scheduler").andReturn(200, status).once();
	
		KubernetesClient client = getClient();
		ComponentStatus stat = client.componentstatuses().withName("scheduler").get();
	    assertNotNull(stat);
	    assertEquals(1, stat.getConditions().size());
	}
	
	@Test
	public void testComponentStatusList() {
		expect().withPath("/api/v1/namespaces/test/componentstatuses").andReturn(200, status).once();
	
		KubernetesClient client = getClient();
		ComponentStatusList stats = client.componentstatuses().list();
	    assertNotNull(stats);
	}
}
