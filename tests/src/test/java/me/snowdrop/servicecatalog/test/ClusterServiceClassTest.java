package me.snowdrop.servicecatalog.test;

import me.snowdrop.servicecatalog.api.client.ServiceCatalogClient;
import me.snowdrop.servicecatalog.api.model.ClusterServiceClass;
import me.snowdrop.servicecatalog.api.model.ClusterServiceClassBuilder;
import me.snowdrop.servicecatalog.api.model.ClusterServiceClassList;
import me.snowdrop.servicecatalog.mock.ServiceCatalogServer;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ClusterServiceClassTest {

  @Rule
  public ServiceCatalogServer server = new ServiceCatalogServer(true, true);

  @Test
  public void testCrud() {
    ServiceCatalogClient client = server.getServiceCatalogClient();


      ClusterServiceClass class1 = new ClusterServiceClassBuilder()
              .withNewMetadata()
              .withName("class1")
              .addToLabels("key1", "value1")
              .endMetadata()
              .withNewSpec()
              .withExternalName("class1")
              .endSpec()
              .build();

      ClusterServiceClass class2 = new ClusterServiceClassBuilder()
              .withNewMetadata()
              .withName("class2")
              .addToLabels("key2", "value2")
              .endMetadata()
              .withNewSpec()
              .withExternalName("class1")
              .endSpec()
              .build();

      ClusterServiceClass class3 = new ClusterServiceClassBuilder()
              .withNewMetadata()
              .withName("class3")
              .addToLabels("key3", "value3")
              .endMetadata()
              .withNewSpec()
              .withExternalName("class1")
              .endSpec()
              .build();



      //Create
      client.clusterServiceClasses().create(class1);
      client.clusterServiceClasses().create(class2);
      client.clusterServiceClasses().create(class3);


      //Read
      ClusterServiceClassList classs = client.clusterServiceClasses().list();
      assertNotNull(classs);
      assertEquals(3, classs.getItems().size());

      ClusterServiceClass r1 = client.clusterServiceClasses().withName("class1").get();
      assertNotNull(r1);

      //Update
      ClusterServiceClass u1 = client.clusterServiceClasses().withName("class1").edit()
              .editMetadata()
              .addToLabels("updated", "true")
              .endMetadata()
              .done();

      assertNotNull(u1);
      assertEquals("true", u1.getMetadata().getLabels().get("updated"));

      //Delete
      assertTrue(client.clusterServiceClasses().withName("class1").delete());
      assertNull(client.clusterServiceClasses().withName("class1").get());
  }
}
