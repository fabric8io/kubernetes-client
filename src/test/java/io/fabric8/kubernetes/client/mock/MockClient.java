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

import io.fabric8.kubernetes.client.KubernetesClient;
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
    expect(client.pods()).andReturn(pods().getDelegate()).anyTimes();
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

  MockEndpoints endpoints() {
    return endpoints;
  }

  MockEvent events() {
    return events;
  }

  MockNamespace namespaces() {
    return namespaces;
  }

  MockNode nodes() {
    return nodes;
  }

  MockPersistentVolume persistentVolumes() {
    return persistentVolumes;
  }

  MockPersistentVolumeClaim persistentVolumeClaims() {
    return persistentVolumeClaims;
  }

  MockPod pods() {
    return pods;
  }

  MockReplicationController replicationControllers() {
    return replicationControllers;
  }

  MockResourceQuota resourceQuotas() {
    return resourceQuotas;
  }

  MockSecret secrets() {
    return secrets;
  }

  MockService services() {
    return services;
  }

  MockServiceAccount serviceAccounts() {
    return serviceAccounts;
  }

  MockTemplate templates() {
    return templates;
  }
}
