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
package io.fabric8.openshift;

import io.fabric8.openshift.api.model.LocalResourceAccessReview;
import io.fabric8.openshift.api.model.LocalResourceAccessReviewBuilder;
import io.fabric8.openshift.api.model.LocalSubjectAccessReview;
import io.fabric8.openshift.api.model.LocalSubjectAccessReviewBuilder;
import io.fabric8.openshift.api.model.ResourceAccessReview;
import io.fabric8.openshift.api.model.ResourceAccessReviewBuilder;
import io.fabric8.openshift.api.model.ResourceAccessReviewResponse;
import io.fabric8.openshift.api.model.RoleBindingRestriction;
import io.fabric8.openshift.api.model.RoleBindingRestrictionBuilder;
import io.fabric8.openshift.api.model.SelfSubjectRulesReview;
import io.fabric8.openshift.api.model.SelfSubjectRulesReviewBuilder;
import io.fabric8.openshift.api.model.SubjectAccessReview;
import io.fabric8.openshift.api.model.SubjectAccessReviewBuilder;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponse;
import io.fabric8.openshift.api.model.SubjectRulesReview;
import io.fabric8.openshift.api.model.SubjectRulesReviewBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class OpenShiftAuthorizationIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  @Before
  public void initialCallToInitializeToken() {
    client.pods().inNamespace(session.getNamespace()).list();
  }

  @Test
  public void createSubjectAccessReviewOpenShift() {
    // Given
    SubjectAccessReview sar = new SubjectAccessReviewBuilder()
      .withResource("pod")
      .withVerb("get")
      .build();

    // When
    SubjectAccessReviewResponse sarResponse = client.subjectAccessReviews().create(sar);

    // Then
    assertNotNull(sarResponse);
    assertTrue(sarResponse.getAllowed());
  }

  @Test
  public void createSubjectRulesReviewOpenShift() {
    // Given
    String user = client.currentUser().getMetadata().getName();
    SubjectRulesReview srr = new SubjectRulesReviewBuilder()
      .withNewSpec()
      .withUser(user)
      .endSpec()
      .build();

    // When
    SubjectRulesReview createdSrr = client.subjectRulesReviews().inNamespace(session.getNamespace()).create(srr);

    // Then
    assertNotNull(createdSrr);
    assertNotNull(createdSrr.getStatus());
    assertFalse(createdSrr.getStatus().getRules().isEmpty());
  }

  @Test
  public void createSelfSubjectRulesReview() {
    // Given
    SelfSubjectRulesReview ssrr = new SelfSubjectRulesReviewBuilder().build();

    // When
    SelfSubjectRulesReview createdSsrr = client.selfSubjectRulesReviews().inNamespace(session.getNamespace()).create(ssrr);

    // Then
    assertNotNull(createdSsrr);
    assertNotNull(createdSsrr.getStatus());
    assertFalse(createdSsrr.getStatus().getRules().isEmpty());
  }

  @Test
  public void createLocalResourceAccessReview() {
    // Given
    LocalResourceAccessReview lrar = new LocalResourceAccessReviewBuilder()
      .withVerb("create")
      .withResource("configmaps")
      .build();

    // When
    ResourceAccessReviewResponse rarr = client.localResourceAccessReviews().inNamespace(session.getNamespace()).create(lrar);

    // Then
    assertNotNull(rarr);
    assertFalse(rarr.getUsers().isEmpty());
    assertFalse(rarr.getGroups().isEmpty());
  }

  @Test
  public void createLocalSubjectAccessReview() {
    // Given
    LocalSubjectAccessReview localSubjectAccessReview = new LocalSubjectAccessReviewBuilder()
      .withNamespace(session.getNamespace())
      .withVerb("get")
      .withResource("pods")
      .build();

    // When
    SubjectAccessReviewResponse response = client.localSubjectAccessReviews().inNamespace(session.getNamespace()).create(localSubjectAccessReview);

    // Then
    assertNotNull(response);
    assertTrue(response.getAllowed());
  }

  @Test
  public void createResourceAccessReview() {
    // Given
    ResourceAccessReview rar = new ResourceAccessReviewBuilder()
      .withVerb("create")
      .withResource("configmaps")
      .build();

    // When
    ResourceAccessReviewResponse rarr = client.resourceAccessReviews().create(rar);

    // Then
    assertNotNull(rarr);
    assertFalse(rarr.getUsers().isEmpty());
    assertFalse(rarr.getGroups().isEmpty());
  }

  @Test
  public void createRoleBindingRestriction() {
    // Given
    String name = "create-oc-rolebindingrestriction";
    RoleBindingRestriction roleBindingRestriction = new RoleBindingRestrictionBuilder()
      .withNewMetadata().withName(name).endMetadata()
      .withNewSpec()
      .withNewGrouprestriction()
      .addToGroups("groups-rolebindingrestriction")
      .endGrouprestriction()
      .endSpec()
      .build();

    // When
    RoleBindingRestriction createdRoleBindingRestriction = client.roleBindingRestrictions().inNamespace(session.getNamespace()).create(roleBindingRestriction);

    // Then
    assertNotNull(createdRoleBindingRestriction);
    assertNotNull(createdRoleBindingRestriction.getMetadata().getUid());
    client.roleBindingRestrictions().inNamespace(session.getNamespace()).withName(name).delete();
  }
}
