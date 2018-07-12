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

import io.fabric8.kubernetes.api.model.rbac.KubernetesRole;
import io.fabric8.kubernetes.api.model.rbac.KubernetesRoleList;
import io.fabric8.kubernetes.api.model.rbac.KubernetesRoleBuilder;
import io.fabric8.kubernetes.api.model.rbac.KubernetesPolicyRuleBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class KubernetesRoleIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private KubernetesRole kubernetesRole;

  private String currentNamespace;

  @Before
  public void init() {

    currentNamespace = session.getNamespace();

    // Do not run tests on opeshift 3.6.0 and 3.6.1
    assumeFalse(client.getVersion().getMajor().equalsIgnoreCase("1")
      && client.getVersion().getMinor().startsWith("6"));

    KubernetesRole kubernetesRole = new KubernetesRoleBuilder()
      .withNewMetadata()
      .withName("job-reader")
      .endMetadata()
      .addToRules(0, new KubernetesPolicyRuleBuilder()
        .addToApiGroups(0,"batch")
        .addToResourceNames(0,"my-job")
        .addToResources(0,"jobs")
        .addToVerbs(0, "get")
        .addToVerbs(1, "watch")
        .addToVerbs(2, "list")
        .build()
      )
      .build();

    client.rbac().kubernetesRoles().inNamespace(currentNamespace).createOrReplace(kubernetesRole);
  }

  @Test
  public void get() {

    kubernetesRole = client.rbac().kubernetesRoles().inNamespace(currentNamespace).withName("job-reader").get();

    assertNotNull(kubernetesRole);
    assertEquals("Role", kubernetesRole.getKind());
    assertNotNull(kubernetesRole.getMetadata());
    assertEquals("job-reader", kubernetesRole.getMetadata().getName());
    assertNotNull(kubernetesRole.getRules());
    assertEquals(1, kubernetesRole.getRules().size());
    assertNotNull(kubernetesRole.getRules().get(0).getApiGroups());
    assertEquals(1, kubernetesRole.getRules().get(0).getApiGroups().size());
    assertEquals("batch", kubernetesRole.getRules().get(0).getApiGroups().get(0));
    assertNotNull(kubernetesRole.getRules().get(0).getResourceNames());
    assertEquals(1, kubernetesRole.getRules().get(0).getResourceNames().size());
    assertEquals("my-job", kubernetesRole.getRules().get(0).getResourceNames().get(0));
    assertNotNull(kubernetesRole.getRules().get(0).getResources());
    assertEquals(1, kubernetesRole.getRules().get(0).getResources().size());
    assertEquals("jobs", kubernetesRole.getRules().get(0).getResources().get(0));
    assertNotNull(kubernetesRole.getRules().get(0).getVerbs());
    assertEquals(3, kubernetesRole.getRules().get(0).getVerbs().size());
    assertEquals("get", kubernetesRole.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", kubernetesRole.getRules().get(0).getVerbs().get(1));
    assertEquals("list", kubernetesRole.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void load() {

    KubernetesRole aKubernetesRole = client.rbac().kubernetesRoles().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-kubernetesrole.yml")).get();

    assertNotNull(aKubernetesRole);
    assertEquals("Role", aKubernetesRole.getKind());
    assertNotNull(aKubernetesRole.getMetadata());
    assertEquals("job-reader", aKubernetesRole.getMetadata().getName());
    assertNotNull(aKubernetesRole.getRules());
    assertEquals(1, aKubernetesRole.getRules().size());
    assertNotNull(aKubernetesRole.getRules().get(0).getApiGroups());
    assertEquals(1, aKubernetesRole.getRules().get(0).getApiGroups().size());
    assertEquals("batch", aKubernetesRole.getRules().get(0).getApiGroups().get(0));
    assertNotNull(aKubernetesRole.getRules().get(0).getNonResourceURLs());
    assertEquals(1, aKubernetesRole.getRules().get(0).getNonResourceURLs().size());
    assertEquals("/healthz", aKubernetesRole.getRules().get(0).getNonResourceURLs().get(0));
    assertNotNull(aKubernetesRole.getRules().get(0).getResourceNames());
    assertEquals(1, aKubernetesRole.getRules().get(0).getResourceNames().size());
    assertEquals("my-job", aKubernetesRole.getRules().get(0).getResourceNames().get(0));
    assertNotNull(aKubernetesRole.getRules().get(0).getResources());
    assertEquals(1, aKubernetesRole.getRules().get(0).getResources().size());
    assertEquals("jobs", aKubernetesRole.getRules().get(0).getResources().get(0));
    assertNotNull(aKubernetesRole.getRules().get(0).getVerbs());
    assertEquals(3, aKubernetesRole.getRules().get(0).getVerbs().size());
    assertEquals("get", aKubernetesRole.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", aKubernetesRole.getRules().get(0).getVerbs().get(1));
    assertEquals("list", aKubernetesRole.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void list() {

    KubernetesRoleList kubernetesRoleList = client.rbac().kubernetesRoles().inNamespace(currentNamespace).list();

    assertNotNull(kubernetesRoleList);
    assertNotNull(kubernetesRoleList.getItems());
    assertEquals(1, kubernetesRoleList.getItems().size());
    assertNotNull(kubernetesRoleList.getItems().get(0));
    assertEquals("Role", kubernetesRoleList.getItems().get(0).getKind());
    assertNotNull(kubernetesRoleList.getItems().get(0).getMetadata());
    assertEquals("job-reader", kubernetesRoleList.getItems().get(0).getMetadata().getName());
    assertNotNull(kubernetesRoleList.getItems().get(0).getRules());
    assertEquals(1, kubernetesRoleList.getItems().get(0).getRules().size());
    assertNotNull(kubernetesRoleList.getItems().get(0).getRules().get(0).getApiGroups());
    assertEquals(1, kubernetesRoleList.getItems().get(0).getRules().get(0).getApiGroups().size());
    assertEquals("batch", kubernetesRoleList.getItems().get(0).getRules().get(0).getApiGroups().get(0));
    assertNotNull(kubernetesRoleList.getItems().get(0).getRules().get(0).getResourceNames());
    assertEquals(1, kubernetesRoleList.getItems().get(0).getRules().get(0).getResourceNames().size());
    assertEquals("my-job", kubernetesRoleList.getItems().get(0).getRules().get(0).getResourceNames().get(0));
    assertNotNull(kubernetesRoleList.getItems().get(0).getRules().get(0).getResources());
    assertEquals(1, kubernetesRoleList.getItems().get(0).getRules().get(0).getResources().size());
    assertEquals("jobs", kubernetesRoleList.getItems().get(0).getRules().get(0).getResources().get(0));
    assertNotNull(kubernetesRoleList.getItems().get(0).getRules().get(0).getVerbs());
    assertEquals(3, kubernetesRoleList.getItems().get(0).getRules().get(0).getVerbs().size());
    assertEquals("get", kubernetesRoleList.getItems().get(0).getRules().get(0).getVerbs().get(0));
    assertEquals("watch", kubernetesRoleList.getItems().get(0).getRules().get(0).getVerbs().get(1));
    assertEquals("list", kubernetesRoleList.getItems().get(0).getRules().get(0).getVerbs().get(2));

  }

  @Test
  public void update() {

    kubernetesRole = client.rbac().kubernetesRoles().inNamespace(currentNamespace).withName("job-reader").edit()
      .editRule(0).addToApiGroups(1, "extensions").endRule().done();

    assertNotNull(kubernetesRole);
    assertEquals("Role", kubernetesRole.getKind());
    assertNotNull(kubernetesRole.getMetadata());
    assertEquals("job-reader", kubernetesRole.getMetadata().getName());
    assertNotNull(kubernetesRole.getRules());
    assertEquals(1, kubernetesRole.getRules().size());
    assertNotNull(kubernetesRole.getRules().get(0).getApiGroups());
    assertEquals(2, kubernetesRole.getRules().get(0).getApiGroups().size());
    assertEquals("batch", kubernetesRole.getRules().get(0).getApiGroups().get(0));
    assertEquals("extensions", kubernetesRole.getRules().get(0).getApiGroups().get(1));
    assertNotNull(kubernetesRole.getRules().get(0).getResourceNames());
    assertEquals(1, kubernetesRole.getRules().get(0).getResourceNames().size());
    assertEquals("my-job", kubernetesRole.getRules().get(0).getResourceNames().get(0));
    assertNotNull(kubernetesRole.getRules().get(0).getResources());
    assertEquals(1, kubernetesRole.getRules().get(0).getResources().size());
    assertEquals("jobs", kubernetesRole.getRules().get(0).getResources().get(0));
    assertNotNull(kubernetesRole.getRules().get(0).getVerbs());
    assertEquals(3, kubernetesRole.getRules().get(0).getVerbs().size());
    assertEquals("get", kubernetesRole.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", kubernetesRole.getRules().get(0).getVerbs().get(1));
    assertEquals("list", kubernetesRole.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void delete() {

    boolean deleted = client.rbac().kubernetesRoles().inNamespace(currentNamespace).delete();

    assertTrue(deleted);
    KubernetesRoleList kubernetesRoleList = client.rbac().kubernetesRoles().inNamespace(currentNamespace).list();
    assertEquals(0,kubernetesRoleList.getItems().size());
  }

  @After
  public void cleanup() {
    client.rbac().kubernetesRoles().inNamespace(currentNamespace).delete();
  }

}
