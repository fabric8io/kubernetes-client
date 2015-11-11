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
    expect().withPath("/api/v1/namespaces/test/pods").andReturn(200, new PodListBuilder().build()).once();
    expect().withPath("/api/v1/namespaces/ns1/pods").andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and().build()).once();

    expect().withPath("/api/v1/pods").andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem()
      .and().build()).once();


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
    expect().withPath("/api/v1/namespaces/test/pods?labelSelector=" + toUrlEncoded("key1=value1,key2=value2,key3=value3")).andReturn(200, new PodListBuilder().build()).always();
    expect().withPath("/api/v1/namespaces/test/pods?labelSelector=" + toUrlEncoded("key1=value1,key2=value2")).andReturn(200, new PodListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .addNewItem().and()
      .build()).once();

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
    expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder().build()).once();
    expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, new PodBuilder().build()).once();

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
    expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder().build()).once();
    expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, new PodBuilder().build()).once();

    KubernetesClient client = getClient();

    Boolean deleted = client.pods().withName("pod1").delete();
    assertNotNull(deleted);

    deleted = client.pods().withName("pod2").delete();
    assertFalse(deleted);

    deleted = client.pods().inNamespace("ns1").withName("pod2").cascading(false).delete();
    assertTrue(deleted);
  }


  @Test
  public void testDeleteMulti() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    Pod pod3 = new PodBuilder().withNewMetadata().withName("pod3").withNamespace("any").and().build();

    expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, pod1).once();
    expect().withPath("/api/v1/namespaces/ns1/pods/pod2").andReturn(200, pod2).once();

    KubernetesClient client = getClient();

    Boolean deleted = client.pods().inAnyNamespace().delete(pod1, pod2);
    assertNotNull(deleted);

    deleted = client.pods().inAnyNamespace().delete(pod3);
    assertFalse(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testDeleteWithNamespaceMismatch() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    KubernetesClient client = getClient();

    Boolean deleted = client.pods().inNamespace("test1").delete(pod1);
    assertNotNull(deleted);
  }

  @Test(expected = KubernetesClientException.class)
  public void testCreateWithNameMismatch() {
    Pod pod1 = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    Pod pod2 = new PodBuilder().withNewMetadata().withName("pod2").withNamespace("ns1").and().build();
    KubernetesClient client = getClient();

    client.pods().inNamespace("test1").withName("mypod1").create(pod1);
  }

  @Test
  public void testGetLog() {
    String pod1Log = "pod1Log";
    String pod2Log = "pod2Log";
    String pod3Log = "pod3Log";
    String pod4Log = "pod4Log";

    expect().withPath("/api/v1/namespaces/test/pods/pod1/log?pretty=true").andReturn(200, pod1Log).once();
    expect().withPath("/api/v1/namespaces/test/pods/pod2/log?pretty=false").andReturn(200, pod2Log).once();
    expect().withPath("/api/v1/namespaces/test/pods/pod3/log?pretty=false&container=cnt3").andReturn(200, pod3Log).once();
    expect().withPath("/api/v1/namespaces/test4/pods/pod4/log?pretty=true&container=cnt4").andReturn(200, pod4Log).once();

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

  @Test
  public void testLoad() {
    KubernetesClient client = getClient();
    Pod pod = client.pods().load(getClass().getResourceAsStream("/test-pod.yml")).get();
    assertEquals("nginx", pod.getMetadata().getName());
  }

  /**
   * Converts string to URL encoded string.
   * It's not a fullblown converter, it serves just the purpose of this test.
   * @param str
   * @return
   */
  private static final String toUrlEncoded(String str) {
    return str.replaceAll("=", "%3D");
  }
}
