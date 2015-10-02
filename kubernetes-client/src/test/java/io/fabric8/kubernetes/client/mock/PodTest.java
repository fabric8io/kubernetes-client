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

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.PodListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class PodTest extends KubernetesMockServerTestBase {

  @Test
  public void testList() {
    expectAndReturnAsJson("/api/v1/namespaces/test/pods", 200, new PodListBuilder().build());
    expectAndReturnAsJson("/api/v1/namespaces/ns1/pods", 200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and().build());

    expectAndReturnAsJson("/api/v1/pods", 200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build());


    KubernetesClient client = getClient();
    PodList podList = client.pods().list();
    assertNotNull(podList);
    assertEquals(0, podList.getItems().size());

    podList = client.pods().inNamespace("ns1").list();
    assertNotNull(podList);
    assertEquals(2, podList.getItems().size());

    podList = client.pods().inAnyNamespace().list();
    assertNotNull(podList);
    assertEquals(3, podList.getItems().size());
  }

  @Test
  public void testListWithLables() {
    expectAndReturnAsJson("/api/v1/namespaces/test/pods?labelSelector=" + toUrlEncoded("key1=value1,key2=value2,key3=value3"), 200, new PodListBuilder().build());
    expectAndReturnAsJson("/api/v1/namespaces/test/pods?labelSelector=" + toUrlEncoded("key1=value1,key2=value2"), 200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build());

    KubernetesClient client = getClient();
    PodList podList = client.pods()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .withLabel("key3","value3")
      .list();


    assertNotNull(podList);
    assertEquals(0, podList.getItems().size());

    podList = client.pods()
      .withLabel("key1", "value1")
      .withLabel("key2","value2")
      .list();

    assertNotNull(podList);
    assertEquals(3, podList.getItems().size());
  }


  @Test
  public void testGet() {
    expectAndReturnAsJson("/api/v1/namespaces/test/pods/pod1", 200, new PodBuilder().build());
    expectAndReturnAsJson("/api/v1/namespaces/ns1/pods/pod2", 200, new PodBuilder().build());

    KubernetesClient client = getClient();

    Pod pod = client.pods().withName("pod1").get();
    assertNotNull(pod);

    pod = client.pods().withName("pod2").get();
    assertNull(pod);

    pod = client.pods().inNamespace("ns1").withName("pod2").get();
    assertNotNull(pod);
  }


  @Test
  public void testDelete() {
    expectAndReturnAsJson("/api/v1/namespaces/test/pods/pod1", 200, new PodBuilder().build());
    expectAndReturnAsJson("/api/v1/namespaces/ns1/pods/pod2", 200, new PodBuilder().build());

    KubernetesClient client = getClient();

    Boolean deleted = client.pods().withName("pod1").delete();
    assertNotNull(deleted);

    deleted = client.pods().withName("pod2").delete();
    assertFalse(deleted);

    deleted = client.pods().inNamespace("ns1").withName("pod2").delete();
    assertTrue(deleted);
  }


  @Test
  public void testGetLog() {
    String pod1Log = "pod1Log";
    String pod2Log = "pod2Log";
    String pod3Log = "pod3Log";
    String pod4Log = "pod4Log";

    expectAndReturnAsString("/api/v1/namespaces/test/pods/pod1/log?pretty=true", 200, pod1Log);
    expectAndReturnAsString("/api/v1/namespaces/test/pods/pod2/log?pretty=false", 200, pod2Log);
    expectAndReturnAsString("/api/v1/namespaces/test/pods/pod3/log?pretty=false&container=cnt3", 200, pod3Log);
    expectAndReturnAsString("/api/v1/namespaces/test4/pods/pod4/log?pretty=true&container=cnt4", 200, pod4Log);

    KubernetesClient client = getClient();

    String log = client.pods().withName("pod1").getLog(true);
    assertEquals(pod1Log, log);

    log = client.pods().withName("pod2").getLog(false);
    assertEquals(pod2Log, log);

    log = client.pods().withName("pod3").getLog("cnt3", false);
    assertEquals(pod3Log, log);

    log = client.pods().inNamespace("test4").withName("pod4").getLog("cnt4", true);
    assertEquals(pod4Log, log);
  }

  @Test(expected = KubernetesClientException.class)
  public void testGetLogNotFound() {
    KubernetesClient client = getClient();
    client.pods().withName("pod5").getLog(true);
  }

  /**
   * Converts string to URL encoded string.
   * It's not a fullblown converter, it serves just the purpose of this test.
   * @param str
   * @return
   */
  private static final String toUrlEncoded(String str) {
    return str.replaceAll("=", "%3D").replaceAll(",","%2C");
  }
}
