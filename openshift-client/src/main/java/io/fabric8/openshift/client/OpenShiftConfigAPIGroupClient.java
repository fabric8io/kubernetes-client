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

import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
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

public class OpenShiftConfigAPIGroupClient extends ClientAdapter<OpenShiftConfigAPIGroupClient>
    implements OpenShiftConfigAPIGroupDSL {

  @Override
  public OpenShiftConfigAPIGroupClient newInstance() {
    return new OpenShiftConfigAPIGroupClient();
  }

  @Override
  public NonNamespaceOperation<APIServer, APIServerList, Resource<APIServer>> apiServers() {
    return resources(APIServer.class, APIServerList.class);
  }

  @Override
  public NonNamespaceOperation<Authentication, AuthenticationList, Resource<Authentication>> authentications() {
    return resources(Authentication.class, AuthenticationList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterOperator, ClusterOperatorList, Resource<ClusterOperator>> clusterOperators() {
    return resources(ClusterOperator.class, ClusterOperatorList.class);
  }

  @Override
  public NonNamespaceOperation<Console, ConsoleList, Resource<Console>> consoles() {
    return resources(Console.class, ConsoleList.class);
  }

  @Override
  public NonNamespaceOperation<ClusterVersion, ClusterVersionList, Resource<ClusterVersion>> clusterVersions() {
    return resources(ClusterVersion.class, ClusterVersionList.class);
  }

  @Override
  public NonNamespaceOperation<DNS, DNSList, Resource<DNS>> dnses() {
    return resources(DNS.class, DNSList.class);
  }

  @Override
  public NonNamespaceOperation<FeatureGate, FeatureGateList, Resource<FeatureGate>> featureGates() {
    return resources(FeatureGate.class, FeatureGateList.class);
  }

  @Override
  public NonNamespaceOperation<Infrastructure, InfrastructureList, Resource<Infrastructure>> infrastructures() {
    return resources(Infrastructure.class, InfrastructureList.class);
  }

  @Override
  public NonNamespaceOperation<Ingress, IngressList, Resource<Ingress>> ingresses() {
    return resources(Ingress.class, IngressList.class);
  }

  @Override
  public NonNamespaceOperation<Network, NetworkList, Resource<Network>> networks() {
    return resources(Network.class, NetworkList.class);
  }

  @Override
  public NonNamespaceOperation<OAuth, OAuthList, Resource<OAuth>> oAuths() {
    return resources(OAuth.class, OAuthList.class);
  }

  @Override
  public NonNamespaceOperation<OperatorHub, OperatorHubList, Resource<OperatorHub>> operatorHubs() {
    return resources(OperatorHub.class, OperatorHubList.class);
  }

  @Override
  public NonNamespaceOperation<Proxy, ProxyList, Resource<Proxy>> proxies() {
    return resources(Proxy.class, ProxyList.class);
  }

  @Override
  public NonNamespaceOperation<Scheduler, SchedulerList, Resource<Scheduler>> schedulers() {
    return resources(Scheduler.class, SchedulerList.class);
  }

}
