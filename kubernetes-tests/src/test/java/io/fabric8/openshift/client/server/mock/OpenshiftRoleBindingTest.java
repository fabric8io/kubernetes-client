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
package io.fabric8.openshift.client.server.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.RoleBindingBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableOpenShiftMockClient
class OpenshiftRoleBindingTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  private RoleBinding expectedRoleBinding = new RoleBindingBuilder()
      .withNewMetadata()
      .endMetadata()
      .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
      .addToGroupNames("testgroup")
      .addNewSubject()
      .withKind("User")
      .withName("testuser1")
      .endSubject()
      .addNewSubject()
      .withKind("User")
      .withName("testuser2")
      .endSubject()
      .addNewSubject()
      .withKind("ServiceAccount")
      .withNamespace("test")
      .withName("svcacct")
      .endSubject()
      .addNewSubject()
      .withKind("Group")
      .withName("testgroup")
      .endSubject()
      .build();

  @Test
  void testCreateWithOnlySubjects() throws Exception {
    server.expect()
        .post()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings")
        .andReturn(201, expectedRoleBinding)
        .once();

    RoleBinding response = client.roleBindings()
        .create(
            new RoleBindingBuilder()
                .withNewMetadata()
                .endMetadata()
                .addNewSubject()
                .withKind("User")
                .withName("testuser1")
                .endSubject()
                .addNewSubject()
                .withKind("User")
                .withName("testuser2")
                .endSubject()
                .addNewSubject()
                .withKind("ServiceAccount")
                .withName("svcacct")
                .endSubject()
                .addNewSubject()
                .withKind("Group")
                .withName("testgroup")
                .endSubject()
                .build());
    assertEquals(expectedRoleBinding, response);

    assertEquals(expectedRoleBinding,
        new ObjectMapper().readerFor(RoleBinding.class).readValue(server.getLastRequest().getBody().readByteArray()));
  }

  @Test
  void testCreateWithUserNamesAndGroupsAndNoSubjects() throws Exception {
    server.expect()
        .post()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings")
        .andReturn(201, expectedRoleBinding)
        .once();

    RoleBinding response = client.roleBindings()
        .create(
            new RoleBindingBuilder()
                .withNewMetadata()
                .endMetadata()
                .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
                .addToGroupNames("testgroup")
                .build());
    assertEquals(expectedRoleBinding, response);
    assertEquals(expectedRoleBinding,
        new ObjectMapper().readerFor(RoleBinding.class).readValue(server.getLastRequest().getBody().inputStream()));
  }

  @Test
  void testCreateWithUserNamesAndGroupsAndOverwriteSubjects() throws Exception {
    server.expect()
        .post()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings")
        .andReturn(201, expectedRoleBinding)
        .once();

    RoleBinding response = client.roleBindings()
        .create(
            new RoleBindingBuilder()
                .withNewMetadata()
                .endMetadata()
                .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
                .addToGroupNames("testgroup")
                .addNewSubject()
                .withKind("User")
                .withName("unexpected")
                .endSubject()
                .build());
    assertEquals(expectedRoleBinding, response);

    assertEquals(expectedRoleBinding,
        new ObjectMapper().readerFor(RoleBinding.class).readValue(server.getLastRequest().getBody().inputStream()));
  }

  @Test
  void testReplaceWithOnlySubjects() throws Exception {
    server.expect()
        .get()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb")
        .andReturn(200, expectedRoleBinding)
        .once();
    server.expect()
        .put()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb")
        .andReturn(200, expectedRoleBinding)
        .once();

    RoleBinding response = client.roleBindings()
        .withName("testrb")
        .replace(
            new RoleBindingBuilder()
                .withNewMetadata()
                .endMetadata()
                .addNewSubject()
                .withKind("User")
                .withName("testuser1")
                .endSubject()
                .addNewSubject()
                .withKind("User")
                .withName("testuser2")
                .endSubject()
                .addNewSubject()
                .withKind("ServiceAccount")
                .withName("svcacct")
                .endSubject()
                .addNewSubject()
                .withKind("Group")
                .withName("testgroup")
                .endSubject()
                .build());
    assertEquals(expectedRoleBinding, response);

    assertEquals(expectedRoleBinding,
        new ObjectMapper().readerFor(RoleBinding.class).readValue(server.getLastRequest().getBody().inputStream()));
  }

  @Test
  void testReplaceWithUserNamesAndGroupsAndNoSubjects() throws Exception {
    server.expect()
        .get()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb")
        .andReturn(200, expectedRoleBinding)
        .once();
    server.expect()
        .put()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb")
        .andReturn(200, expectedRoleBinding)
        .once();

    RoleBinding response = client.roleBindings()
        .withName("testrb")
        .replace(
            new RoleBindingBuilder()
                .withNewMetadata()
                .endMetadata()
                .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
                .addToGroupNames("testgroup")
                .build());
    assertEquals(expectedRoleBinding, response);

    assertEquals(expectedRoleBinding,
        new ObjectMapper().readerFor(RoleBinding.class).readValue(server.getLastRequest().getBody().inputStream()));
  }

  @Test
  void testReplaceWithUserNamesAndGroupsAndOverwriteSubjects() throws Exception {
    server.expect()
        .get()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb")
        .andReturn(200, expectedRoleBinding)
        .once();
    server.expect()
        .put()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb")
        .andReturn(200, expectedRoleBinding)
        .once();

    RoleBinding response = client.roleBindings()
        .withName("testrb")
        .replace(
            new RoleBindingBuilder()
                .withNewMetadata()
                .endMetadata()
                .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
                .addToGroupNames("testgroup")
                .addNewSubject()
                .withKind("User")
                .withName("unexpected")
                .endSubject()
                .build());
    assertEquals(expectedRoleBinding, response);

    assertEquals(expectedRoleBinding,
        new ObjectMapper().readerFor(RoleBinding.class).readValue(server.getLastRequest().getBody().inputStream()));
  }

  @Test
  void testPatchWithOnlySubjects() throws Exception {
    server.expect()
        .get()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb")
        .andReturn(200, new RoleBindingBuilder().addToUserNames("unexpected").build())
        .once();
    server.expect()
        .patch()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb")
        .andReturn(200, expectedRoleBinding)
        .once();

    RoleBinding response = client.roleBindings()
        .withName("testrb")
        .patch(
            new RoleBindingBuilder()
                .withNewMetadata()
                .endMetadata()
                .addNewSubject()
                .withKind("User")
                .withName("testuser1")
                .endSubject()
                .addNewSubject()
                .withKind("User")
                .withName("testuser2")
                .endSubject()
                .addNewSubject()
                .withKind("ServiceAccount")
                .withName("svcacct")
                .endSubject()
                .addNewSubject()
                .withKind("Group")
                .withName("testgroup")
                .endSubject()
                .build());
    assertEquals(expectedRoleBinding, response);

    assertEquals(
        "[{\"op\":\"replace\",\"path\":\"/userNames/0\",\"value\":\"testuser1\"},{\"op\":\"add\",\"path\":\"/userNames/1\",\"value\":\"testuser2\"},{\"op\":\"add\",\"path\":\"/userNames/2\",\"value\":\"system:serviceaccount:test:svcacct\"},{\"op\":\"add\",\"path\":\"/metadata\",\"value\":{}},{\"op\":\"add\",\"path\":\"/groupNames\",\"value\":[\"testgroup\"]},{\"op\":\"add\",\"path\":\"/subjects\",\"value\":[{\"kind\":\"User\",\"name\":\"testuser1\"},{\"kind\":\"User\",\"name\":\"testuser2\"},{\"kind\":\"ServiceAccount\",\"name\":\"svcacct\",\"namespace\":\"test\"},{\"kind\":\"Group\",\"name\":\"testgroup\"}]}]",
        server.getLastRequest().getBody().readUtf8());
  }

  @Test
  void testPatchWithUserNamesAndGroupsAndNoSubjects() throws Exception {
    server.expect()
        .get()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb")
        .andReturn(200, new RoleBindingBuilder().addToUserNames("unexpected").build())
        .once();
    server.expect()
        .patch()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb")
        .andReturn(200, expectedRoleBinding)
        .once();

    RoleBinding response = client.roleBindings()
        .withName("testrb")
        .patch(
            new RoleBindingBuilder()
                .withNewMetadata()
                .endMetadata()
                .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
                .addToGroupNames("testgroup")
                .build());
    assertEquals(expectedRoleBinding, response);

    assertEquals(
        "[{\"op\":\"replace\",\"path\":\"/userNames/0\",\"value\":\"testuser1\"},{\"op\":\"add\",\"path\":\"/userNames/1\",\"value\":\"testuser2\"},{\"op\":\"add\",\"path\":\"/userNames/2\",\"value\":\"system:serviceaccount:test:svcacct\"},{\"op\":\"add\",\"path\":\"/metadata\",\"value\":{}},{\"op\":\"add\",\"path\":\"/groupNames\",\"value\":[\"testgroup\"]},{\"op\":\"add\",\"path\":\"/subjects\",\"value\":[{\"kind\":\"User\",\"name\":\"testuser1\"},{\"kind\":\"User\",\"name\":\"testuser2\"},{\"kind\":\"ServiceAccount\",\"name\":\"svcacct\",\"namespace\":\"test\"},{\"kind\":\"Group\",\"name\":\"testgroup\"}]}]",
        server.getLastRequest().getBody().readUtf8());
  }

  @Test
  void testPatchWithUserNamesAndGroupsAndOverwriteSubjects() throws Exception {
    server.expect()
        .get()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb")
        .andReturn(200, new RoleBindingBuilder().addToUserNames("unexpected").build())
        .once();
    server.expect()
        .patch()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb")
        .andReturn(200, expectedRoleBinding)
        .once();

    RoleBinding response = client.roleBindings()
        .withName("testrb")
        .patch(
            new RoleBindingBuilder()
                .withNewMetadata()
                .endMetadata()
                .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
                .addToGroupNames("testgroup")
                .addNewSubject()
                .withKind("User")
                .withName("unexpected")
                .endSubject()
                .build());
    assertEquals(expectedRoleBinding, response);

    assertEquals(
        "[{\"op\":\"replace\",\"path\":\"/userNames/0\",\"value\":\"testuser1\"},{\"op\":\"add\",\"path\":\"/userNames/1\",\"value\":\"testuser2\"},{\"op\":\"add\",\"path\":\"/userNames/2\",\"value\":\"system:serviceaccount:test:svcacct\"},{\"op\":\"add\",\"path\":\"/metadata\",\"value\":{}},{\"op\":\"add\",\"path\":\"/groupNames\",\"value\":[\"testgroup\"]},{\"op\":\"add\",\"path\":\"/subjects\",\"value\":[{\"kind\":\"User\",\"name\":\"testuser1\"},{\"kind\":\"User\",\"name\":\"testuser2\"},{\"kind\":\"ServiceAccount\",\"name\":\"svcacct\",\"namespace\":\"test\"},{\"kind\":\"Group\",\"name\":\"testgroup\"}]}]",
        server.getLastRequest().getBody().readUtf8());
  }

  @Test
  void testCreateInline() throws Exception {
    server.expect()
        .post()
        .withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings")
        .andReturn(201, expectedRoleBinding)
        .once();

    RoleBinding response = client.roleBindings()
        .create(new RoleBindingBuilder()
            .withNewMetadata()
            .endMetadata()
            .addNewSubject()
            .withKind("User")
            .withName("testuser1")
            .endSubject()
            .addNewSubject()
            .withKind("User")
            .withName("testuser2")
            .endSubject()
            .addNewSubject()
            .withKind("ServiceAccount")
            .withName("svcacct")
            .endSubject()
            .addNewSubject()
            .withKind("Group")
            .withName("testgroup")
            .endSubject()
            .build());
    assertEquals(expectedRoleBinding, response);
    assertEquals(expectedRoleBinding,
        new ObjectMapper().readerFor(RoleBinding.class).readValue(server.getLastRequest().getBody().inputStream()));
  }

}
