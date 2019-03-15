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

package io.fabric8.kubernetes;

import io.fabric8.commons.DeleteEntity;
import io.fabric8.kubernetes.api.model.extensions.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.extensions.PodSecurityPolicyBuilder;
import io.fabric8.kubernetes.api.model.extensions.PodSecurityPolicyList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class PodSecurityPolicyIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private PodSecurityPolicy podSecurityPolicy;

  @Before
  public void init(){

    podSecurityPolicy = new PodSecurityPolicyBuilder().withNewMetadata()
      .withName("test-example")
      .addToLabels("foo","bar")
      .endMetadata()
      .withNewSpec()
      .withPrivileged(false)
      .withNewRunAsUser().withRule("RunAsAny").endRunAsUser()
      .withNewFsGroup().withRule("RunAsAny").endFsGroup()
      .withNewSeLinux().withRule("RunAsAny").endSeLinux()
      .withNewSupplementalGroups().withRule("RunAsAny").endSupplementalGroups()
      .endSpec()
      .build();

    client.extensions().podSecurityPolicies().create(podSecurityPolicy);
  }

  @Test
  public void load() {

    PodSecurityPolicy loadedPodSecurityPolicy = client.extensions().podSecurityPolicies()
      .load(getClass().getResourceAsStream("/test-podsecuritypolicy.yml")).get();

    assertNotNull(loadedPodSecurityPolicy);
    assertEquals("example", loadedPodSecurityPolicy.getMetadata().getName());
    assertFalse(loadedPodSecurityPolicy.getSpec().getPrivileged());
    assertEquals("RunAsAny", loadedPodSecurityPolicy.getSpec().getRunAsUser().getRule());
    assertEquals("RunAsAny", loadedPodSecurityPolicy.getSpec().getFsGroup().getRule());
    assertEquals("RunAsAny", loadedPodSecurityPolicy.getSpec().getSeLinux().getRule());
    assertEquals("RunAsAny", loadedPodSecurityPolicy.getSpec().getSupplementalGroups().getRule());
  }

  @Test
  public void get() {

    PodSecurityPolicy getPodSecurityPolicy = client.extensions().podSecurityPolicies()
      .withName("test-example").get();
    assertNotNull(getPodSecurityPolicy);
    assertEquals("test-example", getPodSecurityPolicy.getMetadata().getName());
  }

  @Test
  public void list() {

    PodSecurityPolicyList podSecurityPolicyList = client.extensions().podSecurityPolicies()
      .withLabels(Collections.singletonMap("foo","bar")).list();
    assertNotNull(podSecurityPolicyList);
    assertEquals(1,podSecurityPolicyList.getItems().size());
    assertEquals("test-example",podSecurityPolicyList.getItems().get(0).getMetadata().getName());
    assertEquals("RunAsAny",podSecurityPolicyList.getItems().get(0).getSpec().getRunAsUser().getRule());
    assertEquals("RunAsAny",podSecurityPolicyList.getItems().get(0).getSpec().getFsGroup().getRule());
    assertEquals("RunAsAny",podSecurityPolicyList.getItems().get(0).getSpec().getSeLinux().getRule());
    assertEquals("RunAsAny",podSecurityPolicyList.getItems().get(0).getSpec().getSupplementalGroups().getRule());
  }

  @Test
  public void update(){

    podSecurityPolicy = client.extensions().podSecurityPolicies().withName("test-example").edit()
      .editSpec().withPrivileged(true).endSpec()
      .done();

    assertNotNull(podSecurityPolicy);
    assertEquals("test-example",podSecurityPolicy.getMetadata().getName());
    assertTrue(podSecurityPolicy.getSpec().getPrivileged());
    assertEquals("RunAsAny",podSecurityPolicy.getSpec().getRunAsUser().getRule());
    assertEquals("RunAsAny",podSecurityPolicy.getSpec().getFsGroup().getRule());
    assertEquals("RunAsAny",podSecurityPolicy.getSpec().getSeLinux().getRule());
    assertEquals("RunAsAny",podSecurityPolicy.getSpec().getSupplementalGroups().getRule());
  }

  @Test
  public void delete(){
    boolean deleted = client.extensions().podSecurityPolicies().delete(podSecurityPolicy);
    assertTrue(deleted);

    DeleteEntity<PodSecurityPolicy> deleteEntity = new DeleteEntity<>(PodSecurityPolicy.class, client, "test-example", null);
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
    PodSecurityPolicyList podSecurityPolicyList = client.extensions().podSecurityPolicies().list();
    assertEquals(0,podSecurityPolicyList.getItems().size());
  }

  @After
  public void cleanup() {
    client.extensions().podSecurityPolicies().withName("test-example").delete();
    DeleteEntity<PodSecurityPolicy> deleteEntity = new DeleteEntity<>(PodSecurityPolicy.class, client, "test-example", null);
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }
}
