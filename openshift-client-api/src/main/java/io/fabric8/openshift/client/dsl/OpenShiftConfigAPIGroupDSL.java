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

public interface OpenShiftConfigAPIGroupDSL extends Client {
  /**
   * API entrypoint for APIServer related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for APIServer type
   */
  NonNamespaceOperation<APIServer, APIServerList, Resource<APIServer>> apiServers();

  /**
   * API entrypoint for Authentication related operations (config.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for Authentication
   */
  NonNamespaceOperation<Authentication, AuthenticationList, Resource<Authentication>> authentications();
  /**
   * API entrypoint for ClusterOperator related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ClusterOperator type
   */
  NonNamespaceOperation<ClusterOperator, ClusterOperatorList, Resource<ClusterOperator>> clusterOperators();

  /**
   * API entrypoint for Console related operations (config.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for Console
   */
  NonNamespaceOperation<Console, ConsoleList, Resource<Console>> consoles();
  /**
   * API entrypoint for ClusterVersion related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for ClusterVersion type
   */
  NonNamespaceOperation<ClusterVersion, ClusterVersionList, Resource<ClusterVersion>> clusterVersions();

  /**
   * API entrypoint for DNS (config.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for DNS resource
   */
  NonNamespaceOperation<DNS, DNSList, Resource<DNS>> dnses();

  /**
   * API entrypoint for FeatureGate related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for FeatureGate type
   */
  NonNamespaceOperation<FeatureGate, FeatureGateList, Resource<FeatureGate>> featureGates();
  /**
   * API entrypoint for Infrastructure related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Infrastructure type
   */
  NonNamespaceOperation<Infrastructure, InfrastructureList, Resource<Infrastructure>> infrastructures();

  /**
   * API entrypoint for Ingress (config.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for Ingress type
   */
  NonNamespaceOperation<Ingress, IngressList, Resource<Ingress>> ingresses();

  /**
   * API entrypoint for Network (config.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for Network type
   */
  NonNamespaceOperation<Network, NetworkList, Resource<Network>> networks();
  /**
   * API entrypoint for OAuth related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for OAuth type
   */
  NonNamespaceOperation<OAuth, OAuthList, Resource<OAuth>> oAuths();
  /**
   * API entrypoint for OperatorHub related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for OperatorHub type
   */
  NonNamespaceOperation<OperatorHub, OperatorHubList, Resource<OperatorHub>> operatorHubs();
  /**
   * API entrypoint for Proxy related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Proxy type
   */
  NonNamespaceOperation<Proxy, ProxyList, Resource<Proxy>> proxies();
  /**
   * API entrypoint for Scheduler related operations(config.openshift.io/v1)
   *
   * @return NonNamespaceOperation object for Scheduler type
   */
  NonNamespaceOperation<Scheduler, SchedulerList, Resource<Scheduler>> schedulers();
}
