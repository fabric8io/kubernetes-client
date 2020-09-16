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
import io.fabric8.openshift.api.model.ClusterOperator;
import io.fabric8.openshift.api.model.ClusterOperatorList;
import io.fabric8.openshift.api.model.ClusterVersion;
import io.fabric8.openshift.api.model.ClusterVersionList;
import io.fabric8.openshift.api.model.DoneableAPIServer;
import io.fabric8.openshift.api.model.DoneableClusterOperator;
import io.fabric8.openshift.api.model.DoneableClusterVersion;
import io.fabric8.openshift.api.model.DoneableFeatureGate;
import io.fabric8.openshift.api.model.DoneableInfrastructure;
import io.fabric8.openshift.api.model.DoneableOAuth;
import io.fabric8.openshift.api.model.DoneableOperatorHub;
import io.fabric8.openshift.api.model.DoneableProxy;
import io.fabric8.openshift.api.model.DoneableScheduler;
import io.fabric8.openshift.api.model.FeatureGate;
import io.fabric8.openshift.api.model.FeatureGateList;
import io.fabric8.openshift.api.model.Infrastructure;
import io.fabric8.openshift.api.model.InfrastructureList;
import io.fabric8.openshift.api.model.OAuth;
import io.fabric8.openshift.api.model.OAuthList;
import io.fabric8.openshift.api.model.OperatorHub;
import io.fabric8.openshift.api.model.OperatorHubList;
import io.fabric8.openshift.api.model.Proxy;
import io.fabric8.openshift.api.model.ProxyList;
import io.fabric8.openshift.api.model.Scheduler;
import io.fabric8.openshift.api.model.SchedulerList;
import io.fabric8.openshift.client.dsl.OpenShiftConfigAPIGroupDSL;
import io.fabric8.openshift.client.dsl.internal.APIServerOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ClusterOperatorOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ClusterVersionOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.FeatureGateOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.InfrastructureOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OAuthOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.OperatorHubOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.ProxyOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.SchedulerOperationsImpl;
import okhttp3.OkHttpClient;

public class OpenShiftConfigAPIGroupClient extends BaseClient implements OpenShiftConfigAPIGroupDSL {
  public OpenShiftConfigAPIGroupClient() {
    super();
  }

  public OpenShiftConfigAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public NonNamespaceOperation<APIServer, APIServerList, DoneableAPIServer, Resource<APIServer, DoneableAPIServer>> apiServers() {
    return new APIServerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ClusterOperator, ClusterOperatorList, DoneableClusterOperator, Resource<ClusterOperator, DoneableClusterOperator>> clusterOperators() {
    return new ClusterOperatorOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<ClusterVersion, ClusterVersionList, DoneableClusterVersion, Resource<ClusterVersion, DoneableClusterVersion>> clusterVersions() {
    return new ClusterVersionOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<FeatureGate, FeatureGateList, DoneableFeatureGate, Resource<FeatureGate, DoneableFeatureGate>> featureGates() {
    return new FeatureGateOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Infrastructure, InfrastructureList, DoneableInfrastructure, Resource<Infrastructure, DoneableInfrastructure>> infrastructures() {
    return new InfrastructureOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OAuth, OAuthList, DoneableOAuth, Resource<OAuth, DoneableOAuth>> oAuths() {
    return new OAuthOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<OperatorHub, OperatorHubList, DoneableOperatorHub, Resource<OperatorHub, DoneableOperatorHub>> operatorHubs() {
    return new OperatorHubOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Proxy, ProxyList, DoneableProxy, Resource<Proxy, DoneableProxy>> proxies() {
    return new ProxyOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public NonNamespaceOperation<Scheduler, SchedulerList, DoneableScheduler, Resource<Scheduler, DoneableScheduler>> schedulers() {
    return new SchedulerOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }
}
