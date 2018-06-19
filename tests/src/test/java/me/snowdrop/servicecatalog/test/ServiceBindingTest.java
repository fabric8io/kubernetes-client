package me.snowdrop.servicecatalog.test;

import me.snowdrop.servicecatalog.api.client.ServiceCatalogClient;
import me.snowdrop.servicecatalog.api.model.ServiceBinding;
import me.snowdrop.servicecatalog.api.model.ServiceBindingBuilder;
import me.snowdrop.servicecatalog.api.model.ServiceBindingList;
import me.snowdrop.servicecatalog.mock.ServiceCatalogServer;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ServiceBindingTest {

  @Rule
  public ServiceCatalogServer server = new ServiceCatalogServer(true, true);

  @Test
  public void testCrud() {
    ServiceCatalogClient client = server.getServiceCatalogClient();


      ServiceBinding binding1 = new ServiceBindingBuilder()
              .withNewMetadata()
              .withName("binding1")
              .addToLabels("key1", "value1")
              .endMetadata()
              .withNewSpec()
              .withSecretName("secret1")
              .withNewInstanceRef("instance1")
              .endSpec()
              .build();

      ServiceBinding binding2 = new ServiceBindingBuilder()
              .withNewMetadata()
              .withName("binding2")
              .addToLabels("key2", "value2")
              .endMetadata()
              .withNewSpec()
              .withSecretName("secret2")
              .withNewInstanceRef("instance2")
              .endSpec()
              .build();

      ServiceBinding binding3 = new ServiceBindingBuilder()
              .withNewMetadata()
              .withName("binding3")
              .addToLabels("key3", "value3")
              .endMetadata()
              .withNewSpec()
              .withSecretName("secret3")
              .withNewInstanceRef("instance3")
              .endSpec()
              .build();


      ServiceBinding binding4 = new ServiceBindingBuilder()
              .withNewMetadata()
              .withName("binding4")
              .addToLabels("key4", "value4")
              .endMetadata()
              .withNewSpec()
              .withSecretName("secret4")
              .withNewInstanceRef("instance4")
              .endSpec()
              .build();

      //Create
      client.serviceBindings().inNamespace("testns").create(binding1);
      client.serviceBindings().inNamespace("testns").create(binding2);
      client.serviceBindings().inNamespace("testns").create(binding3);
      client.serviceBindings().inNamespace("otherns").create(binding4);


      //Read
      ServiceBindingList bindings = client.serviceBindings().inNamespace("testns").list();
      assertNotNull(bindings);
      assertEquals(3, bindings.getItems().size());

      bindings = client.serviceBindings().inNamespace("otherns").list();
      assertNotNull(bindings);
      assertEquals(1, bindings.getItems().size());

      ServiceBinding r1 = client.serviceBindings().inNamespace("testns").withName("binding1").get();
      assertNotNull(r1);

      //Update
      ServiceBinding u1 = client.serviceBindings().inNamespace("testns").withName("binding1").edit()
              .editMetadata()
              .addToLabels("updated", "true")
              .endMetadata()
              .done();

      assertNotNull(u1);
      assertEquals("true", u1.getMetadata().getLabels().get("updated"));

      //Delete
      assertTrue(client.serviceBindings().inNamespace("testns").withName("binding1").delete());
      assertNull(client.serviceBindings().inNamespace("testns").withName("binding1").get());
  }
}
