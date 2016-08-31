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

import io.fabric8.kubernetes.api.model.ComponentStatus;
import io.fabric8.kubernetes.api.model.ComponentStatusList;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsList;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.EventList;
import io.fabric8.kubernetes.api.model.LimitRange;
import io.fabric8.kubernetes.api.model.LimitRangeList;
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
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.mock.impl.MockComponentStatus;
import io.fabric8.kubernetes.client.mock.impl.MockConfigMap;
import io.fabric8.kubernetes.client.mock.impl.MockEndpoints;
import io.fabric8.kubernetes.client.mock.impl.MockEvent;
import io.fabric8.kubernetes.client.mock.impl.MockKubernetesListOperationImpl;
import io.fabric8.kubernetes.client.mock.impl.MockLimitRange;
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
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableComponentStatus;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableConfigMap;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableEndpoints;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableEvent;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableLimitRange;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableNamespace;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableNode;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneablePersistentVolume;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneablePersistentVolumeClaim;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneablePod;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableReplicationController;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableResourceQuota;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableSecret;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableSecurityContextConstraints;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableService;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableServiceAccount;
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

public class KubernetesMockClient implements Replayable<NamespacedKubernetesClient>, Verifiable {

  private final NamespacedKubernetesClient client = createMock(NamespacedKubernetesClient.class);

  private KubernetesMockClient anyNamespaceOp;
  private Map<IArgumentMatcher, KubernetesMockClient> namespaceMap = new HashMap<>();

  private final MockComponentStatus componentstatuses = new MockComponentStatus();
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
  private final MockConfigMap configMaps = new MockConfigMap();
  private final MockLimitRange limitRanges = new MockLimitRange();
  private final MockKubernetesListOperationImpl kubernetesLists = new MockKubernetesListOperationImpl();
  private final ExtensionsAPIGroupMockClient extensions = new ExtensionsAPIGroupMockClient();


  public KubernetesMockClient() {
	  expect(client.componentstatuses()).andReturn(componentstatuses.getDelegate()).anyTimes();
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
    expect(client.configMaps()).andReturn(configMaps.getDelegate()).anyTimes();
    expect(client.limitRanges()).andReturn(limitRanges.getDelegate()).anyTimes();
    expect(client.lists()).andReturn(kubernetesLists.getDelegate()).anyTimes();

    expect(client.extensions()).andReturn(extensions.getDelegate()).anyTimes();
    client.close();
    EasyMock.expectLastCall().anyTimes();
  }

  public NamespacedKubernetesClient replay() {
	componentstatuses.replay();
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
    configMaps.replay();
    limitRanges.replay();
    extensions.replay();
    EasyMock.replay(client);
    return client;
  }

  @Override
  public void verify() {
	componentstatuses.verify();
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
    configMaps.verify();
    limitRanges.verify();
    kubernetesLists.verify();

    extensions.verify();
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

  public MockOperation<ComponentStatus, ComponentStatusList, MockDoneableComponentStatus, MockResource<ComponentStatus, MockDoneableComponentStatus, Boolean>> componentstatuses() {
    return componentstatuses;
  }

  public MockOperation<Endpoints, EndpointsList, MockDoneableEndpoints, MockResource<Endpoints, MockDoneableEndpoints, Boolean>> endpoints() {
    return endpoints;
  }

  public MockOperation<Event, EventList, MockDoneableEvent, MockResource<Event, MockDoneableEvent, Boolean>> events() {
    return events;
  }

  public MockOperation<Namespace, NamespaceList, MockDoneableNamespace, MockResource<Namespace, MockDoneableNamespace, Boolean>> namespaces() {
    return namespaces;
  }

  public MockOperation<Node, NodeList, MockDoneableNode, MockResource<Node, MockDoneableNode, Boolean>> nodes() {
    return nodes;
  }

  public MockOperation<PersistentVolume, PersistentVolumeList, MockDoneablePersistentVolume, MockResource<PersistentVolume, MockDoneablePersistentVolume, Boolean>> persistentVolumes() {
    return persistentVolumes;
  }

  public MockOperation<PersistentVolumeClaim, PersistentVolumeClaimList, MockDoneablePersistentVolumeClaim, MockResource<PersistentVolumeClaim, MockDoneablePersistentVolumeClaim, Boolean>> persistentVolumeClaims() {
    return persistentVolumeClaims;
  }

  public MockOperation<Pod, PodList, MockDoneablePod, MockPodResource<Pod, MockDoneablePod, Boolean>> pods() {
    return pods;
  }

  public MockOperation<ReplicationController, ReplicationControllerList, MockDoneableReplicationController, MockRollableScaleableResource<ReplicationController, MockDoneableReplicationController, Boolean>> replicationControllers() {
    return replicationControllers;
  }

  public MockOperation<ResourceQuota, ResourceQuotaList, MockDoneableResourceQuota, MockResource<ResourceQuota, MockDoneableResourceQuota, Boolean>> resourceQuotas() {
    return resourceQuotas;
  }

  public MockOperation<Secret, SecretList, MockDoneableSecret, MockResource<Secret, MockDoneableSecret, Boolean>> secrets() {
    return secrets;
  }

  public MockOperation<Service, ServiceList, MockDoneableService, MockResource<Service, MockDoneableService, Boolean>> services() {
    return services;
  }

  public MockOperation<ServiceAccount, ServiceAccountList, MockDoneableServiceAccount, MockResource<ServiceAccount, MockDoneableServiceAccount, Boolean>> serviceAccounts() {
    return serviceAccounts;
  }

  public MockOperation<SecurityContextConstraints, SecurityContextConstraintsList, MockDoneableSecurityContextConstraints, MockResource<SecurityContextConstraints, MockDoneableSecurityContextConstraints, Boolean>> securityContextConstraints() {
    return securityContextConstraints;
  }

  public MockOperation<ConfigMap, ConfigMapList, MockDoneableConfigMap, MockResource<ConfigMap, MockDoneableConfigMap, Boolean>> configMaps() {
    return configMaps;
  }

  public MockOperation<LimitRange, LimitRangeList, MockDoneableLimitRange, MockResource<LimitRange, MockDoneableLimitRange, Boolean>> limitRanges() {
    return limitRanges;
  }


  public MockKubernetesListOperation lists() {
    return kubernetesLists;
  }

  public ExtensionsAPIGroupMockClient extensions() {
    return extensions;
  }

  public KubernetesMockClient inNamespace(final String namespace) {
    IArgumentMatcher matcher = getArgument(namespace);
    KubernetesMockClient op = namespaceMap.get(matcher);
    if (op == null) {
      final KubernetesMockClient namespacedClient = new KubernetesMockClient();
      op = namespacedClient;
      expect(client.inNamespace(namespace)).andAnswer(new IAnswer<NamespacedKubernetesClient>() {
        @Override
        public NamespacedKubernetesClient answer() throws Throwable {
          namespacedClient.getNamespace().andReturn(namespace).anyTimes();
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
      expect(client.inAnyNamespace()).andAnswer(new IAnswer<NamespacedKubernetesClient>() {
        @Override
        public NamespacedKubernetesClient answer() throws Throwable {
          namespacedClient.getNamespace().andReturn(null).anyTimes();
          return namespacedClient.replay();
        }
      }).anyTimes();
    }
    return anyNamespaceOp;
  }

  public IExpectationSetters<String> getNamespace() {
    return expect(client.getNamespace());
  }

  public  <T> IExpectationSetters<Boolean> isAdaptable(Class<T> type) {
    return expect(client.isAdaptable(type));
  }

  public <T> IExpectationSetters<T> adapt(Class<T> type) {
    return expect(client.adapt(type));
  }
}
