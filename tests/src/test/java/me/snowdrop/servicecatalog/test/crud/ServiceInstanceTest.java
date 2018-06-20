package me.snowdrop.servicecatalog.test.crud;

import me.snowdrop.servicecatalog.api.client.ServiceCatalogClient;
import me.snowdrop.servicecatalog.api.model.ServiceInstance;
import me.snowdrop.servicecatalog.api.model.ServiceInstanceBuilder;
import me.snowdrop.servicecatalog.api.model.ServiceInstanceList;
import me.snowdrop.servicecatalog.mock.ServiceCatalogServer;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ServiceInstanceTest {

    @Rule
    public ServiceCatalogServer server = new ServiceCatalogServer(true, true);

    @Test
    public void testCrud() {
        ServiceCatalogClient client = server.getServiceCatalogClient();
        ServiceInstance instance1 = new ServiceInstanceBuilder()
                .withNewMetadata()
                .withName("instance1")
                .addToLabels("key1", "value1")
                .endMetadata()
                .withNewSpec()
                .withClusterServiceClassExternalName("class1")
                .withClusterServicePlanExternalName("default")
                .endSpec()
                .build();

        ServiceInstance instance2 = new ServiceInstanceBuilder()
                .withNewMetadata()
                .withName("instance2")
                .addToLabels("key2", "value2")
                .endMetadata()
                .withNewSpec()
                .withClusterServiceClassExternalName("class2")
                .withClusterServicePlanExternalName("default")
                .endSpec()
                .build();

        ServiceInstance instance3 = new ServiceInstanceBuilder()
                .withNewMetadata()
                .withName("instance3")
                .addToLabels("key3", "value3")
                .endMetadata()
                .withNewSpec()
                .withClusterServiceClassExternalName("class3")
                .withClusterServicePlanExternalName("default")
                .endSpec()
                .build();


        ServiceInstance instance4 = new ServiceInstanceBuilder()
                .withNewMetadata()
                .withName("instance4")
                .addToLabels("key4", "value4")
                .endMetadata()
                .withNewSpec()
                .withClusterServiceClassExternalName("class4")
                .withClusterServicePlanExternalName("default")
                .endSpec()
                .build();

        //Create
        client.serviceInstances().inNamespace("testns").create(instance1);
        client.serviceInstances().inNamespace("testns").create(instance2);
        client.serviceInstances().inNamespace("testns").create(instance3);
        client.serviceInstances().inNamespace("otherns").create(instance4);

        //Read
        ServiceInstanceList instances = client.serviceInstances().inNamespace("testns").list();
        assertNotNull(instances);
        assertEquals(3, instances.getItems().size());

        instances = client.serviceInstances().inNamespace("otherns").list();
        assertNotNull(instances);
        assertEquals(1, instances.getItems().size());

        ServiceInstance r1 = client.serviceInstances().inNamespace("testns").withName("instance1").get();
        assertNotNull(r1);

        //Update
        ServiceInstance u1 = client.serviceInstances().inNamespace("testns").withName("instance1").edit()
                .editMetadata()
                .addToLabels("updated", "true")
                .endMetadata()
                .done();

        assertNotNull(u1);
        assertEquals("true", u1.getMetadata().getLabels().get("updated"));

        //Delete
        assertTrue(client.serviceInstances().inNamespace("testns").withName("instance1").delete());
        assertNull(client.serviceInstances().inNamespace("testns").withName("instance1").get());
    }
}
