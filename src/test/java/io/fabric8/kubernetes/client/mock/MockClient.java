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
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.mock.impl.MockEndpoints;
import io.fabric8.kubernetes.client.mock.impl.MockEvent;
import io.fabric8.kubernetes.client.mock.impl.MockNamespace;
import io.fabric8.kubernetes.client.mock.impl.MockNode;
import io.fabric8.kubernetes.client.mock.impl.MockPersistentVolume;
import io.fabric8.kubernetes.client.mock.impl.MockPersistentVolumeClaim;
import io.fabric8.kubernetes.client.mock.impl.MockPod;
import io.fabric8.kubernetes.client.mock.impl.MockReplicationController;
import io.fabric8.kubernetes.client.mock.impl.MockResourceQuota;
import io.fabric8.kubernetes.client.mock.impl.MockSecret;
import io.fabric8.kubernetes.client.mock.impl.MockService;
import io.fabric8.kubernetes.client.mock.impl.MockServiceAccount;
import io.fabric8.kubernetes.client.mock.impl.MockTemplate;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;
import org.easymock.EasyMock;
import static org.easymock.EasyMock.*;

public class MockClient {

  private final KubernetesClient client = EasyMock.createMock(KubernetesClient.class);

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

  public MockClient() {
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
  }

  public KubernetesClient replay() {
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
    EasyMock.replay(client);
    return client;
  }

  MockOperation<Endpoints, EndpointsList, DoneableEndpoints, MockResource<Endpoints, DoneableEndpoints, Void, Boolean>> endpoints() {
    return endpoints;
  }

  MockOperation<Event, EventList, DoneableEvent, MockResource<Event, DoneableEvent, Void, Boolean>> events() {
    return events;
  }

  MockOperation<Namespace, NamespaceList, DoneableNamespace, MockResource<Namespace, DoneableNamespace, Void, Boolean>> namespaces() {
    return namespaces;
  }

  MockOperation<Node, NodeList, DoneableNode, MockResource<Node, DoneableNode, Void, Boolean>> nodes() {
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
}
