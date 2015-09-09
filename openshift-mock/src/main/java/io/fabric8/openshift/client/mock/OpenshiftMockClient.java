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

package io.fabric8.openshift.client.mock;

import io.fabric8.kubernetes.api.model.DoneableEndpoints;
import io.fabric8.kubernetes.api.model.DoneableEvent;
import io.fabric8.kubernetes.api.model.DoneableNamespace;
import io.fabric8.kubernetes.api.model.DoneableNode;
import io.fabric8.kubernetes.api.model.DoneablePersistentVolume;
import io.fabric8.kubernetes.api.model.DoneablePersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.DoneableResourceQuota;
import io.fabric8.kubernetes.api.model.DoneableSecret;
import io.fabric8.kubernetes.api.model.DoneableSecurityContextConstraints;
import io.fabric8.kubernetes.api.model.DoneableService;
import io.fabric8.kubernetes.api.model.DoneableServiceAccount;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventList;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.api.model.PersistentVolume;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimList;
import io.fabric8.kubernetes.api.model.PersistentVolumeList;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaList;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.SecurityContextConstraints;
import io.fabric8.kubernetes.api.model.SecurityContextConstraintsList;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.mock.MockKubernetesListOperation;
import io.fabric8.kubernetes.client.mock.MockNonNamespaceOperation;
import io.fabric8.kubernetes.client.mock.MockOperation;
import io.fabric8.kubernetes.client.mock.MockResource;
import io.fabric8.kubernetes.client.mock.MockRollableScaleableResource;
import io.fabric8.kubernetes.client.mock.MockScaleableResource;
import io.fabric8.kubernetes.client.mock.Replayable;
import io.fabric8.kubernetes.client.mock.Verifiable;
import io.fabric8.kubernetes.client.mock.impl.MockKubernetesListOperationImpl;
import io.fabric8.kubernetes.client.mock.impl.MockSecurityContextConstraints;
import io.fabric8.openshift.api.model.DoneableGroup;
import io.fabric8.openshift.api.model.DoneablePolicy;
import io.fabric8.openshift.api.model.DoneablePolicyBinding;
import io.fabric8.openshift.api.model.DoneableUser;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.api.model.Policy;
import io.fabric8.openshift.api.model.PolicyBinding;
import io.fabric8.openshift.api.model.PolicyBindingList;
import io.fabric8.openshift.api.model.PolicyList;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserList;
import io.fabric8.openshift.client.mock.impl.MockBuild;
import io.fabric8.openshift.client.mock.impl.MockBuildConfig;
import io.fabric8.openshift.client.mock.impl.MockDeploymentConfig;
import io.fabric8.kubernetes.client.mock.impl.MockEndpoints;
import io.fabric8.kubernetes.client.mock.impl.MockEvent;
import io.fabric8.openshift.client.mock.impl.MockGroup;
import io.fabric8.openshift.client.mock.impl.MockImageStream;
import io.fabric8.kubernetes.client.mock.impl.MockNamespace;
import io.fabric8.kubernetes.client.mock.impl.MockNode;
import io.fabric8.openshift.client.mock.impl.MockOAuthAccessToken;
import io.fabric8.openshift.client.mock.impl.MockOAuthAuthorizeToken;
import io.fabric8.openshift.client.mock.impl.MockOAuthClient;
import io.fabric8.kubernetes.client.mock.impl.MockPersistentVolume;
import io.fabric8.kubernetes.client.mock.impl.MockPersistentVolumeClaim;
import io.fabric8.kubernetes.client.mock.impl.MockPod;
import io.fabric8.kubernetes.client.mock.impl.MockReplicationController;
import io.fabric8.kubernetes.client.mock.impl.MockResourceQuota;
import io.fabric8.openshift.client.mock.impl.MockPolicy;
import io.fabric8.openshift.client.mock.impl.MockPolicyBinding;
import io.fabric8.openshift.client.mock.impl.MockRoute;
import io.fabric8.kubernetes.client.mock.impl.MockSecret;
import io.fabric8.kubernetes.client.mock.impl.MockService;
import io.fabric8.kubernetes.client.mock.impl.MockServiceAccount;
import io.fabric8.openshift.client.mock.impl.MockTemplate;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.DoneableBuild;
import io.fabric8.openshift.api.model.DoneableBuildConfig;
import io.fabric8.openshift.api.model.DoneableDeploymentConfig;
import io.fabric8.openshift.api.model.DoneableImageStream;
import io.fabric8.openshift.api.model.DoneableOAuthAccessToken;
import io.fabric8.openshift.api.model.DoneableOAuthAuthorizeToken;
import io.fabric8.openshift.api.model.DoneableOAuthClient;
import io.fabric8.openshift.api.model.DoneableRoute;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamList;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessTokenList;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenList;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientList;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.mock.impl.MockUser;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

import java.net.URL;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class OpenshiftMockClient implements Replayable<OpenShiftClient>, Verifiable {

  private final OpenShiftClient client = createMock(OpenShiftClient.class);

  private final MockEndpoints endpoints = new MockEndpoints();
  private final MockEvent events = new MockEvent();
  private final MockNode nodes = new MockNode();
  private final MockNamespace namespaces = new MockNamespace();
  private final MockPersistentVolume persistentVolumes = new MockPersistentVolume();
  private final MockPersistentVolumeClaim persistentVolumeClaims = new MockPersistentVolumeClaim();
  private final MockPod pods = new MockPod();
  private final MockService services = new MockService();
  private final MockReplicationController replicationControllers = new MockReplicationController();
  private final MockResourceQuota resourceQuotas = new MockResourceQuota();
  private final MockSecret secrets = new MockSecret();
  private final MockServiceAccount serviceAccounts = new MockServiceAccount();
  private final MockSecurityContextConstraints securityContextConstraints = new MockSecurityContextConstraints();
  private final MockKubernetesListOperationImpl kubernetesLists = new MockKubernetesListOperationImpl();

  private final MockTemplate templates = new MockTemplate();
  private final MockBuild builds = new MockBuild();
  private final MockBuildConfig buildConfigs = new MockBuildConfig();
  private final MockDeploymentConfig deploymentConfigs = new MockDeploymentConfig();
  private final MockImageStream imageStreams = new MockImageStream();
  private final MockOAuthAccessToken oAuthAccessTokens = new MockOAuthAccessToken();
  private final MockOAuthAuthorizeToken oAuthAuthorizeTokens = new MockOAuthAuthorizeToken();
  private final MockOAuthClient oAuthClients = new MockOAuthClient();
  private final MockRoute routes = new MockRoute();
  private final MockUser users = new MockUser();
  private final MockGroup groups = new MockGroup();
  private final MockPolicy policies = new MockPolicy();
  private final MockPolicyBinding policyBindings = new MockPolicyBinding();

  public OpenshiftMockClient() {
    expect(client.adapt(OpenShiftClient.class)).andReturn(client).anyTimes();
    expect(client.endpoints()).andReturn(endpoints.getDelegate()).anyTimes();
    expect(client.events()).andReturn(events.getDelegate()).anyTimes();
    expect(client.nodes()).andReturn(nodes.getDelegate()).anyTimes();
    expect(client.namespaces()).andReturn(namespaces.getDelegate()).anyTimes();
    expect(client.persistentVolumes()).andReturn(persistentVolumes.getDelegate()).anyTimes();
    expect(client.persistentVolumeClaims()).andReturn(persistentVolumeClaims.getDelegate()).anyTimes();
    expect(client.pods()).andReturn(pods.getDelegate()).anyTimes();
    expect(client.services()).andReturn(services.getDelegate()).anyTimes();
    expect(client.replicationControllers()).andReturn(replicationControllers.getDelegate()).anyTimes();
    expect(client.resourceQuotas()).andReturn(resourceQuotas.getDelegate()).anyTimes();
    expect(client.secrets()).andReturn(secrets.getDelegate()).anyTimes();
    expect(client.serviceAccounts()).andReturn(serviceAccounts.getDelegate()).anyTimes();
    expect(client.securityContextConstraints()).andReturn(securityContextConstraints.getDelegate()).anyTimes();
    expect(client.lists()).andReturn(kubernetesLists.getDelegate()).anyTimes();

    expect(client.builds()).andReturn(builds.getDelegate()).anyTimes();
    expect(client.buildConfigs()).andReturn(buildConfigs.getDelegate()).anyTimes();
    expect(client.deploymentConfigs()).andReturn(deploymentConfigs.getDelegate()).anyTimes();
    expect(client.imageStreams()).andReturn(imageStreams.getDelegate()).anyTimes();
    expect(client.oAuthAccessTokens()).andReturn(oAuthAccessTokens.getDelegate()).anyTimes();
    expect(client.oAuthAuthorizeTokens()).andReturn(oAuthAuthorizeTokens.getDelegate()).anyTimes();
    expect(client.oAuthClients()).andReturn(oAuthClients.getDelegate()).anyTimes();
    expect(client.routes()).andReturn(routes.getDelegate()).anyTimes();
    expect(client.templates()).andReturn(templates.getDelegate()).anyTimes();
    expect(client.users()).andReturn(users.getDelegate()).anyTimes();
    expect(client.groups()).andReturn(groups.getDelegate()).anyTimes();
    expect(client.policies()).andReturn(policies.getDelegate()).anyTimes();
    expect(client.policyBindings()).andReturn(policyBindings.getDelegate()).anyTimes();

    client.close();
    EasyMock.expectLastCall().anyTimes();
  }

  public OpenShiftClient replay() {
    endpoints.replay();
    events.replay();
    nodes.replay();
    namespaces.replay();
    persistentVolumes.replay();
    persistentVolumeClaims.replay();
    pods.replay();
    services.replay();
    replicationControllers.replay();
    resourceQuotas.replay();
    secrets.replay();
    serviceAccounts.replay();
    securityContextConstraints.replay();
    kubernetesLists.replay();

    builds.replay();
    buildConfigs.replay();
    deploymentConfigs.replay();
    imageStreams.replay();
    oAuthAccessTokens.replay();
    oAuthAuthorizeTokens.replay();
    oAuthClients.replay();
    routes.replay();
    templates.replay();

    users.replay();
    groups.replay();
    policies.replay();
    policyBindings.replay();

    EasyMock.replay(client);
    return client;
  }


  @Override
  public void verify() {
    endpoints.verify();
    events.verify();
    nodes.verify();
    namespaces.verify();
    persistentVolumes.verify();
    persistentVolumeClaims.verify();
    pods.verify();
    services.verify();
    replicationControllers.verify();
    resourceQuotas.verify();
    secrets.verify();
    serviceAccounts.verify();
    securityContextConstraints.verify();
    kubernetesLists.verify();

    builds.verify();
    buildConfigs.verify();
    deploymentConfigs.verify();
    imageStreams.verify();
    oAuthAccessTokens.verify();
    oAuthAuthorizeTokens.verify();
    oAuthClients.verify();
    routes.verify();
    templates.verify();
    users.verify();
    groups.verify();
    policies.verify();
    policyBindings.verify();
    EasyMock.verify(client);
  }

  public IExpectationSetters<URL> getMasterUrl() {
    return expect(client.getMasterUrl());
  }

  public IExpectationSetters<Config> getConfiguration() {
    return expect(client.getConfiguration());
  }


  public IExpectationSetters<RootPaths> rootPaths() {
    return expect(client.rootPaths());
  }

  public MockOperation<Endpoints, EndpointsList, DoneableEndpoints, MockResource<Endpoints, DoneableEndpoints, Boolean>> endpoints() {
    return endpoints;
  }

  public MockOperation<Event, EventList, DoneableEvent, MockResource<Event, DoneableEvent, Boolean>> events() {
    return events;
  }

  public MockNonNamespaceOperation<Namespace, NamespaceList, DoneableNamespace, MockResource<Namespace, DoneableNamespace, Boolean>> namespaces() {
    return namespaces;
  }

  public MockNonNamespaceOperation<Node, NodeList, DoneableNode, MockResource<Node, DoneableNode, Boolean>> nodes() {
    return nodes;
  }

  public MockOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, MockResource<PersistentVolume, DoneablePersistentVolume, Boolean>> persistentVolumes() {
    return persistentVolumes;
  }

  public MockOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, MockResource<PersistentVolumeClaim, DoneablePersistentVolumeClaim, Boolean>> persistentVolumeClaims() {
    return persistentVolumeClaims;
  }

  public MockOperation<Pod, PodList, DoneablePod, MockResource<Pod, DoneablePod, Boolean>> pods() {
    return pods;
  }

  public MockOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, MockRollableScaleableResource<ReplicationController, DoneableReplicationController, Boolean>> replicationControllers() {
    return replicationControllers;
  }

  public MockOperation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, MockResource<ResourceQuota, DoneableResourceQuota, Boolean>> resourceQuotas() {
    return resourceQuotas;
  }

  public MockOperation<Secret, SecretList, DoneableSecret, MockResource<Secret, DoneableSecret, Boolean>> secrets() {
    return secrets;
  }

  public MockOperation<Service, ServiceList, DoneableService, MockResource<Service, DoneableService, Boolean>> services() {
    return services;
  }

  public MockOperation<ServiceAccount, ServiceAccountList, DoneableServiceAccount, MockResource<ServiceAccount, DoneableServiceAccount, Boolean>> serviceAccounts() {
    return serviceAccounts;
  }
  public MockOperation<SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, MockResource<SecurityContextConstraints, DoneableSecurityContextConstraints, Boolean>> securityContextConstraints() {
    return securityContextConstraints;
  }

  public MockKubernetesListOperation lists() {
    return kubernetesLists;
  }

  public MockOperation<Build, BuildList, DoneableBuild, MockResource<Build, DoneableBuild, Boolean>> builds() {
    return builds;
  }

  public MockOperation<BuildConfig, BuildConfigList, DoneableBuildConfig, MockBuildConfigResource> buildConfigs() {
    return buildConfigs;
  }

  public MockOperation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, MockResource<DeploymentConfig, DoneableDeploymentConfig, Boolean>> deploymentConfigs() {
    return deploymentConfigs;
  }

  public MockOperation<ImageStream, ImageStreamList, DoneableImageStream, MockResource<ImageStream, DoneableImageStream, Boolean>> imageStreams() {
    return imageStreams;
  }

  public MockNonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, MockResource<OAuthAccessToken, DoneableOAuthAccessToken, Boolean>> oAuthAccessTokens() {
    return oAuthAccessTokens;
  }

  public MockNonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, MockResource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken, Boolean>> oAuthAuthorizeTokens() {
    return oAuthAuthorizeTokens;
  }

  public MockNonNamespaceOperation<OAuthClient, OAuthClientList, DoneableOAuthClient, MockResource<OAuthClient, DoneableOAuthClient, Boolean>> oAuthClients() {
    return oAuthClients;
  }

  public MockOperation<Route, RouteList, DoneableRoute, MockResource<Route, DoneableRoute, Boolean>> routes() {
    return routes;
  }

  public  MockOperation<Template, TemplateList, DoneableTemplate, MockProcessableResource<Template, DoneableTemplate, Boolean>> templates() {
    return templates;
  }

  public  MockOperation<Group, GroupList, DoneableGroup, MockResource<Group, DoneableGroup, Boolean>> groups() {
    return groups;
  }

  public  MockOperation<User, UserList, DoneableUser, MockResource<User, DoneableUser, Boolean>> users() {
    return users;
  }

  public  MockOperation<Policy, PolicyList, DoneablePolicy, MockResource<Policy, DoneablePolicy, Boolean>> policies() {
    return policies;
  }

  public  MockOperation<PolicyBinding, PolicyBindingList, DoneablePolicyBinding, MockResource<PolicyBinding, DoneablePolicyBinding, Boolean>> policyBindings() {
    return policyBindings;
  }
}
