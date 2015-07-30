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

package io.fabric8.kubernetes.client.mock;

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
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountList;
import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.OpenShiftClient;
import io.fabric8.kubernetes.client.dsl.BuildConfigResource;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.mock.impl.MockBuild;
import io.fabric8.kubernetes.client.mock.impl.MockBuildConfig;
import io.fabric8.kubernetes.client.mock.impl.MockDeploymentConfig;
import io.fabric8.kubernetes.client.mock.impl.MockEndpoints;
import io.fabric8.kubernetes.client.mock.impl.MockEvent;
import io.fabric8.kubernetes.client.mock.impl.MockImageStream;
import io.fabric8.kubernetes.client.mock.impl.MockNamespace;
import io.fabric8.kubernetes.client.mock.impl.MockNode;
import io.fabric8.kubernetes.client.mock.impl.MockOAuthAccessToken;
import io.fabric8.kubernetes.client.mock.impl.MockOAuthAuthorizeToken;
import io.fabric8.kubernetes.client.mock.impl.MockOAuthClient;
import io.fabric8.kubernetes.client.mock.impl.MockPersistentVolume;
import io.fabric8.kubernetes.client.mock.impl.MockPersistentVolumeClaim;
import io.fabric8.kubernetes.client.mock.impl.MockPod;
import io.fabric8.kubernetes.client.mock.impl.MockReplicationController;
import io.fabric8.kubernetes.client.mock.impl.MockResourceQuota;
import io.fabric8.kubernetes.client.mock.impl.MockRoute;
import io.fabric8.kubernetes.client.mock.impl.MockSecret;
import io.fabric8.kubernetes.client.mock.impl.MockService;
import io.fabric8.kubernetes.client.mock.impl.MockServiceAccount;
import io.fabric8.kubernetes.client.mock.impl.MockTemplate;
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
import org.easymock.EasyMock;

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
  private final MockTemplate templates = new MockTemplate();

  private final MockBuild builds = new MockBuild();
  private final MockBuildConfig buildConfigs = new MockBuildConfig();
  private final MockDeploymentConfig deploymentConfigs = new MockDeploymentConfig();
  private final MockImageStream imageStreams = new MockImageStream();
  private final MockOAuthAccessToken oAuthAccessTokens = new MockOAuthAccessToken();
  private final MockOAuthAuthorizeToken oAuthAuthorizeTokens = new MockOAuthAuthorizeToken();
  private final MockOAuthClient oAuthClients = new MockOAuthClient();
  private final MockRoute routes = new MockRoute();

  public OpenshiftMockClient() {
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
    expect(client.templates()).andReturn(templates.getDelegate()).anyTimes();

    expect(client.builds()).andReturn(builds.getDelegate()).anyTimes();
    expect(client.buildConfigs()).andReturn(buildConfigs.getDelegate()).anyTimes();
    expect(client.deploymentConfigs()).andReturn(deploymentConfigs.getDelegate()).anyTimes();
    expect(client.imageStreams()).andReturn(imageStreams.getDelegate()).anyTimes();
    expect(client.oAuthAccessTokens()).andReturn(oAuthAccessTokens.getDelegate()).anyTimes();
    expect(client.oAuthAuthorizeTokens()).andReturn(oAuthAuthorizeTokens.getDelegate()).anyTimes();
    expect(client.oAuthClients()).andReturn(oAuthClients.getDelegate()).anyTimes();
    expect(client.routes()).andReturn(routes.getDelegate()).anyTimes();
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
    templates.replay();

    builds.replay();
    buildConfigs.replay();
    deploymentConfigs.replay();
    imageStreams.replay();
    oAuthAccessTokens.replay();
    oAuthAuthorizeTokens.replay();
    oAuthClients.replay();
    routes.replay();
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
    templates.verify();

    builds.verify();
    buildConfigs.verify();
    deploymentConfigs.verify();
    imageStreams.verify();
    oAuthAccessTokens.verify();
    oAuthAuthorizeTokens.verify();
    oAuthClients.verify();
    routes.verify();
    EasyMock.verify(client);
  }

  MockOperation<Endpoints, EndpointsList, DoneableEndpoints, MockResource<Endpoints, DoneableEndpoints, Void, Boolean>> endpoints() {
    return endpoints;
  }

  MockOperation<Event, EventList, DoneableEvent, MockResource<Event, DoneableEvent, Void, Boolean>> events() {
    return events;
  }

  MockNonNamespaceOperation<Namespace, NamespaceList, DoneableNamespace, MockResource<Namespace, DoneableNamespace, Void, Boolean>> namespaces() {
    return namespaces;
  }

  MockNonNamespaceOperation<Node, NodeList, DoneableNode, MockResource<Node, DoneableNode, Void, Boolean>> nodes() {
    return nodes;
  }

  MockOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, MockResource<PersistentVolume, DoneablePersistentVolume, Void, Boolean>> persistentVolumes() {
    return persistentVolumes;
  }

  MockOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, MockResource<PersistentVolumeClaim, DoneablePersistentVolumeClaim, Void, Boolean>> persistentVolumeClaims() {
    return persistentVolumeClaims;
  }

  MockOperation<Pod, PodList, DoneablePod, MockResource<Pod, DoneablePod, Void, Boolean>> pods() {
    return pods;
  }

  MockOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, MockScaleableResource<ReplicationController, DoneableReplicationController, Void, Boolean>> replicationControllers() {
    return replicationControllers;
  }

  MockOperation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, MockResource<ResourceQuota, DoneableResourceQuota, Void, Boolean>> resourceQuotas() {
    return resourceQuotas;
  }

  MockOperation<Secret, SecretList, DoneableSecret, MockResource<Secret, DoneableSecret, Void, Boolean>> secrets() {
    return secrets;
  }

  MockOperation<Service, ServiceList, DoneableService, MockResource<Service, DoneableService, Void, Boolean>> services() {
    return services;
  }

  MockOperation<ServiceAccount, ServiceAccountList, DoneableServiceAccount, MockResource<ServiceAccount, DoneableServiceAccount, Void, Boolean>> serviceAccounts() {
    return serviceAccounts;
  }

  MockOperation<Template, TemplateList, DoneableTemplate, MockProcessableResource<Template, DoneableTemplate, Void, Boolean>> templates() {
    return templates;
  }

  MockOperation<Build, BuildList, DoneableBuild, MockResource<Build, DoneableBuild, Void, Boolean>> builds() {
    return builds;
  }

  MockOperation<BuildConfig, BuildConfigList, DoneableBuildConfig, MockBuildConfigResource> buildConfigs() {
    return buildConfigs;
  }

  MockOperation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, MockResource<DeploymentConfig, DoneableDeploymentConfig, Void, Boolean>> deploymentConfigs() {
    return deploymentConfigs;
  }

  MockOperation<ImageStream, ImageStreamList, DoneableImageStream, MockResource<ImageStream, DoneableImageStream, Void, Boolean>> imageStreams() {
    return imageStreams;
  }

  MockNonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, MockResource<OAuthAccessToken, DoneableOAuthAccessToken, Void, Boolean>> oAuthAccessTokens() {
    return oAuthAccessTokens;
  }

  MockNonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, MockResource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken, Void, Boolean>> oAuthAuthorizeTokens() {
    return oAuthAuthorizeTokens;
  }

  MockNonNamespaceOperation<OAuthClient, OAuthClientList, DoneableOAuthClient, MockResource<OAuthClient, DoneableOAuthClient, Void, Boolean>> oAuthClients() {
    return oAuthClients;
  }

  MockOperation<Route, RouteList, DoneableRoute, MockResource<Route, DoneableRoute, Void, Boolean>> routes() {
    return routes;
  }
}
