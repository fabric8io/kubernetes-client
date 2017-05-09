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

import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResource;
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResourceBuilder;
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResourceList;
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResourceListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TPRTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testList() {
    server.expect().withPath("/apis/extensions/v1beta1/thirdpartyresources")
      .andReturn(200, new ThirdPartyResourceListBuilder().addNewItem().and().build()).once();

    KubernetesClient client = server.getClient();
    ThirdPartyResourceList tprList = client.extensions().thirdPartyResources().list();
    assertNotNull(tprList);
    assertEquals(1, tprList.getItems().size());
  }

  @Test
  public void testGet(){
    Map<String, String> labelMap = new HashMap<>();

    labelMap.put("resource", "spark-job");
    labelMap.put("object", "spark");

    ThirdPartyResource tpr1 = new ThirdPartyResourceBuilder()
      .withApiVersion("extensions/v1beta1")
      .withKind("ThirdPartyResource")
      .withDescription("A resource that manages a spark job")
      .withVersions()
      .addNewVersion("v1")
      .withNewMetadata()
      .withName("spark-job.apache.io")
      .withLabels(labelMap)
      .endMetadata()
      .build();

    ThirdPartyResource tpr2 = new ThirdPartyResourceBuilder()
      .withApiVersion("extensions/v1beta1")
      .withKind("ThirdPartyResource")
      .withDescription("A test job")
      .withVersions()
      .addNewVersion("v1")
      .withNewMetadata()
      .withName("test-job.apache.io")
      .withLabels(labelMap)
      .endMetadata()
      .build();

    server.expect().withPath("/apis/extensions/v1beta1/thirdpartyresources/tpr1")
      .andReturn(200, tpr1).once();
    server.expect().withPath("/apis/extensions/v1beta1/thirdpartyresources/tpr2")
      .andReturn(200, tpr2).once();

    KubernetesClient client = server.getClient();

    ThirdPartyResource tpr = client.extensions().thirdPartyResources().withName("tpr1").get();
    assertNotNull(tpr);

    tpr = client.extensions().thirdPartyResources().withName("tpr2").get();
    assertNotNull(tpr);

    tpr = client.extensions().thirdPartyResources().withName("tpr3").get();
    assertNull(tpr);
  }

  @Test
  public void testDelete() {
    Map<String, String> labelMap = new HashMap<>();

    labelMap.put("resource", "spark-job");
    labelMap.put("object", "spark");

    ThirdPartyResource tpr1 = new ThirdPartyResourceBuilder()
      .withApiVersion("extensions/v1beta1")
      .withKind("ThirdPartyResource")
      .withDescription("A resource that manages a spark job")
      .withVersions()
        .addNewVersion("v1")
      .withNewMetadata()
        .withName("spark-job.apache.io")
        .withLabels(labelMap)
      .endMetadata()
      .build();

    ThirdPartyResource tpr2 = new ThirdPartyResourceBuilder()
      .withApiVersion("extensions/v1beta1")
      .withKind("ThirdPartyResource")
      .withDescription("A test job")
      .withVersions()
        .addNewVersion("v1")
      .withNewMetadata()
        .withName("test-job.apache.io")
        .withLabels(labelMap)
      .endMetadata()
      .build();

    server.expect().withPath("/apis/extensions/v1beta1/thirdpartyresources/tpr1")
      .andReturn(200, tpr1).once();
    server.expect().withPath("/apis/extensions/v1beta1/thirdpartyresources/tpr2")
      .andReturn(200, tpr2).once();

    KubernetesClient client = server.getClient();

    Boolean deleted = client.extensions().thirdPartyResources().withName("tpr1").delete();
    assertTrue(deleted);

    deleted = client.extensions().thirdPartyResources().withName("tpr2").delete();
    assertTrue(deleted);

    deleted = client.extensions().thirdPartyResources().withName("tpr3").delete();
    assertFalse(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testDeleteMulti(){

    Map<String, String> labelMap = new HashMap<>();

    labelMap.put("resource", "spark-job");
    labelMap.put("object", "spark");

    ThirdPartyResource tpr1 = new ThirdPartyResourceBuilder()
      .withApiVersion("extensions/v1beta1")
      .withKind("ThirdPartyResource")
      .withDescription("A resource that manages a spark job")
      .withVersions()
      .addNewVersion("v1")
      .withNewMetadata()
      .withName("spark-job.apache.io")
      .withLabels(labelMap)
      .endMetadata()
      .build();

    ThirdPartyResource tpr2 = new ThirdPartyResourceBuilder()
      .withApiVersion("extensions/v1beta1")
      .withKind("ThirdPartyResource")
      .withDescription("A test job")
      .withVersions()
      .addNewVersion("v1")
      .withNewMetadata()
      .withName("test-job.apache.io")
      .withLabels(labelMap)
      .endMetadata()
      .build();

    ThirdPartyResourceList tpr = new ThirdPartyResourceListBuilder().withItems(tpr1, tpr2).build();

    server.expect().withPath("/apis/extensions/v1beta1/thirdpartyresources").andReturn(200, tpr).times(2);

    KubernetesClient client = server.getClient();

    ThirdPartyResourceList tprList = client.extensions().thirdPartyResources().list();
    assertNotNull(tprList);
    assertEquals(2, tprList.getItems().size());

    client.extensions().thirdPartyResources().delete();
    client.extensions().thirdPartyResources().list();
  }
}
