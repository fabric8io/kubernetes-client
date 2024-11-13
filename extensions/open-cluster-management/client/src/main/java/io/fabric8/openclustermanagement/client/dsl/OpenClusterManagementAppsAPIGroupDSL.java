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
package io.fabric8.openclustermanagement.client.dsl;

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openclustermanagement.api.model.apps.v1.Channel;
import io.fabric8.openclustermanagement.api.model.apps.v1.ChannelList;
import io.fabric8.openclustermanagement.api.model.apps.v1.PlacementRule;
import io.fabric8.openclustermanagement.api.model.apps.v1.PlacementRuleList;
import io.fabric8.openclustermanagement.api.model.apps.v1.Subscription;
import io.fabric8.openclustermanagement.api.model.apps.v1.SubscriptionList;

public interface OpenClusterManagementAppsAPIGroupDSL extends Client {
  /**
   * API entrypoint for Channel (apps.open-cluster-management.io/v1)
   *
   * @return {@link MixedOperation} for Channel
   */
  MixedOperation<Channel, ChannelList, Resource<Channel>> channels();

  /**
   * API entrypoint for Subscription (apps.open-cluster-management.io/v1)
   *
   * @return {@link MixedOperation} for Subscription
   */
  MixedOperation<Subscription, SubscriptionList, Resource<Subscription>> subscriptions();

  /**
   * API entrypoint for PlacementRule (apps.open-cluster-management.io/v1)
   *
   * @return {@link MixedOperation} for PlacementRule
   */
  MixedOperation<PlacementRule, PlacementRuleList, Resource<PlacementRule>> placementRules();
}
