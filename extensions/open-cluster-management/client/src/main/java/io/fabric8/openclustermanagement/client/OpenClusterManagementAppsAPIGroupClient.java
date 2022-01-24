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
package io.fabric8.openclustermanagement.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.Application;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ApplicationList;
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.GitOpsCluster;
import io.fabric8.openclustermanagement.api.model.multicloudintegration.apps.v1beta1.GitOpsClusterList;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.Channel;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorschannel.apps.v1.ChannelList;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRule;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1.PlacementRuleList;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmRelease;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.helmrelease.v1.HelmReleaseList;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.Subscription;
import io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1.SubscriptionList;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementAppsAPIGroupDSL;

public class OpenClusterManagementAppsAPIGroupClient extends BaseClient implements OpenClusterManagementAppsAPIGroupDSL {

  public OpenClusterManagementAppsAPIGroupClient() {
    super();
  }

  public OpenClusterManagementAppsAPIGroupClient(ClientContext clientContext) {
    super(clientContext);
  }

  @Override
  public MixedOperation<Channel, ChannelList, Resource<Channel>> channels() {
    return Handlers.getOperation(Channel.class, ChannelList.class, this);
  }

  @Override
  public MixedOperation<Subscription, SubscriptionList, Resource<Subscription>> subscriptions() {
    return Handlers.getOperation(Subscription.class, SubscriptionList.class, this);
  }

  @Override
  public MixedOperation<HelmRelease, HelmReleaseList, Resource<HelmRelease>> helmReleases() {
    return Handlers.getOperation(HelmRelease.class, HelmReleaseList.class, this);
  }

  @Override
  public MixedOperation<Application, ApplicationList, Resource<Application>> applications() {
    return Handlers.getOperation(Application.class, ApplicationList.class, this);
  }

  @Override
  public MixedOperation<PlacementRule, PlacementRuleList, Resource<PlacementRule>> placementRules() {
    return Handlers.getOperation(PlacementRule.class, PlacementRuleList.class, this);
  }

  @Override
  public MixedOperation<GitOpsCluster, GitOpsClusterList, Resource<GitOpsCluster>> gitOpsClusters() {
    return Handlers.getOperation(GitOpsCluster.class, GitOpsClusterList.class, this);
  }
}
