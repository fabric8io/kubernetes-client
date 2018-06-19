package me.snowdrop.servicecatalog.test;

import io.fabric8.kubernetes.api.model.Cluster;
import me.snowdrop.servicecatalog.api.client.ServiceCatalogClient;
import me.snowdrop.servicecatalog.api.model.ClusterServiceBroker;
import me.snowdrop.servicecatalog.api.model.ClusterServiceBrokerBuilder;
import me.snowdrop.servicecatalog.api.model.ClusterServiceBrokerList;
import me.snowdrop.servicecatalog.mock.ServiceCatalogServer;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ClusterServiceBrokerTest {

  @Rule
  public ServiceCatalogServer server = new ServiceCatalogServer(true, true);

  @Test
  public void testCrud() {
    ServiceCatalogClient client = server.getServiceCatalogClient();


      ClusterServiceBroker broker1 = new ClusterServiceBrokerBuilder()
              .withNewMetadata()
              .withName("broker1")
              .addToLabels("key1", "value1")
              .endMetadata()
              .withNewSpec()
              .withUrl("https://broker1.somewhere.com")
              .endSpec()
              .build();

      ClusterServiceBroker broker2 = new ClusterServiceBrokerBuilder()
              .withNewMetadata()
              .withName("broker1")
              .addToLabels("key2", "value2")
              .endMetadata()
              .withNewSpec()
              .withUrl("https://broker2.somewhere.com")
              .endSpec()
              .build();

      ClusterServiceBroker broker3 = new ClusterServiceBrokerBuilder()
              .withNewMetadata()
              .withName("broker3")
              .addToLabels("key3", "value3")
              .endMetadata()
              .withNewSpec()
              .withUrl("https://broker3.somewhere.com")
              .endSpec()
              .build();



      //Create
      client.clusterServiceBrokers().create(broker1);
      client.clusterServiceBrokers().create(broker2);
      client.clusterServiceBrokers().create(broker3);


      //Read
      ClusterServiceBrokerList brokers = client.clusterServiceBrokers().list();
      assertNotNull(brokers);
      //assertEquals(3, brokers.getItems().size());

      ClusterServiceBroker r1 = client.clusterServiceBrokers().withName("broker1").get();
      assertNotNull(r1);

      //Update
      ClusterServiceBroker u1 = client.clusterServiceBrokers().withName("broker1").edit()
              .editMetadata()
              .addToLabels("updated", "true")
              .endMetadata()
              .done();

      assertNotNull(u1);
      assertEquals("true", u1.getMetadata().getLabels().get("updated"));

      //Delete
      assertTrue(client.clusterServiceBrokers().withName("broker1").delete());
      assertNull(client.clusterServiceBrokers().withName("broker1").get());
  }
}
