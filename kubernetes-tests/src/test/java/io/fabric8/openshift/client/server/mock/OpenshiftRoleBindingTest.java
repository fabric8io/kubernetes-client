/**
 * Copyright (C) 2015 Fabric8 Authors.
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
import io.fabric8.openshift.api.model.OpenshiftRoleBinding;
import io.fabric8.openshift.api.model.OpenshiftRoleBindingBuilder;
import io.fabric8.openshift.client.NamespacedOpenShiftClient;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableRuleMigrationSupport
public class OpenshiftRoleBindingTest {
  @Rule
  public OpenShiftServer server = new OpenShiftServer();

  private OpenshiftRoleBinding expectedOpenshiftRoleBinding = new OpenshiftRoleBindingBuilder()
    .withNewMetadata().endMetadata()
    .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
    .addToGroupNames("testgroup")
    .addNewSubject().withKind("User").withName("testuser1").endSubject()
    .addNewSubject().withKind("User").withName("testuser2").endSubject()
    .addNewSubject().withKind("ServiceAccount").withNamespace("test").withName("svcacct").endSubject()
    .addNewSubject().withKind("Group").withName("testgroup").endSubject()
    .build();

  @Test
  public void testCreateWithOnlySubjects() throws Exception {
    server.expect().post().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings").andReturn(201, expectedOpenshiftRoleBinding).once();

    NamespacedOpenShiftClient client = server.getOpenshiftClient();

    OpenshiftRoleBinding response = client.roleBindings().create(
      new OpenshiftRoleBindingBuilder()
        .withNewMetadata().endMetadata()
        .addNewSubject().withKind("User").withName("testuser1").endSubject()
        .addNewSubject().withKind("User").withName("testuser2").endSubject()
        .addNewSubject().withKind("ServiceAccount").withName("svcacct").endSubject()
        .addNewSubject().withKind("Group").withName("testgroup").endSubject()
      .build()
    );
    assertEquals(expectedOpenshiftRoleBinding, response);

    RecordedRequest request = server.getLastRequest();
    assertEquals(expectedOpenshiftRoleBinding, new ObjectMapper().readerFor(OpenshiftRoleBinding.class).readValue(request.getBody().readByteArray()));
  }

  @Test
  public void testCreateWithUserNamesAndGroupsAndNoSubjects() throws Exception {
    server.expect().post().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings").andReturn(201, expectedOpenshiftRoleBinding).once();

    NamespacedOpenShiftClient client = server.getOpenshiftClient();

    OpenshiftRoleBinding response = client.roleBindings().create(
      new OpenshiftRoleBindingBuilder()
        .withNewMetadata().endMetadata()
        .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
        .addToGroupNames("testgroup")
      .build()
    );
    assertEquals(expectedOpenshiftRoleBinding, response);

    RecordedRequest request = server.getLastRequest();
    assertEquals(expectedOpenshiftRoleBinding, new ObjectMapper().readerFor(OpenshiftRoleBinding.class).readValue(request.getBody().inputStream()));
  }

  @Test
  public void testCreateWithUserNamesAndGroupsAndOverwriteSubjects() throws Exception {
    server.expect().post().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings").andReturn(201, expectedOpenshiftRoleBinding).once();

    NamespacedOpenShiftClient client = server.getOpenshiftClient();

    OpenshiftRoleBinding response = client.roleBindings().create(
      new OpenshiftRoleBindingBuilder()
        .withNewMetadata().endMetadata()
        .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
        .addToGroupNames("testgroup")
        .addNewSubject().withKind("User").withName("unexpected").endSubject()
      .build()
    );
    assertEquals(expectedOpenshiftRoleBinding, response);

    RecordedRequest request = server.getLastRequest();
    assertEquals(expectedOpenshiftRoleBinding, new ObjectMapper().readerFor(OpenshiftRoleBinding.class).readValue(request.getBody().inputStream()));
  }

  @Test
  public void testReplaceWithOnlySubjects() throws Exception {
    server.expect().get().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb").andReturn(200, expectedOpenshiftRoleBinding).once();
    server.expect().put().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb").andReturn(200, expectedOpenshiftRoleBinding).once();

    NamespacedOpenShiftClient client = server.getOpenshiftClient();

    OpenshiftRoleBinding response = client.roleBindings().withName("testrb").replace(
      new OpenshiftRoleBindingBuilder()
        .withNewMetadata().endMetadata()
        .addNewSubject().withKind("User").withName("testuser1").endSubject()
        .addNewSubject().withKind("User").withName("testuser2").endSubject()
        .addNewSubject().withKind("ServiceAccount").withName("svcacct").endSubject()
        .addNewSubject().withKind("Group").withName("testgroup").endSubject()
        .build()
    );
    assertEquals(expectedOpenshiftRoleBinding, response);

    RecordedRequest request = server.getLastRequest();
    assertEquals(expectedOpenshiftRoleBinding, new ObjectMapper().readerFor(OpenshiftRoleBinding.class).readValue(request.getBody().inputStream()));
  }

  @Test
  public void testReplaceWithUserNamesAndGroupsAndNoSubjects() throws Exception {
    server.expect().get().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb").andReturn(200, expectedOpenshiftRoleBinding).once();
    server.expect().put().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb").andReturn(200, expectedOpenshiftRoleBinding).once();

    NamespacedOpenShiftClient client = server.getOpenshiftClient();

    OpenshiftRoleBinding response = client.roleBindings().withName("testrb").replace(
      new OpenshiftRoleBindingBuilder()
        .withNewMetadata().endMetadata()
        .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
        .addToGroupNames("testgroup")
        .build()
    );
    assertEquals(expectedOpenshiftRoleBinding, response);


    RecordedRequest request = server.getLastRequest();
    assertEquals(expectedOpenshiftRoleBinding, new ObjectMapper().readerFor(OpenshiftRoleBinding.class).readValue(request.getBody().inputStream()));
  }

  @Test
  public void testReplaceWithUserNamesAndGroupsAndOverwriteSubjects() throws Exception {
    server.expect().get().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb").andReturn(200, expectedOpenshiftRoleBinding).once();
    server.expect().put().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb").andReturn(200, expectedOpenshiftRoleBinding).once();

    NamespacedOpenShiftClient client = server.getOpenshiftClient();

    OpenshiftRoleBinding response = client.roleBindings().withName("testrb").replace(
      new OpenshiftRoleBindingBuilder()
        .withNewMetadata().endMetadata()
        .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
        .addToGroupNames("testgroup")
        .addNewSubject().withKind("User").withName("unexpected").endSubject()
      .build()
    );
    assertEquals(expectedOpenshiftRoleBinding, response);

    RecordedRequest request = server.getLastRequest();
    assertEquals(expectedOpenshiftRoleBinding, new ObjectMapper().readerFor(OpenshiftRoleBinding.class).readValue(request.getBody().inputStream()));
  }

  @Test
  public void testPatchWithOnlySubjects() throws Exception {
    server.expect().get().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb").andReturn(200, new OpenshiftRoleBindingBuilder().addToUserNames("unexpected").build()).once();
    server.expect().patch().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb").andReturn(200, expectedOpenshiftRoleBinding).once();

    NamespacedOpenShiftClient client = server.getOpenshiftClient();

    OpenshiftRoleBinding response = client.roleBindings().withName("testrb").patch(
      new OpenshiftRoleBindingBuilder()
        .withNewMetadata().endMetadata()
        .addNewSubject().withKind("User").withName("testuser1").endSubject()
        .addNewSubject().withKind("User").withName("testuser2").endSubject()
        .addNewSubject().withKind("ServiceAccount").withName("svcacct").endSubject()
        .addNewSubject().withKind("Group").withName("testgroup").endSubject()
        .build()
    );
    assertEquals(expectedOpenshiftRoleBinding, response);

    RecordedRequest request = server.getLastRequest();
    assertEquals(
      "[{\"op\":\"replace\",\"path\":\"/userNames/0\",\"value\":\"testuser1\"},{\"op\":\"add\",\"path\":\"/userNames/1\",\"value\":\"testuser2\"},{\"op\":\"add\",\"path\":\"/userNames/2\",\"value\":\"system:serviceaccount:test:svcacct\"},{\"op\":\"add\",\"path\":\"/metadata\",\"value\":{}},{\"op\":\"add\",\"path\":\"/groupNames\",\"value\":[\"testgroup\"]},{\"op\":\"add\",\"path\":\"/subjects\",\"value\":[{\"kind\":\"User\",\"name\":\"testuser1\"},{\"kind\":\"User\",\"name\":\"testuser2\"},{\"kind\":\"ServiceAccount\",\"name\":\"svcacct\",\"namespace\":\"test\"},{\"kind\":\"Group\",\"name\":\"testgroup\"}]}]",
      request.getBody().readUtf8()
    );
  }

  @Test
  public void testPatchWithUserNamesAndGroupsAndNoSubjects() throws Exception {
    server.expect().get().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb").andReturn(200, new OpenshiftRoleBindingBuilder().addToUserNames("unexpected").build()).once();
    server.expect().patch().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb").andReturn(200, expectedOpenshiftRoleBinding).once();

    NamespacedOpenShiftClient client = server.getOpenshiftClient();

    OpenshiftRoleBinding response = client.roleBindings().withName("testrb").patch(
      new OpenshiftRoleBindingBuilder()
        .withNewMetadata().endMetadata()
        .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
        .addToGroupNames("testgroup")
        .build()
    );
    assertEquals(expectedOpenshiftRoleBinding, response);

    RecordedRequest request = server.getLastRequest();
    assertEquals(
      "[{\"op\":\"replace\",\"path\":\"/userNames/0\",\"value\":\"testuser1\"},{\"op\":\"add\",\"path\":\"/userNames/1\",\"value\":\"testuser2\"},{\"op\":\"add\",\"path\":\"/userNames/2\",\"value\":\"system:serviceaccount:test:svcacct\"},{\"op\":\"add\",\"path\":\"/metadata\",\"value\":{}},{\"op\":\"add\",\"path\":\"/groupNames\",\"value\":[\"testgroup\"]},{\"op\":\"add\",\"path\":\"/subjects\",\"value\":[{\"kind\":\"User\",\"name\":\"testuser1\"},{\"kind\":\"User\",\"name\":\"testuser2\"},{\"kind\":\"ServiceAccount\",\"name\":\"svcacct\",\"namespace\":\"test\"},{\"kind\":\"Group\",\"name\":\"testgroup\"}]}]",
      request.getBody().readUtf8()
    );
  }

  @Test
  public void testPatchWithUserNamesAndGroupsAndOverwriteSubjects() throws Exception {
    server.expect().get().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb").andReturn(200, new OpenshiftRoleBindingBuilder().addToUserNames("unexpected").build()).once();
    server.expect().patch().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings/testrb").andReturn(200, expectedOpenshiftRoleBinding).once();

    NamespacedOpenShiftClient client = server.getOpenshiftClient();

    OpenshiftRoleBinding response = client.roleBindings().withName("testrb").patch(
      new OpenshiftRoleBindingBuilder()
        .withNewMetadata().endMetadata()
        .addToUserNames("testuser1", "testuser2", "system:serviceaccount:test:svcacct")
        .addToGroupNames("testgroup")
        .addNewSubject().withKind("User").withName("unexpected").endSubject()
      .build()
    );
    assertEquals(expectedOpenshiftRoleBinding, response);

    RecordedRequest request = server.getLastRequest();
    assertEquals(
      "[{\"op\":\"replace\",\"path\":\"/userNames/0\",\"value\":\"testuser1\"},{\"op\":\"add\",\"path\":\"/userNames/1\",\"value\":\"testuser2\"},{\"op\":\"add\",\"path\":\"/userNames/2\",\"value\":\"system:serviceaccount:test:svcacct\"},{\"op\":\"add\",\"path\":\"/metadata\",\"value\":{}},{\"op\":\"add\",\"path\":\"/groupNames\",\"value\":[\"testgroup\"]},{\"op\":\"add\",\"path\":\"/subjects\",\"value\":[{\"kind\":\"User\",\"name\":\"testuser1\"},{\"kind\":\"User\",\"name\":\"testuser2\"},{\"kind\":\"ServiceAccount\",\"name\":\"svcacct\",\"namespace\":\"test\"},{\"kind\":\"Group\",\"name\":\"testgroup\"}]}]",
      request.getBody().readUtf8()
    );
  }

  @Test
  public void testCreateInline() throws Exception {
    server.expect().post().withPath("/apis/authorization.openshift.io/v1/namespaces/test/rolebindings").andReturn(201, expectedOpenshiftRoleBinding).once();

    NamespacedOpenShiftClient client = server.getOpenshiftClient();

    OpenshiftRoleBinding response = client.roleBindings().createNew()
      .withNewMetadata().endMetadata()
      .addNewSubject().withKind("User").withName("testuser1").endSubject()
      .addNewSubject().withKind("User").withName("testuser2").endSubject()
      .addNewSubject().withKind("ServiceAccount").withName("svcacct").endSubject()
      .addNewSubject().withKind("Group").withName("testgroup").endSubject()
      .done();
    assertEquals(expectedOpenshiftRoleBinding, response);

    RecordedRequest request = server.getLastRequest();
    assertEquals(expectedOpenshiftRoleBinding, new ObjectMapper().readerFor(OpenshiftRoleBinding.class).readValue(request.getBody().inputStream()));
  }

}
