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

import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.junit.Test;

public class UntrustedCertTest extends KubernetesMockServerTestBase {

  @Test(expected = KubernetesClientException.class)
  public void testList() {
    expect().withPath("/api/v1/namespaces/test/pods").andReturn(200, new PodListBuilder().build()).once();
    expect().withPath("/api/v1/namespaces/ns1/pods").andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

    expect().withPath("/api/v1/pods").andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();


    //We override the config to create a client that doesn't trust all certs.
    Config override = new ConfigBuilder(getClient().getConfiguration())
      .withTrustCerts(false)
      .build();

    KubernetesClient client = new DefaultKubernetesClient(override);

    PodList podList = client.pods().list();
  }
}
