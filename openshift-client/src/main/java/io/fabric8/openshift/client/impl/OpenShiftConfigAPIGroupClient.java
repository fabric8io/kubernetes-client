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
package io.fabric8.openshift.client.impl;

import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
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
  public NonNamespaceOperation<Build, BuildList, Resource<Build>> builds() {
    return resources(Build.class, BuildList.class);
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
  public NonNamespaceOperation<Image, ImageList, Resource<Image>> images() {
    return resources(Image.class, ImageList.class);
  }

  @Override
  public NonNamespaceOperation<ImageContentPolicy, ImageContentPolicyList, Resource<ImageContentPolicy>> imageContentPolicies() {
    return resources(ImageContentPolicy.class, ImageContentPolicyList.class);
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
  public NonNamespaceOperation<Project, ProjectList, Resource<Project>> projects() {
    return resources(Project.class, ProjectList.class);
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
