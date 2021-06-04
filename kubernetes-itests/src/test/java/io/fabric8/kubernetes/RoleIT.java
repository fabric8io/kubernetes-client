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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.DeleteEntity;
import io.fabric8.kubernetes.api.model.rbac.Role;
import io.fabric8.kubernetes.api.model.rbac.RoleBuilder;
import io.fabric8.kubernetes.api.model.rbac.RoleList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class RoleIT {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private String currentNamespace;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(RoleIT.class.getResourceAsStream("/role-it.yml"));
  }

  @Before
  public void initNamespace() {
    this.currentNamespace = session.getNamespace();
  }

  @Test
  public void get() {

    Role role = client.rbac().roles().inNamespace(currentNamespace).withName("role-get").get();

    assertNotNull(role);
    assertEquals("Role", role.getKind());
    assertNotNull(role.getMetadata());
    assertEquals("role-get", role.getMetadata().getName());
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
    assertTrue(roleList.getItems().size() >= 1);
    Optional<Role> role = roleList.getItems().stream().filter(r -> r.getMetadata().getName().equals("role-list")).findFirst();
    assertTrue(role.isPresent());
    assertNotNull(role.get());
    assertEquals("Role", role.get().getKind());
    assertNotNull(role.get().getMetadata());
    assertEquals("role-list", role.get().getMetadata().getName());
    assertNotNull(role.get().getRules());
    assertEquals(1, role.get().getRules().size());
    assertNotNull(role.get().getRules().get(0).getApiGroups());
    assertEquals(1, role.get().getRules().get(0).getApiGroups().size());
    assertEquals("batch", role.get().getRules().get(0).getApiGroups().get(0));
    assertNotNull(role.get().getRules().get(0).getResourceNames());
    assertEquals(1, role.get().getRules().get(0).getResourceNames().size());
    assertEquals("my-job", role.get().getRules().get(0).getResourceNames().get(0));
    assertNotNull(role.get().getRules().get(0).getResources());
    assertEquals(1, role.get().getRules().get(0).getResources().size());
    assertEquals("jobs", role.get().getRules().get(0).getResources().get(0));
    assertNotNull(role.get().getRules().get(0).getVerbs());
    assertEquals(3, role.get().getRules().get(0).getVerbs().size());
    assertEquals("get", role.get().getRules().get(0).getVerbs().get(0));
    assertEquals("watch", role.get().getRules().get(0).getVerbs().get(1));
    assertEquals("list", role.get().getRules().get(0).getVerbs().get(2));

  }

  @Test
  public void update() {

    Role role = client.rbac().roles().inNamespace(currentNamespace).withName("role-update").edit(r -> new RoleBuilder(r)
                 .editRule(0).addToApiGroups(1, "extensions").endRule().build());

    assertNotNull(role);
    assertEquals("Role", role.getKind());
    assertNotNull(role.getMetadata());
    assertEquals("role-update", role.getMetadata().getName());
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

    int countBeforeDeletion = client.rbac().roles().inNamespace(currentNamespace).list().getItems().size();
    boolean deleted = client.rbac().roles().inNamespace(currentNamespace).withName("role-delete").delete();

    assertTrue(deleted);

    DeleteEntity<Role> deleteEntity = new DeleteEntity<>(Role.class, client, "role-delete", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);

    RoleList roleList = client.rbac().roles().inNamespace(currentNamespace).list();
    assertEquals(countBeforeDeletion - 1,roleList.getItems().size());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(RoleIT.class.getResourceAsStream("/role-it.yml"));
  }
}
