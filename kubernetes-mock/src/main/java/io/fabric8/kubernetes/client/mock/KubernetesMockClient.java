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
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.mock.impl.MockEndpoints;
import io.fabric8.kubernetes.client.mock.impl.MockEvent;
import io.fabric8.kubernetes.client.mock.impl.MockKubernetesListOperationImpl;
import io.fabric8.kubernetes.client.mock.impl.MockNamespace;
import io.fabric8.kubernetes.client.mock.impl.MockNode;
import io.fabric8.kubernetes.client.mock.impl.MockPersistentVolume;
import io.fabric8.kubernetes.client.mock.impl.MockPersistentVolumeClaim;
import io.fabric8.kubernetes.client.mock.impl.MockPod;
import io.fabric8.kubernetes.client.mock.impl.MockReplicationController;
import io.fabric8.kubernetes.client.mock.impl.MockResourceQuota;
import io.fabric8.kubernetes.client.mock.impl.MockSecret;
import io.fabric8.kubernetes.client.mock.impl.MockSecurityContextConstraints;
import io.fabric8.kubernetes.client.mock.impl.MockService;
import io.fabric8.kubernetes.client.mock.impl.MockServiceAccount;
import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.easymock.IArgumentMatcher;
import org.easymock.IExpectationSetters;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static io.fabric8.kubernetes.client.mock.util.MockUtils.getArgument;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;

public class KubernetesMockClient implements Replayable<KubernetesClient>, Verifiable {

  private final KubernetesClient client = createMock(KubernetesClient.class);

  private KubernetesMockClient anyNamespaceOp;
  private Map<IArgumentMatcher, KubernetesMockClient> namespaceMap = new HashMap<>();


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
    expect(client.securityContextConstraints()).andReturn(securityContextConstraints.getDelegate()).anyTimes();
    expect(client.lists()).andReturn(kubernetesLists.getDelegate()).anyTimes();
    client.close();
    EasyMock.expectLastCall().anyTimes();
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
    securityContextConstraints.replay();
    kubernetesLists.replay();
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

  public MockOperation<Namespace, NamespaceList, DoneableNamespace, MockResource<Namespace, DoneableNamespace, Boolean>> namespaces() {
    return namespaces;
  }

  public MockOperation<Node, NodeList, DoneableNode, MockResource<Node, DoneableNode, Boolean>> nodes() {
    return nodes;
  }

  public MockOperation<PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, MockResource<PersistentVolume, DoneablePersistentVolume, Boolean>> persistentVolumes() {
    return persistentVolumes;
  }

  public MockOperation<PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, MockResource<PersistentVolumeClaim, DoneablePersistentVolumeClaim, Boolean>> persistentVolumeClaims() {
    return persistentVolumeClaims;
  }

  public MockOperation<Pod, PodList, DoneablePod, MockLoggableResource<Pod, DoneablePod, Boolean>> pods() {
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


  public KubernetesMockClient inNamespace(String namespace) {
    IArgumentMatcher matcher = getArgument(namespace);
    KubernetesMockClient op = namespaceMap.get(matcher);
    if (op == null) {
      final KubernetesMockClient namespacedClient = new KubernetesMockClient();
      op = namespacedClient;
      expect(client.inNamespace(namespace)).andAnswer(new IAnswer<KubernetesClient>() {
        @Override
        public KubernetesClient answer() throws Throwable {
          return namespacedClient.replay();
        }
      }).anyTimes();
      namespaceMap.put(matcher, op);
    }
    return op;
  }

  public KubernetesMockClient inAnyNamespace() {
    if (anyNamespaceOp == null) {
      final KubernetesMockClient namespacedClient = new KubernetesMockClient();
      anyNamespaceOp = namespacedClient;
      expect(client.inAnyNamespace()).andAnswer(new IAnswer<KubernetesClient>() {
        @Override
        public KubernetesClient answer() throws Throwable {
          return namespacedClient.replay();
        }
      }).anyTimes();
    }
    return anyNamespaceOp;
  }
}
