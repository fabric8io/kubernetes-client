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

import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.openshift.client.dsl.BuildConfigClientResource;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
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
import io.fabric8.openshift.client.dsl.TemplateClientResource;
import io.fabric8.openshift.client.dsl.internal.BuildConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.BuildOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.DeploymentConfigOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.GroupOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ImageStreamOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OAuthAccessTokenOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OAuthAuthorizeTokenOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OAuthClientOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.PolicyBindingOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.PolicyOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.RouteOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.TemplateOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.UserOperationsImpl;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultOpenshiftClient extends DefaultKubernetesClient implements OpenShiftClient {

  private URL openShiftUrl;

  public DefaultOpenshiftClient() throws KubernetesClientException {
    this(new OpenshiftConfigBuilder().build());
  }

  public DefaultOpenshiftClient(final Config config) throws KubernetesClientException {
    this(new OpenshiftConfig(config));
  }

  public DefaultOpenshiftClient(final OpenshiftConfig config) throws KubernetesClientException {
    super(config);
    try {
      this.openShiftUrl = new URL(config.getOpenShiftUrl());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Could not create client", e);
    }
  }

  public DefaultOpenshiftClient(String masterUrl) throws KubernetesClientException {
    this(new OpenshiftConfigBuilder().withNewKubernetesConfig().withMasterUrl(masterUrl).and().build());
  }

  @Override
  public URL getOpenshiftUrl() {
    return openShiftUrl;
  }


  @Override
  public ClientOperation<OpenShiftClient, Build, BuildList, DoneableBuild, ClientResource<Build, DoneableBuild>> builds() {
    return new BuildOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, BuildConfig, BuildConfigList, DoneableBuildConfig, BuildConfigClientResource<BuildConfig, DoneableBuildConfig, Void, Void>> buildConfigs() {
    return new BuildConfigOperationsImpl(this, null, null, true, null, null, null);
  }

  @Override
  public ClientOperation<OpenShiftClient, DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, ClientResource<DeploymentConfig, DoneableDeploymentConfig>> deploymentConfigs() {
    return new DeploymentConfigOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, Group, GroupList, DoneableGroup, ClientResource<Group, DoneableGroup>> groups() {
    return new GroupOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, ImageStream, ImageStreamList, DoneableImageStream, ClientResource<ImageStream, DoneableImageStream>> imageStreams() {
    return new ImageStreamOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<OpenShiftClient, OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, ClientResource<OAuthAccessToken, DoneableOAuthAccessToken>> oAuthAccessTokens() {
    return new OAuthAccessTokenOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<OpenShiftClient, OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, ClientResource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken>> oAuthAuthorizeTokens() {
    return new OAuthAuthorizeTokenOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<OpenShiftClient, OAuthClient, OAuthClientList, DoneableOAuthClient, ClientResource<OAuthClient, DoneableOAuthClient>> oAuthClients() {
    return new OAuthClientOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, Policy, PolicyList, DoneablePolicy, ClientResource<Policy, DoneablePolicy>> policies() {
    return new PolicyOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, PolicyBinding, PolicyBindingList, DoneablePolicyBinding, ClientResource<PolicyBinding, DoneablePolicyBinding>> policyBindings() {
    return new PolicyBindingOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, Route, RouteList, DoneableRoute, ClientResource<Route, DoneableRoute>> routes() {
    return new RouteOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, Template, TemplateList, DoneableTemplate, TemplateClientResource<Template, KubernetesList, DoneableTemplate>> templates() {
    return new TemplateOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, User, UserList, DoneableUser, ClientResource<User, DoneableUser>> users() {
    return new UserOperationsImpl(this);
  }

}
