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

import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.api.model.rbac.ClusterRole;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBinding;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingBuilder;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBuilder;
import io.fabric8.kubernetes.api.model.rbac.PolicyRuleBuilder;
import io.fabric8.kubernetes.api.model.rbac.RoleRefBuilder;
import io.fabric8.kubernetes.api.model.rbac.SubjectBuilder;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.api.model.ProjectRequestBuilder;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class UserImpersonationIT {

  private static final String SERVICE_ACCOUNT = "serviceaccount1";
  private static final String NEW_PROJECT = "impersonation" + System.nanoTime();

  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  private ServiceAccount serviceAccount1;
  private ClusterRole impersonatorRole;
  private ClusterRoleBinding impersonatorRoleBinding;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    // Create impersonator cluster role
    impersonatorRole = new ClusterRoleBuilder()
      .withNewMetadata()
      .withName("impersonator")
      .endMetadata()
      .addToRules(new PolicyRuleBuilder()
        .addToApiGroups("")
        .addToResources("users", "groups", "userextras", "serviceaccounts")
        .addToVerbs("impersonate")
        .build()
      )
      .build();
    client.rbac().clusterRoles().createOrReplace(impersonatorRole);

    // Create Service Account
    serviceAccount1 = new ServiceAccountBuilder()
      .withNewMetadata().withName(SERVICE_ACCOUNT).endMetadata()
      .build();
    client.serviceAccounts().inNamespace(currentNamespace).create(serviceAccount1);

    // Bind Impersonator Role to current user
    impersonatorRoleBinding = new ClusterRoleBindingBuilder()
      .withNewMetadata()
      .withName("impersonate-role")
      .endMetadata()
      .addToSubjects(new SubjectBuilder()
        .withApiGroup("rbac.authorization.k8s.io")
        .withKind("User")
        .withName(client.currentUser().getMetadata().getName())
        .withNamespace(currentNamespace)
        .build()
      )
      .withRoleRef(new RoleRefBuilder()
        .withApiGroup("rbac.authorization.k8s.io")
        .withKind("ClusterRole")
        .withName("impersonator")
        .build()
      )
      .build();

    client.rbac().clusterRoleBindings().createOrReplace(impersonatorRoleBinding);
  }


  @Test
  public void should_be_able_to_return_service_account_name_when_impersonating_current_user() {
    RequestConfig requestConfig = new RequestConfigBuilder()
    .withImpersonateUsername(SERVICE_ACCOUNT)
    .withImpersonateGroups("system:authenticated", "system:authenticated:oauth")
    .withImpersonateExtras(Collections.singletonMap("scopes", Arrays.asList("cn=jane","ou=engineers","dc=example","dc=com"))).build();

    User user = client.withRequestConfig(requestConfig).call(OpenShiftClient::currentUser);
    assertThat(user.getMetadata().getName()).isEqualTo(SERVICE_ACCOUNT);
  }

  @Test
  public void should_be_able_to_create_a_project_impersonating_service_account() {
    RequestConfig requestConfig = new RequestConfigBuilder()
    .withImpersonateUsername(SERVICE_ACCOUNT)
    .withImpersonateGroups("system:authenticated", "system:authenticated:oauth")
    .withImpersonateExtras(Collections.singletonMap("scopes", Collections.singletonList("development")))
    .build();

    // Create a project
    ProjectRequest projectRequest = client.withRequestConfig(requestConfig).call(c -> c.projectrequests().create(new ProjectRequestBuilder()
      .withNewMetadata()
      .withName(NEW_PROJECT)
      .endMetadata()
      .build()));

    // Grab the requester annotation
    String requester = projectRequest.getMetadata().getAnnotations().get("openshift.io/requester");
    assertThat(requester).isEqualTo(SERVICE_ACCOUNT);
  }


  @After
  public void cleanup() {
    // Reset original authentication
    RequestConfig requestConfig = client.getConfiguration().getRequestConfig();
    requestConfig.setImpersonateUsername(null);
    requestConfig.setImpersonateGroups((String) null);

    // DeleteEntity Cluster Role
    client.rbac().clusterRoles().delete(impersonatorRole);
    await().atMost(30, TimeUnit.SECONDS).until(kubernetesClusterRoleIsDeleted());

    // DeleteEntity Cluster Role binding
    client.rbac().clusterRoleBindings().delete(impersonatorRoleBinding);
    await().atMost(30, TimeUnit.SECONDS).until(kubernetesClusterRoleBindingIsDeleted());

    // DeleteEntity project
    client.projects().withName(NEW_PROJECT).delete();
    await().atMost(30, TimeUnit.SECONDS).until(projectIsDeleted());

    // DeleteEntity ServiceAccounts
    client.serviceAccounts().inNamespace(currentNamespace).delete(serviceAccount1);
    await().atMost(30, TimeUnit.SECONDS).until(serviceAccountIsDeleted());
  }

  private Callable<Boolean> serviceAccountIsDeleted() {
    return () -> client.serviceAccounts().inNamespace(currentNamespace).withName(serviceAccount1.getMetadata().getName()).get() == null;
  }

  private Callable<Boolean> projectIsDeleted() {
    return () -> client.projects().withName(NEW_PROJECT).get() == null;
  }

  private Callable<Boolean> kubernetesClusterRoleBindingIsDeleted() {
    return () -> client.rbac().clusterRoleBindings().withName("impersonator-role").get() == null;
  }

  private Callable<Boolean> kubernetesClusterRoleIsDeleted() {
    return () -> client.rbac().clusterRoles().withName("impersonator").get() == null;
  }


}
