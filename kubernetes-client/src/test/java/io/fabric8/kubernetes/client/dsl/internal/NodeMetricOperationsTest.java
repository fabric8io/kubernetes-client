package io.fabric8.kubernetes.client.dsl.internal;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import io.fabric8.kubernetes.api.model.metrics.v1beta1.NodeMetricsList;

public class NodeMetricOperationsTest {

	private DefaultKubernetesClient defaultKubernetesClient;

	@BeforeEach
	public void setUp() {
		defaultKubernetesClient = new DefaultKubernetesClient();
	}

	@AfterEach
	public void tearDown() {
		defaultKubernetesClient.close();
		defaultKubernetesClient = null;
	}

	public void testGetMetricsViaLabl() {
		Map<String,Object> lablesMap = new HashMap();
		lablesMap.put("ss", "true");
		lablesMap.put("cs", "true");
		NodeMetricsList nodeMetricList = defaultKubernetesClient.top().nodes().metrics(lablesMap);
		 assertEquals(0, nodeMetricList.getItems().size());
	}
}
