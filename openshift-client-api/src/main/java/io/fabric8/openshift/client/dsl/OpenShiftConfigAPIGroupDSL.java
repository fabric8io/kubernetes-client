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
import io.fabric8.openshift.api.model.config.v1.APIServer;
import io.fabric8.openshift.api.model.config.v1.APIServerList;
import io.fabric8.openshift.api.model.config.v1.Authentication;
import io.fabric8.openshift.api.model.config.v1.AuthenticationList;
import io.fabric8.openshift.api.model.config.v1.Build;
import io.fabric8.openshift.api.model.config.v1.BuildList;
import io.fabric8.openshift.api.model.config.v1.ClusterOperator;
import io.fabric8.openshift.api.model.config.v1.ClusterOperatorList;
import io.fabric8.openshift.api.model.config.v1.ClusterVersion;
import io.fabric8.openshift.api.model.config.v1.ClusterVersionList;
import io.fabric8.openshift.api.model.config.v1.Console;
import io.fabric8.openshift.api.model.config.v1.ConsoleList;
import io.fabric8.openshift.api.model.config.v1.DNS;
import io.fabric8.openshift.api.model.config.v1.DNSList;
import io.fabric8.openshift.api.model.config.v1.FeatureGate;
import io.fabric8.openshift.api.model.config.v1.FeatureGateList;
import io.fabric8.openshift.api.model.config.v1.Image;
import io.fabric8.openshift.api.model.config.v1.ImageContentPolicy;
import io.fabric8.openshift.api.model.config.v1.ImageContentPolicyList;
import io.fabric8.openshift.api.model.config.v1.ImageList;
import io.fabric8.openshift.api.model.config.v1.Infrastructure;
import io.fabric8.openshift.api.model.config.v1.InfrastructureList;
import io.fabric8.openshift.api.model.config.v1.Ingress;
import io.fabric8.openshift.api.model.config.v1.IngressList;
import io.fabric8.openshift.api.model.config.v1.Network;
import io.fabric8.openshift.api.model.config.v1.NetworkList;
import io.fabric8.openshift.api.model.config.v1.OAuth;
import io.fabric8.openshift.api.model.config.v1.OAuthList;
import io.fabric8.openshift.api.model.config.v1.OperatorHub;
import io.fabric8.openshift.api.model.config.v1.OperatorHubList;
import io.fabric8.openshift.api.model.config.v1.Project;
import io.fabric8.openshift.api.model.config.v1.ProjectList;
import io.fabric8.openshift.api.model.config.v1.Proxy;
import io.fabric8.openshift.api.model.config.v1.ProxyList;
import io.fabric8.openshift.api.model.config.v1.Scheduler;
import io.fabric8.openshift.api.model.config.v1.SchedulerList;

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
   * API entrypoint for Build related operations (config.openshift.io/v1)
   * 
   * @return {@link NonNamespaceOperation} for Build
   */
  NonNamespaceOperation<Build, BuildList, Resource<Build>> builds();

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
   * API entrypoint for Image related operations (config.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for Image
   */
  NonNamespaceOperation<Image, ImageList, Resource<Image>> images();

  /**
   * API entrypoint for ImageContentPolicy related operations (config.openshift.io/v1)
   * 
   * @return {@link NonNamespaceOperation} for ImageContentPolicy
   */
  NonNamespaceOperation<ImageContentPolicy, ImageContentPolicyList, Resource<ImageContentPolicy>> imageContentPolicies();

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
   * API entrypoint for Project related operations (config.openshift.io/v1)
   *
   * @return {@link NonNamespaceOperation} for Project
   */
  NonNamespaceOperation<Project, ProjectList, Resource<Project>> projects();

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
