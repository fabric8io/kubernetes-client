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
package io.fabric8.openshift.client.dsl;

import io.fabric8.kubernetes.client.Client;
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

public interface OpenShiftConfigAPIGroupDSL extends Client {
  /**
   * API entrypoint for APIServer related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for APIServer type
   */
  NonNamespaceOperation<APIServer, APIServerList, DoneableAPIServer, Resource<APIServer, DoneableAPIServer>> apiServers();
  /**
   * API entrypoint for ClusterOperator related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ClusterOperator type
   */
  NonNamespaceOperation<ClusterOperator, ClusterOperatorList, DoneableClusterOperator, Resource<ClusterOperator, DoneableClusterOperator>> clusterOperators();
  /**
   * API entrypoint for ClusterVersion related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ClusterVersion type
   */
  NonNamespaceOperation<ClusterVersion, ClusterVersionList, DoneableClusterVersion, Resource<ClusterVersion, DoneableClusterVersion>> clusterVersions();
  /**
   * API entrypoint for FeatureGate related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for FeatureGate type
   */
  NonNamespaceOperation<FeatureGate, FeatureGateList, DoneableFeatureGate, Resource<FeatureGate, DoneableFeatureGate>> featureGates();
  /**
   * API entrypoint for Infrastructure related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Infrastructure type
   */
  NonNamespaceOperation<Infrastructure, InfrastructureList, DoneableInfrastructure, Resource<Infrastructure, DoneableInfrastructure>> infrastructures();
  /**
   * API entrypoint for OAuth related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for OAuth type
   */
  NonNamespaceOperation<OAuth, OAuthList, DoneableOAuth, Resource<OAuth, DoneableOAuth>> oAuths();
  /**
   * API entrypoint for OperatorHub related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for OperatorHub type
   */
  NonNamespaceOperation<OperatorHub, OperatorHubList, DoneableOperatorHub, Resource<OperatorHub, DoneableOperatorHub>> operatorHubs();
  /**
   * API entrypoint for Proxy related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Proxy type
   */
  NonNamespaceOperation<Proxy, ProxyList, DoneableProxy, Resource<Proxy, DoneableProxy>> proxies();
  /**
   * API entrypoint for Scheduler related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Scheduler type
   */
  NonNamespaceOperation<Scheduler, SchedulerList, DoneableScheduler, Resource<Scheduler, DoneableScheduler>> schedulers();
}
