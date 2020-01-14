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
