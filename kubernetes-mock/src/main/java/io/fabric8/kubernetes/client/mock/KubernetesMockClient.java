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
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.mock.impl.*;
import io.fabric8.openshift.api.model.DoneableTemplate;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;
import org.easymock.EasyMock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class KubernetesMockClient implements Replayable<KubernetesClient>, Verifiable {

  private final KubernetesClient client = createMock(KubernetesClient.class);

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

  public KubernetesMockClient() {
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
    EasyMock.verify(client);
  }

  MockOperation<Endpoints, EndpointsList, DoneableEndpoints, MockResource<Endpoints, DoneableEndpoints, Boolean>> endpoints() {
    return endpoints;
  }

  MockOperation<Event, EventList, DoneableEvent, MockResource<Event, DoneableEvent, Boolean>> events() {
    return events;
  }

  MockOperation<Namespace, NamespaceList, DoneableNamespace, MockResource<Namespace, DoneableNamespace, Boolean>> namespaces() {
    return namespaces;
  }

  MockOperation<Node, NodeList, DoneableNode, MockResource<Node, DoneableNode, Boolean>> nodes() {
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
}
