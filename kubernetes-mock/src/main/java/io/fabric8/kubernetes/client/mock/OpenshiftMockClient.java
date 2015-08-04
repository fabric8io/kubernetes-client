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

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.OpenShiftClient;
import io.fabric8.kubernetes.client.mock.impl.*;
import io.fabric8.openshift.api.model.*;
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

    expect(client.builds()).andReturn(builds.getDelegate()).anyTimes();
    expect(client.buildConfigs()).andReturn(buildConfigs.getDelegate()).anyTimes();
    expect(client.deploymentConfigs()).andReturn(deploymentConfigs.getDelegate()).anyTimes();
    expect(client.imageStreams()).andReturn(imageStreams.getDelegate()).anyTimes();
    expect(client.oAuthAccessTokens()).andReturn(oAuthAccessTokens.getDelegate()).anyTimes();
    expect(client.oAuthAuthorizeTokens()).andReturn(oAuthAuthorizeTokens.getDelegate()).anyTimes();
    expect(client.oAuthClients()).andReturn(oAuthClients.getDelegate()).anyTimes();
    expect(client.routes()).andReturn(routes.getDelegate()).anyTimes();
    expect(client.templates()).andReturn(templates.getDelegate()).anyTimes();
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

  MockOperation<Endpoints, EndpointsList, DoneableEndpoints, MockResource<Endpoints, DoneableEndpoints, Boolean>> endpoints() {
    return endpoints;
  }

  MockOperation<Event, EventList, DoneableEvent, MockResource<Event, DoneableEvent, Boolean>> events() {
    return events;
  }

  MockNonNamespaceOperation<Namespace, NamespaceList, DoneableNamespace, MockResource<Namespace, DoneableNamespace, Boolean>> namespaces() {
    return namespaces;
  }

  MockNonNamespaceOperation<Node, NodeList, DoneableNode, MockResource<Node, DoneableNode, Boolean>> nodes() {
    return nodes;
  }

  MockOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, MockResource<PersistentVolume, DoneablePersistentVolume, Boolean>> persistentVolumes() {
    return persistentVolumes;
  }

  MockOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, MockResource<PersistentVolumeClaim, DoneablePersistentVolumeClaim, Boolean>> persistentVolumeClaims() {
    return persistentVolumeClaims;
  }

  MockOperation<Pod, PodList, DoneablePod, MockResource<Pod, DoneablePod, Boolean>> pods() {
    return pods;
  }

  MockOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, MockScaleableResource<ReplicationController, DoneableReplicationController, Boolean>> replicationControllers() {
    return replicationControllers;
  }

  MockOperation<ResourceQuota, ResourceQuotaList, DoneableResourceQuota, MockResource<ResourceQuota, DoneableResourceQuota, Boolean>> resourceQuotas() {
    return resourceQuotas;
  }

  MockOperation<Secret, SecretList, DoneableSecret, MockResource<Secret, DoneableSecret, Boolean>> secrets() {
    return secrets;
  }

  MockOperation<Service, ServiceList, DoneableService, MockResource<Service, DoneableService, Boolean>> services() {
    return services;
  }

  MockOperation<ServiceAccount, ServiceAccountList, DoneableServiceAccount, MockResource<ServiceAccount, DoneableServiceAccount, Boolean>> serviceAccounts() {
    return serviceAccounts;
  }

  MockOperation<Build, BuildList, DoneableBuild, MockResource<Build, DoneableBuild, Boolean>> builds() {
    return builds;
  }

  MockOperation<BuildConfig, BuildConfigList, DoneableBuildConfig, MockBuildConfigResource> buildConfigs() {
    return buildConfigs;
  }

  MockOperation<DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, MockResource<DeploymentConfig, DoneableDeploymentConfig, Boolean>> deploymentConfigs() {
    return deploymentConfigs;
  }

  MockOperation<ImageStream, ImageStreamList, DoneableImageStream, MockResource<ImageStream, DoneableImageStream, Boolean>> imageStreams() {
    return imageStreams;
  }

  MockNonNamespaceOperation<OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, MockResource<OAuthAccessToken, DoneableOAuthAccessToken, Boolean>> oAuthAccessTokens() {
    return oAuthAccessTokens;
  }

  MockNonNamespaceOperation<OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, MockResource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken, Boolean>> oAuthAuthorizeTokens() {
    return oAuthAuthorizeTokens;
  }

  MockNonNamespaceOperation<OAuthClient, OAuthClientList, DoneableOAuthClient, MockResource<OAuthClient, DoneableOAuthClient, Boolean>> oAuthClients() {
    return oAuthClients;
  }

  MockOperation<Route, RouteList, DoneableRoute, MockResource<Route, DoneableRoute, Boolean>> routes() {
    return routes;
  }

  MockOperation<Template, TemplateList, DoneableTemplate, MockProcessableResource<Template, DoneableTemplate, Boolean>> templates() {
    return templates;
  }
}
