package me.snowdrop.servicecatalog.test;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import me.snowdrop.servicecatalog.api.client.ServiceCatalogClient;
import me.snowdrop.servicecatalog.mock.ServiceCatalogMockServer;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.client.KubernetesClient;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AdaptTest {

  private ServiceCatalogMockServer mock = new ServiceCatalogMockServer();

  @Before
  public void setUp() {
    mock.init();
  }

  @After
  public void tearDown() throws IOException {
    mock.destroy();
  }


  @Test
  public void testAdapt() {
    ServiceCatalogClient sc = mock.createServiceCatalog();
    KubernetesClient kc = new DefaultKubernetesClient(sc.getConfiguration());
    Assert.assertNotNull(kc.adapt(ServiceCatalogClient.class));
  }
}
