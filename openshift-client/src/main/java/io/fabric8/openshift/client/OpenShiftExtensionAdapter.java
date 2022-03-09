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

package io.fabric8.openshift.client;

import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.ClusterRoleBinding;
import io.fabric8.openshift.api.model.DNS;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.Role;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1.NetworkAttachmentDefinition;
import io.fabric8.openshift.client.dsl.internal.apps.DeploymentConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.authorization.ClusterRoleBindingOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.authorization.RoleBindingOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.authorization.RoleOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.build.BuildConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.build.BuildOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.DNSOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.core.NetworkAttachmentDefinitionOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.core.TemplateOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.oauth.OAuthAccessTokenOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.oauth.OAuthAuthorizeTokenOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.oauth.OAuthClientOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.project.ProjectOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.security.SecurityContextConstraintsOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.user.GroupOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.user.UserOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service
public class OpenShiftExtensionAdapter extends OpenshiftAdapterSupport<OpenShiftClient> {

  static {
    OpenShiftHandlers.register(BuildConfig.class, BuildConfigOperationsImpl::new);
    OpenShiftHandlers.register(Build.class, BuildOperationsImpl::new);
    OpenShiftHandlers.register(ClusterRoleBinding.class, ClusterRoleBindingOperationsImpl::new);
    OpenShiftHandlers.register(DeploymentConfig.class, DeploymentConfigOperationsImpl::new);
    OpenShiftHandlers.register(DNS.class, DNSOperationsImpl::new);
    OpenShiftHandlers.register(Group.class, GroupOperationsImpl::new);
    OpenShiftHandlers.register(NetworkAttachmentDefinition.class, NetworkAttachmentDefinitionOperationsImpl::new);
    OpenShiftHandlers.register(OAuthAccessToken.class, OAuthAccessTokenOperationsImpl::new);
    OpenShiftHandlers.register(OAuthAuthorizeToken.class, OAuthAuthorizeTokenOperationsImpl::new);
    OpenShiftHandlers.register(OAuthClient.class, OAuthClientOperationsImpl::new);
    OpenShiftHandlers.register(RoleBinding.class, RoleBindingOperationsImpl::new);
    OpenShiftHandlers.register(Role.class, RoleOperationsImpl::new);
    OpenShiftHandlers.register(SecurityContextConstraints.class, SecurityContextConstraintsOperationsImpl::new);
    OpenShiftHandlers.register(Template.class, TemplateOperationsImpl::new);
    OpenShiftHandlers.register(User.class, UserOperationsImpl::new);
    OpenShiftHandlers.register(Project.class, ProjectOperationsImpl::new);
  }

  @Override
  public Class<OpenShiftClient> getExtensionType() {
    return OpenShiftClient.class;
  }

}
