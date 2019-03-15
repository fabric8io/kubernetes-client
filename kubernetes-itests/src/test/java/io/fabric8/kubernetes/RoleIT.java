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
import io.fabric8.kubernetes.api.model.rbac.Role;
import io.fabric8.kubernetes.api.model.rbac.RoleList;
import io.fabric8.kubernetes.api.model.rbac.RoleBuilder;
import io.fabric8.kubernetes.api.model.rbac.PolicyRuleBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class RoleIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private Role role;

  private String currentNamespace;

  @Before
  public void init() {

    currentNamespace = session.getNamespace();

    // Do not run tests on opeshift 3.6.0 and 3.6.1
    assumeFalse(client.getVersion().getMajor().equalsIgnoreCase("1")
      && client.getVersion().getMinor().startsWith("6"));

    Role role = new RoleBuilder()
      .withNewMetadata()
      .withName("job-reader")
      .endMetadata()
      .addToRules(0, new PolicyRuleBuilder()
        .addToApiGroups(0,"batch")
        .addToResourceNames(0,"my-job")
        .addToResources(0,"jobs")
        .addToVerbs(0, "get")
        .addToVerbs(1, "watch")
        .addToVerbs(2, "list")
        .build()
      )
      .build();

    client.rbac().roles().inNamespace(currentNamespace).createOrReplace(role);
  }

  @Test
  public void get() {

    role = client.rbac().roles().inNamespace(currentNamespace).withName("job-reader").get();

    assertNotNull(role);
    assertEquals("Role", role.getKind());
    assertNotNull(role.getMetadata());
    assertEquals("job-reader", role.getMetadata().getName());
    assertNotNull(role.getRules());
    assertEquals(1, role.getRules().size());
    assertNotNull(role.getRules().get(0).getApiGroups());
    assertEquals(1, role.getRules().get(0).getApiGroups().size());
    assertEquals("batch", role.getRules().get(0).getApiGroups().get(0));
    assertNotNull(role.getRules().get(0).getResourceNames());
    assertEquals(1, role.getRules().get(0).getResourceNames().size());
    assertEquals("my-job", role.getRules().get(0).getResourceNames().get(0));
    assertNotNull(role.getRules().get(0).getResources());
    assertEquals(1, role.getRules().get(0).getResources().size());
    assertEquals("jobs", role.getRules().get(0).getResources().get(0));
    assertNotNull(role.getRules().get(0).getVerbs());
    assertEquals(3, role.getRules().get(0).getVerbs().size());
    assertEquals("get", role.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", role.getRules().get(0).getVerbs().get(1));
    assertEquals("list", role.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void load() {

    Role aRole = client.rbac().roles().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-kubernetesrole.yml")).get();

    assertNotNull(aRole);
    assertEquals("Role", aRole.getKind());
    assertNotNull(aRole.getMetadata());
    assertEquals("job-reader", aRole.getMetadata().getName());
    assertNotNull(aRole.getRules());
    assertEquals(1, aRole.getRules().size());
    assertNotNull(aRole.getRules().get(0).getApiGroups());
    assertEquals(1, aRole.getRules().get(0).getApiGroups().size());
    assertEquals("batch", aRole.getRules().get(0).getApiGroups().get(0));
    assertNotNull(aRole.getRules().get(0).getNonResourceURLs());
    assertEquals(1, aRole.getRules().get(0).getNonResourceURLs().size());
    assertEquals("/healthz", aRole.getRules().get(0).getNonResourceURLs().get(0));
    assertNotNull(aRole.getRules().get(0).getResourceNames());
    assertEquals(1, aRole.getRules().get(0).getResourceNames().size());
    assertEquals("my-job", aRole.getRules().get(0).getResourceNames().get(0));
    assertNotNull(aRole.getRules().get(0).getResources());
    assertEquals(1, aRole.getRules().get(0).getResources().size());
    assertEquals("jobs", aRole.getRules().get(0).getResources().get(0));
    assertNotNull(aRole.getRules().get(0).getVerbs());
    assertEquals(3, aRole.getRules().get(0).getVerbs().size());
    assertEquals("get", aRole.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", aRole.getRules().get(0).getVerbs().get(1));
    assertEquals("list", aRole.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void list() {

    RoleList roleList = client.rbac().roles().inNamespace(currentNamespace).list();

    assertNotNull(roleList);
    assertNotNull(roleList.getItems());
    assertEquals(1, roleList.getItems().size());
    assertNotNull(roleList.getItems().get(0));
    assertEquals("Role", roleList.getItems().get(0).getKind());
    assertNotNull(roleList.getItems().get(0).getMetadata());
    assertEquals("job-reader", roleList.getItems().get(0).getMetadata().getName());
    assertNotNull(roleList.getItems().get(0).getRules());
    assertEquals(1, roleList.getItems().get(0).getRules().size());
    assertNotNull(roleList.getItems().get(0).getRules().get(0).getApiGroups());
    assertEquals(1, roleList.getItems().get(0).getRules().get(0).getApiGroups().size());
    assertEquals("batch", roleList.getItems().get(0).getRules().get(0).getApiGroups().get(0));
    assertNotNull(roleList.getItems().get(0).getRules().get(0).getResourceNames());
    assertEquals(1, roleList.getItems().get(0).getRules().get(0).getResourceNames().size());
    assertEquals("my-job", roleList.getItems().get(0).getRules().get(0).getResourceNames().get(0));
    assertNotNull(roleList.getItems().get(0).getRules().get(0).getResources());
    assertEquals(1, roleList.getItems().get(0).getRules().get(0).getResources().size());
    assertEquals("jobs", roleList.getItems().get(0).getRules().get(0).getResources().get(0));
    assertNotNull(roleList.getItems().get(0).getRules().get(0).getVerbs());
    assertEquals(3, roleList.getItems().get(0).getRules().get(0).getVerbs().size());
    assertEquals("get", roleList.getItems().get(0).getRules().get(0).getVerbs().get(0));
    assertEquals("watch", roleList.getItems().get(0).getRules().get(0).getVerbs().get(1));
    assertEquals("list", roleList.getItems().get(0).getRules().get(0).getVerbs().get(2));

  }

  @Test
  public void update() {

    role = client.rbac().roles().inNamespace(currentNamespace).withName("job-reader").edit()
      .editRule(0).addToApiGroups(1, "extensions").endRule().done();

    assertNotNull(role);
    assertEquals("Role", role.getKind());
    assertNotNull(role.getMetadata());
    assertEquals("job-reader", role.getMetadata().getName());
    assertNotNull(role.getRules());
    assertEquals(1, role.getRules().size());
    assertNotNull(role.getRules().get(0).getApiGroups());
    assertEquals(2, role.getRules().get(0).getApiGroups().size());
    assertEquals("batch", role.getRules().get(0).getApiGroups().get(0));
    assertEquals("extensions", role.getRules().get(0).getApiGroups().get(1));
    assertNotNull(role.getRules().get(0).getResourceNames());
    assertEquals(1, role.getRules().get(0).getResourceNames().size());
    assertEquals("my-job", role.getRules().get(0).getResourceNames().get(0));
    assertNotNull(role.getRules().get(0).getResources());
    assertEquals(1, role.getRules().get(0).getResources().size());
    assertEquals("jobs", role.getRules().get(0).getResources().get(0));
    assertNotNull(role.getRules().get(0).getVerbs());
    assertEquals(3, role.getRules().get(0).getVerbs().size());
    assertEquals("get", role.getRules().get(0).getVerbs().get(0));
    assertEquals("watch", role.getRules().get(0).getVerbs().get(1));
    assertEquals("list", role.getRules().get(0).getVerbs().get(2));
  }

  @Test
  public void delete() {

    Integer countBeforeDeletion = client.rbac().roles().inNamespace(currentNamespace).list().getItems().size();
    boolean deleted = client.rbac().roles().inNamespace(currentNamespace).delete();

    assertTrue(deleted);

    DeleteEntity<Role> deleteEntity = new DeleteEntity<>(Role.class, client, "job-reader", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);

    RoleList roleList = client.rbac().roles().inNamespace(currentNamespace).list();
    assertEquals(countBeforeDeletion - 1,roleList.getItems().size());
  }

  @After
  public void cleanup() {
    client.rbac().roles().inNamespace(currentNamespace).delete();
  }

}
