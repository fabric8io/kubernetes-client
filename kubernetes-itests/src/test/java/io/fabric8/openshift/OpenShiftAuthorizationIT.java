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

import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.api.model.Namespace;
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
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(RoleBindingRestriction.class)
class OpenShiftAuthorizationIT {

  OpenShiftClient client;

  Namespace namespace;

  @Test
  void createSubjectAccessReviewOpenShift() {
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
  void createSubjectRulesReviewOpenShift() {
    // Given
    String user = client.currentUser().getMetadata().getName();
    SubjectRulesReview srr = new SubjectRulesReviewBuilder()
        .withNewSpec()
        .withUser(user)
        .endSpec()
        .build();

    // When
    SubjectRulesReview createdSrr = client.subjectRulesReviews().inNamespace(namespace.getMetadata().getName()).create(srr);

    // Then
    assertNotNull(createdSrr);
    assertNotNull(createdSrr.getStatus());
    assertFalse(createdSrr.getStatus().getRules().isEmpty());
  }

  @Test
  void createSelfSubjectRulesReview() {
    // Given
    SelfSubjectRulesReview ssrr = new SelfSubjectRulesReviewBuilder().build();

    // When
    SelfSubjectRulesReview createdSsrr = client.selfSubjectRulesReviews().inNamespace(namespace.getMetadata().getName())
        .create(ssrr);

    // Then
    assertNotNull(createdSsrr);
    assertNotNull(createdSsrr.getStatus());
    assertFalse(createdSsrr.getStatus().getRules().isEmpty());
  }

  @Test
  void createLocalResourceAccessReview() {
    // Given
    LocalResourceAccessReview lrar = new LocalResourceAccessReviewBuilder()
        .withVerb("create")
        .withResource("configmaps")
        .build();

    // When
    ResourceAccessReviewResponse rarr = client.localResourceAccessReviews().inNamespace(namespace.getMetadata().getName())
        .create(lrar);

    // Then
    assertNotNull(rarr);
    assertFalse(rarr.getUsers().isEmpty());
    assertFalse(rarr.getGroups().isEmpty());
  }

  @Test
  void createLocalSubjectAccessReview() {
    // Given
    LocalSubjectAccessReview localSubjectAccessReview = new LocalSubjectAccessReviewBuilder()
        .withNamespace(namespace.getMetadata().getName())
        .withVerb("get")
        .withResource("pods")
        .build();

    // When
    SubjectAccessReviewResponse response = client.localSubjectAccessReviews().inNamespace(namespace.getMetadata().getName())
        .create(localSubjectAccessReview);

    // Then
    assertNotNull(response);
    assertTrue(response.getAllowed());
  }

  @Test
  void createResourceAccessReview() {
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
  void createRoleBindingRestriction() {
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
    RoleBindingRestriction createdRoleBindingRestriction = client.roleBindingRestrictions().create(roleBindingRestriction);

    // Then
    assertNotNull(createdRoleBindingRestriction);
    assertNotNull(createdRoleBindingRestriction.getMetadata().getUid());
    client.roleBindingRestrictions().withName(name).delete();
  }
}
