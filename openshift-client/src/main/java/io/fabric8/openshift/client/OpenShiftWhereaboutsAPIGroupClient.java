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
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPPool;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.IPPoolList;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.OverlappingRangeIPReservation;
import io.fabric8.openshift.api.model.whereabouts.v1alpha1.OverlappingRangeIPReservationList;
import io.fabric8.openshift.client.dsl.OpenShiftWhereaboutsAPIGroupDSL;
import okhttp3.OkHttpClient;

public class OpenShiftWhereaboutsAPIGroupClient  extends BaseClient implements OpenShiftWhereaboutsAPIGroupDSL {
  public OpenShiftWhereaboutsAPIGroupClient() {
    super();
  }

  public OpenShiftWhereaboutsAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<IPPool, IPPoolList, Resource<IPPool>> ippools() {
    return OpenShiftHandlers.getOperation(IPPool.class, IPPoolList.class, httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<OverlappingRangeIPReservation, OverlappingRangeIPReservationList, Resource<OverlappingRangeIPReservation>> overlappingRangeIpReservations() {
    return OpenShiftHandlers.getOperation(OverlappingRangeIPReservation.class, OverlappingRangeIPReservationList.class, httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }
}
