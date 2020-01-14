package io.fabric8.kubernetes.client;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;



/**
 * init default client
 * @author wangyushuai2@jd.com
 * @date 2020/1/13
 */
public class DefaultKubernetesClientTest {


  @Test
  public void testInitClientWithCustomHeader() {
    Map<String,String> customHeaders = new HashMap();
    customHeaders.put("user-id","test-user");
    customHeaders.put("cluster-id","test-cluster");

    DefaultKubernetesClient defaultKubernetesClient = new DefaultKubernetesClient();

    Config configWithCustomerHeaders = new ConfigBuilder().withCustomHeaders(customHeaders).build();
    DefaultKubernetesClient client = new DefaultKubernetesClient(configWithCustomerHeaders);
    Assert.assertTrue(client.getHttpClient().networkInterceptors().size() >= 1);

    Config defaultConfig =  new ConfigBuilder().build();
    DefaultKubernetesClient client1 = new DefaultKubernetesClient(defaultConfig);
    Assert.assertTrue(client1.getHttpClient().interceptors().size() ==
      defaultKubernetesClient.getHttpClient().networkInterceptors().size() );

  }

}
