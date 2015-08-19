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

import io.fabric8.kubernetes.api.model.DoneableSecurityContextConstraints;
import io.fabric8.kubernetes.api.model.SecurityContextConstraints;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsList;
import io.fabric8.kubernetes.client.Extension;
import io.fabric8.kubernetes.client.dsl.BuildConfigClientResource;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ProcessableClientResource;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.DoneableBuild;
import io.fabric8.openshift.api.model.DoneableBuildConfig;
import io.fabric8.openshift.api.model.DoneableDeploymentConfig;
import io.fabric8.openshift.api.model.DoneableGroup;
import io.fabric8.openshift.api.model.DoneableImageStream;
import io.fabric8.openshift.api.model.DoneableOAuthAccessToken;
import io.fabric8.openshift.api.model.DoneableOAuthAuthorizeToken;
import io.fabric8.openshift.api.model.DoneableOAuthClient;
import io.fabric8.openshift.api.model.DoneablePolicy;
import io.fabric8.openshift.api.model.DoneablePolicyBinding;
import io.fabric8.openshift.api.model.DoneableRoute;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.DoneableUser;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamList;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessTokenList;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenList;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientList;
import io.fabric8.openshift.api.model.Policy;
import io.fabric8.openshift.api.model.PolicyBinding;
import io.fabric8.openshift.api.model.PolicyBindingList;
import io.fabric8.openshift.api.model.PolicyList;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserList;

import java.net.URL;

public interface OpenShiftClient extends Extension {

  URL getOpenshiftUrl();

  ClientOperation<OpenShiftClient, Build, BuildList, DoneableBuild, ClientResource<Build, DoneableBuild>> builds();

  ClientOperation<OpenShiftClient, BuildConfig, BuildConfigList, DoneableBuildConfig, BuildConfigClientResource<BuildConfig, DoneableBuildConfig, Void, Void>> buildConfigs();

  ClientOperation<OpenShiftClient, DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, ClientResource<DeploymentConfig, DoneableDeploymentConfig>> deploymentConfigs();

  ClientOperation<OpenShiftClient, Group, GroupList, DoneableGroup, ClientResource<Group, DoneableGroup>> groups();

  ClientOperation<OpenShiftClient, ImageStream, ImageStreamList, DoneableImageStream, ClientResource<ImageStream, DoneableImageStream>> imageStreams();

  ClientNonNamespaceOperation<OpenShiftClient, OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, ClientResource<OAuthAccessToken, DoneableOAuthAccessToken>> oAuthAccessTokens();

  ClientNonNamespaceOperation<OpenShiftClient, OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, ClientResource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken>> oAuthAuthorizeTokens();

  ClientNonNamespaceOperation<OpenShiftClient, OAuthClient, OAuthClientList, DoneableOAuthClient, ClientResource<OAuthClient, DoneableOAuthClient>> oAuthClients();

  ClientOperation<OpenShiftClient, Policy, PolicyList, DoneablePolicy, ClientResource<Policy, DoneablePolicy>> policies();

  ClientOperation<OpenShiftClient, PolicyBinding, PolicyBindingList, DoneablePolicyBinding, ClientResource<PolicyBinding, DoneablePolicyBinding>> policyBindings();

  ClientOperation<OpenShiftClient, Route, RouteList, DoneableRoute, ClientResource<Route, DoneableRoute>> routes();

  ClientNonNamespaceOperation<OpenShiftClient, SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, ClientResource<SecurityContextConstraints, DoneableSecurityContextConstraints>> securityContextConstraints();

  ClientOperation<OpenShiftClient, Template, TemplateList, DoneableTemplate, ProcessableClientResource<Template, DoneableTemplate>> templates();

  ClientOperation<OpenShiftClient, User, UserList, DoneableUser, ClientResource<User, DoneableUser>> users();

}
