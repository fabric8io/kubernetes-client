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

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.APIServer;
import io.fabric8.openshift.api.model.APIServerList;
import io.fabric8.openshift.api.model.Authentication;
import io.fabric8.openshift.api.model.AuthenticationList;
import io.fabric8.openshift.api.model.ClusterOperator;
import io.fabric8.openshift.api.model.ClusterOperatorList;
import io.fabric8.openshift.api.model.ClusterVersion;
import io.fabric8.openshift.api.model.ClusterVersionList;
import io.fabric8.openshift.api.model.Console;
import io.fabric8.openshift.api.model.ConsoleList;
import io.fabric8.openshift.api.model.DNS;
import io.fabric8.openshift.api.model.DNSList;
import io.fabric8.openshift.api.model.FeatureGate;
import io.fabric8.openshift.api.model.FeatureGateList;
import io.fabric8.openshift.api.model.Infrastructure;
import io.fabric8.openshift.api.model.InfrastructureList;
import io.fabric8.openshift.api.model.Ingress;
import io.fabric8.openshift.api.model.IngressList;
import io.fabric8.openshift.api.model.Network;
import io.fabric8.openshift.api.model.NetworkList;
import io.fabric8.openshift.api.model.OAuth;
import io.fabric8.openshift.api.model.OAuthList;
import io.fabric8.openshift.api.model.OperatorHub;
import io.fabric8.openshift.api.model.OperatorHubList;
import io.fabric8.openshift.api.model.Proxy;
import io.fabric8.openshift.api.model.ProxyList;
import io.fabric8.openshift.api.model.Scheduler;
import io.fabric8.openshift.api.model.SchedulerList;
import io.fabric8.openshift.client.dsl.OpenShiftConfigAPIGroupDSL;
import io.fabric8.openshift.client.dsl.internal.config.APIServerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.AuthenticationOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.ClusterOperatorOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.ClusterVersionOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.ConsoleOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.DNSOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.FeatureGateOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.InfrastructureOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.NetworkOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.OAuthOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.OperatorHubOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.ProxyOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.IngressOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.config.SchedulerOperationsImpl;
import okhttp3.OkHttpClient;

public class OpenShiftConfigAPIGroupClient extends BaseClient implements OpenShiftConfigAPIGroupDSL {
  public OpenShiftConfigAPIGroupClient() {
    super();
  }

  public OpenShiftConfigAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public NonNamespaceOperation<APIServer, APIServerList, Resource<APIServer>> apiServers() {
    return new APIServerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Authentication, AuthenticationList, Resource<Authentication>> authentications() {
    return new AuthenticationOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ClusterOperator, ClusterOperatorList, Resource<ClusterOperator>> clusterOperators() {
    return new ClusterOperatorOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Console, ConsoleList, Resource<Console>> consoles() {
    return new ConsoleOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ClusterVersion, ClusterVersionList, Resource<ClusterVersion>> clusterVersions() {
    return new ClusterVersionOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<DNS, DNSList, Resource<DNS>> dnses() {
    return new DNSOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<FeatureGate, FeatureGateList, Resource<FeatureGate>> featureGates() {
    return new FeatureGateOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Infrastructure, InfrastructureList, Resource<Infrastructure>> infrastructures() {
    return new InfrastructureOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Ingress, IngressList, Resource<Ingress>> ingresses() {
    return new IngressOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Network, NetworkList, Resource<Network>> networks() {
    return new NetworkOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OAuth, OAuthList, Resource<OAuth>> oAuths() {
    return new OAuthOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OperatorHub, OperatorHubList, Resource<OperatorHub>> operatorHubs() {
    return new OperatorHubOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Proxy, ProxyList, Resource<Proxy>> proxies() {
    return new ProxyOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Scheduler, SchedulerList, Resource<Scheduler>> schedulers() {
    return new SchedulerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }
}
