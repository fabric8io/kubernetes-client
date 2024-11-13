/*
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

import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.openclustermanagement.api.model.apps.v1.Channel;
import io.fabric8.openclustermanagement.api.model.apps.v1.ChannelList;
import io.fabric8.openclustermanagement.api.model.apps.v1.PlacementRule;
import io.fabric8.openclustermanagement.api.model.apps.v1.PlacementRuleList;
import io.fabric8.openclustermanagement.api.model.apps.v1.Subscription;
import io.fabric8.openclustermanagement.api.model.apps.v1.SubscriptionList;
import io.fabric8.openclustermanagement.client.dsl.OpenClusterManagementAppsAPIGroupDSL;

public class OpenClusterManagementAppsAPIGroupClient extends ClientAdapter<OpenClusterManagementAppsAPIGroupClient>
    implements OpenClusterManagementAppsAPIGroupDSL {

  @Override
  public OpenClusterManagementAppsAPIGroupClient newInstance() {
    return new OpenClusterManagementAppsAPIGroupClient();
  }

  @Override
  public MixedOperation<Channel, ChannelList, Resource<Channel>> channels() {
    return resources(Channel.class, ChannelList.class);
  }

  @Override
  public MixedOperation<Subscription, SubscriptionList, Resource<Subscription>> subscriptions() {
    return resources(Subscription.class, SubscriptionList.class);
  }

  @Override
  public MixedOperation<PlacementRule, PlacementRuleList, Resource<PlacementRule>> placementRules() {
    return resources(PlacementRule.class, PlacementRuleList.class);
  }
}
